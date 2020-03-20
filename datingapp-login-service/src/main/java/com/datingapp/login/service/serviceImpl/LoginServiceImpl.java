package com.datingapp.login.service.serviceImpl;

import com.datingapp.login.constants.ErrorMessageConstants.ForgetPassword;
import com.datingapp.login.constants.ErrorMessageConstants.IncorrectPasswordAttempts;
import com.datingapp.login.constants.ErrorMessageConstants.InvalidAdminStatus;
import com.datingapp.login.constants.ErrorMessageConstants.InvalidAdminUsername;
import com.datingapp.login.constants.PatternConstants.EmailConstants;
import com.datingapp.login.exceptions.UnauthorisedException;
import com.datingapp.login.feignInterface.AdminInterface;
import com.datingapp.login.jwt.JwtTokenProvider;
import com.datingapp.login.requestDTO.AdminRequestDTO;
import com.datingapp.login.requestDTO.LoginRequestDTO;
import com.datingapp.login.responseDTO.AdminResponseDTO;
import com.datingapp.login.service.LoginService;
import com.datingapp.login.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
@Service
@Transactional("transactionManager")
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AdminInterface adminInterface;

    @Override
    public String login(LoginRequestDTO requestDTO, HttpServletRequest request) {

        LOGGER.info("LOGIN PROCESS STARTED ::::");

        long startTime = DateUtils.getTimeInMillisecondsFromLocalDate();

        AdminResponseDTO admin = fetchAdminDetails.apply(requestDTO);

        validateAdminUsername.accept(admin);

        validateAdminStatus.accept(admin);

        validatePassword.accept(requestDTO, admin);

        String jwtToken = jwtTokenProvider.createToken(requestDTO.getUserCredential(), request);

        LOGGER.info("LOGIN PROCESS COMPLETED IN ::: " + (DateUtils.getTimeInMillisecondsFromLocalDate() - startTime)
                + " ms");

        return jwtToken;
    }

    private Function<LoginRequestDTO, AdminResponseDTO> fetchAdminDetails = (loginRequestDTO) -> {

        Pattern pattern = Pattern.compile(EmailConstants.EMAIL_PATTERN);
        Matcher m = pattern.matcher(loginRequestDTO.getUserCredential());

        return m.find() ? adminInterface.searchAdmin
                (new AdminRequestDTO(null, loginRequestDTO.getUserCredential()))
                : adminInterface.searchAdmin
                (new AdminRequestDTO(loginRequestDTO.getUserCredential(), null));
    };

    private Consumer<AdminResponseDTO> validateAdminUsername = (admin) -> {
        if (Objects.isNull(admin))
            throw new UnauthorisedException(InvalidAdminUsername.MESSAGE, InvalidAdminUsername.DEVELOPER_MESSAGE);
        LOGGER.info(":::: ADMIN USERNAME VALIDATED ::::");
    };

    private Consumer<AdminResponseDTO> validateAdminStatus = (admin) -> {

        switch (admin.getStatus()) {
            case 'B':
                throw new UnauthorisedException(InvalidAdminStatus.MESSAGE_FOR_BLOCKED,
                        InvalidAdminStatus.DEVELOPER_MESSAGE_FOR_BLOCKED);

            case 'N':
                throw new UnauthorisedException(InvalidAdminStatus.MESSAGE_FOR_INACTIVE,
                        InvalidAdminStatus.DEVELOPER_MESSAGE_FOR_INACTIVE);
        }
        LOGGER.info(":::: ADMIN STATUS VALIDATED ::::");
    };

    private BiConsumer<LoginRequestDTO, AdminResponseDTO> validatePassword = (requestDTO, admin) -> {

        LOGGER.info(":::: ADMIN PASSWORD VALIDATION ::::");

        if (BCrypt.checkpw(requestDTO.getPassword(), admin.getPassword())) {
            admin.setLoginAttempt(0);
            adminInterface.updateAdmin(admin);
        } else {
            admin.setLoginAttempt(admin.getLoginAttempt() + 1);

            if (admin.getLoginAttempt() >= 3) {
                admin.setStatus('B');
                adminInterface.updateAdmin(admin);

                LOGGER.debug("ADMIN IS BLOCKED DUE TO MULTIPLE WRONG ATTEMPTS...");
                throw new UnauthorisedException(IncorrectPasswordAttempts.MESSAGE,
                        IncorrectPasswordAttempts.DEVELOPER_MESSAGE);
            }

            LOGGER.debug("INCORRECT PASSWORD...");
            throw new UnauthorisedException(ForgetPassword.MESSAGE, ForgetPassword.DEVELOPER_MESSAGE);
        }

        LOGGER.info(":::: ADMIN PASSWORD VALIDATED ::::");
    };

}


package com.datingapp.authdemo.service.impl;

import com.datingapp.authdemo.dto.request.AdminRequestDTO;
import com.datingapp.authdemo.dto.response.AdminResponseDTO;
import com.datingapp.authdemo.dto.response.ResponseDTO;
import com.datingapp.authdemo.entities.Admin;
import com.datingapp.authdemo.exceptions.NoContentFoundException;
import com.datingapp.authdemo.repository.AdminRepository;
import com.datingapp.authdemo.service.AdminService;
import com.datingapp.authdemo.utility.AdminUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.datingapp.authdemo.query.AdminQuery.createQueryToFetchAdminDetails;
import static com.datingapp.authdemo.query.AdminQuery.createQueryToFetchAdminsToSendEmail;
import static com.datingapp.authdemo.utility.AdminUtils.convertToAdminResponse;

/**
 * Datingapp on 21.03.2020
 *
 * @author volkanulutas
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminRepository adminRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public void saveAdmin(AdminRequestDTO requestDTO) {

        LOGGER.info(":::: SAVE ADMIN PROCESS STARTED::::");
        validateAdminRequestDTO.accept(requestDTO);

        System.out.println("VALIDATION DONE");
    }

    public Consumer<AdminRequestDTO> validateAdminRequestDTO = (requestDTO) -> {
//        adminRepository.fetchAdminByUsername(requestDTO.getUsername()).ifPresent(admin -> {
//            throw new DataDuplicationException(DUPLICATE_USERNAME_MESSAGE, DUPLICATE_USERNAME_DEVELOPER_MESSAGE);
//        });
//
//        adminRepository.fetchAdminByEmailAddress(requestDTO.getEmailAddress()).ifPresent(admin -> {
//            throw new DataDuplicationException(DUPLICATE_EMAILADDRESS_MESSAGE, DUPLICATE_EMAILADDRESS_DEVELOPER_MESSAGE);
//        });
    };


    //    @Override
//    public void saveAdmin(AdminRequestDTO requestDTO) {
////        Admin admin = MapperUtility.map(requestDTO, Admin.class);
////
////        admin.setPassword(BCrypt.hashpw(requestDTO.getPassword(), BCrypt.gensalt()));
////        admin.setLoginAttempt(0);
////
////        admin.setRoles(Arrays.asList("ROLE_USER"));
////        adminRepository.save(admin);
//    }

    /*SEARCH ADMIN FOR LOGIN VALIDATION*/
    @Override
    public AdminResponseDTO searchAdmin(AdminRequestDTO requestDTO) throws NoContentFoundException {

        List<Object[]> results = entityManager.createNativeQuery(
                createQueryToFetchAdminDetails.apply(requestDTO)).getResultList();

//        if (ObjectUtils.isEmpty(results))
//            throw new NoContentFoundException(AdminNotFoundException.MESSAGE, AdminNotFoundException.DEVELOPER_MESSAGE);

        return convertToAdminResponse.apply(results);
    }

    @Override
    public Admin updateAdmin(AdminRequestDTO requestDTO) {
        return null;
    }

    @Override
    public Admin fetchAdminByUsername(String username) {
        return null;
    }


    /*FOR UPDATING LOGIN ATTEMPTS */
//    @Override
//    public Admin updateAdmin(AdminRequestDTO requestDTO) {
//
////        Admin admin = this.adminRepository.getAdminById(requestDTO.getId()).orElseThrow(() -> {
////            return new NoContentFoundException(AdminNotFoundException.MESSAGE, AdminNotFoundException.DEVELOPER_MESSAGE);
////        });
//
//        admin.setStatus(requestDTO.getStatus());
////        admin.setLoginAttempt(requestDTO.getLoginAttempt());
//
//        return adminRepository.save(admin);
//    }


    /*USED BY AUTH-SERVICE AFTER SUCCESSFUL TOKEN VALIDATION*/
//    @Override
//    public Admin fetchAdminByUsername(String username) {
//        return adminRepository.fetchAdminByUsername(username).orElseThrow(() ->
//                new NoContentFoundException(AdminNotFoundException.MESSAGE, AdminNotFoundException.DEVELOPER_MESSAGE));
//    }


    @Override
    public ResponseDTO adminsToSendEmails() {

        List<Object[]> results = entityManager.createNativeQuery(
                createQueryToFetchAdminsToSendEmail.get()).getResultList();

        List<AdminResponseDTO> responseDTOS = results.stream().map(AdminUtils.convertToResponse)
                .collect(Collectors.toList());

        return new ResponseDTO(responseDTOS, null);
    }

    @Override
    public List<Admin> fetchAllAdmins() {
        return null;
    }


}

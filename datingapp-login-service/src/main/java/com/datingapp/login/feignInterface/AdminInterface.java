package com.datingapp.login.feignInterface;

import com.datingapp.login.constants.MicroServiceConstants;
import com.datingapp.login.constants.MicroServiceConstants.*;
import com.datingapp.login.requestDTO.AdminRequestDTO;
import com.datingapp.login.responseDTO.AdminResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
@FeignClient(name = AdminMicroServiceConstants.BASE)
@Service
@RequestMapping(value = MicroServiceConstants.BASE_API)
public interface AdminInterface {

    @RequestMapping(value = AdminMicroServiceConstants.SEARCH_ADMIN)
    AdminResponseDTO searchAdmin(@RequestBody AdminRequestDTO requestDTO);

    @RequestMapping(value = AdminMicroServiceConstants.UPDATE_ADMIN)
    void updateAdmin(@RequestBody AdminResponseDTO responseDTO);
}

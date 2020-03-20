package com.datingapp.auth.feignInterface;


import com.datingapp.auth.responseDTO.AdminResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static com.datingapp.auth.constants.MicroServiceConstants.ADMIN_MICROSERVICE;
import static com.datingapp.auth.constants.MicroServiceConstants.BASE_API;

import com.datingapp.auth.constants.MicroServiceConstants.AdminMicroServiceConstants;


/**
 * Datingapp on 19.03.2020
 *
 * @author volkanulutas
 */
@FeignClient(name = ADMIN_MICROSERVICE)
@Service
@RequestMapping(value = BASE_API)
public interface AdminInterface {

    @RequestMapping(value = AdminMicroServiceConstants.FETCH_ADMIN_BY_USERNAME)
    Optional<AdminResponseDTO> fetchAdminByUsername(@PathVariable("username") String username);
}

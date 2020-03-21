package com.datingapp.authdemo.service;

import com.datingapp.authdemo.dto.request.AdminRequestDTO;
import com.datingapp.authdemo.dto.response.AdminResponseDTO;
import com.datingapp.authdemo.dto.response.ResponseDTO;
import com.datingapp.authdemo.entities.Admin;

import java.util.List;

/**
 * Datingapp on 21.03.2020
 *
 * @author volkanulutas
 */
public interface AdminService {

    void saveAdmin(AdminRequestDTO requestDTO);

    AdminResponseDTO searchAdmin(AdminRequestDTO requestDTO);

    Admin updateAdmin(AdminRequestDTO requestDTO);

    Admin fetchAdminByUsername(String username);

    ResponseDTO adminsToSendEmails();

    List<Admin> fetchAllAdmins();
}

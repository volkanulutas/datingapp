package com.datingapp.login.service;

import com.datingapp.login.requestDTO.LoginRequestDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
public interface LoginService {

     String login(LoginRequestDTO requestDTO, HttpServletRequest request);

}

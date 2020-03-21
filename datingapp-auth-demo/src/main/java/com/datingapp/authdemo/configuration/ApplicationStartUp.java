package com.datingapp.authdemo.configuration;

import com.datingapp.authdemo.entities.Admin;
import com.datingapp.authdemo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;


/**
 * Datingapp on 21.03.2020
 * <p>
 * THIS CLASS RUNS BEFORE THE MAIN APPLICATION AND IS USED TO CREATE A SUPERADMIN DURING FIRST BOOT OF THE APPLICATION
 *
 * @author volkanulutas
 */
@Component
public class ApplicationStartUp {

    @Autowired
    private StartupProperties startupProperties;

    @Bean
    public CommandLineRunner loadData(AdminRepository adminRepository) {
        return (args) -> {
            List<Admin> admins = adminRepository.findAll();

            if (ObjectUtils.isEmpty(admins))
                adminRepository.save(saveAdmin());
        };
    }

    public Admin saveAdmin() {
        Admin admin = new Admin();
        admin.setUsername(startupProperties.getUsername());
        admin.setFullName(startupProperties.getFullName());
        admin.setPassword(BCrypt.hashpw(startupProperties.getPassword(), BCrypt.gensalt()));
        admin.setEmailAddress(startupProperties.getEmailAddress());
        admin.setProfileId(startupProperties.getProfileId());
        admin.setStatus(startupProperties.getStatus());
        admin.setRoles(Arrays.asList("ADMIN"));

        return admin;
    }
}



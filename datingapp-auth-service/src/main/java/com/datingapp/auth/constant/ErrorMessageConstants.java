package com.datingapp.auth.constant;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public class ErrorMessageConstants {

    public interface ForgetPassword {
        String DEVELOPER_MESSAGE = "Password didn't match with the original one.";
        String MESSAGE = "Incorrect password.Forgot Password?";
    }

    public interface IncorrectPasswordAttempts {
        String DEVELOPER_MESSAGE = "User is blocked with status 'B'";
        String MESSAGE = "User is blocked. Please contact your system administrator.";
    }

    public interface InvalidAdminUsername {
        String DEVELOPER_MESSAGE = "Admin entity returned null";
        String MESSAGE = "Admin with given username doesn't exits.";
    }

    public interface SingupErrorMessage{
        String DEVELOPER_MESSAGE = "Signup error is occurred.";
        String MESSAGE =  "Signup error is occurred.";
    }
}

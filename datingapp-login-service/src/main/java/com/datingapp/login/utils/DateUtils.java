package com.datingapp.login.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Datingapp on 20.03.2020
 *
 * @author volkanulutas
 */
public class DateUtils {

    public static long getTimeInMillisecondsFromLocalDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return Timestamp.valueOf(localDate).getTime();
    }
}

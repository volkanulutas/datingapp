package com.datingapp.user.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateUtil{

    public static long getTimeInMillisecondsFromLocalDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return Timestamp.valueOf(localDate).getTime();
    }
}

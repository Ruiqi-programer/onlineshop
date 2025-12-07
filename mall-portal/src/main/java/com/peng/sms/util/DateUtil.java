package com.peng.sms.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    /**
     * Extracts the date part from a Date object (time set to 00:00:00)
     */
    public static Date getDate(Date date) {
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Extracts the time part from a Date object (date set to 1970-01-01)
     */
    public static Date getTime(Date date) {
        LocalTime localTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalTime();
        LocalDate epochDate = LocalDate.of(1970, 1, 1);
        LocalDateTime dateTime = LocalDateTime.of(epochDate, localTime);
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Optional: Directly get LocalDate (without converting to Date)
     */
    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Optional: Directly get LocalTime (without converting to Date)
     */
    public static LocalTime toLocalTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }
}

package com.example.demo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String getDateStrFromTimestamp(long timestamp) {
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofHours(8));
        return ldt.format(dtf);
    }

    public static Date getCurrentDate() {
        LocalDateTime ldt = LocalDateTime.now();
        return convertToDateViaInstant(ldt.toLocalDate());
    }

    public static String getCurrentDateStr() {
        return getDateStrFromTimestamp(System.currentTimeMillis()/1000);
    }

    public static Date convertToDateViaInstant(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay().atZone(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date date) {
        return date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
    }

    public static LocalDate convertToLocalDateViaInstant(Date date) {
        return date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDate();
    }
}

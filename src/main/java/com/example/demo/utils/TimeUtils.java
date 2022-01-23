package com.example.demo.utils;

import java.math.BigInteger;
import java.sql.Time;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeUtils {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static String getTimeStrFromTimestamp(long timestamp) {
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.ofHours(8));
        return ldt.format(dtf);
    }

    public static Time getCurrentTime() {
        return Time.valueOf(LocalTime.now());
    }

    public static Date convertToDateViaInstant(LocalTime localTime) {
        Instant instant = localTime.atDate(LocalDate.now().withYear(1970).withMonth(1).withDayOfMonth(1))
                .atZone(ZoneId.of("Asia/Shanghai")).toInstant();
        BigInteger milis = BigInteger.valueOf(instant.getEpochSecond()).multiply(
                BigInteger.valueOf(1000));
        milis = milis.add(BigInteger.valueOf(instant.getNano()).divide(
                BigInteger.valueOf(1_000_000)));
        return new Date(milis.longValue());
    }

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date date) {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt1 = date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
        return ldt1.withYear(ldt.getYear())
                .withMonth(ldt.getMonth().getValue())
                .withDayOfMonth(ldt.getDayOfMonth());
    }

    public static LocalTime convertToLocalTimeViaInstant(Date date) {
        return date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalTime();
    }

    public static LocalDateTime mergeDateToLocalDateTimeViaInstant(Date date, Date time) {
        LocalTime lt = convertToLocalTimeViaInstant(time);
        LocalDateTime ldt1 = date.toInstant().atZone(ZoneId.of("Asia/Shanghai")).toLocalDateTime();
        return ldt1.withHour(lt.getHour())
                .withMinute(lt.getMinute())
                .withSecond(lt.getSecond())
                .withNano(lt.getNano());
    }
}

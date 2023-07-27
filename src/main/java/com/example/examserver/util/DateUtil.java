package com.example.examserver.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class DateUtil {
    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static LocalDateTime now = LocalDateTime.now();
    public static String getCurrentDateTime() {
        return now.format(format);
    }
    @Scheduled(fixedRate = 1000) // 1000 milliseconds = 1 second
    public static void updateCurrentDateTime() {
        now = LocalDateTime.now();
    }
}
package com.barbosa.scheduler;

import com.barbosa.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluScheduler {

    private static final Logger logger = LoggerFactory.getLogger(MagaluScheduler.class);

    private final NotificationService notificationService;

    public MagaluScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(fixedDelay = 30, timeUnit = TimeUnit.SECONDS)
    public void checkTasks() {

        var dateTime = LocalDateTime.now();

        logger.info("RUNNING AT: {}", dateTime);

        notificationService.checkAndSend(dateTime);
    }
}

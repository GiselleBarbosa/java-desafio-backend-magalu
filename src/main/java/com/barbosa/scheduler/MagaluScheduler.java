package com.barbosa.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class MagaluScheduler {

    private static final Logger logger = LoggerFactory.getLogger(MagaluScheduler.class);

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runTasks() {

        var dateTime = LocalDateTime.now();
        logger.info("Running at {}", dateTime);
    }
}

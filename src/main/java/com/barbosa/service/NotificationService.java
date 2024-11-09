package com.barbosa.service;

import com.barbosa.controller.dto.ScheduleNotificationDto;
import com.barbosa.entity.Notification;
import com.barbosa.enums.StatusType;
import com.barbosa.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void scheduleNotification(ScheduleNotificationDto dto) {
        notificationRepository.save(dto.toNotification());
    }

    public Optional<Notification> findById(Long notificationId) {
        return Optional.ofNullable(notificationRepository
                .findById(notificationId)
                .orElseThrow(() ->
                        new RuntimeException("Notification not found")));
    }

    public void deleteNotificationByID(Long notificationId) {
        var notification = findById(notificationId);

        if (notification.isPresent()) {
            notification.get().setStatus(StatusType.CANCELED.toStatus());
            notificationRepository.save(notification.get());
        }
    }


}

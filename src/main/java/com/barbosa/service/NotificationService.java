package com.barbosa.service;

import com.barbosa.controller.dto.ScheduleNotificationDto;
import com.barbosa.entity.Notification;
import com.barbosa.enums.StatusType;
import com.barbosa.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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

    public void checkAndSend(LocalDateTime dateTime) {
        var notifications = notificationRepository.findByStatusInAndDateTimeBefore(
                List.of(
                        StatusType.PENDING.toStatus(),
                        StatusType.ERROR.toStatus()), dateTime
        );

        notifications.forEach(sendoNotification());
    }

    private Consumer<Notification> sendoNotification() {
        return notification -> {

            // TODO - REALIZAR ENVIO DA NOTIFICACAO

            notification.setStatus(StatusType.SUCCESS.toStatus());
            notificationRepository.save(notification);
        };
    }
}

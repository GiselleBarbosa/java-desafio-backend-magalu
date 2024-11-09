package com.barbosa.controller.dto;

import com.barbosa.entity.Notification;
import com.barbosa.enums.ChannelType;
import com.barbosa.enums.StatusType;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(
        LocalDateTime dateTime,
        String destination,
        String message,
        ChannelType channel
) {
    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                StatusType.PENDING.toStatus()
        );
    }
}

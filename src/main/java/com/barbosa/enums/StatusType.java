package com.barbosa.enums;

import com.barbosa.entity.Status;

public enum StatusType {
    PENDING(1L, "pending"),
    SUCCESS(2L, "success"),
    ERROR(3L, "error"),
    CANCELED(4L, "canceled");

    private final Long id;
    private final String description;

    StatusType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status toStatus() {
        Status status = new Status(id, description);
        status.setStatusType(this);
        return status;
    }
}
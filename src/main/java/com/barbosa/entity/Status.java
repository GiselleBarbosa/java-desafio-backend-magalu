package com.barbosa.entity;

import com.barbosa.enums.StatusType;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private Long statusId;

    private String description;

    private StatusType statusType;

    public Status() {
    }

    public Status(Long statusId, String description) {
        this.statusId = statusId;
        this.description = description;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }
}

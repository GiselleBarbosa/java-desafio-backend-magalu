package com.barbosa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_status")
public class Status {

    @Id
    private Long StatusId;

    private String description;

    public Status() {
    }

    public Long getStatusId() {
        return StatusId;
    }

    public void setStatusId(Long statusId) {
        StatusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

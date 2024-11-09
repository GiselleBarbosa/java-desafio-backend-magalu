package com.barbosa.enums;

import com.barbosa.entity.Channel;

public enum ChannelType {
    EMAIL(1L, "email"),
    SMS(2L, "sms"),
    PUSH(3L, "push"),
    WHATSAPP(4L, "whatsapp");

    private final Long id;
    private final String description;

    ChannelType(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Channel toChannel() {
        Channel channel = new Channel(id, description);
        channel.setChannelType(this);
        return channel;
    }
}
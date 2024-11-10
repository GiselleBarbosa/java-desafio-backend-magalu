package com.barbosa.config;

import com.barbosa.enums.ChannelType;
import com.barbosa.enums.StatusType;
import com.barbosa.repository.ChannelRepository;
import com.barbosa.repository.StatusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final ChannelRepository channelRepository;
    private final StatusRepository statusRepository;

    public DataLoader(ChannelRepository channelRepository, StatusRepository statusRepository) {
        this.channelRepository = channelRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(ChannelType.values())
                .map(ChannelType::toChannel)
                .forEach(channelRepository::save);

        Arrays.stream(StatusType.values())
                .map(StatusType::toStatus)
                .forEach(statusRepository::save);
    }
}

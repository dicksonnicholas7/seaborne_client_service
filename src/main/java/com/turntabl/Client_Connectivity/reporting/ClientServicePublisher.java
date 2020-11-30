package com.turntabl.Client_Connectivity.reporting;

import org.springframework.data.redis.listener.ChannelTopic;

public interface ClientServicePublisher {
    void publish(String message);
}

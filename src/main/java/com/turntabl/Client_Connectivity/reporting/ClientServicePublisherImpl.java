package com.turntabl.Client_Connectivity.reporting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientServicePublisherImpl implements  ClientServicePublisher{

    private final AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;

    public ClientServicePublisherImpl() {
    }

    public ClientServicePublisherImpl(RedisTemplate<String, Object> redisTemplate, ChannelTopic topic) {
        this.redisTemplate = redisTemplate;
        this.topic = topic;
    }

    @Override
    public void publish(String message) {
        System.out.println(
                "Publishing : " + message + ", " + Thread.currentThread().getName());

        redisTemplate.convertAndSend(topic.getTopic(), message);
    }

}

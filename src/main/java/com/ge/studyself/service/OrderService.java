package com.ge.studyself.service;

import com.ge.studyself.entity.OrderReturnReasonEntity;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.io.IOException;

public interface OrderService {

    void receiveMessage(Message message, OrderReturnReasonEntity content, Channel channel);
}

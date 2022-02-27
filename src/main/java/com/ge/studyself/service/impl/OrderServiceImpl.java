package com.ge.studyself.service.impl;

import com.ge.studyself.entity.OrderReturnReasonEntity;
import com.ge.studyself.service.OrderService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OrderServiceImpl implements OrderService {

    /**
     * queues：声明需要监听的队列
     * channel：当前传输数据的通道
     */
    @Override
    @RabbitListener(queues = {"hello-java-queue"})
    public void receiveMessage(Message message, OrderReturnReasonEntity content, Channel channel){

        try {
            //拿到主体内容
            System.out.println("接受到的消息...内容" + message + "===内容：" + content);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            try {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }



    }
}

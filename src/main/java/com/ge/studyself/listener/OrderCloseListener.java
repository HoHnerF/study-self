package com.ge.studyself.listener;

import com.ge.studyself.entity.OrderEntity;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RabbitListener(queues = "order.release.order.queue")
@Component
public class OrderCloseListener {

    @RabbitHandler
    public void listener(OrderEntity orderEntity, Channel channel, Message message) throws IOException {
        try {
            System.out.println("收到过期的订单信息，重新验单" + orderEntity.getName());
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

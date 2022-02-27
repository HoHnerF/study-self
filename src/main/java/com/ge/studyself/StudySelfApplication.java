package com.ge.studyself;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用RabbitMQ
 * 1、引入amqp场景;RabbitAutoConfiguration就会自动生效
 * 2、给容器中自动配置了
 *      RabbitTemplate、AmqpAdmin、CachingConnectionFactory、RabbitMessagingTemplate
 * 3、@EnableRabbit:
 */

@EnableRabbit
@SpringBootApplication
public class StudySelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySelfApplication.class, args);
    }

}

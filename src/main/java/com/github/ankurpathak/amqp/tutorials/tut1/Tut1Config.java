package com.github.ankurpathak.amqp.tutorials.tut1;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"tut1", "hello-world"})
public class Tut1Config {


    @Bean
    public Queue queue(){
        return new Queue("hello");
    }


    @Bean
    @Profile("sender")
    public Tut1Sender sender(RabbitTemplate template, Queue queue){
        return new Tut1Sender(template, queue);
    }


    @Bean
    @Profile("receiver")
    public Tut1Receiver receiver(){
        return new Tut1Receiver();
    }
}

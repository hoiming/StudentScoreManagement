package com.haiming.services.concrete;


import com.haiming.dao.Course;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class CourseMessagingService {

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Autowired
    private MessageConverter messageConverter;

    private RabbitTemplate rabbitTemplate;

    public void sendCourse(Course course){
        MessageProperties props = new MessageProperties();
        Message message = messageConverter.toMessage(course, props);
        rabbitTemplate.send("amq.direct", "course", message);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}

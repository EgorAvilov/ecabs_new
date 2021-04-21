package com.itechart.config;

import com.itechart.constants.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.itechart.constants.Constants.BOOKING_EXCHANGE;
import static com.itechart.constants.Constants.MESSAGE_EXCHANGE;
import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class RabbitConfig {
    private static final String CONNECTION_NAME = "localhost";
    private static final String INTERCEPTOR_MSG = "received from queue : ";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(CONNECTION_NAME);
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue bookingAddQueue() {
        return new Queue(Constants.BOOKING_ADD_QUEUE_NAME);
    }

    @Bean
    public Queue userAddQueue() {
        return new Queue(Constants.USER_ADD_QUEUE_NAME);
    }

    @Bean
    public Queue userFindByIdQueue() {
        return new Queue(Constants.USER_FIND_BY_ID_QUEUE_NAME);
    }

    @Bean
    public Queue bookingEditQueue() {
        return new Queue(Constants.BOOKING_EDIT_QUEUE_NAME);
    }

    @Bean
    public Queue bookingDeleteQueue() {
        return new Queue(Constants.BOOKING_DELETE_QUEUE_NAME);
    }
    @Bean
    public Queue messageAuditQueue() {
        return new Queue(Constants.MESSAGE_AUDIT_QUEUE_NAME);
    }
    @Bean
    public FanoutExchange messageExchange() {
        return new FanoutExchange(MESSAGE_EXCHANGE);
    }

    @Bean
    public DirectExchange bookingExchange() {
        return new DirectExchange(BOOKING_EXCHANGE);
    }

    @Bean
    public Binding messageExchangeToBookingExchange() {
        return bind(messageExchange()).to(messageExchange());
    }

    @Bean
    public Binding BookingExchangeToBookingAddQueue() {
        return bind(bookingAddQueue()).to(bookingExchange())
                                      .with("add booking");
    }

    @Bean
    public Binding BookingExchangeToBookingEditQueue() {
        return bind(bookingEditQueue()).to(bookingExchange())
                                       .with("edit booking");
    }

    @Bean
    public Binding BookingExchangeToBookingDeleteQueue() {
        return bind(bookingDeleteQueue()).to(bookingExchange())
                                         .with("delete booking");
    }

    @Bean
    public Binding MessageExchangeToMessageAuditQueue() {
        return bind(messageAuditQueue()).to(messageExchange());
    }
}

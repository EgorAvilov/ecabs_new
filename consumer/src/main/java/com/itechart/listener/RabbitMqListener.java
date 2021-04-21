package com.itechart.listener;


import com.itechart.service.BookingService;
import com.itechart.mapper.BookingMapper;
import com.itechart.mapper.UserMapper;
import com.itechart.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.itechart.constants.Constants.*;


@Component
@Configuration
public class RabbitMqListener {
    private final BookingService bookingService;
    private final UserService userService;
    private final BookingMapper bookingMapper;
    private final UserMapper userMapper;


    @Autowired
    public RabbitMqListener(BookingService bookingService, UserService userService, BookingMapper bookingMapper, UserMapper userMapper) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.bookingMapper = bookingMapper;
        this.userMapper = userMapper;
    }
/*
    @RabbitListener(queues = USER_ADD_QUEUE_NAME)
    public String userAddQueue(String message) throws IOException {
        return userMapper.toJSON(userService.create(userMapper.toJavaObject(message)));
    }
*/
    @RabbitListener(queues = USER_FIND_BY_ID_QUEUE_NAME)
    public String userFindByIdQueue(String message) throws IOException {
        return userMapper.toJSON(userService.findById(userMapper.toString(message)));
    }

    @RabbitListener(queues = BOOKING_ADD_QUEUE_NAME)
    public String bookingAddQueue(String message) throws IOException {
        return bookingMapper.toJSON(bookingService.create(bookingMapper.toJavaObject(message)));
    }

    @RabbitListener(queues = BOOKING_EDIT_QUEUE_NAME)
    public String bookingEditQueue(String message) throws IOException {
        return bookingMapper.toJSON(bookingService.update(bookingMapper.toJavaObject(message)));
    }

    @RabbitListener(queues = BOOKING_DELETE_QUEUE_NAME)
    public void bookingDeleteQueue(String message) throws IOException {
        bookingService.delete(bookingMapper.toLong(message));
       // return bookingMapper.toJSON(bookingService.delete(bookingMapper.toLong(message)));
    }
}

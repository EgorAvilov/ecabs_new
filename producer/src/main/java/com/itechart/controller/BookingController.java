package com.itechart.controller;


import com.itechart.constants.Constants;
import com.itechart.dto.BookingDto;
import com.itechart.mapper.BookingMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping(value = "/api/bookings")
public class BookingController {
    private final AmqpTemplate template;
    private final BookingMapper mapper;

    @Autowired
    public BookingController(AmqpTemplate template, BookingMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody BookingDto bookingDto) throws IOException {
        return new ResponseEntity<>(template.convertSendAndReceive(Constants.BOOKING_ADD_QUEUE_NAME, mapper.toJSON(bookingDto)), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity update(@RequestBody BookingDto bookingDto) throws IOException {
        return new ResponseEntity<>(template.convertSendAndReceive(Constants.BOOKING_EDIT_QUEUE_NAME, mapper.toJSON(bookingDto)), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) throws IOException {
        template.convertAndSend(Constants.BOOKING_DELETE_QUEUE_NAME, mapper.toJSON(id));
    }

}

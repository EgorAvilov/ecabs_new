package com.itechart.service;


import com.itechart.dto.BookingDto;

public interface BookingService {
    BookingDto create(BookingDto bookingDto);

    BookingDto update(BookingDto bookingDto);

    void delete(Long id);

}

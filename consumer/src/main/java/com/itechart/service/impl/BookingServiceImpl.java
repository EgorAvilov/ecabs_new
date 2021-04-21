package com.itechart.service.impl;


import com.itechart.entity.Booking;
import com.itechart.service.BookingService;
import com.itechart.dto.BookingDto;
import com.itechart.mapper.BookingMapper;
import com.itechart.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;


    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public BookingDto create(BookingDto bookingDto) {
        Booking booking = bookingMapper.dtoToEntity(bookingDto);
        booking = bookingRepository.save(booking);
        return bookingMapper.entityToDto(booking);
    }

    @Override
    public BookingDto update(BookingDto bookingDto) {
        Booking booking = bookingMapper.dtoToEntity(bookingDto);
        Booking finalBooking = booking;
        Booking persistBooking=bookingRepository.findById(booking.getId()).orElseGet(()-> {
            Booking newBooking = new Booking();
            newBooking.setId(finalBooking.getId());
            newBooking.setPassengerName(finalBooking.getPassengerName());
            newBooking.setPassengerContactNumber(finalBooking.getPassengerContactNumber());
            newBooking.setPickupTime(finalBooking.getPickupTime());
            newBooking.setAsap(finalBooking.getAsap());
            newBooking.setWaitingTime(finalBooking.getWaitingTime());
            newBooking.setNumberOfPassengers(finalBooking.getNumberOfPassengers());
            newBooking.setPrice(finalBooking.getPrice());
            newBooking.setRating(finalBooking.getRating());
            newBooking.setCreatedOn(LocalDateTime.now());
            newBooking.setLastModifiedOn(LocalDateTime.now());
            newBooking.setTripWaypoints(finalBooking.getTripWaypoints());

            return newBooking;
        });
        booking = bookingRepository.save(persistBooking);
        return bookingMapper.entityToDto(booking);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookingRepository.deleteById(id);
    }
}

package com.itechart.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.entity.Booking;
import com.itechart.dto.BookingDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookingMapper {
    public BookingDto entityToDto(Booking booking) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(booking, BookingDto.class);
    }

    public Booking dtoToEntity(BookingDto bookingDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(bookingDto, Booking.class);
    }

    public List<BookingDto> entityToDto(List<Booking> bookings) {
        return bookings.stream()
                       .map(this::entityToDto)
                       .collect(Collectors.toList());
    }

    public List<Booking> dtoToEntity(List<BookingDto> bookingDtos) {
        return bookingDtos.stream()
                          .map(this::dtoToEntity)
                          .collect(Collectors.toList());
    }

    public String toJSON(BookingDto bookingDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(bookingDto);
    }

    public BookingDto toJavaObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, BookingDto.class);
    }

    public Long toLong(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Long.class);
    }
}

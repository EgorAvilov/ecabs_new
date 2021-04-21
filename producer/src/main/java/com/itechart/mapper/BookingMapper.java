package com.itechart.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.dto.BookingDto;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BookingMapper {

    public String toJSON(BookingDto bookingDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(bookingDto);
    }


    public String toJSON(Long id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(id);
    }
}

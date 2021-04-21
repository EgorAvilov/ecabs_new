package com.itechart.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itechart.dto.TripWaypointDto;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TripWaypointMapper {

    public String toJSON(TripWaypointDto tripWaypointDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(tripWaypointDto);
    }
}

package com.itechart.mapper;


import com.itechart.entity.TripWaypoint;
import com.itechart.dto.TripWaypointDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TripWaypointMapper {
    public TripWaypointDto entityToDto(TripWaypoint tripWaypoint) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(tripWaypoint, TripWaypointDto.class);
    }

    public TripWaypoint dtoToEntity(TripWaypointDto tripWaypointDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(tripWaypointDto, TripWaypoint.class);
    }

    public List<TripWaypointDto> entityToDto(List<TripWaypoint> tripWaypoints) {
        return tripWaypoints.stream()
                            .map(this::entityToDto)
                            .collect(Collectors.toList());
    }

    public List<TripWaypoint> dtoToEntity(List<TripWaypointDto> tripWaypointDtos) {
        return tripWaypointDtos.stream()
                               .map(this::dtoToEntity)
                               .collect(Collectors.toList());
    }
}

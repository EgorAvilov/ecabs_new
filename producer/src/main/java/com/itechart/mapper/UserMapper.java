package com.itechart.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.itechart.dto.UserDto;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserMapper {

    public String toJSON(UserDto userDto) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDto);
    }

    public String toString(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, String.class);
    }

    public UserDto toJavaObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, UserDto.class);
    }

    public String toJSON(String id) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(id);
    }

}
package com.itechart.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.itechart.dto.UserDto;
import com.itechart.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto entityToDto(User user) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(user, UserDto.class);
    }

    public User dtoToEntity(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(userDto, User.class);
    }

    public List<UserDto> entityToDto(List<User> users) {
        return users.stream()
                    .map(this::entityToDto)
                    .collect(Collectors.toList());
    }

    public List<User> dtoToEntity(List<UserDto> userDtos) {
        return userDtos.stream()
                       .map(this::dtoToEntity)
                       .collect(Collectors.toList());
    }

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
package com.itechart.service;


import com.itechart.dto.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);

    UserDto findById(String id);
}

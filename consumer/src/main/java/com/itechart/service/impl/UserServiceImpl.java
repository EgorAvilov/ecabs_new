package com.itechart.service.impl;


import com.itechart.repository.UserDetailRepository;
import com.itechart.dto.UserDto;
import com.itechart.entity.User;
import com.itechart.mapper.UserMapper;
import com.itechart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDetailRepository userDetailRepository;
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserDetailRepository userDetailRepository, UserMapper mapper) {
        this.userDetailRepository = userDetailRepository;
        this.mapper = mapper;
    }


    @Override
    @Transactional
    public UserDto create(UserDto userDto) {
        User user = mapper.dtoToEntity(userDto);
        return mapper.entityToDto(userDetailRepository.save(user));
    }

    @Override
    public UserDto findById(String id) {
        return mapper.entityToDto(userDetailRepository.findById(id).get());
    }
}

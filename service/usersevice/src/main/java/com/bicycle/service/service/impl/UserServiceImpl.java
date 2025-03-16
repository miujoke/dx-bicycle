package com.bicycle.service.service.impl;

import com.bicycle.service.mapper.UserMapper;
import com.bicycle.service.model.User;
import com.bicycle.service.model.UserDto;
import com.bicycle.service.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author miujoke
 * @date 2025/3/17 0:26
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<UserDto> getAllUsers() {
        List<User> allUsers = userMapper.getAllUsers();
        if (allUsers != null) {
            List<UserDto> userDtos = allUsers.stream().map(m -> {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(m, userDto);
                return userDto;
            }).collect(Collectors.toList());
            return userDtos;
        }
        return new ArrayList<>();
    }

    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }
}

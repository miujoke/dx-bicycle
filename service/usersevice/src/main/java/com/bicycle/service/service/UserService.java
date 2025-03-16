package com.bicycle.service.service;

import com.bicycle.service.model.User;
import com.bicycle.service.model.UserDto;

import java.util.List;

/**
 * @author miujoke
 * @date 2025/3/17 0:26
 */
public interface UserService {

    public List<UserDto> getAllUsers();

    public User getUserById(Long id);

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(Long id);
}

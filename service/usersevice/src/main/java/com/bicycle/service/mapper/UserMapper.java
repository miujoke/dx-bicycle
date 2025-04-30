package com.bicycle.service.mapper;

import com.bicycle.service.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author miujoke
 * @date 2025/3/17 0:24
 */
//@Mapper
public interface UserMapper {
    List<User> getAllUsers();
    User getUserById(Long id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}

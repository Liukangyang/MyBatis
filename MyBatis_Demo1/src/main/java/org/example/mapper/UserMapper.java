package org.example.mapper;


import org.example.User;

import java.util.List;

//DAO
public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser();


    /**
     * 查询实体类对象
     */
    User getUserById();

    /**
     * 查询用户集合
     */
    List<User> getAllUsers();
}

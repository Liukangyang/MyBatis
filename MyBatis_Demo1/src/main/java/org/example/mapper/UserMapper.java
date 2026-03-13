package org.example.mapper;


import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.User;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据用户名查询
     */
    User getUserByName(String username);

    /**
     *
     */
    User CheckLogin(String username,String password);

    /**
     * 验证登录：Map
     */
    User CheckLoginByMap(Map<String,Object> map);

    User CheckLoginByUser(User user);

    //查询单个对象
    User CheckLoginById(@Param("ID") Integer id);

    //查询多个对象的集合
    List<User> getUserBySex(@Param("sex") String sex);


    /**
     * 查询用户数量
     */
    Integer getUserCount();

    /**
     * 查询返回Map集合
     */
    List<Map<String,Object>> getUsersByAge(@Param("age") int age);

    @MapKey("id")
    Map<Integer,Object> getAllUsersMap();

    /**
     * 模糊查询
     */
    List<User> getUserByLike(@Param("username") String username);


    /**
     * 动态设置表名
     */
    List<User> getAllUsersByTable(@Param("table") String tabelname);

    /**
     * 获取更新主键值
     */
    int insertUserGetId(User user);

}

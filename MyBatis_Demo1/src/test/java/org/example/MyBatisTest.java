package org.example;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest extends TestCase{

    public SqlSession getSqlSession() throws IOException {
        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //获取Builder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //通过核心配置文件获取session工厂
        SqlSessionFactory sqlSessionFactory = builder.build(in);

        //创建sqlsession对象，并自动提交事务
        SqlSession session = sqlSessionFactory.openSession(true);
        return session;
    }

    public void testMyBatis() throws IOException {
        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //获取Builder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //通过核心配置文件获取session工厂
        SqlSessionFactory sqlSessionFactory = builder.build(in);

        //创建sqlsession对象，并自动提交事务
        SqlSession session = sqlSessionFactory.openSession(true);

        //通过代理获取Mapper接口
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //执行SQL操作
        int r = userMapper.insertUser();

        // 提交事务
        //session.commit();

        //打印结果
        System.out.println("reuslt:" + r);

    }


    public void testGetUser() throws IOException {
        //加载核心配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //获取Builder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //通过核心配置文件获取session工厂
        SqlSessionFactory sqlSessionFactory = builder.build(in);

        //创建sqlsession对象，并自动提交事务
        SqlSession session = sqlSessionFactory.openSession(true);

        //通过代理获取Mapper接口
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //执行SQL操作
        //User user = userMapper.getUserById();

        // 提交事务
        //session.commit();

       // System.out.println(user.toString());

        List<User> users = userMapper.getAllUsers();
        users.forEach(user-> System.out.println(user.toString()));
    }


    public void testGetUserByName() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //
        User user = userMapper.getUserByName("admin");
        //
        System.out.println(user);

    }

    public void testCheckLogin() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = userMapper.CheckLogin("admin","123456");
        System.out.println(user);
    }

    public void testCheckLoginByMap() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        User user = userMapper.CheckLoginByMap(map);
        System.out.println(user);
    }


    public void testCheckLoginByUser() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User checkuser = new User(2,"admin2","123456",24,"女");

        User user = userMapper.CheckLoginByUser(checkuser);
        System.out.println(user);
    }

    public void testCheckLoginById() throws IOException {
         SqlSession session = getSqlSession();
          UserMapper userMapper =  session.getMapper(UserMapper.class);
          User user = userMapper.CheckLoginById(3);
          System.out.println(user);
    }

    public void testGetUsersBySex() throws IOException {
        SqlSession session = getSqlSession();
        UserMapper userMapper =  session.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserBySex("女");
        users.forEach(user-> System.out.println(user));
    }

    public void testGetUserCount() throws IOException{
        SqlSession session = getSqlSession();
        UserMapper userMapper =  session.getMapper(UserMapper.class);
        Integer count = userMapper.getUserCount();
        System.out.println("User count:"+count);
    }


    public void testGetUsersByAge() throws IOException{
        SqlSession session = getSqlSession();
        UserMapper userMapper =  session.getMapper(UserMapper.class);
        List<Map<String,Object>> userlist = userMapper.getUsersByAge(24);
        userlist.forEach(usrmap-> System.out.println(usrmap));
    }

    public void testGetAllUsersMap() throws IOException{
        SqlSession session = getSqlSession();
        UserMapper userMapper =  session.getMapper(UserMapper.class);
        Map<Integer,Object> result = userMapper.getAllUsersMap();
        System.out.println("result"+result);
        System.out.println("User info:");
        for(Integer key:result.keySet()){
           //Map<String,Object> usermap=(Map<String,Object>)result.get(key);
            System.out.println(result.get(key));
        }
    }

    public void testGetUsersLike() throws IOException{
        SqlSession session = getSqlSession();
        UserMapper userMapper =  session.getMapper(UserMapper.class);
        List<User> userlist = userMapper.getUserByLike("admin");
        userlist.forEach(user-> System.out.println(user));
    }

    public void testGetAllUsersByTable() throws IOException{
        SqlSession session = getSqlSession();
        UserMapper userMapper =  session.getMapper(UserMapper.class);
        List<User> userlist = userMapper.getAllUsersByTable("t_user");
        userlist.forEach(user-> System.out.println(user));
    }

    public void testInsertUser() throws IOException{
        SqlSession session = getSqlSession();
        UserMapper userMapper =  session.getMapper(UserMapper.class);
        User user = new User(null,"WYQ","123456",28,"女");
        int r = userMapper.insertUserGetId(user);
        System.out.println("insert user info:"+user);
    }



}

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
import java.util.List;

public class MyBatisTest extends TestCase{

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

}

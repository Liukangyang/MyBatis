package org.example;

import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.DynamicSQLMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest extends TestCase {


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


    public void testGetEmpByCondition() throws IOException {
        SqlSession session =getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = session.getMapper(DynamicSQLMapper.class);
        Emp emp  = new Emp(null,null,null,null);
        List<Emp> emps = dynamicSQLMapper.getEmpByCondition(emp);
        System.out.println(emps);
    }

    public void testInsertMultiEmps() throws IOException {
        SqlSession session =getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = session.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"XX1","156784651",1);
        Emp emp2 = new Emp(null,"XX2","156784652",2);
        Emp emp3 = new Emp(null,"XX3","156784653",3);
        List<Emp> emps = Arrays.asList(emp1,emp2,emp3);
        int r = dynamicSQLMapper.insertMultiEmps(emps);
        System.out.println("insert result is :"+r);
    }
}
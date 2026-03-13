package org.example;

import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.EmpMapper;

import javax.crypto.spec.PSource;
import java.io.IOException;
import java.io.InputStream;

public class EmpMapperTest extends TestCase {

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


    public void testInsertEmpInfo() throws IOException {
        SqlSession session = getSqlSession();
         EmpMapper empMapper= session.getMapper(EmpMapper.class);
         int r = empMapper.insertEmpInfo(3,"YYY","17328493024",2);
        System.out.println("insert result:"+r);

    }

    public void testGetEmpByEid() throws IOException {
            SqlSession session = getSqlSession();
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            Emp emp = empMapper.getEmpByEid(5);
            System.out.println(emp);
    }
}
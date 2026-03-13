package org.example;

import junit.framework.TestCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.DeptMapper;
import org.example.mapper.EmpMapper;

import java.io.IOException;
import java.io.InputStream;

public class DeptMapperTest extends TestCase {
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

    public void testInsertDeptInfo() throws IOException {
        SqlSession session = getSqlSession();
        DeptMapper deptMapper= session.getMapper(DeptMapper.class);
        int r = deptMapper.insertDeptInfo(3,"C");
        System.out.println("insert result:"+r);
    }

    public void testGetDeptByDid() throws IOException {
        SqlSession session = getSqlSession();
        DeptMapper deptMapper= session.getMapper(DeptMapper.class);
        Dept dept =  deptMapper.getDeptByDid(1);
        System.out.println(dept);
    }

    public void testGetDeptAndEmps() throws IOException {
        SqlSession session = getSqlSession();
        DeptMapper deptMapper= session.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmps(1);
        System.out.println(dept);

    }

    public void testGetDeptAndEmpsByStepTwo() throws IOException {
        SqlSession session = getSqlSession();
        DeptMapper deptMapper= session.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpsByStepTwo(1);
        System.out.println(dept);
    }
}
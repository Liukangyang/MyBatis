package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.EmpMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class MBGTest extends TestCase{

    public void testMBG() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

//       List<Emp> emps = mapper.selectByExample(null);
        EmpExample example = new EmpExample();
        example.createCriteria().andEidGreaterThan(1).andDidBetween(1,2);
        //example.or().andEmpNameIsNotNull();
        List<Emp> emps = mapper.selectByExample(example);
        emps.forEach(emp-> System.out.println(emp));

    }
}

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

//        条件查询
        EmpExample example = new EmpExample();
        example.createCriteria().andEidGreaterThan(0).andDidBetween(1,3);
        //example.or().andEmpNameIsNotNull();
        List<Emp> emps = mapper.selectByExample(example);
        emps.forEach(emp-> System.out.println(emp));

//        条件修改
//        mapper.updateByPrimaryKey(new Emp(1,"LKY",null,2));
//        mapper.updateByPrimaryKeySelective(new Emp(1,null,null,3));

    }
}

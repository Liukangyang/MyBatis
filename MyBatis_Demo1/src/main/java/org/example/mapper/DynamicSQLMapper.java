package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.Emp;

import java.util.List;

public interface DynamicSQLMapper {

    /**
     * 多条件查询
     */

    List<Emp> getEmpByCondition(Emp emp);

    /**
     * foreach
     */
    int insertMultiEmps(@Param("emps") List<Emp> emps);

}

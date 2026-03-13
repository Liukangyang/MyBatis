package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.Emp;

import java.util.List;

public interface EmpMapper {
    /**
     * 添加员工信息
     */
    int insertEmpInfo(@Param("eid") int eid,@Param("emp_name") String name,
                      @Param("emp_telecom") String telecom, @Param("did") int did);

    /**
     * 获取员工信息（多对一查询情形）
     */
    Emp getEmpByEid(@Param("eid") int eid);

    /**
     * 根据部门did获取员工
     */
    List<Emp> getEmpsByDid(@Param("did") int did);

}

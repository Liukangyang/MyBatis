package org.example.mapper;
import org.apache.ibatis.annotations.Param;
import org.example.Dept;
public interface DeptMapper {
    /**
     * 添加部门信息
     */
    int insertDeptInfo(@Param("did") int did, @Param("dept_name") String deptName);

    /**
     * 根据did获取部门信息
     */
    Dept getDeptByDid(@Param("did") int did);


    /**
     * 获取部门以及部门中的所有员工信息:级联查询
     */
    Dept getDeptAndEmps(@Param("did") int did);

    /**
     * 获取部门以及部门中的所有员工信息：分步查询
     */

    Dept getDeptAndEmpsByStepTwo(@Param("did") int did);

}

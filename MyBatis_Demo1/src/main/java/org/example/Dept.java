package org.example;

import java.util.List;

public class Dept {
    private int did;
    private String deptName;
    private List<Emp> emps;  //部门里的员工集合

    public Dept() {
    }

    public Dept(int did,String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ",emps="+ emps +
                '}';
    }
}

package org.example;

public class Emp {
    private int eid;
    private String name;
    private String telecom;
    private int did;
    private Dept dept; //部门对象作为成员


    public Emp() {
    }

    public Emp(int eid, String name, String telecom, int did) {
        this.eid = eid;
        this.name = name;
        this.telecom = telecom;
        this.did = did;
        this.dept = new Dept(did,"null");
    }

    public Emp(Integer eid, String name, String telecom, Integer did) {
    if(eid!=null)
        this.eid = eid;
     this.name = name;
     this.telecom = telecom;
     if(did!=null)
         this.did = did;
    }

    public Emp(Integer o, Object o1, Object o2, Object o3) {
    }


    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelecom() {
        return telecom;
    }

    public void setTelecom(String telecom) {
        this.telecom = telecom;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", telecom='" + telecom + '\'' +
                ", dept_did=" + did +
                '}';
    }
}

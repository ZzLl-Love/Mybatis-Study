package cn.zyy.domain;

import java.util.List;

/**
 * 班级类
 */
public class Grade {

    private Long gid;
    private String name;

    /**
     * 能体现出一个班级对应多个学生
     */
    private List<Student> students;

    public Grade() {
    }

    public Grade(Long gid, String name, List<Student> students) {
        this.gid = gid;
        this.name = name;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}

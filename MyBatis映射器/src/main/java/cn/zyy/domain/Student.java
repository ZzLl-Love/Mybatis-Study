package cn.zyy.domain;

/**
 * 学生类
 */
public class Student {

    /**
     * 学生id
     */
    private long sid;
    private String name;
    private int age;

    /**
     * 班级id
     */
    private long classId;

    /**
     * 体现出多个学生对应一个班级
     */
    private  Grade grade;

    public Student(long sid, String name, int age, long classId, Grade grade) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.classId = classId;
        this.grade = grade;
    }

    public Student() {
    }

    public Student(long sid, String name, int age, long classId) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.classId = classId;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    public long getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getClassId() {
        return classId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classId=" + classId +
                ", grade=" + grade +
                '}';
    }
}

package cn.zyy.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Zz
 * @Date: 2023/10/28/13:15
 * @Description:  怪兽类
 */
public class Monster implements Serializable {

    private static final long serialVersionUID = -816889905433205332L;

    private int id;
    private int age;
    private Date birthday;
    private String email;
    private int gender;
    private String name;
    private double salary;

    public Monster() {
    }

    public Monster(int id, int age, Date birthday, String email, int gender, String name, double salary) {
        this.id = id;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", age=" + age +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

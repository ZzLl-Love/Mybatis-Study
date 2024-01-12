package cn.zyy.mapper;

import cn.zyy.domain.Grade;
import cn.zyy.domain.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 查询多个学生对应哪个班级
     * @return
     *
     * 复习 ：多对一查询
     */
    List<Student> selAllStusInclGrade();


    /**
     * 查询学生信息，包含班级信息
     * 复习：嵌套查询
     */
    List<Student>  listAllStusByAssociationSelect();

    Grade  getClassById(Long id);
}

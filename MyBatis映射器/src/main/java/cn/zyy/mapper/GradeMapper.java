package cn.zyy.mapper;

import cn.zyy.domain.Grade;
import cn.zyy.domain.Student;

import java.util.List;

public interface GradeMapper {

    /**
     * 查询班级里面的多个学生
     * @param id
     * @return
     *
     * 复习：一对多的查询
     */
    Grade getGradeIncludeStus(long id);

}

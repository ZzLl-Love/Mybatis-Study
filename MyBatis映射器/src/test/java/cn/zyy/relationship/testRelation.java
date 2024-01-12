package cn.zyy.relationship;

import cn.zyy.domain.Grade;
import cn.zyy.domain.Student;
import cn.zyy.mapper.GradeMapper;
import cn.zyy.mapper.StudentMapper;
import cn.zyy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 用来测试 Mybatis中的一对多和多对一的关系
 */
public class testRelation {

    SqlSession sqlSession = MybatisUtils.getSqlSession();
    GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);


    /**
     * 测试一对多的关系
     */
    @Test
    public void testGetGradeIncludeStus(){

        Grade gradeIncludeStus = gradeMapper.getGradeIncludeStus(1l);
        System.out.println(gradeIncludeStus);
    }


    /**
     * 测试多对一的关系
     */
    @Test
    public void testSelAllStusInclGrade(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selAllStusInclGrade();
        System.out.println(students);
    }


    /**
     *测试嵌套查询
     */
    @Test
    public void testQTao(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.listAllStusByAssociationSelect();
        System.out.println(students);
    }
}

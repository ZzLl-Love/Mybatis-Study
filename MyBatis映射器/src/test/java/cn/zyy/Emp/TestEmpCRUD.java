package cn.zyy.Emp;

import cn.zyy.domain.Employee;
import cn.zyy.mapper.EmployeeMapper;
import cn.zyy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TestEmpCRUD {

    private SqlSession sqlSession = MybatisUtils.getSqlSession();
    EmployeeMapper empMapper = sqlSession.getMapper(EmployeeMapper.class);


    @Test
    public void testSelectEmpCount(){
        int empCount = empMapper.selectEmpCount();
        System.out.println("员工数量:" + empCount);
    }


    /**
     * 查询员工信息通过id
     */
    @Test
    public void testSelEmpById(){
       Employee employee =  empMapper.selEmpById(1l);
        System.out.println(employee);
    }


    /**
     * 查询所有的员工对象List
     */
    @Test
    public void testSelEmpAll(){
       List<Employee> empAll =  empMapper.selEmpAll();
        for (Employee employee : empAll) {
            System.out.println(employee);
        }
    }


    /**
     * 根据id查询员工信息
     */
    @Test
    public void testSelEmpByIdMap(){
      Map emp = empMapper.selectEmpByIdMap(1L);
        System.out.println(emp);
        Class<? extends Map> aClass = emp.getClass();
        System.out.println(aClass);
    }

}

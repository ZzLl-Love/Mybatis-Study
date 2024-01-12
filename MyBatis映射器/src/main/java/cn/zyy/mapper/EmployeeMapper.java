package cn.zyy.mapper;

import cn.zyy.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    /**
     * 查询全部员工数量
     * 目的复习知识点，当查询返回的是单个值 ===》 resultType = java.lang.Integer
     * @return
     */
     public int selectEmpCount();


    /**
     * 根据id查询员工信息
     * @param id
     * @return
     *复习 ：查询单个具体的对象 ====》 resultType = resultType="cn.zyy.domain.Employee
     */
    public Employee  selEmpById( long id);


    /**
     * 查询所有的员工对象
     * @return
     * 复习：查询集合对象  resultType =  resultType="cn.zyy.domain.Employee"
     */
    public List<Employee> selEmpAll();


    /**
     * 根据id查询员工信息
     * 复习：查询单个Map对象 resultType = 查询单个Map对象
     */
    public Map selectEmpByIdMap(long id);






}

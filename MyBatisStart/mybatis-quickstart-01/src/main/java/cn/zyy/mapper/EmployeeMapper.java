package cn.zyy.mapper;

import cn.zyy.domain.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

    /**
     *  查询员工信息
     * @param id 员工id
     * @return
     */
    Employee selectEmployee(@Param("id") Long id);

    /**
     * 插入员工
     * @param emp
     */
    void insert(@Param("emp")Employee emp);

    /**
     * 删除
     * @param id
     */
    void delete(@Param("id") Long id);

    /**
     * 修改员工信息
     * @param emp
     */
    void update(@Param("emp") Employee emp);
}

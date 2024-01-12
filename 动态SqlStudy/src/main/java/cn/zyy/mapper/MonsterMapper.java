package cn.zyy.mapper;

import cn.zyy.domain.Monster;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zz
 * @Date: 2023/10/29/13:00
 * @Description: 致敬
 */
public interface MonsterMapper {

    /**
     * 根据age来查询
     * age < 0 查询所有数据
     * age > num 查询age>num的怪兽列表信息
     * @param age
     * @return
     */
    public List<Monster> findMonsterByAge(@Param("age") Integer age);


    /**
     * 根据id 和name 来查询结果
     * @param monster
     * @return
     *  测试<WHERE>标签的使用
     */
    public List<Monster> findMonsterByIdAndName(Monster monster);

    /**
     *
     * @param map
     * @return
     * 测试choose标签的使用
     */
    public List<Monster> findMonsterByIdAndName_Choose(Map<String, Object> map);


    /**
     * 测试forech的标签使用
     * @param map
     * @return
     */
    public List<Monster> findMonsterById_foreach(Map<String, List<Integer>> map);

    /**
     * 测试Set标签
     * @param map
     */
    public void updateMonster_set(Map<String, Object> map);
}

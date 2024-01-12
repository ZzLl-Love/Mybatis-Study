package cn.zyy.mapper;

import cn.zyy.domain.Monster;

/**
 * @Author: Zz
 * @Date: 2023/10/28/13:20
 * @Description:  mapper 接口
 */
public interface MonsterMapper {

    /**
     * 根据id查怪兽
     * @param id
     * @return
     */
    Monster getMonsterById(int id);


    /**
     * 修改怪兽信息
     * @param monster
     */
    void updateMonster(Monster monster);
}

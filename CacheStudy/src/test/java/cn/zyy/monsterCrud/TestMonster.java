package cn.zyy.monsterCrud;

import cn.zyy.domain.Monster;
import cn.zyy.mapper.MonsterMapper;
import cn.zyy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author: Zz
 * @Date: 2023/10/28/13:23
 * @Description: 致敬
 */
public class TestMonster {

    SqlSession sqlSession = MybatisUtils.getSqlSession();
    MonsterMapper monsterMapper = sqlSession.getMapper(MonsterMapper.class);

    @Test
    public void testGetMonsterById(){
        Monster monster = monsterMapper.getMonsterById(3);
        System.out.println(monster);
    }



    /**
     * 测试修改monster
     */
    @Test
    public void testUpdateMonster(){

        Monster monster = monsterMapper.getMonsterById(3);
        monster.setName("左怪2");
        monsterMapper.updateMonster(monster);

        //提交，更新数据中表的信息
        if(sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }



    /**
     * 测试一级缓存机制问题
     */
    @Test
    public void level1CacheTest(){

        System.out.println("===================第一次查询================");
        //查询id=3的monster
        Monster monster1 = monsterMapper.getMonsterById(3);
        System.out.println(monster1);

        System.out.println("===================第二次查询================");

        //第二次查询id=3的monster
        Monster monster2 = monsterMapper.getMonsterById(3);
        System.out.println(monster2);
    }


    /**
     * 测试一级缓存失效的问题
     * 失效原因： 关闭了sqlSession
     */
    @Test
    public void level1CacheTest1(){
        System.out.println("===================第一次查询================");
        //查询id=3的monster
        Monster monster1 = monsterMapper.getMonsterById(3);
        System.out.println(monster1);

        /**
         * 再第一次和第二次查询之间关闭了sqlSession
         */
        if(sqlSession != null){
            sqlSession.close();
        }

        System.out.println("===================第二次查询================");

        //第二次查询id=3的monster
         sqlSession = MybatisUtils.getSqlSession();
        MonsterMapper monsterMapper = sqlSession.getMapper(MonsterMapper.class);
        Monster monster2 = monsterMapper.getMonsterById(3);
        System.out.println(monster2);
    }


    /**
     * 测试一级缓存失效的问题
     * 失效原因： 执行了sqlSession.clearCarche()
     */
    @Test
    public void level1CacheTest2(){
        System.out.println("===================第一次查询================");
        //查询id=3的monster
        Monster monster1 = monsterMapper.getMonsterById(3);
        System.out.println(monster1);

        /**
         * sqlSession.clearCarche()
         */
        sqlSession.clearCache();

        System.out.println("===================第二次查询================");

        //第二次查询id=3的monster
        Monster monster2 = monsterMapper.getMonsterById(3);
        System.out.println(monster2);
    }

    /**
     * 测试一级缓存失效问题
     * 情况三： 修改了同一个Monster对象
     */
    @Test
    public void level1CacheTest3(){
        System.out.println("===================第一次查询================");
        //查询id=3的monster
        Monster monster1 = monsterMapper.getMonsterById(3);
        System.out.println(monster1);

        /**
         * 修改Monster对象
         */
        monster1.setName("Z东风不败");
        monsterMapper.updateMonster(monster1);

        System.out.println("===================第二次查询================");

        //第二次查询id=3的monster
        Monster monster2 = monsterMapper.getMonsterById(3);
        System.out.println(monster2);

        /**
         * 提交操作
         */
        if(sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }


    //=============================================测试二级缓存=====================================================
    /**
     * 测试二级缓存
     */
    @Test
    public void level2CacheTest(){
        System.out.println("===================第一次查询================");
        //查询id=3的monster
        Monster monster1 = monsterMapper.getMonsterById(3);
        System.out.println(monster1);


        /**
         * 关闭sqlSession
         */
        if(sqlSession != null){
            sqlSession.close();
        }

        sqlSession = MybatisUtils.getSqlSession();
        MonsterMapper monsterMapper = sqlSession.getMapper(MonsterMapper.class);
        System.out.println("===================第二次查询================");
        //第二次查询id=3的monster
        Monster monster2 = monsterMapper.getMonsterById(3);
        System.out.println(monster2);
    }


    //=============================================测试一级缓存和二级缓存的执行顺序=====================================================
    @Test
    public void cacheSeqTest(){
        System.out.println("===================第一次查询================");
        //查询id=3的monster
        Monster monster1 = monsterMapper.getMonsterById(3);
        System.out.println(monster1);


        System.out.println("===================第二次查询================");
        //第二次查询id=3的monster
        Monster monster2 = monsterMapper.getMonsterById(3);
        System.out.println(monster2);

        System.out.println("===================第三次查询================");
        //第二次查询id=3的monster
        Monster monster3 = monsterMapper.getMonsterById(3);
        System.out.println(monster2);

    }
}

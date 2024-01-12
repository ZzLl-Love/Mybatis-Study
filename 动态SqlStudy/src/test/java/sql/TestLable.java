package sql;

import cn.zyy.domain.Monster;
import cn.zyy.mapper.MonsterMapper;
import cn.zyy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zz
 * @Date: 2023/10/29/15:38
 * @Description: 测试动态标签
 */
public class TestLable {

    //属性
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    /**
     *  当方法标注 @Before, 表示在执行你的目标测试方法前，会先执行该方法
     */
    @Before
    public void init(){
        sqlSession = MybatisUtils.getSqlSession();
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }


    /**
     * 测试动态sql中的if标签
     */
    @Test
    public void testIf(){

        List<Monster> monsters = monsterMapper.findMonsterByAge(-1);
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }


    /**
     * 测试动态sql中的WHERE标签
     */
    @Test
    public void  testWHERE(){
        Monster monster = new Monster();
        monster.setId(-1);
        monster.setName("");
        List<Monster> monsters = monsterMapper.findMonsterByIdAndName(monster);
        for (Monster m : monsters) {
            System.out.println(m);
        }
    }

    @Test
    public void testChoose(){
        Map<String, Object> map = new HashMap<>();
        //map.put("name", "牛魔王");
        //map.put("id", 22);
        List<Monster> monsters = monsterMapper.findMonsterByIdAndName_Choose(map);
        for (Monster m : monsters) {
            System.out.println(m);
        }

    }

    @Test
    public void testForEach(){

        //准备数据
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("ids", Arrays.asList(11,22));

        List<Monster> monsters = monsterMapper.findMonsterById_foreach(map);
        for (Monster m : monsters) {
            System.out.println(m);
        }
    }


    @Test
    public void testSet(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 18);
        map.put("email" , "zyy@qq.com");
        map.put("id" , 3);

        monsterMapper.updateMonster_set(map);

        sqlSession.commit();
    }

}

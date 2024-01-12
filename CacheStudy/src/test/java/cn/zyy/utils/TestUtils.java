package cn.zyy.utils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestUtils {

    /**
     * 测试能否拿到SqlSession对象  ====》 ok  ===》happy
     */
    @Test
    public void testGetSqlSession() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        System.out.println(sqlSession);
    }

}

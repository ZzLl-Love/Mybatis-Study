package cn.zyy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 该工具类 获取sqlSession的实例
 *  作用 ：SqlSession提供了对数据库执行SQL命令所需的所有方法
 *        通过SqlSession实例来直接执行以映射的SQL语句
 */
public class MybatisUtils {

    /**
     * 初始化SqlSessionFactory对象
     */
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            String resource = "mybatis-config.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取SqlSession的实例
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}

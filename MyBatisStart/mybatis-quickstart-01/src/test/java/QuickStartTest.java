import cn.zyy.domain.Employee;
import cn.zyy.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class QuickStartTest {


    @Test
    public void testMybatis01() throws IOException {

        //
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);

        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.selectEmployee(1L);
            System.out.println(employee);

            //插入
            Employee addEmp = new Employee(null, "zz", 11, "上海");
            mapper.insert(addEmp);


            //删除
            mapper.delete(10L);


        }


    }
}

package com.cqjtu.cssl;

import com.cqjtu.cssl.entity.TestFile;
import com.cqjtu.cssl.service.TestFileService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestFileMapperTest {

    @Autowired
    private TestFileService testFileService;

/*    @Test
    public void addFile() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        //反射生成的动态代理类
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser();
        session.commit();
        session.close();
    }

    @Test
    public void findOneUser() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        //反射生成的动态代理类
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findOne();
        System.out.println(user);
        session.commit();
        session.close();
    }*/

    @Test
    public void findOneGenderUser() throws IOException {

        byte[] file=new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0};

//        TestFile testFile=new TestFile (1,file);

//        testFileService.addFile(testFile);
        System.out.println(file);
    }

}

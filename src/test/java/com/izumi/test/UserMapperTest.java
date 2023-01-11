package com.izumi.test;

import com.izumi.mapper.BrandMapper;
import com.izumi.mapper.UserMapper;
import com.izumi.pojo.Brand;
import com.izumi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {

    @Test
    public void testSelectById() throws IOException {
        // 1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. ��ȡMapper�ӿڵĴ������
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4. ִ�з���
        User brands = userMapper.selectById(1);
        System.out.println("9999" +brands);

        // 5. �ͷ���Դ
        sqlSession.close();
    }
}

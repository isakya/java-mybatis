package com.izumi;

import com.izumi.mapper.UserMapper;
import com.izumi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/***
 * Mybatis ������
 */
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        // 1. ����mybatis�ĺ��������ļ�����ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. ��ȡSqlSession����������ִ��sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. ִ��sql
        // List<User> users = sqlSession.selectList("test.selectAll");
        // 3.1 ��ȡUserMapper �ӿڵĴ������
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        System.out.println(users);

        // 4. �ͷ���Դ
        sqlSession.close();
    }
}

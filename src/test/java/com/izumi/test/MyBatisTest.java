package com.izumi.test;

import com.izumi.mapper.BrandMapper;
import com.izumi.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        // 1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. ����ȥMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. ִ�з���
        List<Brand> brands = brandMapper.selectAll();
        System.out.println("9999" +brands);

        // 5. �ͷ���Դ
        sqlSession.close();
    }
}

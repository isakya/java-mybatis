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
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testSelectById() throws IOException {
        // ���ղ���
        int id = 1;

        // 1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. ����ȥMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. ִ�з���
        Brand brands = brandMapper.selectById(id);
        System.out.println("9999" +brands);

        // 5. �ͷ���Դ
        sqlSession.close();
    }


    @Test
    public void testSelectByCondition() throws IOException {
        // ���ղ���
        int status = 1;
        String companyName = "��Ϊ";
        String brandName = "��Ϊ";

        // �������
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // ��װ����
        /*
            Brand brand = new Brand();
            brand.setStatus(status);
            brand.setCompanyName(companyName);
            brand.setBrandName(brandName);
         */

        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        // map.put("brandName", brandName);

        // 1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. ����ȥMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. ִ�з���
        // List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        // List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println("9999" +brands);

        // 5. �ͷ���Դ
        sqlSession.close();
    }


    @Test
    public void testSelectByConditionSingle() throws IOException {
        // ���ղ���
        int status = 1;
        String companyName = "��Ϊ";
        String brandName = "��Ϊ";

        // �������
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // ��װ����

            Brand brand = new Brand();
            brand.setStatus(status);
            // brand.setCompanyName(companyName);
            // brand.setBrandName(brandName);


        // 1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. ��ȡSqlSession����
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. ����ȥMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. ִ�з���
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println("9999" +brands);

        // 5. �ͷ���Դ
        sqlSession.close();
    }




    @Test
    public void testAdd() throws IOException {
        // ���ղ���
        int status = 1;
        String companyName = "�����ֻ�";
        String brandName = "����";
        String description = "�ֻ��е�ս����";
        int ordered = 100;

        // ��װ����
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);


        // 1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. ��ȡSqlSession����
        // true: �����Զ��ύ����
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. ����ȥMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. ִ�з���
        brandMapper.add(brand);

        // �ύ����
        // sqlSession.commit();

        // 5. �ͷ���Դ
        sqlSession.close();
    }


    @Test
    public void testAdd2() throws IOException {
        // ���ղ���
        int status = 1;
        String companyName = "�����ֻ�";
        String brandName = "����";
        String description = "�ֻ��е�ս����";
        int ordered = 100;

        // ��װ����
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);


        // 1. ��ȡSqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. ��ȡSqlSession����
        // true: �����Զ��ύ����
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 3. ����ȥMapper�ӿڵĴ������
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. ִ�з���
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println("@@@"+id);


        // 5. �ͷ���Դ
        sqlSession.close();
    }
}

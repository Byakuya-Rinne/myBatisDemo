package com.test;

import com.mapper.BrandMapper;
import com.pojo.Brand;
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
        //加载mybatis核心配置文件, 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSessionFactory对象, 用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        List<Brand> brands = brandMapper.selectAll();

        System.out.println(brands);
        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {
        int id = 2;

        //加载mybatis核心配置文件, 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSessionFactory对象, 用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        List<Brand> brands = brandMapper.selectById(id);

        System.out.println(brands);
        sqlSession.close();

    }


}

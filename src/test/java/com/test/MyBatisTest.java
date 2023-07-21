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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Test
    public void selectByCondition() throws IOException {


        int status = 1;
        String companyName = "华为";
        //String brandName = "华为";

        companyName = "%" + companyName + "%";
        //brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        brand.setStatus(status);
        //brand.setBrandName(brandName);
        brand.setCompanyName(companyName);

        Map map = new HashMap();
        map.put("status", status);
        //map.put("brandName",brandName);
        map.put("companyName", companyName);


        //加载mybatis核心配置文件, 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSessionFactory对象, 用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
        List<Brand> brands = brandMapper.selectByCondition(brand);
//        List<Brand> brands = brandMapper.selectByCondition(map);

        System.out.println(brands);
        sqlSession.close();
    }


}

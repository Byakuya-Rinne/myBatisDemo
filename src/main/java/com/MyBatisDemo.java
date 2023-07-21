package com;

import com.mapper.UserMapper;
import com.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        //加载mybatis核心配置文件, 获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSessionFactory对象, 用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行SQL
        //List<User> users = sqlSession.selectList("userTest.selectAll");
        //UserMapper接口和UserMapper.xml放在一样的目录结构下
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();


        System.out.println(users);
        sqlSession.close();
    }


}

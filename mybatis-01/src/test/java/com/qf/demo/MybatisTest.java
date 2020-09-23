package com.qf.demo;


import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {


    @Test
    public void testFindAll()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> users = userDao.findAll();

        System.out.println(users);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindById()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findById(1);

        System.out.println(user);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testAddUser()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setName("张三三三三");
        user.setPassword("444");

        userDao.addUser(user);

        System.out.println(user);

        sqlSession.commit();//提交
        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }


    @Test
    public void testUpdateUser()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setId(8);
        user.setName("lisi");
        user.setPassword("444");

        userDao.updateUser(user);

        System.out.println(user);

        sqlSession.commit();//提交
        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }


    @Test
    public void testDeleteUser()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

       userDao.deleteUser("8");

        sqlSession.commit();//提交
        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindByName()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        //List<User> users = userDao.findByName1("张");
        //List<User> users = userDao.findByName2("%张%");
        List<User> users = userDao.findByName3("张");

        System.out.println(users);
        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testGetTotalCount()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        System.out.println(userDao.getTotalCount());
        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindByPageData()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("first",2);
        map.put("pageNum",2);

        List<User> pageData = userDao.findByPageData(map);
        System.out.println(pageData);
        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }
}

package com.qf.test;

import com.qf.dao.PassengerDao;
import com.qf.pojo.Passenger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MybatisTest {

    @Test
    public void testFindById()throws Exception{

        //准备环境
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //-------------------------------------------------------------

        PassengerDao passengerDao = sqlSession.getMapper(PassengerDao.class);

        Passenger passenger = passengerDao.findById(1);

        System.out.println(passenger);

        //-------------------------------------------------------------
        sqlSession.close();
        inputStream.close();
    }


}

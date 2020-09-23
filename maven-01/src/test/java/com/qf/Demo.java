package com.qf;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo {

    @BeforeClass
    public static void init() {
        System.out.println("准备环境...");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @AfterClass
    public static void destroy() {
        System.out.println("结束环境...");
    }



}



package com.qf.controller;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


public class MyServlet extends HttpServlet {

    public MyServlet() {
        System.out.println("MyServlet无参构造");

    }


    //无参init
//    @Override
//    public void init() throws ServletException {
//        System.out.println("无参init");
//    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("有参init");
        ServletContext servletContext = config.getServletContext();


        Enumeration enumeration = servletContext.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
                String name = enumeration.nextElement().toString();
                String value = servletContext.getInitParameter(name);
                System.out.println(name + ":" + value);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MySevlet doGet");
    }
}

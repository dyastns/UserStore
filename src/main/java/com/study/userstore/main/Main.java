package com.study.userstore.main;

import com.study.userstore.dao.UserDao;
import com.study.userstore.dao.jdbc.JdbcUserDao;
import com.study.userstore.service.impl.DefaultUserService;
import com.study.userstore.web.servlet.UsersServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class Main {
    public static void main(String[] args) throws Exception {
        //config dao
        UserDao userDao = new JdbcUserDao();
        //config service
        DefaultUserService userService = new DefaultUserService();
        userService.setUserDao(userDao);
        //config servlet
        UsersServlet usersServlet = new UsersServlet();
        usersServlet.setUserService(userService);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(usersServlet), "/users");

        Server server = new Server(8080);
        server.setHandler(contextHandler);

        server.start();
    }
}

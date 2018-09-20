package com.study.userstore;

import com.study.userstore.dao.UserDao;
import com.study.userstore.dao.jdbc.JdbcUserDao;
import com.study.userstore.service.impl.DefaultUserService;
import com.study.userstore.web.servlet.AssetsServlet;
import com.study.userstore.web.servlet.UsersAddServlet;
import com.study.userstore.web.servlet.UsersRemoveServlet;
import com.study.userstore.web.servlet.UsersServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class Starter {
    public static void main(String[] args) throws Exception {
        //config dao
        UserDao userDao = new JdbcUserDao();

        //config service
        DefaultUserService userService = new DefaultUserService();
        userService.setUserDao(userDao);

        //config servlet
        UsersServlet usersServlet = new UsersServlet();
        usersServlet.setUserService(userService);

        UsersRemoveServlet usersRemoveServlet = new UsersRemoveServlet();
        usersRemoveServlet.setUserService(userService);

        UsersAddServlet usersAddServlet = new UsersAddServlet();
        usersAddServlet.setUserService(userService);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(usersServlet), "/users");
        contextHandler.addServlet(new ServletHolder(usersAddServlet), "/users/add");
        contextHandler.addServlet(new ServletHolder(usersRemoveServlet), "/users/remove/*");
        contextHandler.addServlet(new ServletHolder(new AssetsServlet()), "/assets/*");

        Server server = new Server(8080);
        server.setHandler(contextHandler);

        server.start();
    }
}

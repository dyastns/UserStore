package com.study.userstore.web.servlet;

import com.study.userstore.entity.User;
import com.study.userstore.service.UserService;
import com.study.userstore.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAll();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("users", users);

        response.setContentType("text/html;charset=utf-8");

        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("users.html", parameters);
        response.getWriter().write(page);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

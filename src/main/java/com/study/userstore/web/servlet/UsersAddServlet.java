package com.study.userstore.web.servlet;

import com.study.userstore.entity.User;
import com.study.userstore.service.UserService;
import com.study.userstore.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class UsersAddServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Map<String, Object> parameters = new HashMap<>();

        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("adduser.html", parameters);
        response.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> requestParameters = request.getParameterMap();
        User user = new User();
        user.setId(Integer.parseInt(requestParameters.get("id")[0]));
        user.setFirstName(requestParameters.get("firstname")[0]);
        user.setLastName(requestParameters.get("lastname")[0]);
        user.setSalary(Double.parseDouble(requestParameters.get("salary")[0]));
        user.setDateOfBirth(LocalDate.parse(requestParameters.get("dateofbirth")[0]));
        int result = userService.addUser(user);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user", user);
        parameters.put("result", result);

        response.setContentType("text/html;charset=utf-8");

        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("adduser.html", parameters);
        response.getWriter().write(page);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

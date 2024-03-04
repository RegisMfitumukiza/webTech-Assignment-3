package com.regis.hibernatehw.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.regis.hibernatehw.bean.User;
import com.regis.hibernatehw.Dao.UserDao;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String sex = request.getParameter("sex");
            String country = request.getParameter("country");

            User user = new User(0, name, password, email, sex, country); // 0 for ID, as it will be auto-generated
            UserDao userDao = new UserDao();
            int userId = userDao.saveUser(user);

            if (userId > 0) {
                request.setAttribute("message", "User registered successfully!");
            } else {
                request.setAttribute("message", "Failed to register user.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while processing your request.");
        }

        // Forward the request back to the registration form
        request.getRequestDispatcher("/adduserform.jsp").forward(request, response);
    }
}

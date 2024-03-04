package com.regis.hibernatehw.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.regis.hibernatehw.bean.User;
import com.regis.hibernatehw.Dao.UserDao;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String sex = request.getParameter("sex");
            String country = request.getParameter("country");

            User updatedUser = new User(id, name, password, email, sex, country);
            UserDao userDao = new UserDao();
            boolean success = userDao.updateUser(updatedUser);

            if (success) {
                request.setAttribute("message", "User updated successfully!");
            } else {
                request.setAttribute("message", "Failed to update user.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while processing your request.");
        }

        // Forward back to the user list page with feedback message
        request.getRequestDispatcher("/viewusers.jsp").forward(request, response);
    }
}

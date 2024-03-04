package com.regis.hibernatehw.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.regis.hibernatehw.Dao.UserDao;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UserDao userDao = new UserDao();
            boolean success = userDao.deleteUser(id);

            if (success) {
                request.setAttribute("message", "User deleted successfully!");
            } else {
                request.setAttribute("message", "Failed to delete user.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while processing your request.");
        }

        // Forward back to the user list page with feedback message
        request.getRequestDispatcher("/viewusers.jsp").forward(request, response);
    }
}

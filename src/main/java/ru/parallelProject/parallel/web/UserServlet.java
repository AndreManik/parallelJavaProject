package ru.parallelProject.parallel.web;

import java.io.IOException;

public class UserServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }
}

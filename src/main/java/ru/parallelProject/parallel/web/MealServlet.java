package ru.parallelProject.parallel.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parallelProject.parallel.util.MealUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MealServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MealServlet.class);

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }*/


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("Started mealServlet {}");

        request.setAttribute("mealList", MealUtils.getMealWithExceeded(MealUtils.mealList, 2000));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("mealList.jsp");
        requestDispatcher.forward(request, response);
    }
}

package ru.parallelProject.parallel.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parallelProject.parallel.util.MealUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MealServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MealServlet.class);

    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("MealServlet doGet method started GET ALL");
        request.setAttribute("mealList", MealUtils.getWithExceeder(MealUtils.MEAL_LIST, 2000));
        request.getRequestDispatcher("mealList.jsp").forward(request, response);
    }
}

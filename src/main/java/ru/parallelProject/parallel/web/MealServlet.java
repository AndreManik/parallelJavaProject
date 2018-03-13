package ru.parallelProject.parallel.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.parallelProject.parallel.model.Meal;
import ru.parallelProject.parallel.model.MealWithExceed;
import ru.parallelProject.parallel.repository.InMemoryMealRepositoryImpl;
import ru.parallelProject.parallel.repository.MealRepository;
import ru.parallelProject.parallel.util.MealUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class MealServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(MealServlet.class);
    private static MealRepository repository;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        LOG.debug("Do post method work");
        String id = request.getParameter("id");
        LocalDateTime ld = LocalDateTime.parse(request.getParameter("dateTime"));
        String description = request.getParameter("description");
        Integer calories = Integer.valueOf(request.getParameter("calories"));

        Meal meal = new Meal(id.isEmpty() ? null : Integer.valueOf(id), ld, description, calories);
        LOG.info(meal.isNew() ? "Create {}" : "Update {}");
        repository.save(meal);
        response.sendRedirect("meals");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryMealRepositoryImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("Started mealServlet {}");


        String action = request.getParameter("action");
        if (action == null) {
            LOG.debug("Show all {}");
            List<MealWithExceed> mealWithExceeds = MealUtils.getMealWithExceeded(repository.getAll(), 2000);
            request.setAttribute("mealList", mealWithExceeds);
            request.getRequestDispatcher("mealList.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            LOG.debug("Delete {}" + getId(request));
            repository.delete(getId(request));
            response.sendRedirect("meals");
        } else if ("create".equals(action) || "update".equals(action)) {
            LOG.debug("Update | Delete");
            Meal meal = action.equals("update") ?
                    repository.get(getId(request)) :
                    new Meal(LocalDateTime.now(),"", 1000);
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("mealEdit.jsp").forward(request, response);
        }

        /*request.setAttribute("mealList", MealUtils.getMealWithExceeded(MealUtils.mealList, 2000));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("mealList.jsp");
        requestDispatcher.forward(request, response);*/
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}

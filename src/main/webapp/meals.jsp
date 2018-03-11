<%@ page import="ru.parallelProject.parallel.util.DateTimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meal List</title>
    <style>
        .normsl {
            color: green;
        }
        .exceeded {
            color: red;
        }
    </style>
</head>
<body>
<section>
    <h3><a href="index.html">Home</a> </h3>
    <h2>Meals</h2>
    <hr/>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
        </thead>

        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" type="ru.parallelProject.parallel.model.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>
                    <%=DateTimeUtil.toString(meal.getDateTime())%>
                </td>
                <td>
                    ${meal.description}
                </td>
                <td>
                    ${meal.calories}
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>

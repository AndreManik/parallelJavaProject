<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">
<html>
<head>
    <title>Meal list</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>

<body>
    <h1><a href="index.html">go home to parallel world portal</a></h1>
    <h2><a href="users">go to the users Servlet</a></h2>
    <h3>Meal list</h3>

    <form method="post" action="meals?action=filter">
        <dl>
            <dt>From Data:</dt>
            <dd><input type="date" name="startDate" value="${param.startDate}"></dd>
        </dl>
        <dl>
            <dt>To Date:</dt>
            <dd><input type="date" name="endDate" value="${param.endDate}"></dd>
        </dl>
        <dl>
            <dt>From Time:</dt>
            <dd><input type="time" name="startTime" value="${param.startTime}"></dd>
        </dl>
        <dl>
            <dt>To Time:</dt>
            <dd><input type="time" name="endTime" value="${param.endTime}"></dd>
        </dl>
        <button type="submit">Select</button>
    </form>

    <hr/>

    <a href="meals?action=create">Add meal</a>
    <hr/>

    <table cellspacing="0" cellpadding="8" class="bContentTables">
        <caption>Meal table</caption>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th>Exceeded</th>
            <th></th>
            <th></th>
        </tr>

        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" type="ru.parallelProject.parallel.to.MealWithExceed"/>
            <tr data-mealExceed="${meal.exceed}">
                <td>
                    ${meal.dateTime.toLocalDate()}
                            ${meal.dateTime.toLocalTime()}
                </td>
                <td>
                     ${meal.getDescription()}
                </td>
                <td>
                    ${meal.getCalories()}
                </td>
                <td>
                    ${meal.exceed}
                </td>
                <td><a href="meals?action=update&id=${meal.getId()}">Update</a></td>
                <td><a href="meals?action=delete&id=${meal.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

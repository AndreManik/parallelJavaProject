<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">
<html>
<head>
    <title>Meal list</title>

    <style>
        .normal {
            color:lightgreen;
            background: green;
            font-family: 'PT Sans', sans-serif;
        }
        .exceeded {
            color: antiquewhite;
            background: brown;
            font-family: 'PT Sans', sans-serif;
        }
        .headers {
              color: lightgray;
              background: dimgrey;
            font-family: 'PT Sans', sans-serif;

        }
        .bContentTables{
            border:1px solid #CCCCCC;
            border-radius: 10px; /* CSS3 */
            overflow:hidden;
            font-family: 'PT Sans', sans-serif;
        }
        h1 {
            font-family: 'PT Sans', sans-serif;
        }
        h2 {
            font-family: 'PT Sans', sans-serif;
        }
        a {
            text-decoration: none;
            color: brown;
        }
        a.visited {
            color: brown;
        }

    </style>

</head>
<body>
    <h1><a href="index.html">go home to parallel world portal</a></h1>
    <h2><a href="users">go to the users Servlet</a></h2>
    <table cellspacing="0" cellpadding="8" class="bContentTables">
        <caption>Meal table</caption>
        <tr>
            <th>Date</th>
            <th>Description</th>
            <th>Calories</th>
            <th>Exceeded</th>
        </tr>

        <c:forEach items="${mealList}" var="meal">
            <jsp:useBean id="meal" type="ru.parallelProject.parallel.model.MealWithExceed"/>
            <tr class="${meal.isExceed() ? "exceeded" : "normal"}">
                <td>
                    ${meal.getDate()}
                </td>
                <td>
                     ${meal.getDescription()}
                </td>
                <td>
                    ${meal.getCalories()}
                </td>
                <td>
                    ${meal.isExceed()}
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

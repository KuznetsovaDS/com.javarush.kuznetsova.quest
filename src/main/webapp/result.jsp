<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Итог</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class ="container mt-5 text-center">
    <h1>
        <c:choose>
            <c:when test="${isWinning}">
                Поздравляю, ${sessionScope.userName} ты выйграл!
            </c:when>
            <c:otherwise>
                К сожалению, ты проиграл, ${sessionScope.userName}
            </c:otherwise>
        </c:choose>
        <h3>${text}</h3>
        <p>Сессия:${sessionId} </p>
        <p>Количество игр в данной сессии: ${playedGames}</p>
        <form action="/game" method="get">
            <button type="submit" class="btn btn-dark">Сыграть еще раз</button>
        </form>
    </h1>
</div>
</body>
</html>
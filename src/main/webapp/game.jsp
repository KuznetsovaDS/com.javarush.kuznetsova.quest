<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Игра</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class ="container mt-5 text-center">
    <div class="text-end mb-4">
        <p><strong>Игрок:</strong> ${sessionScope.userName}</p>
        <p><strong>Сессия:</strong> ${sessionId}</p>
    </div>
    <h1>${question.text}</h1>
    <form action="/game" method="get">
        <c:forEach var="answer" items="${question.answers}">
            <button type="submit" name="questionId" value="${answer.nextQuestionId}"
                    class="btn btn-dark">
                    ${answer.text}
            </button>
        </c:forEach>
    </form>
</div>
</body>
</html>

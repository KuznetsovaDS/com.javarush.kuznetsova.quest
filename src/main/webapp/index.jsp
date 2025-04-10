<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Начало игры</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class ="container mt-5 text-center">
    <h2 class="text-dark">Добро пожаловать в мини игру</h2>
    <h1 class="text-dark" style="text-shadow: 2px 2px 5px rgba(92, 0, 0, 0.93);"><strong>Выбраться из темного леса</strong></h1>
    <div class="mt-5 mb-5">
        <p>Безрезультатно пробродив по лесу в течение четырёх часов, вы поняли, что заблудились. </p>
        <p>Связь не ловит, и на ваши крики никто не откликается. Что делать?...</p>
    </div>
    <p>Введите ваше имя перед стартом</p>
    <form action="/game" method="get">
        <input type="text" name="userName" placeholder="Введите ваше имя" required>
        <button type="submit" class="btn btn-dark">Старт</button>
    </form>
</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/css/table-style.css"/>" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="container">
    <form id="contact" action="/users" method="post">
        <h3>New person</h3>
        <h4>Hello</h4>
        <fieldset>
            <input name="name" placeholder="Имя" type="text" tabindex="1" required autofocus>
        </fieldset>
        <fieldset>
            <input name="login" placeholder="Логин" type="text" tabindex="2" required autofocus>
        </fieldset>
        <fieldset>
            <input name="password" placeholder="Пароль" type="text" tabindex="3" required>
        </fieldset>
        <fieldset>
            <input name="age" placeholder="Возраст" type="text" tabindex="4" required>
        </fieldset>
        <fieldset>
            <button name="submit" type="submit">Submit</button>
        </fieldset>
    </form>
</div>
</body>
</html>

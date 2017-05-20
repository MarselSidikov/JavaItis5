<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.itis.models.User" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/css/table-style.css"/>" rel="stylesheet">
</head>
<body>
<%--<table>--%>
<%--<% ArrayList<User> userList = (ArrayList<User>) request.getAttribute("users"); %>--%>
<%--<% for (User user : userList) { %>--%>
<%--<tr>--%>
<%--<td><%=user.getId()%>--%>
<%--</td>--%>
<%--<td><%=user.getName()%>--%>
<%--</td>--%>
<%--<td><%=user.getAge()%>--%>
<%--</td>--%>
<%--</tr>--%>
<%--<%}%>--%>
<%--</table>--%>
<%--<hr>--%>
<table>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

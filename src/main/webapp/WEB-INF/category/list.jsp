<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Categories list</title>
</head>
<body>
<div class="menu">
    <ul>
        <li><a href="/home">Home</a></li>
        <li><a href="/itemForm/list">Items list</a></li>
        <li><a href="/itemForm/form">Add items</a></li>
        <li><a href="/customerForm/list">Customers list</a></li>
        <li><a href="/customerForm/form">Add customers</a></li>
        <li><a href="/categoryForm/list">Categories list</a></li>
        <li><a href="/categoryForm/form">Add category</a></li>
    </ul>
</div>
<div class="content">
    <h1>Categories list</h1>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${categories}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>
                    <a href="/categoryForm/edit/${p.id}">Edit</a>
                    <a href="/categoryForm/confirmDel/${p.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

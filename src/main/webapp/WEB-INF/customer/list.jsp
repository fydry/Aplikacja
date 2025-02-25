<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Items list</title>

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
<h1>Customers list</h1>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Name</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="p" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.address}</td>
            <td>
                <a href="/customerForm/edit/${p.id}">Edit</a>
                <a href="/customerForm/confirmDel/${p.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>

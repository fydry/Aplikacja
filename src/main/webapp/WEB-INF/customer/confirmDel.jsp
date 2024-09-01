
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm delete</title>
</head>
<body>
<h1>Delete confirmation</h1>
<p>Are you sure you want to delete item with id <b>${customer.id}</b> and name <b>${customer.name}</b></p>
<a href="/customerForm/list">No, cancel</a><br>
<a href="/customerForm/delete/${customer.id}">Yes, delete</a>
</body>
</html>

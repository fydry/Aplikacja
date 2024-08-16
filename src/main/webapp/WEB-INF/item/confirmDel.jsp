<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm delete</title>
</head>
<body>
<h1>Delete confirmation</h1>
<p>Are you sure you want to delete item with id <b>${item.id}</b> and name <b>${item.name}</b></p>
<a href="/itemForm/list">No, cancel</a><br>
<a href="/itemForm/delete/${item.id}">Yes, delete</a>
</body>
</html>

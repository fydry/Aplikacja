<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Confirm delete</title>
</head>
<body>
<h1>Delete confirmation</h1>
<p>Are you sure you want to delete category with id <b>${category.id}</b> and name <b>${category.name}</b></p>
<a href="/categoryForm/list">No, cancel</a><br>
<a href="/categoryForm/delete/${categoryr.id}">Yes, delete</a>
</body>
</html>
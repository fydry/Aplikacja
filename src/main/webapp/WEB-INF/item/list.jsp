<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Items list</title>
</head>
<body>
<h1>Items list</h1>
<%@ include file="../menu.jsp" %>
<table>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
    <th>Category</th>
    <th>Unit</th>
    <th>Price</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${items}" var="p">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.description}</td>
      <td>${p.category}</td>
      <td>${p.unit}</td>
      <td>${p.price}</td>
      <td>
        <a href="/itemForm/edit/${p.id}">Edit</a>
        <a href="/itemForm/confirmDel/${p.id}">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>

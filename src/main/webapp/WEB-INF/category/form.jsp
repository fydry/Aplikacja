<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Category</title>
  <style>
    .error {
      color: red;
      font-weight: bold;
    }
  </style>
</head>
<body>
<h1>Add/edit category</h1>
<%@ include file="../menu.jsp" %>
<form:form method="post" modelAttribute="category" action="/categoryForm/form">
  <form:hidden path="id"/>
  <label>Name:
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
  </label>
  <form:button>Save</form:button>
</form:form>
</body>
</html>

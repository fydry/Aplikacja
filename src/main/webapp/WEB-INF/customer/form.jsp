<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add customer</h1>
<%@ include file="../menu.jsp" %>
<form:form method="post" modelAttribute="customer" action="/customerForm/form">
    <form:hidden path="id"/>
    <label>Name:
    <form:input path="name" cssClass="form-group"/>
    <form:errors path="name" cssClass="error"/>
    </label>
    <label>Address:
    <form:input path="address" cssClass="form-group"/>
    <form:errors path="address" cssClass="error"/>
    </label>
    <label><form:button>Save</form:button></label>
</form:form>
</body>
<head>
    <title>Customer</title>
</head>
</html>

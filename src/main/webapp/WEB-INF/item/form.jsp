<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Item form</title>
    <style>

        .error {
            color: red;
            font-weight: bold;
        }
        .form-group {
            display: grid;
            grid-template-columns: 150px 1fr;
            align-items: center;
            gap: 10px;
            margin-bottom: 10px;
        }

        .form-group label {
            text-align: right;
        }
    </style>
</head>
<body>
<h1>Add items</h1>
<%@ include file="../menu.jsp" %>
<form:form method="post" modelAttribute="item" action="/itemForm/form">
    <form:hidden path="id"/>
    <label>Name:
        <form:input path="name" cssClass="form-group"/>
        <form:errors path="name" cssClass="error"/>
    </label>
    <hr/>
    <label>Description:
        <form:input path="description" cssClass="form-group"/>
        <form:errors path="description" cssClass="error"/>
    </label>
    <hr/>
    <label>Category:
        <form:input path="category" cssClass="form-group"/>
        <form:errors path="category" cssClass="error"/>
    </label>
    <hr/>
    <label>Unit:
        <form:input path="unit" cssClass="form-group"/>
        <form:errors path="unit" cssClass="error"/>
    </label>
    <hr/>
    <label>Price:
        <form:input path="price" cssClass="form-group"/>
        <form:errors path="price" cssClass="error"/>
    </label>

    <label><form:button>Save</form:button></label>

</form:form>
</body>
<head>
    <title>Item</title>
</head>
</html>

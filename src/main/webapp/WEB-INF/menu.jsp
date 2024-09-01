<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Navigation Menu</title>
  <style>
    /* Resetowanie domyślnych stylów przeglądarki */
    body, ul {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Arial', sans-serif;
    }

    body {
      background-color: #f7f7f7;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    ul {
      list-style-type: none;
      padding: 0;
      background-color: #fff;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      overflow: hidden;
      width: 250px; /* Szerokość menu */
    }

    li {
      margin: 0;
    }

    li a {
      display: block;
      padding: 15px 20px;
      color: #007bff;
      text-decoration: none;
      text-align: center;
      font-size: 18px;
      transition: background-color 0.3s ease, color 0.3s ease;
    }

    li a:hover {
      background-color: #007bff;
      color: #fff;
    }

    /* Efekt dla aktywnego linku (jeśli potrzebujesz) */
    li a.active {
      background-color: #0056b3;
      color: #fff;
    }

    /* Stylowanie dla mniejszych ekranów */
    @media (max-width: 600px) {
      ul {
        width: 90%; /* Pełna szerokość na mniejszych ekranach */
      }

      li a {
        padding: 12px;
        font-size: 16px;
      }
    }
  </style>
</head>
<body>
<ul>
  <li><a href="/home">Home</a></li>
  <li><a href="/itemForm/list">Items list</a></li>
  <li><a href="/itemForm/form">Add items</a></li>
  <li><a href="/customerForm/list">Customers list</a></li>
  <li><a href="/customerForm/form">Add customers</a></li>
</ul>
</body>
</html>

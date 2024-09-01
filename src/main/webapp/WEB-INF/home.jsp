<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
    <style>
        /* Resetowanie domyślnych stylów przeglądarki */
        body, ul {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f7f7f7;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        ul {
            list-style: none;
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px; /* Szerokość kontenera menu */
        }

        h1 {
            margin: 15px 0;
        }

        h1 a {
            text-decoration: none;
            color: #fff;
            padding: 10px 0;
            display: block;
            width: 100%;
            border-radius: 4px;
            transition: background-color 0.3s ease;
            font-size: 18px;
        }

        /* Stylowanie linków */
        h1:nth-child(1) a {
            background-color: #007bff;
        }

        h1:nth-child(2) a {
            background-color: #007bff;
        }

        h1:nth-child(3) a {
            background-color: #007bff;
        }

        h1:nth-child(4) a {
            background-color: #007bff;
        }

        /* Efekt hover dla linków */
        h1 a:hover {
            background-color: #0056b3;
        }

        /* Stylowanie dla mniejszych ekranów */
        @media (max-width: 600px) {
            ul {
                width: 90%; /* Pełna szerokość kontenera na mniejszych ekranach */
            }

            h1 a {
                padding: 12px 0;
                font-size: 16px;
            }
        }
    </style>
</head>
<body>
<ul>
    <h1><a href="/itemForm/list">Items List</a></h1>
    <h1><a href="/itemForm/form">Add Items</a></h1>
    <h1><a href="/customerForm/list">Customers List</a></h1>
    <h1><a href="/customerForm/form">Add Customers</a></h1>
</ul>
</body>
</html>

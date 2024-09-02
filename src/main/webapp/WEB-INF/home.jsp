<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
    <style>
        /* Resetowanie domyślnych stylów przeglądarki */
        body {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
            background-color: #f7f7f7;
            color: #333;
            display: flex;
            flex-direction: row; /* Ustawienie elementów w rzędzie */
            min-height: 100vh;
        }

        .menu {
            width: 200px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
            display: flex;
            flex-direction: column; /* Menu ma być w kolumnie */
            margin: 20px; /* Margines wokół menu */
        }

        .menu ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .menu li {
            margin: 0;
        }

        .menu li a {
            display: block;
            padding: 15px 20px;
            color: #007bff;
            text-decoration: none;
            text-align: center;
            font-size: 16px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }

        .menu li a:hover {
            background-color: #007bff;
            color: #fff;
        }

        .content {
            flex-grow: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 20px; /* Margines wokół zawartości */
        }

        h1 {
            color: #007bff;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
            text-transform: uppercase;
            font-size: 14px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #e9f5ff;
        }

        a {
            color: #007bff;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #0056b3;
            color: #fff;
        }

        td:last-child {
            text-align: center;
        }

        /* Stylowanie dla mniejszych ekranów */
        @media (max-width: 768px) {
            body {
                flex-direction: column; /* Ustawienie kolumny na mniejszych ekranach */
            }

            .menu {
                width: 100%; /* Menu zajmuje całą szerokość na mniejszych ekranach */
                margin: 0;
                margin-bottom: 20px;
            }

            .content {
                width: 100%;
            }

            table {
                width: 100%;
            }

            th, td {
                padding: 10px;
                font-size: 12px;
            }

            h1 {
                font-size: 24px;
            }
        }
    </style>
</head>
<body>
<div class=menu>
    <ul>
        <li><a href="/itemForm/list">Items List</a></li>
        <li><a href="/itemForm/form">Add Items</a></li>
        <li><a href="/customerForm/list">Customers List</a></li>
        <li><a href="/customerForm/form">Add Customers</a></li>
        <li><a href="/categoryForm/list">Categories list</a></li>
        <li><a href="/categoryForm/form">Add category</a></li>
    </ul>
</div>
</body>
</html>

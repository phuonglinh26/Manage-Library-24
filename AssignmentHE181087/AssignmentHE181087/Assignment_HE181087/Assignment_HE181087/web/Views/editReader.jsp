<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Reader"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Reader</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: 'Arial', sans-serif;
                background-color: #f4f4f4;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
            }

            .container {
                background-color: #fff;
                padding: 40px;
                border-radius: 10px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
                max-width: 500px;
                width: 100%;
            }

            h1 {
                text-align: center;
                margin-bottom: 30px;
                font-size: 24px;
                color: #333;
            }

            label {
                display: block;
                margin-bottom: 8px;
                font-weight: bold;
                color: #555;
            }

            input[type="text"], input[type="date"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 5px;
                font-size: 16px;
            }

            button {
                width: 100%;
                padding: 12px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #0056b3;
            }

            .back-button {
                background-color: #28a745;
                margin-top: 10px;
            }

            .back-button:hover {
                background-color: #218838;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Edit Reader</h1>

            <form action="EditReaderServlet" method="post">
                <input type="hidden" name="readerID" value="${reader.readerID}">

                <label for="name">Full Name:</label>
                <input type="text" id="name" name="name" value="${reader.readerName}" required>

                <label for="gender">Gender:</label>
                <input type="text" id="gender" name="gender" value="${reader.readerGender}" required>

                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" value="${reader.readerDOB}" required>

                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" value="${reader.readerPhone}" required>

                <label for="address">Address:</label>
                <input type="text" id="address" name="address" value="${reader.readerAddress}" required>

                <button type="submit">Update</button>
            </form>

            <form action="${pageContext.request.contextPath}/ListReaderServlet" method="GET">
                <button type="submit">Back to List</button>
            </form>
        </div>
    </body>
</html>

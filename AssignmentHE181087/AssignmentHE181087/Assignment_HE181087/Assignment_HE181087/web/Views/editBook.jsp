<%-- 
    Document   : editBook
    Created on : Oct 19, 2024, 1:21:41 PM
    Author     : THC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Book</title>
        <style>
            /* Reset một số phần tử mặc định */
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

            input[type="text"], input[type="number"] {
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
            <h1>Edit Book</h1>

            <form action="EditBookServlet" method="post">
                <input type="hidden" name="bookID" value="${book.bookID}">

                <label for="title">Title:</label>
                <input type="text" id="title" name="title" value="${book.title}" required>

                <label for="publishedYear">Published Year:</label>
                <input type="number" id="publishedYear" name="publishedYear" value="${book.publishedYear}" required>

                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" value="${book.quantity}" required>

                <label for="genre">Genre:</label>
                <input type="text" id="genre" name="genre" value="${book.genre}" required>

                <label for="publisherName">Publisher:</label>
                <input type="text" id="publisherName" name="publisherName" value="${book.publisherName}" required>

                <label for="authorName">Author:</label>
                <input type="text" id="authorName" name="authorName" value="${book.authorName}" required>

                <button type="submit">Update</button>
            </form>

            <form action="${pageContext.request.contextPath}/ListBookServlet" method="GET">
                <button type="submit">Back to List</button>
            </form>
        </div>
    </body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert Book</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background-color: #f0f0f0;
            }
            .container {
                width: 90%;
                max-width: 500px;
                padding: 20px;
                background-color: white;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                margin-bottom: 30px;
                font-size: 24px;
                color: #333;
            }
            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
                color: #555;
            }
            input {
                display: block;
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ddd;
                border-radius: 5px;
                font-size: 16px;
            }
            button {
                width: 100%;
                padding: 10px;
                background-color: #007BFF;
                color: white;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                margin-bottom: 10px;
            }
            button:hover {
                background-color: #0056b3;
            }
            .back-button {
                background-color: #ccc;
                color: #333;
            }
            .back-button:hover {
                background-color: #bbb;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Insert New Book</h1>
            <form action="${pageContext.request.contextPath}/InsertBookServlet" method="post">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>

                <label for="publishedYear">Published Year:</label>
                <input type="number" id="publishedYear" name="publishedYear" required>

                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="quantity" required>

                <label for="genre">Genre:</label>
                <input type="text" id="genre" name="genre" required>

                <label for="publisherName">Publisher Name:</label>
                <input type="text" id="publisherName" name="publisherName" required>

                <label for="authorName">Author Name:</label>
                <input type="text" id="authorName" name="authorName" required>

                <button type="submit" class="action-button">Add Book</button>
                <a href="${pageContext.request.contextPath}/ListBookServlet">
                    <button type="button" class="back-button">Back to List</button>
                </a>
            </form>
        </div>
    </body>
</html>

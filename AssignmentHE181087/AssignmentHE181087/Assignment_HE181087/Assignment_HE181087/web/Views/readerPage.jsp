<%@ page import="Models.Reader" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Reader Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                display: flex;
                justify-content: center;
                align-items: flex-start;
                min-height: 100vh;
                background-color: #f0f0f0;
                padding-top: 50px;
            }

            .container {
                width: 80%;
                max-width: 1000px;
                padding: 20px;
                background-color: white;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 10px;
                margin-top: 20px;
            }

            h1 {
                text-align: center;
                margin-bottom: 30px;
                font-size: 30px;
            }

            .info-box {
                border: 1px solid black;
                padding: 20px;
                margin-bottom: 20px;
                width: 100%;
                box-sizing: border-box;
                border-radius: 10px;
                text-align: left;
            }

            .button-container {
                display: flex;
                justify-content: space-between;
                align-items: center;
                width: 100%;
                margin-top: 20px;
            }


            .button-container form:nth-child(2) {
                margin: 0 auto;
            }

            button {
                padding: 10px 20px;
                border: none;
                background-color: #007BFF;
                color: white;
                cursor: pointer;
                border-radius: 5px;
                font-size: 16px;
            }

            button:hover {
                background-color: #0056b3;
            }

            .info-box h2 {
                text-align: center;
                font-size: 26px;
                margin-bottom: 15px;
                margin-top: -10px;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h1>Welcome to Library, reader <c:out value="${reader.readerName}" />!</h1>

            <div class="info-box">
                <h2>Information</h2>
                <p><strong>Full name:</strong> <c:out value="${reader.readerName}" /></p>
                <p><strong>Gender:</strong> <c:out value="${reader.readerGender}" /></p>
                <p><strong>Date of Birth:</strong> <c:out value="${reader.readerDOB}" /></p>
                <p><strong>Phone:</strong> <c:out value="${reader.readerPhone}" /></p>
                <p><strong>Address:</strong> <c:out value="${reader.readerAddress}" /></p>
            </div>

            <div class="button-container">
                <form action="${pageContext.request.contextPath}/index.html" method="GET">
                    <button type="submit">Logout</button>
                </form>

                <form action="${pageContext.request.contextPath}/BorrowRecordServlet" method="GET">
                    <button type="submit">Your Borrowed Books</button>
                </form>

                <form action="${pageContext.request.contextPath}/ListBookServlet" method="GET">
                    <button type="submit">All Books in Library</button>
                </form>

            </div>
        </div>
    </body>
</html>

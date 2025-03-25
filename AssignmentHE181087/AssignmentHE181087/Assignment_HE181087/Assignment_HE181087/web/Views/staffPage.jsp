<%@ page import="Models.Staff" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Staff Page</title>
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
                padding-top: 20px;
            }

            .container {
                width: 80%;
                max-width: 800px;
                padding: 25px;
                background-color: white;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 10px;
                margin-top: 20px;
            }

            h1 {
                text-align: center;
                margin-bottom: 25px;
                font-size: 28px;
                color: #333;
            }

            .info-box {
                border: 1px solid #ddd;
                padding: 15px;
                margin-bottom: 20px;
                border-radius: 8px;
                text-align: left;
                background-color: #fafafa;
            }

            .info-box h2 {
                text-align: center;
                font-size: 24px;
                color: #555;
                margin-bottom: 15px;
            }

            p {
                margin: 8px 0;
                font-size: 16px;
                color: #333;
            }

            .button-container {
                display: flex;
                justify-content: space-between;
                align-items: center;
                width: 100%;
                margin-top: 20px;
            }

            .button-container form {
                display: inline-block;
                width: calc(33.3% - 10px);
                text-align: center;
            }

            button {
                padding: 10px 15px;
                width: 100%;
                border: none;
                background-color: #007BFF;
                color: white;
                cursor: pointer;
                border-radius: 5px;
                font-size: 16px;
                transition: background-color 0.3s;
            }

            button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Welcome, Staff <c:out value="${staff.staffName}" />!</h1>

            <div class="info-box">
                <h2>Your Information</h2>
                <p><strong>Full Name:</strong> <c:out value="${staff.staffName}" /></p>
                <p><strong>Gender:</strong> <c:out value="${staff.staffGender}" /></p>
                <p><strong>Date of Birth:</strong> <c:out value="${staff.staffDOB}" /></p>
                <p><strong>Phone:</strong> <c:out value="${staff.staffPhone}" /></p>
                <p><strong>Address:</strong> <c:out value="${staff.staffAddress}" /></p>
            </div>

            <div class="button-container">
                <form action="${pageContext.request.contextPath}/index.html">
                    <button type="submit">Logout</button>
                </form>

                <form action="${pageContext.request.contextPath}/ListReaderServlet" method="GET">
                    <button type="submit">View Readers</button>
                </form>


                <form action="${pageContext.request.contextPath}/ListBookServlet" method="GET">
                    <button type="submit">View Books</button>
                </form>
            </div>
        </div>
    </body>
</html>

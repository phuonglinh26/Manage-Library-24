<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert Reader</title>
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
            input, select {
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
            <h1>Insert New Reader</h1>
            <form action="${pageContext.request.contextPath}/InsertReaderServlet" method="post">
                <label for="name">Full Name:</label>
                <input type="text" id="name" name="name" required>


                <label for="gender">Gender:</label>
                <select id="gender" name="gender" required>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>

                <label for="dob">Date of Birth:</label>
                <input type="date" id="dob" name="dob" required>



                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" required>

                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>

                <button type="submit" class="action-button">Add Reader</button>
                <a href="${pageContext.request.contextPath}/ListReaderServlet">
                    <button type="button" class="back-button">Back to List</button>
                </a>
            </form>
        </div>
    </body>
</html>

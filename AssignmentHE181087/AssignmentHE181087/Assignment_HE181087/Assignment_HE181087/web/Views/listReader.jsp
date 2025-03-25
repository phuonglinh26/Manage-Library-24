<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Readers</title>
        <style>

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                font-family: Arial, sans-serif;
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
                max-width: 800px;
                width: 100%;
                text-align: center;
            }

            h1 {
                font-size: 24px;
                color: #333;
                margin-bottom: 20px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 10px;
                text-align: left;
                color: #333;
            }

            th {
                background-color: #007BFF;
                color: white;
                font-weight: bold;
            }

            .button-container {
                display: flex;
                justify-content: center;
                gap: 10px;
            }

            button {
                padding: 8px 15px;
                border: none;
                background-color: #007BFF;
                color: white;
                cursor: pointer;
                border-radius: 5px;
                font-size: 14px;
            }

            button:hover {
                background-color: #0056b3;
            }

            .no-data {
                text-align: center;
                color: #888;
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>List of Readers</h1>
            <form action="ListReaderServlet" method="GET">
                <input type="text" name="keyword" placeholder="Search here" />
                <button type="submit">Search</button>
            </form>
            <table>


                <tr>
                    <th>Full Name</th>
                    <th>Gender</th>
                    <th>Date of Birth</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>

                <c:choose>
                    <c:when test="${not empty reader}">
                        <c:forEach var="reader" items="${reader}">
                            <tr>
                                <td>${reader.readerName}</td>
                                <td>${reader.readerGender}</td>
                                <td>${reader.readerDOB}</td>
                                <td>${reader.readerPhone}</td>
                                <td>${reader.readerAddress}</td>
                                <td>
                                    <div class="button-container">
                                        <a href="EditReaderServlet?type=reader&readerID=${reader.readerID}">
                                            <button type="button">Edit</button>
                                        </a>
                                        <a href="DeleteServlet?type=reader&id=${reader.readerID}" 
                                           onclick="return confirm('Are you sure you want to delete this reader?');">
                                            <button type="button">Delete</button>
                                        </a>
                                        <a href="BorrowRecordServlet?readerID=${reader.readerID}">
                                            <button type="button">Details</button>
                                        </a>
                                    </div>
                                </td>

                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="6" class="no-data">No data available</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>

            <a href="InsertReaderServlet">
                <button type="button">Insert New Reader</button>
            </a>

            <c:if test="${sessionScope.role == 'Admin'}">
                <a href="Views/adminPage.jsp">
                    <button type="button">Back</button>
                </a>
            </c:if>
            <c:if test="${sessionScope.role == 'Staff'}">
                <a href="Views/staffPage.jsp">
                    <button type="button">Back</button>
                </a>
            </c:if>

        </div>
    </body>
</html>
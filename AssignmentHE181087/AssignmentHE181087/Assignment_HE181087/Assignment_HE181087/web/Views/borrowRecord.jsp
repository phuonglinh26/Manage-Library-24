<%-- 
    Document   : borrowRecord
    Created on : Oct 25, 2024, 2:28:40 PM
    Author     : THC
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Your Borrowed Books</title>
        <style>
            body {
                font-family: Arial, sans-serif;
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
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h2 {
                text-align: center;
                margin-bottom: 20px;
                font-size: 26px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid black;
                padding: 10px;
                text-align: left;
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

            .back-button {
                margin-top: 20px;
                display: flex;
                justify-content: flex-start;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Your Borrowed Books</h2>
            <table>
                <tr>
                    <th>Borrow ID</th>
                    <th>Book Title</th>
                    <th>Borrow Date</th>
                    <th>Allowed Days</th>
                    <th>Fine Amount</th>
                </tr>
                <c:choose>
                    <c:when test="${not empty borrowRecordsWithDetails}">
                        <c:forEach var="recordDetails" items="${borrowRecordsWithDetails}">
                            <tr>
                                <td><c:out value="${recordDetails.borrowID}" /></td>
                                <td><c:out value="${recordDetails.bookTitle}" /></td>
                                <td><c:out value="${recordDetails.borrowDate}" /></td>
                                <td><c:out value="${recordDetails.allowedDay}" /></td>
                                <td><c:out value="${recordDetails.fineAmount}" /></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="5">No borrowed books found</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>

            <div class="back-button">
                <c:choose>
                    <c:when test="${sessionScope.role == 'Reader'}">
                        <form action="${pageContext.request.contextPath}/ReaderServlet" method="GET">
                            <button type="submit">Back</button>
                        </form>
                    </c:when>
                    <c:when test="${sessionScope.role == 'Admin'}">
                        <form action="${pageContext.request.contextPath}/ListReaderServlet" method="GET">
                            <button type="submit">Back</button>
                        </form>
                    </c:when>
                    <c:when test="${sessionScope.role == 'Staff'}">
                        <form action="${pageContext.request.contextPath}/ListReaderServlet" method="GET">
                            <button type="submit">Back</button>
                        </form>
                    </c:when>

                </c:choose>
            </div>

        </div>
    </body>
</html>
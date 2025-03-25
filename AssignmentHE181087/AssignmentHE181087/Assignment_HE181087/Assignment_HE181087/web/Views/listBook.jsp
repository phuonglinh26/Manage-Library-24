<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Books</title>
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
            <h1>List of Books</h1>

            <form action="ListBookServlet" method="GET">
                <input type="text" name="keyword" placeholder="Search here" />
                <button type="submit">Search</button>
            </form>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Published Year</th>
                    <th>Quantity</th>
                    <th>Genre</th>
                    <th>Publisher</th>
                    <th>Author</th>

                    <c:if test="${sessionScope.role == 'Admin' || sessionScope.role == 'Staff'}">
                        <th>Action</th>
                        </c:if>
                </tr>

                <c:choose>
                    <c:when test="${not empty books}">
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.title}</td>
                                <td>${book.publishedYear}</td>
                                <td>${book.quantity}</td>
                                <td>${book.genre}</td>
                                <td>${book.publisherName}</td>
                                <td>${book.authorName}</td>

                                <c:if test="${sessionScope.role == 'Admin' || sessionScope.role == 'Staff'}">
                                    <td>
                                        <div class="button-container">
                                            <a href="EditBookServlet?type=book&bookID=${book.bookID}">
                                                <button type="button">Edit</button>
                                            </a>
                                            <a href="DeleteServlet?type=book&id=${book.bookID}" 
                                               onclick="return confirm('Are you sure you want to delete this book?');">
                                                <button type="button">Delete</button>
                                            </a>
                                        </div>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="7" class="no-data">No data available</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </table>
            <c:if test="${sessionScope.role == 'Admin' || sessionScope.role == 'Staff'}">
                <a href="InsertBookServlet">
                    <button type="button">Insert New Book</button>
                </a>
            </c:if>

            <c:if test="${sessionScope.role == 'Admin' }">
                <a href="Views/adminPage.jsp">
                    <button type="button">Back</button>
                </a>
            </c:if>
            <c:if test="${sessionScope.role == 'Staff'}">
                <a href="Views/staffPage.jsp">
                    <button type="button">Back</button>
                </a>
            </c:if>
            <c:if test="${sessionScope.role == 'Reader'}">
                <a href="Views/readerPage.jsp">
                    <button type="button">Back</button>
                </a>
            </c:if>
        </div>
    </body>
</html>

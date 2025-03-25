<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Staff</title>
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
            <h1>List of Staff</h1>
            <form action="ListStaffServlet" method="GET">
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
                    <c:when test="${not empty staffs}">
                        <c:forEach var="staff" items="${staffs}">
                            <tr>
                                <td>${staff.staffName}</td>
                                <td>${staff.staffGender}</td>
                                <td>${staff.staffDOB}</td>
                                <td>${staff.staffPhone}</td>
                                <td>${staff.staffAddress}</td>
                                <td>
                                    <div class="button-container">
                                        <a href="EditStaffServlet?type=staff&staffID=${staff.staffID}">
                                            <button type="button">Edit</button>
                                        </a>
                                        <a href="DeleteServlet?type=staff&id=${staff.staffID}" 
                                           onclick="return confirm('Are you sure you want to delete this staff member?');">
                                            <button type="button">Delete</button>
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

            <a href="InsertStaffServlet">
                <button type="button">Insert New Staff</button>
            </a>

            <c:if test="${sessionScope.role == 'Admin' }">
                <a href="Views/adminPage.jsp">
                    <button type="button">Back</button>
                </a>
            </c:if>

        </div>

    </body>
</html>

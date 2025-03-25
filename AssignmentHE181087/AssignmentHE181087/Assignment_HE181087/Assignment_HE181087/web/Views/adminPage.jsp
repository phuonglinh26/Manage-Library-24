
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Dashboard</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                background-color: #f4f4f4;
            }
            .container {
                text-align: center;
                width: 50%;
                padding: 20px;
                background-color: white;
                border-radius: 10px;
                box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            }
            button {
                padding: 10px 20px;
                margin: 10px;
                border: none;
                border-radius: 5px;
                background-color: #007bff;
                color: white;
                cursor: pointer;
                font-size: 16px;
            }
            button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Welcome, Admin</h1>
            <a href="${pageContext.request.contextPath}/ListBookServlet"><button>View Books</button></a>
            <a href="${pageContext.request.contextPath}/ListStaffServlet"><button>View Staffs</button></a>
            <a href="${pageContext.request.contextPath}/ListReaderServlet"><button>View Readers</button></a>
            <a href="${pageContext.request.contextPath}/index.html"><button>Logout</button></a>
        </div>
    </body>
</html>

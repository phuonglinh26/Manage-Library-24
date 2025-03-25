package Session;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Models.Login;
import DAL.DAO;
import java.io.PrintWriter;

public class SessionLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (validateLogin(username, password, role)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);

            response.setContentType("text/html");
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<html>");
                writer.println("<h2>Hi " + username + "! You have logged in as " + role + "</h2>");
                writer.println("<a href='SessionLoginDetails'>View login details</a>");
                writer.println("</html>");
            }
        } else {

            response.sendRedirect("index.html?error=Invalid login");
        }
    }

    private boolean validateLogin(String username, String password, String role) {

        return username != null && password != null && role != null;
    }
}

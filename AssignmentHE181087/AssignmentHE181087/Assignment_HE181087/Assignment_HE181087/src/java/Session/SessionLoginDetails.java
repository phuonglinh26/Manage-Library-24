package Session;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionLoginDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        String username = null;
        String role = null;
        if (session != null) {
            username = (String) session.getAttribute("username");
            role = (String) session.getAttribute("role");
        }

        response.setContentType("text/html");
        try (PrintWriter writer = response.getWriter()) {
            writer.println("<html>");
            if (username != null && role != null) {
                writer.println("<h2>Username: " + username + "</h2>");
                writer.println("<h2>Role: " + role + "</h2>");
            } else {
                writer.println("<h2>No login details found in session</h2>");
            }
            writer.println("<a href='index.html'>Back to login</a>");
            writer.println("</html>");
        }
    }
}

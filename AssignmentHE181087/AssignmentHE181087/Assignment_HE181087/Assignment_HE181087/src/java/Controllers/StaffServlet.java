package Controllers;

import DAL.DAO;
import Models.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class StaffServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || !"Staff".equalsIgnoreCase((String) session.getAttribute("role"))) {
            response.sendRedirect("index.html");
            return;
        }

        String username = (String) session.getAttribute("username");
        Staff staff = DAO.INSTANCE.getStaffByUsername(username);

        if (staff != null) {
            request.setAttribute("staff", staff);
        } else {
            request.setAttribute("error", "Staff information not found.");
        }

        request.getRequestDispatcher("Views/staffPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


import DAL.DAO;
import Models.Reader;
import Models.Staff;
import Models.Login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Login login = DAO.INSTANCE.getLoginByUsername(username);

        if (login != null && login.getPassword().equals(password)) {

            HttpSession session = request.getSession();

            if ("Reader".equalsIgnoreCase(role)) {

                Reader reader = DAO.INSTANCE.getReaderByUsername(username);
                session.setAttribute("reader", reader);
                session.setAttribute("role", "Reader");

                response.sendRedirect("Views/readerPage.jsp");

            } else if ("Staff".equalsIgnoreCase(role)) {

                Staff staff = DAO.INSTANCE.getStaffByUsername(username);
                session.setAttribute("staff", staff);
                session.setAttribute("role", "Staff");

                response.sendRedirect("Views/staffPage.jsp");

            } else if ("Admin".equalsIgnoreCase(role) && login.getRoleID() == 1) {
                session.setAttribute("role", "Admin");
                response.sendRedirect("Views/adminPage.jsp");
            } else {

                request.setAttribute("errorMessage", "Invalid role");
                request.getRequestDispatcher("index.html").forward(request, response);
            }
        } else {

            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("index.html").forward(request, response);
        }
    }
}

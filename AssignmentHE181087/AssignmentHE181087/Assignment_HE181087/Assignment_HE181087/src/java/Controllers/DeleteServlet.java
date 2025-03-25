package Controllers;

import DAL.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        String id = request.getParameter("id");
        DAO dao = DAO.INSTANCE;

        try {
            if (null != type) {
                switch (type) {
                    case "book":
                        dao.deleteBookByID(Integer.parseInt(id));
                        break;
                    case "staff":
                        dao.deleteStaffByID(Integer.parseInt(id));
                        break;
                    case "reader":
                        dao.deleteReaderByID(Integer.parseInt(id));
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid ID format: " + e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/ListBookServlet");
    }
}

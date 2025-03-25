package Controllers;

import DAL.DAO;
import Models.Reader;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class BorrowRecordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("index.html");
            return;
        }

        String role = (String) session.getAttribute("role");
        int readerID;

        try {

            if ("Admin".equalsIgnoreCase(role) || "Staff".equalsIgnoreCase(role)) {
                readerID = Integer.parseInt(request.getParameter("readerID"));
            } else if ("Reader".equalsIgnoreCase(role)) {

                Reader reader = (Reader) session.getAttribute("reader");
                readerID = reader.getReaderID();
            } else {
                response.sendRedirect("index.html");
                return;
            }

            ArrayList<Map<String, Object>> borrowRecordsWithDetails = DAO.INSTANCE.getBorrowRecordsWithDetailsByReaderID(readerID);
            request.setAttribute("borrowRecordsWithDetails", borrowRecordsWithDetails);
            request.getRequestDispatcher("Views/borrowRecord.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("index.html");
        }
    }
}

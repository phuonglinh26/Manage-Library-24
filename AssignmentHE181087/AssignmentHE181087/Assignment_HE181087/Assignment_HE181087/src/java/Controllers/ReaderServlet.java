package Controllers;

import DAL.DAO;
import Models.Reader;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ReaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || !"Reader".equalsIgnoreCase((String) session.getAttribute("role"))) {
            response.sendRedirect("index.html");
            return;
        }

        String username = (String) session.getAttribute("username");
        Reader reader = DAO.INSTANCE.getReaderByUsername(username);

        if (reader != null) {
            request.setAttribute("reader", reader);

            ArrayList<Map<String, Object>> borrowRecordsWithDetails = DAO.INSTANCE.getBorrowRecordsWithDetailsByReaderID(reader.getReaderID());
            request.setAttribute("borrowRecordsWithDetails", borrowRecordsWithDetails);
        } else {
            request.setAttribute("error", "Reader information not found.");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("Views/readerPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

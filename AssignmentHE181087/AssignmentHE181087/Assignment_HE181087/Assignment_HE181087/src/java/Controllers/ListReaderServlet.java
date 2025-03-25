package Controllers;

import DAL.DAO;
import Models.Reader;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListReaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        ArrayList<Reader> reader;

        if (keyword != null && !keyword.trim().isEmpty()) {

            reader = DAO.INSTANCE.searchReadersByKeyword(keyword.trim());
            System.out.println("Searching readers with keyword: " + keyword);
        } else {

            reader = DAO.INSTANCE.getReaders();
            System.out.println("No keyword provided. Displaying all readers.");
        }

        request.setAttribute("reader", reader);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views/listReader.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ListReaderServlet handles displaying the list of readers.";
    }
}

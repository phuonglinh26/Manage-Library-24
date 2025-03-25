package Controllers;

import DAL.DAO;
import Models.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        ArrayList<Book> books;

        if (keyword != null && !keyword.trim().isEmpty()) {

            books = DAO.INSTANCE.searchBooksByKeyword(keyword.trim());
            System.out.println("Searching books with keyword: " + keyword);
        } else {

            books = DAO.INSTANCE.getAllBooks();
            System.out.println("No keyword provided. Displaying all books.");
        }

        request.setAttribute("books", books);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views/listBook.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

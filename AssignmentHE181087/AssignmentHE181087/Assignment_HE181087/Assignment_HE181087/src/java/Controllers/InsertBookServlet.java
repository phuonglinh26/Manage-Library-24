package Controllers;

import DAL.DAO;
import Models.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class InsertBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Views/insertBook.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        int publishedYear = Integer.parseInt(request.getParameter("publishedYear"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String genre = request.getParameter("genre");
        String publisherName = request.getParameter("publisherName");
        String authorName = request.getParameter("authorName");

        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setPublishedYear(publishedYear);
        newBook.setQuantity(quantity);
        newBook.setGenre(genre);
        newBook.setPublisherName(publisherName);
        newBook.setAuthorName(authorName);

        DAO.INSTANCE.insertBook(newBook);

        response.sendRedirect(request.getContextPath() + "/ListBookServlet");
    }
}

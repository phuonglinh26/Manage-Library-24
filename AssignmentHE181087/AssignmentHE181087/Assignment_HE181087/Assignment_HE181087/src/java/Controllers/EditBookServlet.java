package Controllers;

import DAL.DAO;
import Models.Book;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookID = Integer.parseInt(request.getParameter("bookID"));
        Book book = DAO.INSTANCE.getBookByID(bookID);
        if (book != null) {
            request.setAttribute("book", book);
            request.getRequestDispatcher("Views/editBook.jsp").forward(request, response);
        } else {
            response.sendRedirect("ListBookServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String bookID = request.getParameter("bookID");
        String title = request.getParameter("title");
        String publishedYear = request.getParameter("publishedYear");
        String quantity = request.getParameter("quantity");
        String genre = request.getParameter("genre");
        String publisherName = request.getParameter("publisherName");
        String authorName = request.getParameter("authorName");

        Book book = new Book();
        book.setBookID(Integer.parseInt(bookID));
        book.setTitle(title);
        book.setPublishedYear(Integer.parseInt(publishedYear));
        book.setQuantity(Integer.parseInt(quantity));
        book.setGenre(genre);
        book.setPublisherName(publisherName);
        book.setAuthorName(authorName);

        DAO.INSTANCE.updateBook(book);

        response.sendRedirect("ListBookServlet");
    }
}

package Controllers;

import DAL.DAO;
import Models.Book;
import Models.Reader;
import Models.Staff;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        String itemID = request.getParameter("id");

        if ("book".equalsIgnoreCase(type)) {
            Book book = DAO.INSTANCE.getBookByID(Integer.parseInt(itemID));
            request.setAttribute("book", book);
        } else if ("staff".equalsIgnoreCase(type)) {
            Staff staff = DAO.INSTANCE.getStaffByID(Integer.parseInt(itemID));
            request.setAttribute("staff", staff);
        } else if ("reader".equalsIgnoreCase(type)) {
            Reader reader = DAO.INSTANCE.getReaderByID(Integer.parseInt(itemID));
            request.setAttribute("reader", reader);
        }

        request.getRequestDispatcher("Views/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");

        if ("book".equalsIgnoreCase(type)) {
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

        } else if ("staff".equalsIgnoreCase(type)) {
            String staffID = request.getParameter("staffID");
            String staffName = request.getParameter("staffName");
            String staffGender = request.getParameter("staffGender");
            String staffDOBStr = request.getParameter("staffDOB");
            String staffPhone = request.getParameter("staffPhone");
            String staffAddress = request.getParameter("staffAddress");

            Date staffDOB = parseDate(staffDOBStr);

            Staff staff = new Staff();
            staff.setStaffID(Integer.parseInt(staffID));
            staff.setStaffName(staffName);
            staff.setStaffGender(staffGender);
            staff.setStaffDOB(staffDOB);
            staff.setStaffPhone(staffPhone);
            staff.setStaffAddress(staffAddress);

            DAO.INSTANCE.updateStaff(staff);
            response.sendRedirect("ListStaffServlet");

        } else if ("reader".equalsIgnoreCase(type)) {
            String readerID = request.getParameter("readerID");
            String readerName = request.getParameter("readerName");
            String readerGender = request.getParameter("readerGender");
            String readerDOBStr = request.getParameter("readerDOB");
            String readerPhone = request.getParameter("readerPhone");
            String readerAddress = request.getParameter("readerAddress");

            Date readerDOB = parseDate(readerDOBStr);

            Reader reader = new Reader();
            reader.setReaderID(Integer.parseInt(readerID));
            reader.setReaderName(readerName);
            reader.setReaderGender(readerGender);
            reader.setReaderDOB(readerDOB);
            reader.setReaderPhone(readerPhone);
            reader.setReaderAddress(readerAddress);

            DAO.INSTANCE.updateReader(reader);
            response.sendRedirect("ListReaderServlet");
        }
    }

    private Date parseDate(String dateStr) {
        try {
            return DATE_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

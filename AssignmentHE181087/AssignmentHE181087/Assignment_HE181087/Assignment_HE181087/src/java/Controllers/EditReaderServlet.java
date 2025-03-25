package Controllers;

import DAL.DAO;
import Models.Reader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditReaderServlet extends HttpServlet {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int readerID = Integer.parseInt(request.getParameter("readerID"));
        Reader reader = DAO.INSTANCE.getReaderByID(readerID);
        if (reader != null) {
            request.setAttribute("reader", reader);
            request.getRequestDispatcher("Views/editReader.jsp").forward(request, response);
        } else {
            response.sendRedirect("ListReaderServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String readerID = request.getParameter("readerID");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dobStr = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Date dob = parseDate(dobStr);

        Reader reader = new Reader();
        reader.setReaderID(Integer.parseInt(readerID));
        reader.setReaderName(name);
        reader.setReaderGender(gender);
        reader.setReaderDOB(dob);
        reader.setReaderPhone(phone);
        reader.setReaderAddress(address);

        DAO.INSTANCE.updateReader(reader);

        response.sendRedirect("ListReaderServlet");
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

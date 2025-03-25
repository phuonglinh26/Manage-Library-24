package Controllers;

import DAL.DAO;
import Models.Reader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

public class InsertReaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Views/insertReader.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        Date dob = Date.valueOf(request.getParameter("dob"));
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Reader newReader = new Reader();
        newReader.setReaderName(name);
        newReader.setReaderDOB(dob);
        newReader.setReaderGender(gender);
        newReader.setReaderPhone(phone);
        newReader.setReaderAddress(address);

        DAO.INSTANCE.insertReader(newReader);

        response.sendRedirect(request.getContextPath() + "/ListReaderServlet");

    }
}

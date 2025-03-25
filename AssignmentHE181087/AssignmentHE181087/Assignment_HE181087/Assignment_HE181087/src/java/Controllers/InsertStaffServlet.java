package Controllers;

import DAL.DAO;
import Models.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

public class InsertStaffServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Views/insertStaff.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String staffName = request.getParameter("staffName");
        String staffGender = request.getParameter("staffGender");
        Date staffDOB = Date.valueOf(request.getParameter("staffDOB"));
        String staffPhone = request.getParameter("staffPhone");
        String staffAddress = request.getParameter("staffAddress");

        Staff newStaff = new Staff();
        newStaff.setStaffName(staffName);
        newStaff.setStaffGender(staffGender);
        newStaff.setStaffDOB(staffDOB);
        newStaff.setStaffPhone(staffPhone);
        newStaff.setStaffAddress(staffAddress);

        DAO.INSTANCE.insertStaff(newStaff);

        response.sendRedirect(request.getContextPath() + "/ListStaffServlet");
    }
}

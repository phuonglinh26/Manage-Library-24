package Controllers;

import DAL.DAO;
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

public class EditStaffServlet extends HttpServlet {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int staffID = Integer.parseInt(request.getParameter("staffID"));
        Staff staff = DAO.INSTANCE.getStaffByID(staffID);
        if (staff != null) {
            request.setAttribute("staff", staff);
            request.getRequestDispatcher("Views/editStaff.jsp").forward(request, response);
        } else {
            response.sendRedirect("ListStaffServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String staffID = request.getParameter("staffID");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String dobStr = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        Date dob = null;
        try {
            dob = DATE_FORMAT.parse(dobStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Staff staff = new Staff();
        staff.setStaffID(Integer.parseInt(staffID));
        staff.setStaffName(name);
        staff.setStaffGender(gender);
        staff.setStaffDOB(dob);
        staff.setStaffPhone(phone);
        staff.setStaffAddress(address);

        DAO.INSTANCE.updateStaff(staff);

        response.sendRedirect("ListStaffServlet");
    }
}

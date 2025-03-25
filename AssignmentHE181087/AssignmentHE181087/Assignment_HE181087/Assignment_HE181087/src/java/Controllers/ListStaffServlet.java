package Controllers;

import DAL.DAO;
import Models.Staff;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListStaffServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        ArrayList<Staff> staffs;

        if (keyword != null && !keyword.trim().isEmpty()) {

            staffs = DAO.INSTANCE.searchStaffByKeyword(keyword.trim());
            System.out.println("Searching staff with keyword: " + keyword);
        } else {

            staffs = DAO.INSTANCE.getStaffs();
            System.out.println("No keyword provided. Displaying all staff.");
        }

        request.setAttribute("staffs", staffs);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views/listStaff.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ListStaffServlet handles displaying the list of staff members.";
    }
}

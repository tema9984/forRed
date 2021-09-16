package com.example.red.data.employees;

import com.example.red.data.department.DepDB;
import com.example.red.data.department.Department;
import com.example.red.data.position.Positions;
import com.example.red.data.position.PositionsDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/edit-empl")
public class EditEmpl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Employees employee = EmployeesDB.selectOne(id);
            ArrayList<Department> departments = DepDB.select();
            request.setAttribute("departments", departments);
            ArrayList<Positions> positions = PositionsDB.select();
            request.setAttribute("positions", positions);
            if(employee!=null) {
                request.setAttribute("employee", employee);
                request.getServletContext().getRequestDispatcher("/editEmpl.jsp").forward(request, response);
            }
            else {
                request.getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            int positions_id = Integer.parseInt(request.getParameter("positions"));
            int department_id = Integer.parseInt(request.getParameter("department"));
            Employees employee = new Employees(id, name, surname, positions_id, department_id);
            EmployeesDB.update(employee);
            response.sendRedirect(request.getContextPath() + "/depart-servlet");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}

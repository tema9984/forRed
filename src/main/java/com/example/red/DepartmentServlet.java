package com.example.red;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.red.data.department.DepDB;
import com.example.red.data.department.Department;
import com.example.red.data.employees.Employees;
import com.example.red.data.employees.EmployeesDB;
import com.example.red.data.position.Positions;
import com.example.red.data.position.PositionsDB;

@WebServlet(name = "departServlet", value = "/depart-servlet")
public class DepartmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ArrayList<Department> departments = DepDB.select();
        request.setAttribute("departments", departments);
        ArrayList<Positions> positions = PositionsDB.select();
        request.setAttribute("positions", positions);
        ArrayList<Employees> employees = EmployeesDB.select();
        request.setAttribute("employees", employees);
        getServletContext().getRequestDispatcher("/depart.jsp").forward(request, response);
    }
}

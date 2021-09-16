package com.example.red.data.department;

import com.example.red.data.department.DepDB;
import com.example.red.data.department.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editdep")
public class EditDep extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Department department = DepDB.selectOne(id);
            if(department!=null) {
                request.setAttribute("department", department);
                request.getServletContext().getRequestDispatcher("/editdepV.jsp").forward(request, response);
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
            String mail = request.getParameter("mail");
            int phone = Integer.parseInt(request.getParameter("phone"));
            Department department = new Department(id, name, mail, phone);
            DepDB.update(department);
            response.sendRedirect(request.getContextPath() + "/depart-servlet");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}

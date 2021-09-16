package com.example.red.data.department;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createDepartServlet", value = "/create-servlet")
public class CreateDepServ extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/createdep.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String mail = request.getParameter("mail");
            int phone = Integer.parseInt(request.getParameter("phone"));
            Department department = new Department( name, mail, phone);
            DepDB.insert(department);
            response.sendRedirect(request.getContextPath()+"/depart-servlet");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/createdep.jsp").forward(request, response);
        }
    }
}

package com.example.red.data.position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-posit")
public class CreatePositServ extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/createPosit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String position = request.getParameter("position");
            int salary = Integer.parseInt(request.getParameter("salary"));
            Positions positions = new Positions( position, salary);
            PositionsDB.insert(positions);
            response.sendRedirect(request.getContextPath()+"/depart-servlet");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/createPosit.jsp").forward(request, response);
        }
    }
}

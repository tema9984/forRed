package com.example.red.data.position;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-posit")
public class EditPosit extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Positions position = PositionsDB.selectOne(id);
            if(position!=null) {
                request.setAttribute("position", position);
                request.getServletContext().getRequestDispatcher("/editPosit.jsp").forward(request, response);
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
            String post = request.getParameter("position");
            int salary = Integer.parseInt(request.getParameter("salary"));
            Positions position = new Positions(id, post, salary);
            PositionsDB.update(position);
            response.sendRedirect(request.getContextPath() + "/depart-servlet");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}

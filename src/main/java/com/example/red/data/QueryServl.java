package com.example.red.data;

import com.example.red.data.department.DepDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/select-query")
public class QueryServl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String query = request.getParameter("query");         ArrayList<String> answer=SelectQuery.select(query);
            request.setAttribute("answer", answer);
            getServletContext().getRequestDispatcher("/answer.jsp").forward(request, response);
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}

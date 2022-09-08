package sit.int202.simple.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PlusNumServlet", value = "/PlusNum")
public class PlusNumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        double sum = Double.parseDouble(num1)+Double.parseDouble(num2);
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("result", sum);
        request.getRequestDispatcher("/resultSum.jsp").forward(request, response);
    }
}

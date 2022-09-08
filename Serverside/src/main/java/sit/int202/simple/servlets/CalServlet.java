package sit.int202.simple.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/Cal")
public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String operator = request.getParameter("operator");
        if(operator.equals("+")){
            request.setAttribute("result", Double.parseDouble(num1)+Double.parseDouble(num2));
        }
        else if(operator.equals("-")){
            request.setAttribute("result",Double.parseDouble(num1)-Double.parseDouble(num2));
        }
        else if(operator.equals("*")){
            request.setAttribute("result",Double.parseDouble(num1)*Double.parseDouble(num2));
        }
        else if(operator.equals("/")){
            request.setAttribute("result",Double.parseDouble(num1)/Double.parseDouble(num2));
        }
        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("operator",operator);
        request.getRequestDispatcher("/Result.jsp").forward(request, response);
    }
}


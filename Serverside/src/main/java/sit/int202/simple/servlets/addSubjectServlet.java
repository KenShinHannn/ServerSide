package sit.int202.simple.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.simple.entities.Subject;

import java.io.IOException;

@WebServlet(name = "addSubjectServlet", value = "/AddSubject")
public class addSubjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("subjectId");
        String title = request.getParameter("subjectName");
        String credit = request.getParameter("credit");
        Subject subject = new Subject(id, title, Double.parseDouble(credit));
        request.setAttribute("subject", subject);
        request.getRequestDispatcher("/subject_info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }
}

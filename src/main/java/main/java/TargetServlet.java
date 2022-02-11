package main.java;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class TargetServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies= request.getCookies();
        for (Cookie cookie: cookies){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
        HttpSession session = request.getSession();
        Object userName = session.getAttribute("userName");
        PrintWriter writer = response.getWriter();
        writer.print("Username is "+userName);
    }
}

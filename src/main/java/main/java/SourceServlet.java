package main.java;

import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class SourceServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
        Cookie[] cookies= request.getCookies();
        for (Cookie cookie: cookies){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
        response.addCookie(new Cookie("securityToken","abc1234"));

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String url="targetServlet?sessionId="+session.getId();
        writer.print("<a href='"+url+"'>Click Here To Get User Name</a>");
    }
}

package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import db.ManagementSystem;
import logic.Chatter;
/**
 * Created by Diman on 19.04.2015.
 */

public class loginHandler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getServletPath().equals("/logout")){
            HttpSession session = req.getSession(false);
            String nickName = (String)session.getAttribute("nickname");
            Cookie loginCookie = null;
            Cookie[] cookies = req.getCookies();
            if (cookies!=null){
                for (Cookie cookie: cookies){
                    if (cookie.getName().equals("userNick")){
                        loginCookie = cookie;
                        break;
                    }
                }
            }
            if (loginCookie!=null){
                loginCookie.setMaxAge(0);
                resp.addCookie(loginCookie);
            }
            System.out.println("------------Session id= " + session.getId() + "-----------------");
            try {
                ManagementSystem.getInstance().deleteChatter(new Chatter(nickName,session.getId()));
            } catch (SQLException e) {
                throw new ServletException(e);
            }
            session.invalidate();
            resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            resp.setDateHeader("Expires", 0); // Proxies.
            resp.sendRedirect(req.getContextPath() + "/JSPs/homepage.jsp");
        }
        else{
            String nickName = req.getParameter("nickname");
            HttpSession session = req.getSession(false);
            System.out.println("*******Session id= " + session.getId() + "*********");
            int timeout = Integer.parseInt(getServletContext().getInitParameter("sessionTimeout"));
            timeout *= 60;
            session.setMaxInactiveInterval(timeout);
            session.setAttribute("nickname", nickName);
            Cookie userCookie = new Cookie("userNick", nickName);
            userCookie.setMaxAge(60*60);
            resp.addCookie(userCookie);
            Chatter chatter = new Chatter(nickName, session.getId());
            try {
                ManagementSystem.getInstance().insertChatter(chatter);
            } catch (SQLException e) {
                throw new ServletException(e);
            }
            resp.sendRedirect(req.getContextPath() + "/JSPs/homepage.jsp");
        }
    }
}

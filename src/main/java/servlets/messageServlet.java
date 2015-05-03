package servlets;

import db.ManagementSystem;
import logic.Message;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Diman on 02.05.2015.
 */
public class messageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String timeStamp = req.getParameter("timestamp");
        try {
            JSONArray jsonArray = ManagementSystem.getInstance().getAllMessages(timeStamp);
            JSONObject responseJSON = new JSONObject();
            responseJSON.put("messages", jsonArray);
            PrintWriter out = resp.getWriter();
            responseJSON.writeJSONString(out);
            out.flush();
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/JSPs/homepage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String msgText = req.getParameter("text");
        String timeStamp = req.getParameter("timeStamp");
        Message messageItem = new Message(userName, msgText, timeStamp);
        try {
            ManagementSystem.getInstance().insertMessage(messageItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

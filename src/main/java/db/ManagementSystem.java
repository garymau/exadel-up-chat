package db;

import logic.Chatter;
import logic.Message;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Diman on 01.05.2015.
 */
public class ManagementSystem {
    private static Connection connection;
    private static  ManagementSystem instance;
    private static DataSource dataSource;

    private ManagementSystem(){
    }

    public static synchronized ManagementSystem getInstance(){
        if (instance == null){
            try{
                instance = new ManagementSystem();
                Context context = new InitialContext();
                instance.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/chatDS");
                connection = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void insertChatter(Chatter chatter) throws SQLException {
        int number = -1;
        PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) AS count FROM chatters "
                + "WHERE Name=?");
        stmt.setString(1, chatter.getNickName());
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            number = rs.getInt("count");
        }
        if (number > 0){
            updateChatter(chatter);
        }
        else {
            stmt = connection.prepareStatement("INSERT INTO chatters "
                    + "(Name, Session_Id )"
                    + "VALUES(?, ?)");
            stmt.setString(1, chatter.getNickName());
            stmt.setString(2, chatter.getSessionId());
            stmt.executeUpdate();
        }
    }

    public void updateChatter(Chatter chatter) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("UPDATE chatters "
                + "SET Session_Id=?"
                + "WHERE Name=?");
        stmt.setString(1, chatter.getSessionId());
        stmt.setString(2, chatter.getNickName());
        stmt.executeUpdate();
    }

    public void deleteChatter(Chatter chatter) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("DELETE FROM chatters WHERE Name=?");
        stmt.setString(1, chatter.getNickName());
        stmt.executeUpdate();
    }

    public void insertMessage(Message messageItem) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO messages" +
                "(userName, text, addingTime) " +
                        "VALUES (?,?,?)");
        statement.setString(1,messageItem.getChatterName());
        statement.setString(2,messageItem.getMessageText());
        statement.setString(3,messageItem.getTimeStamp());

        statement.executeUpdate();
    }

    public JSONArray getAllMessages(String timeStamp) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM messages " +
                "WHERE addingTime<?;");
        statement.setString(1,timeStamp);
        ResultSet rs = statement.executeQuery();

        JSONArray jsonArray = new JSONArray();
        while (rs.next()){
            JSONObject jo= new JSONObject();
            jo.put("userName",rs.getString("userName"));
            jo.put("text",rs.getString("text"));
            jo.put("timeStamp",rs.getString("addingTime"));
            jsonArray.add(jo);
        }
        return jsonArray;
    }
}

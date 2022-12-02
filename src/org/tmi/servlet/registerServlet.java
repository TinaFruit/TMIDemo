package org.tmi.servlet;

import org.json.JSONException;
import org.json.JSONObject;
import org.tmi.DAO.UserDAO;
import org.tmi.DAO.UserDAOImpl;
import org.tmi.Utils.HTTPUtils;
import org.tmi.Utils.JDBCUtils;
import org.tmi.Utils.JsonUtils;
import org.tmi.pojo.Message;
import org.tmi.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        HTTPUtils.setResponseHeaders(resp);

        String username = null;
        String password = null;

        JSONObject jo = JsonUtils.getJsonObject(req);
        username = jo.getString("username");
        password = jo.getString("password");

        /*String username = req.getParameter("username");
        String password = req.getParameter("password");*/
        UserDAO udao = new UserDAOImpl();
        int result = 0;
        User user = null;
        try {
            user = udao.getSingleUser(username);
            if(user != null){
                resp.setStatus(HTTPUtils.STATUS_403);

                Message msg = new Message();
                msg.setMessage("username exist.");
                JSONObject jobj = new JSONObject(msg);

                resp.getWriter().write(jobj.toString());

                return;
            }
            result = udao.setSingleUser(JDBCUtils.getConnection(),username,password);

        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HTTPUtils.STATUS_500);

           Message msg = new Message();
            msg.setMessage("Unexpected server error.");
            JSONObject jobj = new JSONObject(msg);

            resp.getWriter().write(jobj.toString());
            return;
        }
        if(result == 0)// update结束，受影响行数为0
        {
            Message msg = new Message();
            msg.setMessage("Please enter your username or password.");
            JSONObject jobj = new JSONObject(msg);

            resp.getWriter().write(jobj.toString());
            return;
        }

        Message msg = new Message();
        msg.setMessage("Thanks for your registration.");
        JSONObject jobj = new JSONObject(msg);

        resp.getWriter().write(jobj.toString());
    }
}

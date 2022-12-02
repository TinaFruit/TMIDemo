package org.tmi.servlet;

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
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        HTTPUtils.setResponseHeaders(resp);
        String username;
        String password;
        if (session!=null && !session.isNew()) {
            session.invalidate();
        }
        req.setCharacterEncoding("utf-8");


        JSONObject jo = JsonUtils.getJsonObject(req);
        username = jo.getString("username");
        password = jo.getString("password");

        UserDAO udao = new UserDAOImpl();
        User user = null;
        try {
             user = udao.getSingleUser(username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user == null)
        {
            resp.setStatus(HTTPUtils.STATUS_404);

            Message msg = new Message();
            msg.setMessage("Invalid username or password.");
            JSONObject jobj = new JSONObject(msg);
            resp.getWriter().write(jobj.toString());

            return;
        }

        req.getSession(true).setAttribute("user",user);
        resp.sendRedirect(req.getContextPath() + "/welcome.jsp");

    }
}

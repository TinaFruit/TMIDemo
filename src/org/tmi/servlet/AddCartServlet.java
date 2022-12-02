package org.tmi.servlet;

import org.json.JSONObject;
import org.tmi.DAO.UserDAO;
import org.tmi.DAO.UserDAOImpl;
import org.tmi.Utils.HTTPUtils;
import org.tmi.Utils.JsonUtils;
import org.tmi.pojo.Message;
import org.tmi.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/servlet3test")
public class AddCartServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name;

        JSONObject jo = JsonUtils.getJsonObject(req);
        name = jo.getString("name");

        HTTPUtils.setResponseHeaders(resp);
        if(name == null)
        {
            resp.setStatus(HTTPUtils.STATUS_404);
            Message msg = new Message();
            msg.setMessage("Name cannot be null");
            JSONObject jobj = new JSONObject(msg);
            resp.getWriter().write(jobj.toString());
            return;
        }


        //2.1从session中获取购物车   商品名   数量
     Map<String,Integer> map = (Map<String,Integer>) req.getSession().getAttribute("cart");
        Integer count= null;
        //2.2判断购物车是否为空
        if(map==null) {
            //第一次购物，创建购物车
            map = new HashMap<>();
            //创建完购物车，放入session中
            req.getSession().setAttribute("cart", map);
            //第一次加入商品到购物车,默认数量为1
            if(req.getParameter("quantity")!=null)
            {
                count = Integer.valueOf(req.getParameter("quantity"));
            }else {
                count = 1;
            }
        } else {
        //购物车不为空，继续判断购物车中是否有同种商品
        //map购物车通过商品名查找其数量
        count = map.get(name);
        if(req.getParameter("quantity")!=null) {
            //购物车没有当前商品
            count = count+Integer.valueOf(req.getParameter("quantity"));
        }else {
            //购物车已经存在该商品
            count++;
        }
    }

    //将商品以及数量等新数据放入购物车
            map.put(name,count);
        //3.提示信息

       JSONObject jobj = new JSONObject();
       jobj.put("itemName",name);

         resp.getWriter().write(jobj.toString());
    }


/*
抄的
    private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //设置编码
            response.setContentType("text/html;charset=UTF-8");
            //1.获取商品的名称,要考虑中文乱码
            String name = request.getParameter("name");
            //2.将商品添加到购物车
            //2.1从session中获取购物车   商品名   数量
            Map<String,Integer> map = (Map<String,Integer>) request.getSession().getAttribute("cart");
            Integer count= null;
            //2.2判断购物车是否为空
            if(map==null) {
                //第一次购物，创建购物车
                map = new HashMap<>();
                //创建完购物车，放入session中
                request.getSession().setAttribute("cart", map);
                //第一次加入商品到购物车,默认不选择数量为1
                count=1;
            }else {
                //购物车不为空，继续判断购物车中是否有同种商品
                //map购物车通过商品名查找其数量
                count = map.get(name);
                if(count==null) {
                    //购物车没有当前商品
                    count = 1;
                }else {
                    //购物车已经存在该商品
                    count++;
                }
            }
            //将商品以及数量等新数据放入购物车
            map.put(name,count);

            //3.提示信息
            PrintWriter w = response.getWriter();
            w.print("Added<b>"+name+"</b>to the Cart<hr>");
            w.print("<a href='"+request.getContextPath()+"/welcome.jsp'>Continue shopping</a>&nbsp;&nbsp;&nbsp;&nbsp;");
            w.print("<a href='"+request.getContextPath()+"/cart.jsp'>Go to Cart</a>&nbsp;&nbsp;&nbsp;&nbsp;");
        }
*/

      /*  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }
*/
}

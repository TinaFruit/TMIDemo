<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
</head>
<body>
    <table border="1" align="center" width="30%">
        <tr>
            <td>Product Name</td>
            <td>Quality</td>
        </tr>

        <%
        //获取购物车
        Map<String,Integer> map  = (Map<String, Integer>) request.getSession().getAttribute("cart");
        //判断购物车是否为空
        if(map==null){
            //购物车为空
            out.print("<tr><td colspan='2'>Shooping Cart is Empty. Go shopping first ~</td></tr>");
        }else{
            //若不为空，显示商品名及数量信息
            for(String name:map.keySet()){
                out.print("<tr><td>"+name+"</td><td>"+map.get(name)+"</td></tr>");
            }
        }
        %>

    </table>
    <hr>
    <center>
        <a href="/welcome.jsp">Continue Shopping</a>
    </center>
</body>
</html>
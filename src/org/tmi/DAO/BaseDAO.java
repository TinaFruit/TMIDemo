package org.tmi.DAO;

import org.tmi.Utils.JDBCUtils;
import org.tmi.pojo.User;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;


public class BaseDAO {

    /**
     * Common Insert,Delete,Update
     * @param sql
     * @param args
     */

    public int update (Connection conn, String sql, Object ...args){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);

            for(int i=0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            JDBCUtils.closeResource(null,ps);
        }
        return 0;
    }
//    public void update ( String sql, Object ...args){
//
//        Connection conn = null;
//        PreparedStatement ps = null;
//        try {
//            conn = JDBCUtils.getConnection();
//            ps = conn.prepareStatement(sql);
//
//            for(int i=0;i < args.length;i++){
//                ps.setObject(i + 1, args[i]);
//
//            }
//            ps.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            JDBCUtils.closeResource(conn,ps);
//        }
//    }
//
//    public void testUpdate(){
//
//        String sql1 = "insert into user_info where id = ?";
//        update(sql1,2);
//
//        String sql2 = "update user_info set userName = ? where id = ?";
//        update(sql2,"abc",2);
//
//        String sql3 ="insert into user_info (userName,password,location_id) values (?,?,?)";
//        update(sql3,"abc","abc123",2);
//    }
    /**
     * Common Select
     * @param sql
     * @param
     * @return
     */


    public User querySingle(String sql,String username){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1,username);
            rs = ps.executeQuery();
            User user = new User();
            if(rs.next()){//next 方法是，默认情况下结果指针指向一行空数据，调用next后，如果结果集中有数据，
                // 则返回true且指针移动到下一行，即第一行数据。持续调用next就会持续移动指针。
                // 直到没有数据为止，然后就返回false。
                user.setUserName(username);
                user.setId(rs.getInt("id"));
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null ;
    }

    public User queryUser(String sql,String username,String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1,username);
            ps.setObject(2,password);
            rs = ps.executeQuery();
            User user = new User();
            if(rs.next()){//next 方法是，默认情况下结果指针指向一行空数据，调用next后，如果结果集中有数据，
                // 则返回true且指针移动到下一行，即第一行数据。持续调用next就会持续移动指针。
                // 直到没有数据为止，然后就返回false。
                user.setUserName(username);
                user.setPassword(password);
                user.setId(rs.getInt("id"));
                return user;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null ;
    }


          public User query(String sql,Object...args) {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                conn = JDBCUtils.getConnection();
                ps = conn.prepareStatement(sql);

                for(int i = 0;i < args.length ;i++){
                    ps.setObject(i+1,args[i]);
                }
                rs = ps.executeQuery();

                ResultSetMetaData metaData = rs.getMetaData();

                int columnCount = metaData.getColumnCount();
                if(rs.next()){
                    User user = new User();

                    for(int i = 0;i<columnCount;i++){

                        Object columnValue = rs.getObject(i + 1);

                        String columnName = metaData.getColumnName(i + 1);

                        Field field = User.class.getDeclaredField(columnName);
                        field.setAccessible(true);
                        field.set(user,columnValue);
                    }
                    return user;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.closeResource(conn,ps,rs);
            }
            return null;
        }

//    public void testQuery(){
//
//        String sql = "select id,userName,password,location,id from user_info where id = ?";
//        User user = query(sql, 2);
//        System.out.println(user);
//    }
}


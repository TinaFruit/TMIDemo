package org.tmi.DAO;

import java.sql.Connection;
import org.junit.Test;
import org.tmi.Utils.JDBCUtils;
import org.tmi.pojo.User;

public class UserDAOImplTest {
    private UserDAOImpl dao = new UserDAOImpl();
    @Test
    public void testGetInfor(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();

            User user = dao.getSingleUser( "tina","tina123");
            System.out.println(user);

            System.out.println("Successful");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}

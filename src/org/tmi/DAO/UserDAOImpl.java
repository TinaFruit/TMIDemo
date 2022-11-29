package org.tmi.DAO;


import org.junit.Test;
import org.tmi.Utils.JDBCUtils;
import org.tmi.pojo.User;
import java.sql.Connection;

public class UserDAOImpl extends BaseDAO implements UserDAO {

    /**
     * insert
     * @param conn
     * @param userName
     * @param password
     * @return
     */
    @Override
    public int setSingleUser(Connection conn, String userName, String password) {

        String sql = "insert into user_info (userName,password ) values (?,?);";

        int up = update(conn, sql, userName, password);
        return up;
    }

    /**
     * delete
     * @param conn
     * @param userName
     * @return
     */
    public int deleteSingleUser(Connection conn, String userName) {

        String sql = "delete from user_info where userName = ?;";

        int up = update(conn, sql, userName);
        return up;
    }

    /**
     * update
     * @param conn
     * @param password
     * @param userName
     * @return
     */
    public int updateSingleUser(Connection conn, String password,String userName) {

        String sql = "update user_info set password = ? where userName = ?;";

        int up = update(conn, sql, password, userName);
        return up;
    }

    /** Login
     *  select
     * @param userName
     * @param password
     * @return
     */
    public User getSingleUser(String userName, String password) {

            String sql = "select * from user_info where userName = ? and password = ?";

            User user = queryUser(sql, userName, password);
            return user;
    }

    /** Register
     * select
     * @param  username
     * @return
     */
    public User getSingleUser(String username) {

        String sql = "select * from user_info where userName = ?";

        User user = querySingle(sql, username);
        return user;
    }
}

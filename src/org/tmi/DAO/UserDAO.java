package org.tmi.DAO;


import org.tmi.pojo.User;

import java.sql.Connection;

public interface UserDAO {

    int setSingleUser(Connection conn, String userName, String password);
    int deleteSingleUser(Connection conn, String userName);
    int updateSingleUser(Connection conn, String password,String userName);
    User getSingleUser(String userName, String password);
    User getSingleUser(String userName);
}


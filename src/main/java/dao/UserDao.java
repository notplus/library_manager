package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.JdbcUtil;

public class UserDao {
    public void updateUser(User user, String userName, String password) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql = "updat user" + "set user_name=?,user_pwd=?" + "where user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        preparedStatement.setInt(3, user.getId());
        preparedStatement.execute();
    }

    public List<User> query() throws Exception {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        List<User> userList = new ArrayList<User>();
        User user = null;

        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("user_name"));
            user.setUniteID(resultSet.getString("unite_id"));
            user.setPassword(resultSet.getString("user_pwd"));
            user.setEmail(resultSet.getString("user_email"));
            user.setRole(resultSet.getString("user_role"));
            userList.add(user);
        }
        return userList;
    }

    public boolean isUserPwdCorrect(String username, String password) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select * from user where user_name='" + username + "' and user_pwd='" + password + "'");
        if (resultSet.next())
            return true;
        else
            return false;

    }

    public boolean isAdmin(String username) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select user_role from user where user_name='" + username + "'");
        resultSet.next();
        if (resultSet.getString("user_role").equals("admin"))
            return true;
        else
            return false;
    }

    
}

import util.JdbcUtil;

import java.sql.*;

public class LinkMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取数据库连接
        Connection connection = JdbcUtil.getConnection();
        //需要执行的sql语句
        String sql = "select * from book";
        //获取预处理对象，并给参数赋值
        Statement statement = connection.createStatement();
        ResultSet resultset= statement.executeQuery(sql);
        while (resultset.next()){
            System.out.println(resultset.getInt("book_id"));
        }

        //关闭jdbc连接
        statement.close();
        connection.close();


    }
}
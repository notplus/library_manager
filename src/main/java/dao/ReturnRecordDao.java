package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ReturnRecord;
import util.JdbcUtil;
import util.UserRole;

public class ReturnRecordDao {
    public List<ReturnRecord> query() throws Exception {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        if (UserRole.isAdmin) {
            ResultSet resultSet = statement.executeQuery(
                    "select * from returnbooks inner join book on returnbooks.book_id=book.book_id");
            return setData(resultSet);
        }

        else {
            ResultSet resultSet = statement.executeQuery(
                    "select * from returnbooks inner join book on returnbooks.book_id=book.book_id where user_id='"
                            + Integer.toString(UserRole.id) + "'");
            return setData(resultSet);
        }
    }

    private List<ReturnRecord> setData(ResultSet resultSet) throws Exception {
        List<ReturnRecord> returnRecordList = new ArrayList<ReturnRecord>();
        ReturnRecord returnRecord = null;
        while (resultSet.next()) {
            returnRecord = new ReturnRecord();
            returnRecord.setID(resultSet.getInt("id"));
            returnRecord.setUser_id(resultSet.getInt("user_id"));
            returnRecord.setBook_id(resultSet.getInt("book_id"));
            returnRecord.setBook_name(resultSet.getString("book_name"));
            returnRecord.setBorrow_date(resultSet.getDate("borrow_date"));
            returnRecord.setBorrow_time(resultSet.getTime("borrow_time"));
            returnRecord.setReturn_date(resultSet.getDate("return_date"));
            returnRecord.setReturn_time(resultSet.getTime("return_time"));
            returnRecordList.add(returnRecord);
        }

        return returnRecordList;
    }
}


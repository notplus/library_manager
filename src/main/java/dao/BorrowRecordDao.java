package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BorrowRecord;
import util.JdbcUtil;
import util.UserRole;

public class BorrowRecordDao {
    public List<BorrowRecord> query() throws Exception {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        if (UserRole.isAdmin) {
            ResultSet resultSet = statement.executeQuery(
                    "select * from borrowingbooks inner join book on borrowingbooks.book_id=book.book_id");
            return setData(resultSet);
        }

        else {
            ResultSet resultSet = statement.executeQuery(
                    "select * from borrowingbooks inner join book on borrowingbooks.book_id=book.book_id where user_id='"
                            + Integer.toString(UserRole.id) + "'");
            return setData(resultSet);
        }

    }

    private List<BorrowRecord> setData(ResultSet resultSet) throws Exception {
        List<BorrowRecord> borrowRecordList = new ArrayList<BorrowRecord>();
        BorrowRecord borrowRecord = null;
        while (resultSet.next()) {
            borrowRecord = new BorrowRecord();
            borrowRecord.setID(resultSet.getInt("id"));
            borrowRecord.setUser_id(resultSet.getInt("user_id"));
            borrowRecord.setBook_id(resultSet.getInt("book_id"));
            borrowRecord.setBook_name(resultSet.getString("book_name"));
            borrowRecord.setBorrow_date(resultSet.getDate("borrow_date"));
            borrowRecord.setBorrow_time(resultSet.getTime("borrow_time"));
            borrowRecord.setDue_date(resultSet.getDate("due_date"));
            borrowRecordList.add(borrowRecord);
        }
        return borrowRecordList;
    }
}

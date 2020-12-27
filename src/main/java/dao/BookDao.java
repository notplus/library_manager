package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import model.*;

public class BookDao {
    public void addBook(Book book) throws Exception {
        Connection connection = JdbcUtil.getConnection();
        String sql = "insert into book "
                + "(book_isbn,book_name,book_price,book_author,book_publish,book_category,book_introduction,is_lend)"
                + "values(" + "?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // preparedStatement.setInt(1, book.getID());
        preparedStatement.setString(1, book.getISBN());
        preparedStatement.setString(2, book.getBookName());
        preparedStatement.setFloat(3, book.getPrice());
        preparedStatement.setString(4, book.getAuthor());
        preparedStatement.setString(5,book.getPublishedHouse());
        preparedStatement.setString(6, book.getBookCategory());
        preparedStatement.setString(7, book.getBookIntroduction());
        preparedStatement.setString(8, Boolean.toString(book.getIsLend()));

        preparedStatement.execute();
    }

    public List<Book> query(int mode, String data) throws Exception {
        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from book");
        if (mode == 1) // 通过书名查找
            resultSet = statement.executeQuery("select * from book where book_name like '%" + data + "%'");
        else if (mode == 2) // 通过ISBN查找
            resultSet = statement.executeQuery("select * from book where book_isbn = " + data + "'");
        else if (mode == 3) // 通过作者查找
            resultSet = statement.executeQuery("select * from book where book_author like '%" + data + "%'");

        List<Book> bookList = new ArrayList<Book>();
        Book book = null;
        while (resultSet.next()) {
            book = new Book();
            book.setID(resultSet.getInt("book_id"));
            book.setISBN(resultSet.getString("book_isbn"));
            book.setBookName(resultSet.getString("book_name"));
            book.setPrice(resultSet.getFloat("book_price"));
            book.setAuthor(resultSet.getString("book_author"));
            book.setPublishedHouse(resultSet.getString("book_publish"));
            book.setBookCategory(resultSet.getString("book_category"));
            book.setBookIntroduction(resultSet.getString("book_introduction"));
            book.setIsLend(Boolean.parseBoolean(resultSet.getString("is_lend")));
            bookList.add(book);
        }
        return bookList;
    }

    public void deleteBook(int id) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql = "delete from book where book_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public void updateBook(Book book) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql = "update book set book.book_isbn=?, book.book_name=?, book.book_price=?,  book.book_author=?,"
                + "  book.book_publish=?,  book.book_category=?,  book.book_introduction=?, book.is_lend=? where book.book_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, book.getISBN());
        preparedStatement.setString(2, book.getBookName());
        preparedStatement.setFloat(3, book.getPrice());
        preparedStatement.setString(4, book.getAuthor());
        preparedStatement.setString(5, book.getPublishedHouse());
        preparedStatement.setString(6, book.getBookCategory());
        preparedStatement.setString(7, book.getBookIntroduction());
        preparedStatement.setString(8, Boolean.toString(book.getIsLend()));
        preparedStatement.setInt(9, book.getID());
        preparedStatement.execute();

    }

}

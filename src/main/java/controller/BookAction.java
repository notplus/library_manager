package controller;

import java.util.List;

import dao.BookDao;
import model.Book;

public class BookAction {
    // @SuppressWarnings("rawtypes")
    // public Object[][] initializTable(String[] columnNames) throws Exception {
    // BookDao bookDao = new BookDao();
    // List list = bookDao.query(0, "");
    // Object[][] results = new Object[list.size()][columnNames.length];

    // for (int i = 0; i < list.size(); i++) {
    // Book book = (Book) list.get(i);

    // results[i][0] = book.getID();
    // results[i][1] = book.getISBN();
    // results[i][2] = book.getBookName();
    // results[i][3] = book.getAuthor();
    // results[i][4] = book.getPrice();
    // results[i][5] = book.getPublishedHouse();
    // results[i][6] = book.getBookCategory();
    // results[i][7] = book.getBookIntroduction();
    // if (book.getIsLend())
    // results[i][8] = "是";
    // else
    // results[i][8] = "否";
    // }

    // return results;
    // }

    @SuppressWarnings("rawtypes")
    public Object[][] setQueryTable(String[] columnNames, int mode, String data) throws Exception {
        BookDao bookDao = new BookDao();
        List list = bookDao.query(mode, data);
        Object[][] results = new Object[list.size()][columnNames.length];

        for (int i = 0; i < list.size(); i++) {
            Book book = (Book) list.get(i);

            results[i][0] = book.getID();
            results[i][1] = book.getISBN();
            results[i][2] = book.getBookName();
            results[i][3] = book.getAuthor();
            results[i][4] = book.getPrice();
            results[i][5] = book.getPublishedHouse();
            results[i][6] = book.getBookCategory();
            results[i][7] = book.getBookIntroduction();
            if (book.getIsLend())
                results[i][8] = "是";
            else
                results[i][8] = "否";
        }

        return results;
    }

    public void addBookInformation(String bookIsbn, String bookName, String bookAuthor, String bookPrice,
            String bookPublish, String bookCategory, String bookIntroduction) throws Exception {

        BookDao bookDao = new BookDao();
        Book book = new Book();

        book.setISBN(bookIsbn);
        book.setBookName(bookName);
        book.setAuthor(bookAuthor);
        book.setPrice(Float.parseFloat(bookPrice));
        book.setPublishedHouse(bookPublish);
        book.setBookCategory(bookCategory);
        book.setBookIntroduction(bookIntroduction);
        book.setIsLend(false);

        bookDao.addBook(book);
    }

    public void deleteBook(int id) throws Exception {
        BookDao bookDao = new BookDao();
        bookDao.deleteBook(id);
    }

    public void updateBookInfo(int bookID, String bookIsbn, String bookName, String bookAuthor, String bookPrice,
            String bookPublish, String bookCategory, String bookIntroduction) throws Exception {
        BookDao bookDao = new BookDao();
        Book book = new Book();

        book.setID(bookID);
        book.setISBN(bookIsbn);
        book.setBookName(bookName);
        book.setAuthor(bookAuthor);
        book.setPrice(Float.parseFloat(bookPrice));
        book.setPublishedHouse(bookPublish);
        book.setBookCategory(bookCategory);
        book.setBookIntroduction(bookIntroduction);
        book.setIsLend(false);

        bookDao.updateBook(book);
    }
}

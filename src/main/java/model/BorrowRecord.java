package model;

import java.sql.Time;
import java.sql.Date;

public class BorrowRecord {
    private int ID;
    private int user_id;
    private int book_id;
    private String book_name;
    private Date borrow_date;
    private Time borrow_time;
    private Date due_date;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Time getBorrow_time() {
        return borrow_time;
    }

    public void setBorrow_time(Time borrow_time) {
        this.borrow_time = borrow_time;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

}

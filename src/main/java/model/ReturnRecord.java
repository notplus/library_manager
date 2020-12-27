package model;

import java.sql.Time;
import java.sql.Date;

public class ReturnRecord {
    private int ID;
    private int user_id;
    private int book_id;
    private String book_name;
    private Date borrow_date;
    private Time borrow_time;
    private Date return_date;
    private Time return_time;

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

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public Time getReturn_time() {
        return return_time;
    }

    public void setReturn_time(Time return_time) {
        this.return_time = return_time;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }


}

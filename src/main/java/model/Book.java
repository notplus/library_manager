package model;

public class Book {
    private int ID;

    private String ISBN;
    private String bookName;
    private float Price;
    private String author;
    private String publishedHouse;
    private String bookCategory;
    private String bookIntroduction;
    private boolean isLend;

    public int getID(){
        return ID;
    }

    public void setID(int id){
        ID=id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedHouse() {
        return publishedHouse;
    }

    public void setPublishedHouse(String publishedHouse) {
        this.publishedHouse = publishedHouse;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }

    public boolean getIsLend() {
        return isLend;
    }

    public void setIsLend(boolean isLend) {
        this.isLend = isLend;
    }

    
}

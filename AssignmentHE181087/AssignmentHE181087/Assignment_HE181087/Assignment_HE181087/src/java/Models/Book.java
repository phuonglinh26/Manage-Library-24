/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Models;

public class Book {
    private int bookID;
    private String title;
    private int publishedYear;
    private int quantity;
    private String genre;
    private String publisherName;
    private String authorName;
    private int rowID;
    private int shelfID;

    public Book() {
    }

    public Book(int bookID, String title, int publishedYear, int quantity, String genre, String publisherName, String authorName, int rowID, int shelfID) {
        this.bookID = bookID;
        this.title = title;
        this.publishedYear = publishedYear;
        this.quantity = quantity;
        this.genre = genre;
        this.publisherName = publisherName;
        this.authorName = authorName;
        this.rowID = rowID;
        this.shelfID = shelfID;
    }

 
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public int getShelfID() {
        return shelfID;
    }

    public void setShelfID(int shelfID) {
        this.shelfID = shelfID;
    }
}

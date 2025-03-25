/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import DAL.DAO;
import java.util.Date;

public class BorrowRecord {

    private int borrowID;
    private Date borrowDate;
    private int allowedDay;
    private int readerID;
    private int bookID;
    private int staffID;

    public BorrowRecord() {
    }

    public BorrowRecord(int borrowID, Date borrowDate, int allowedDay, int readerID, int bookID, int staffID) {
        this.borrowID = borrowID;
        this.borrowDate = borrowDate;
        this.allowedDay = allowedDay;
        this.readerID = readerID;
        this.bookID = bookID;
        this.staffID = staffID;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getAllowedDay() {
        return allowedDay;
    }

    public void setAllowedDay(int allowedDay) {
        this.allowedDay = allowedDay;
    }

    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    
    // Phương thức lấy thông tin sách từ Book dựa trên bookID
    public String getBookTitle() {
        Book book = DAO.INSTANCE.getBookByID(bookID);
        return book != null ? book.getTitle() : "Unknown";
    }

    // Phương thức lấy tiền phạt từ bảng BorrowReturnDetail
    public int getFineAmount() {
        BorrowReturnDetail returnDetail = DAO.INSTANCE.getBorrowReturnDetailByBorrowId(borrowID);
        return returnDetail != null ? returnDetail.getFineAmount() : 0;
    }
}


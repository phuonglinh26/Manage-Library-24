/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class BorrowReturnDetail {
    private String note;
    private int fineAmount;
    private int borrowID;
    private int returnID;

    public BorrowReturnDetail() {
    }

    public BorrowReturnDetail(String note, int fineAmount, int borrowID, int returnID) {
        this.note = note;
        this.fineAmount = fineAmount;
        this.borrowID = borrowID;
        this.returnID = returnID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getReturnID() {
        return returnID;
    }

    public void setReturnID(int returnID) {
        this.returnID = returnID;
    }
   
    
}
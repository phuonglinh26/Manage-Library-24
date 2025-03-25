/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

public class Reader {

    private int readerID;
    private String readerName;
    private String readerGender;
    private Date readerDOB;
    private String readerPhone;
    private String readerAddress;
    private int loginID;

    public Reader() {
    }

    public Reader(int readerID, String readerName, String readerGender, Date readerDOB, String readerPhone, String readerAddress, int loginID) {
        this.readerID = readerID;
        this.readerName = readerName;
        this.readerGender = readerGender;
        this.readerDOB = readerDOB;
        this.readerPhone = readerPhone;
        this.readerAddress = readerAddress;
        this.loginID = loginID;
    }

  
    public int getReaderID() {
        return readerID;
    }

    public void setReaderID(int readerID) {
        this.readerID = readerID;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getReaderGender() {
        return readerGender;
    }

    public void setReaderGender(String readerGender) {
        this.readerGender = readerGender;
    }

    public Date getReaderDOB() {
        return readerDOB;
    }

    public void setReaderDOB(Date readerDOB) {
        this.readerDOB = readerDOB;
    }

    public String getReaderPhone() {
        return readerPhone;
    }

    public void setReaderPhone(String readerPhone) {
        this.readerPhone = readerPhone;
    }

    public String getReaderAddress() {
        return readerAddress;
    }

    public void setReaderAddress(String readerAddress) {
        this.readerAddress = readerAddress;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }
}

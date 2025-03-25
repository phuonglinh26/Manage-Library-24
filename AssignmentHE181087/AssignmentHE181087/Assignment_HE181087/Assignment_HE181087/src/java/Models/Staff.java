/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

public class Staff {

    private int staffID;
    private String staffName;
    private String staffGender;
    private Date staffDOB;
    private String staffPhone;
    private String staffAddress;
    private int loginID;

    public Staff() {
    }

    public Staff(int staffID, String staffName, String staffGender, Date staffDOB, String staffPhone, String staffAddress, int loginID) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffGender = staffGender;
        this.staffDOB = staffDOB;
        this.staffPhone = staffPhone;
        this.staffAddress = staffAddress;
        this.loginID = loginID;
    }

    
    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender;
    }

    public Date getStaffDOB() {
        return staffDOB;
    }

    public void setStaffDOB(Date staffDOB) {
        this.staffDOB = staffDOB;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public int getLoginID() {
        return loginID;
    }

    public void setLoginID(int loginID) {
        this.loginID = loginID;
    }
}

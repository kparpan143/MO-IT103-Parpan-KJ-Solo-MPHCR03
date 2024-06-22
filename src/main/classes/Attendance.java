/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.classes;

/**
 *
 * @author Kristine Parpan
 */
public class Attendance {
    
    private int year;
    private int month;
    private int date;
    private String timeIn;
    private String timeOut;
    
    public Attendance(int yr, int mnth, int dt, String ti, String to) {
        this.year = yr;
        this.month = mnth;
        this.date = dt;
        this.timeIn = ti;
        this.timeOut = to;
    }
    
    public int getYear(){
        return this.year;
    }
    public void setYear(int yr){
        this.year = yr;
    }
    
    public int getMonth(){
        return this.month;
    }
    public void setMonth(int mnth){
        this.month = mnth;
    }
    
    public int getDate(){
        return this.date;
    }
    public void setDate(int dt){
        this.date = dt;
    }
    
    public String getTimeIn(){
        return this.timeIn;
    }
    public void setTimeIn(String ti){
        this.timeIn = ti;
    }
    
    public String getTimeOut(){
        return this.timeOut;
    }
    public void setTimeOut(String to){
        this.timeOut = to;
    }
}

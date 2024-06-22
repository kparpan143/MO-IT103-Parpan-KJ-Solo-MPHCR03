/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.classes;

/**
 *
 * @author Kristine Parpan
 */
public class Employee {
    
    private int employeeNumber;
    private String employeeName, firstName, lastName, sss, philHealth, tin, pagibig, position;
    private String birthday;
    private double hourlyRate;
    private double basicSalary;
    
    public Employee (int empNumber, String empName, String bday, double hrlyRate, double bscSalary) {
        this.employeeNumber = empNumber;
        this.employeeName = empName;
        this.birthday = bday;
        this.hourlyRate = hrlyRate;
        this.basicSalary = bscSalary;
    }

    public Employee (int empNumber, String firstName, String lastName, String sss, String philHealth, String tin, String pagibig) {
        this.employeeNumber = empNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sss = sss;
        this.philHealth = philHealth;
        this.tin = tin;
        this.pagibig = pagibig;
    }

    public Employee (int empNumber, String firstName, String lastName, String sss, String philHealth, String tin, String pagibig, String bday, double hrlyRate, double bscSalary, String position) {
        this.employeeNumber = empNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sss = sss;
        this.philHealth = philHealth;
        this.tin = tin;
        this.pagibig = pagibig;
        this.birthday = bday;
        this.hourlyRate = hrlyRate;
        this.basicSalary = bscSalary;
        this.position = position;
    }
    
    public int getEmployeeNumber() {
        return this.employeeNumber;
    }
    public void setEmployeeNumber(int empNumber) {
        this.employeeNumber = empNumber;
    }
    
    public String getEmployeeName() {
    	if (this.employeeName == null) {
    		return this.firstName + " " + this.lastName;
    	}
    	else {
    		return this.employeeName;
    	}
    }
    public void setEmployeeName(String empName) {
        this.employeeName = empName;
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    } 
    
    public String getPosition() {
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getSSS() {
        return this.sss;
    }
    public void setSSS(String sss) {
        this.sss = sss;
    }
    
    public String getPhilHealth() {
        return this.philHealth;
    }
    public void setPhilHealth(String philHealth) {
        this.philHealth = philHealth;
    }
    
    public String getTIN() {
        return this.tin;
    }
    public void setTIN(String tin) {
        this.tin = tin;
    }
    
    public String getPagibig() {
        return this.pagibig;
    }
    public void setPagibig(String pagibig) {
        this.pagibig = pagibig;
    }
    
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String bday) {
        this.birthday = bday;
    }
    
    public double getHourlyRate() {
        return this.hourlyRate;
    }
    public void setHourlyRate(double hrlyRate) {
        this.hourlyRate = hrlyRate;
    }
    
    public double getBasicSalary() {
        return this.basicSalary;
    }
    public void setBasicSalary(double bscSalary) {
        this.basicSalary = bscSalary;
    }
}

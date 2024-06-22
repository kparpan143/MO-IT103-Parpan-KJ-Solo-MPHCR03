package main.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Salary {
    
    private double grossWage;
    private double netWage;
    private SalaryDeduction salaryDeduction;
    
    public Salary (double grossWage, double netWage, SalaryDeduction salaryDeduction) {
        this.grossWage = grossWage;
        this.netWage = netWage;
        this.salaryDeduction = salaryDeduction;
    }
    
    public double getGrossWage(){
        return this.grossWage;
    }
    public void setGrossWage(double grossWage){
        this.grossWage = grossWage;
    }
    
    public double getNetWage(){
        return this.netWage;
    }
    public void setNetWage(double netWage){
        this.netWage = netWage;
    }
    
    public SalaryDeduction getSalaryDeduction(){
        return this.salaryDeduction;
    }
    public void setSalaryDeduction(SalaryDeduction salaryDeduction){
        this.salaryDeduction = salaryDeduction;
    }


    // Method used for calculating employee salary
    public static Salary calculateSalary (Employee employee, List<Attendance> attendances) {
        double totalHoursWorked =  calculateHoursWorked(attendances);
        double grossWage = calculateGrossWage (employee, totalHoursWorked);
        double sss = Double.parseDouble(String.format("%.2f", SalaryDeduction.getSSSContribution(employee)));
        double philHealth = Double.parseDouble(String.format("%.2f", SalaryDeduction.getPhilHealthContribution(employee)));
        double pagibig = Double.parseDouble(String.format("%.2f", SalaryDeduction.getPagibigContribution(employee)));
        double witholdingTax = Double.parseDouble(String.format("%.2f", (SalaryDeduction.getWitholdingTax(grossWage, sss,  philHealth, pagibig))));
        
        SalaryDeduction salaryDeduction = new SalaryDeduction(sss, philHealth, pagibig, witholdingTax);
        
        double netWage = calculateNetWage (grossWage, salaryDeduction);
        
        return new Salary(grossWage, netWage, salaryDeduction);
    }
    
    // Method used for calculating hours per week depending on the month number provided
    public static double calculateHoursWorked (List<Attendance> attendances) {
    	double hoursWorked = 0.0;
        // loop through employee weekly attendance record
        for (int a = 0; a < attendances.size(); a++) {
            double hoursWorkedPerDay = getHoursWorkedPerDay(attendances.get(a));
            hoursWorked += hoursWorkedPerDay;
        }
        return hoursWorked;
    }
    
    // Method used for calculating the Weekly Gross Wage
    public static double calculateGrossWage (Employee employee, double totalHoursWorked) {
        return totalHoursWorked * employee.getHourlyRate();
    }
    
    // Method used for calculating the Weekly Net Wage
    public static double calculateNetWage (double grossWage, SalaryDeduction salaryDeduction) {
        return grossWage - salaryDeduction.getTotalDeductions();
    }

    // Method used for getting hours worked per day
    public static double getHoursWorkedPerDay (Attendance attendance) {
        String attDate = attendance.getMonth() + "/" + attendance.getDate() + "/" + attendance.getYear();
        
        // Convert String date and time to LocalDateTime
        LocalDateTime localDateTimeIn = getDateTime(attDate, attendance.getTimeIn());
        LocalDateTime localDateTimeOut = getDateTime(attDate, attendance.getTimeOut());
        
        // Set Grace Period as indicated in the requirements
        LocalTime gracePeriod = LocalTime.of(8, 11);
        // Check if time in is beyond grace period
        if (localDateTimeIn.toLocalTime().isBefore(gracePeriod)){
            // reset time in to 8AM to remove deduction
            localDateTimeIn = getDateTime(attDate, "08:00");
        }
        
        // Calculate Time Difference between timein and timeout
        long timeDiff = localDateTimeIn.toLocalTime().until(localDateTimeOut.toLocalTime(), ChronoUnit.MINUTES);
        double timeDiffDouble = Double.parseDouble(Long.toString(timeDiff)) / 60;
        
        if (timeDiffDouble <= 0) {
            // return zero for invalid data
            return 0.00;
        }
        else {
            // return total hours worked - 1 hour of breaktime
            timeDiffDouble = Double.parseDouble(String.format("%.2f", timeDiffDouble -1));
            
            return timeDiffDouble;
        }
    }
    
    // Method used for converting String date and String time
    public static LocalDateTime getDateTime (String date, String time) {
        String[] splitDate = date.split("/");
        String[] splitTime = time.split(":");
        
        // Convert String date to LocalDate
        LocalDate localDate = LocalDate.of(Integer.parseInt(splitDate[2]), Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]));
        // Convert String time to LocalTime
        LocalTime localTime = LocalTime.of(Integer.parseInt(splitTime[0]), Integer.parseInt(splitTime[1]));
        // Combine date and time
        LocalDateTime dateTime = LocalDateTime.of(localDate, localTime);
        
        return dateTime;
    }
}

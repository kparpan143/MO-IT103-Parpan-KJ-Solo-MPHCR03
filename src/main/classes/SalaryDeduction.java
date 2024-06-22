/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.classes;

/**
 *
 * @author Kristine Parpan
 */
public class SalaryDeduction {
    
    private double sssContribution;
    private double philHealthContribution;
    private double pagibigContribution;
    private double witholdingTax;
    
    public SalaryDeduction (double sss, double philHealth, double pagibig, double wTax) {
        this.sssContribution = sss;
        this.philHealthContribution = philHealth;
        this.pagibigContribution = pagibig;
        this.witholdingTax = wTax;
    }
    
    public double getSSSContribution(){
        return this.sssContribution;
    }
    public void setSSSContribution(double sss){
        this.sssContribution = sss;
    }
    
    public double getPhilHealthContribution(){
        return this.philHealthContribution;
    }
    public void setPhilHealthContribution(double philHealth){
        this.philHealthContribution = philHealth;
    }
    
    public double getPagibigContribution(){
        return this.pagibigContribution;
    }
    public void setPagibigContribution(double pagibig){
        this.pagibigContribution = pagibig;
    }
    
    public double getWitholdingTax(){
        return this.witholdingTax;
    }
    public void setWitholdingTax(double wTax){
        this.witholdingTax = wTax;
    }
    
    public double getTotalDeductions() {
    	return this.sssContribution + this.philHealthContribution + this.pagibigContribution + this.witholdingTax;
    }
    
    // Method used for getting SSS Contribution
    // hard coded values are based on the Google Sheet Provided
    public static double getSSSContribution(Employee employee) {
        if (employee.getBasicSalary() < 3250) {
            return 135.00;
        }
        else if (employee.getBasicSalary() >= 3250 && employee.getBasicSalary() <= 3750) {
            return 157.50;
        }
        else if (employee.getBasicSalary() >= 3750 && employee.getBasicSalary() <= 4250) {
            return 180.00;
        }
        else if (employee.getBasicSalary() >= 4250 && employee.getBasicSalary() <= 4750) {
            return 202.50;
        }
        else if (employee.getBasicSalary() >= 4750 && employee.getBasicSalary() <= 5250) {
            return 225.00;
        }
        else if (employee.getBasicSalary() >= 5250 && employee.getBasicSalary() <= 5750) {
            return 247.50;
        }
        else if (employee.getBasicSalary() >= 5750 && employee.getBasicSalary() <= 6250) {
            return 270.00;
        }
        else if (employee.getBasicSalary() >= 6250 && employee.getBasicSalary() <= 6750) {
            return 292.50;
        }
        else if (employee.getBasicSalary() >= 6750 && employee.getBasicSalary() <= 7250) {
            return 315.00;
        }
        else if (employee.getBasicSalary() >= 7250 && employee.getBasicSalary() <= 7750) {
            return 337.50;
        }
        else if (employee.getBasicSalary() >= 7750 && employee.getBasicSalary() <= 8250) {
            return 360.00;
        }
        else if (employee.getBasicSalary() >= 8250 && employee.getBasicSalary() <= 8750) {
            return 382.50;
        }
        else if (employee.getBasicSalary() >= 8750 && employee.getBasicSalary() <= 9250) {
            return 405.00;
        }
        else if (employee.getBasicSalary() >= 9250 && employee.getBasicSalary() <= 9750) {
            return 427.50;
        }
        else if (employee.getBasicSalary() >= 9750 && employee.getBasicSalary() <= 10250) {
            return 450.00;
        }
        else if (employee.getBasicSalary() >= 10250 && employee.getBasicSalary() <= 10750) {
            return 472.50;
        }
        else if (employee.getBasicSalary() >= 10750 && employee.getBasicSalary() <= 11250) {
            return 495.00;
        }
        else if (employee.getBasicSalary() >= 11250 && employee.getBasicSalary() <= 11750) {
            return 517.50;
        }
        else if (employee.getBasicSalary() >= 11750 && employee.getBasicSalary() <= 12250) {
            return 540.00;
        }
        else if (employee.getBasicSalary() >= 12250 && employee.getBasicSalary() <= 12750) {
            return 562.50;
        }
        else if (employee.getBasicSalary() >= 12750 && employee.getBasicSalary() <= 13250) {
            return 585.00;
        }
        else if (employee.getBasicSalary() >= 13250 && employee.getBasicSalary() <= 13750) {
            return 607.50;
        }
        else if (employee.getBasicSalary() >= 13750 && employee.getBasicSalary() <= 14250) {
            return 630.00;
        }
        else if (employee.getBasicSalary() >= 14250 && employee.getBasicSalary() <= 14750) {
            return 652.50;
        }
        else if (employee.getBasicSalary() >= 14750 && employee.getBasicSalary() <= 15250) {
            return 675.00;
        }
        else if (employee.getBasicSalary() >= 15250 && employee.getBasicSalary() <= 15750) {
            return 697.50;
        }
        else if (employee.getBasicSalary() >= 15750 && employee.getBasicSalary() <= 16250) {
            return 720.00;
        }
        else if (employee.getBasicSalary() >= 16250 && employee.getBasicSalary() <= 16750) {
            return 742.50;
        }
        else if (employee.getBasicSalary() >= 16750 && employee.getBasicSalary() <= 17250) {
            return 765.00;
        }
        else if (employee.getBasicSalary() >= 17250 && employee.getBasicSalary() <= 17750) {
            return 787.50;
        }
        else if (employee.getBasicSalary() >= 17750 && employee.getBasicSalary() <= 18250) {
            return 810.00;
        }
        else if (employee.getBasicSalary() >= 18250 && employee.getBasicSalary() <= 18750) {
            return 832.50;
        }
        else if (employee.getBasicSalary() >= 18750 && employee.getBasicSalary() <= 19250) {
            return 855.00;
        }
        else if (employee.getBasicSalary() >= 19250 && employee.getBasicSalary() <= 19750) {
            return 877.50;
        }
        else if (employee.getBasicSalary() >= 19750 && employee.getBasicSalary() <= 20250) {
            return 900.00;
        }
        else if (employee.getBasicSalary() >= 20250 && employee.getBasicSalary() <= 20750) {
            return 922.50;
        }
        else if (employee.getBasicSalary() >= 20750 && employee.getBasicSalary() <= 21250) {
            return 945.00;
        }
        else if (employee.getBasicSalary() >= 21250 && employee.getBasicSalary() <= 21750) {
            return 967.50;
        }
        else if (employee.getBasicSalary() >= 21750 && employee.getBasicSalary() <= 22250) {
            return 990.00;
        }
        else if (employee.getBasicSalary() >= 22250 && employee.getBasicSalary() <= 22750) {
            return 1012.50;
        }
        else if (employee.getBasicSalary() >= 22750 && employee.getBasicSalary() <= 23250) {
            return 1035.00;
        }
        else if (employee.getBasicSalary() >= 23250 && employee.getBasicSalary() <= 23750) {
            return 1057.50;
        }
        else if (employee.getBasicSalary() >= 23750 && employee.getBasicSalary() <= 24250) {
            return 1080.00;
        }
        else if (employee.getBasicSalary() >= 24250 && employee.getBasicSalary() <= 24750) {
            return 1102.50;
        }
        else {
            return 1125.00;
        }
    }

    // Method used for getting PhilHealth Contribution
    // hard coded values are based on the Google Sheet Provided
    public static double getPhilHealthContribution(Employee employee) {
        if (employee.getBasicSalary() <= 10000.00) {
            return 150.00;
        }
        else if (employee.getBasicSalary() > 10000 && employee.getBasicSalary() < 60000) {
            return (employee.getBasicSalary() * 0.03) / 2;
        }
        else {
            return 900;
        }
    }

    // Method used for getting Pagibig Contribution
    // hard coded values are based on the Google Sheet Provided
    public static double getPagibigContribution(Employee employee) {
        if (employee.getBasicSalary() >= 1000 && employee.getBasicSalary() <= 1500) {
            return employee.getBasicSalary() * 0.01;
        }
        else if (employee.getBasicSalary() > 1500){
            if ((employee.getBasicSalary() * 0.02) <= 100) {
                return employee.getBasicSalary() * 0.02;
            }
            else {
                return 100;
            }
        }
        else {
            return 0.0;
        }
    }

    // Method used for getting Witholding Tax
    // hard coded values are based on the Google Sheet Provided
    public static double getWitholdingTax(double grossWage, double sss, double philHealth, double pagibig) {
        double deductedSalary = grossWage - sss - philHealth - pagibig;
        
        if (deductedSalary <= 20832){
            return 0.0;
        }
        else if (deductedSalary >= 20833 && deductedSalary < 33333) {
            return (deductedSalary - 20833) * 0.2;
        }
        else if (deductedSalary >= 33333 && deductedSalary < 66667) {
            return ((deductedSalary - 33333) * 0.25) + 2500;
        }
        else if (deductedSalary >= 66667 && deductedSalary < 166667) {
            return ((deductedSalary - 66667) * 0.3) + 10833;
        }
        else if (deductedSalary >= 166667 && deductedSalary < 666667) {
            return ((deductedSalary - 166667) * 0.32) + 40833.33;
        }
        else {
            return ((deductedSalary - 666667) * 0.35) + 200833.33;
        }
    }
}

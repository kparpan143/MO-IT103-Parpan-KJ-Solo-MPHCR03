package main.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import main.MotorPH;
import main.classes.Attendance;
import main.classes.Employee;
import main.classes.Salary;

public class EmployeeDetailsView {

    // Constant Variables
    private static final String ATTENDANCE_CSV = System.getProperty("user.dir") + "/src/main/resources/attendance.csv";
    
    // Variables needed for the Employee Details View
    private JLabel lblHeader, lblHeader2, lblEmployeeNumber, lblEmployeeName, lblYear, lblMonth;
    private JTextField txtEmployeeNumber, txtEmployeeName, txtYear;
    private JButton computeButton;

    // Variables needed for Additional Employee Detail 
    private JLabel lblSSSNo, lblPhilHealthNo, lblTIN, lblPagibigNo, lblBirthday, lblHourlyRate, lblBasicSalary, lblPosition;
    private JTextField txtSSSNo, txtPhilHealthNo, txtTIN, txtPagibigNo, txtBirthday, txtHourlyRate, txtBasicSalary, txtPosition;
    
    // Variables needed for the Salary Computation View
    private JLabel lblHeader3, lblYear2, lblMonth2, lblGrossWage, lblNetWage, lblDeductions, lblSSS, lblPagibig, lblPhilHealth, lblWitholdingTax;
    private JTextField txtYear2,txtMonth, txtGrossWage, txtNetWage, txtDeductions, txtSSS, txtPagibig, txtPhilHealth, txtWitholdingTax;
    
    private final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private BufferedReader attendanceReader = null;
    
	public EmployeeDetailsView (Employee employee) {
		
		// Set Frame
		JFrame frame = new JFrame();
        frame.setSize(450, 450);
        frame.setTitle("MotorPH Employee App");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Set Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        
        // Set Panel 1
        // Create labels and textfields
        lblHeader = new JLabel("MotorPH Employee Details");
        lblHeader.setFont(new Font("Calibri", Font.BOLD, 20));
        lblHeader2 = new JLabel("Calculate Salary");
        lblHeader2.setFont(new Font("Calibri", Font.BOLD, 20));
        lblEmployeeNumber = new JLabel("Employee Number:");
        txtEmployeeNumber = new JTextField(20);
        txtEmployeeNumber.setEnabled(false);
        txtEmployeeNumber.setText(String.valueOf(employee.getEmployeeNumber()));
        
        lblEmployeeName = new JLabel("Employee Name:");
        txtEmployeeName = new JTextField(20);
        txtEmployeeName.setEnabled(false);
        txtEmployeeName.setText(String.valueOf(employee.getEmployeeName()));
        
        lblYear = new JLabel("Enter Year:");
        txtYear = new JTextField(5);
        txtYear.setFont(new Font(txtYear.getFont().getName(), Font.PLAIN, 15));
        lblMonth = new JLabel("Select Month:");
        final JComboBox<String> cbMonth = new JComboBox<String>(MONTHS);
        
        computeButton = new JButton("Compute");
        computeButton.setPreferredSize(new Dimension(150, 50));

        lblSSSNo = new JLabel("SSS No:");
        txtSSSNo = new JTextField(10);
        txtSSSNo.setEnabled(false);
        txtSSSNo.setText(employee.getSSS());
        
        lblPhilHealthNo = new JLabel("PhilHealth No:");
        txtPhilHealthNo = new JTextField(10);
        txtPhilHealthNo.setEnabled(false);
        txtPhilHealthNo.setText(employee.getPhilHealth());
        
        lblTIN = new JLabel("TIN:");
        txtTIN = new JTextField(10);
        txtTIN.setEnabled(false);
        txtTIN.setText(employee.getTIN());
        
        lblPagibigNo = new JLabel("Pagibig No:");
        txtPagibigNo = new JTextField(10);
        txtPagibigNo.setEnabled(false);
        txtPagibigNo.setText(employee.getPagibig());

        lblBirthday = new JLabel("Birthday:");
        txtBirthday = new JTextField(10);
        txtBirthday.setEnabled(false);
        txtBirthday.setText(employee.getBirthday());

        lblHourlyRate = new JLabel("Hourly Rate:");
        txtHourlyRate = new JTextField(10);
        txtHourlyRate.setEnabled(false);
        txtHourlyRate.setText(String.valueOf(employee.getHourlyRate()));

        lblBasicSalary = new JLabel("Basic Salary:");
        txtBasicSalary = new JTextField(10);
        txtBasicSalary.setEnabled(false);
        txtBasicSalary.setText(String.valueOf(employee.getBasicSalary()));

        lblPosition = new JLabel("Position:");
        txtPosition = new JTextField(15);
        txtPosition.setEnabled(false);
        txtPosition.setText(employee.getPosition());
        
        // Define the panel to hold the components  
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
       
        // Add the components to the frame
        panel.add(lblHeader);
        panel.add(lblHeader2);
        panel.add(lblEmployeeNumber);
        panel.add(txtEmployeeNumber);
        panel.add(lblEmployeeName);
        panel.add(txtEmployeeName);
        panel.add(lblYear);
        panel.add(txtYear);
        panel.add(lblMonth);
        panel.add(cbMonth);
        panel.add(computeButton);

        panel.add(lblSSSNo);
        panel.add(txtSSSNo);

        panel.add(lblPhilHealthNo);
        panel.add(txtPhilHealthNo);

        panel.add(lblTIN);
        panel.add(txtTIN);

        panel.add(lblPagibigNo);
        panel.add(txtPagibigNo);

        panel.add(lblBirthday);
        panel.add(txtBirthday);

        panel.add(lblHourlyRate);
        panel.add(txtHourlyRate);

        panel.add(lblBasicSalary);
        panel.add(txtBasicSalary);

        panel.add(lblPosition);
        panel.add(txtPosition);
        
        // Put constraint on components       
        // Employee Details Section
        // Set label and textfield position: top and bottom
        layout.putConstraint(SpringLayout.NORTH, lblHeader, 20, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblHeader, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        
        layout.putConstraint(SpringLayout.NORTH, lblEmployeeNumber, 20, SpringLayout.SOUTH, lblHeader);
        layout.putConstraint(SpringLayout.WEST, lblEmployeeNumber, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtEmployeeNumber, 20, SpringLayout.SOUTH, lblHeader);
        layout.putConstraint(SpringLayout.WEST, txtEmployeeNumber, 18, SpringLayout.EAST, lblEmployeeNumber);

        layout.putConstraint(SpringLayout.NORTH, lblEmployeeName, 10, SpringLayout.SOUTH, lblEmployeeNumber);
        layout.putConstraint(SpringLayout.WEST, lblEmployeeName, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtEmployeeName, 6, SpringLayout.SOUTH, txtEmployeeNumber);
        layout.putConstraint(SpringLayout.WEST, txtEmployeeName, 30, SpringLayout.EAST, lblEmployeeName);

        layout.putConstraint(SpringLayout.NORTH, lblBirthday, 10, SpringLayout.SOUTH, lblEmployeeName);
        layout.putConstraint(SpringLayout.WEST, lblBirthday, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtBirthday, 6, SpringLayout.SOUTH, txtEmployeeName);
        layout.putConstraint(SpringLayout.WEST, txtBirthday, 30, SpringLayout.EAST, lblBirthday);

        layout.putConstraint(SpringLayout.NORTH, lblPosition, 10, SpringLayout.SOUTH, lblEmployeeName);
        layout.putConstraint(SpringLayout.WEST, lblPosition, 20, SpringLayout.EAST, txtBirthday);
        layout.putConstraint(SpringLayout.NORTH, txtPosition, 6, SpringLayout.SOUTH, txtEmployeeName);
        layout.putConstraint(SpringLayout.EAST, txtPosition, -10, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblSSSNo, 10, SpringLayout.SOUTH, lblBirthday);
        layout.putConstraint(SpringLayout.WEST, lblSSSNo, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtSSSNo, 6, SpringLayout.SOUTH, lblPosition);
        layout.putConstraint(SpringLayout.WEST, txtSSSNo, 35, SpringLayout.EAST, lblSSSNo);

        layout.putConstraint(SpringLayout.NORTH, lblPhilHealthNo, 10, SpringLayout.SOUTH, lblPosition);
        layout.putConstraint(SpringLayout.WEST, lblPhilHealthNo, 20, SpringLayout.EAST, txtSSSNo);
        layout.putConstraint(SpringLayout.NORTH, txtPhilHealthNo, 6, SpringLayout.SOUTH, txtPosition);
        layout.putConstraint(SpringLayout.EAST, txtPhilHealthNo, -10, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblPagibigNo, 10, SpringLayout.SOUTH, lblSSSNo);
        layout.putConstraint(SpringLayout.WEST, lblPagibigNo, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtPagibigNo, 6, SpringLayout.SOUTH, lblPhilHealthNo);
        layout.putConstraint(SpringLayout.WEST, txtPagibigNo, 16, SpringLayout.EAST, lblPagibigNo);

        layout.putConstraint(SpringLayout.NORTH, lblTIN, 10, SpringLayout.SOUTH, lblPhilHealthNo);
        layout.putConstraint(SpringLayout.WEST, lblTIN, 20, SpringLayout.EAST, txtPagibigNo);
        layout.putConstraint(SpringLayout.NORTH, txtTIN, 6, SpringLayout.SOUTH, txtPhilHealthNo);
        layout.putConstraint(SpringLayout.EAST, txtTIN, -10, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblBasicSalary, 10, SpringLayout.SOUTH, lblPagibigNo);
        layout.putConstraint(SpringLayout.WEST, lblBasicSalary, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtBasicSalary, 6, SpringLayout.SOUTH, txtPagibigNo);
        layout.putConstraint(SpringLayout.WEST, txtBasicSalary, 10, SpringLayout.EAST, lblBasicSalary);

        layout.putConstraint(SpringLayout.NORTH, lblHourlyRate, 10, SpringLayout.SOUTH, lblTIN);
        layout.putConstraint(SpringLayout.WEST, lblHourlyRate, 20, SpringLayout.EAST, txtBasicSalary);
        layout.putConstraint(SpringLayout.NORTH, txtHourlyRate, 6, SpringLayout.SOUTH, txtTIN);
        layout.putConstraint(SpringLayout.EAST, txtHourlyRate, -10, SpringLayout.EAST, panel);
        
        // Calculate Salary Section
        layout.putConstraint(SpringLayout.NORTH, lblHeader2, 40, SpringLayout.SOUTH, lblBasicSalary);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblHeader2, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        
        layout.putConstraint(SpringLayout.NORTH, lblYear, 20, SpringLayout.SOUTH, lblHeader2);
        layout.putConstraint(SpringLayout.WEST, lblYear, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, txtYear, 10, SpringLayout.SOUTH, lblYear);
        layout.putConstraint(SpringLayout.WEST, txtYear, 10, SpringLayout.WEST, panel);

        layout.putConstraint(SpringLayout.NORTH, lblMonth, 20, SpringLayout.SOUTH, lblHeader2);
        layout.putConstraint(SpringLayout.WEST, lblMonth, 30, SpringLayout.EAST, lblYear);
        layout.putConstraint(SpringLayout.NORTH, cbMonth, 10, SpringLayout.SOUTH, lblMonth);
        layout.putConstraint(SpringLayout.WEST, cbMonth, 30, SpringLayout.EAST, txtYear);
        
        // Set button position
        layout.putConstraint(SpringLayout.NORTH, computeButton, 20, SpringLayout.SOUTH, lblHeader2);
        layout.putConstraint(SpringLayout.WEST, computeButton, 20, SpringLayout.EAST, cbMonth);


        //Add panel to frame
        mainPanel.add(panel);
        
        lblHeader3 = new JLabel("MotorPH Salary Computation");
        lblHeader3.setFont(new Font("Calibri", Font.BOLD, 20));
        
        lblYear2 = new JLabel("Year:");
        txtYear2 = new JTextField(10);
        txtYear2.setEnabled(false);
        
        lblMonth2 = new JLabel("Month:");
        txtMonth = new JTextField(10);
        txtMonth.setEnabled(false);
        
        lblGrossWage = new JLabel("Gross Wage:");
        txtGrossWage = new JTextField(20);
        txtGrossWage.setEnabled(false);

        lblDeductions = new JLabel("Deductions:");
        txtDeductions = new JTextField(20);
        txtDeductions.setEnabled(false);

        lblSSS = new JLabel("SSS Contribution:");
        txtSSS = new JTextField(20);
        txtSSS.setEnabled(false);

        lblPagibig = new JLabel("Pagibig Contribution:");
        txtPagibig = new JTextField(20);
        txtPagibig.setEnabled(false);

        lblPhilHealth = new JLabel("PhilHealth Contribution:");
        txtPhilHealth = new JTextField(20);
        txtPhilHealth.setEnabled(false);

        lblWitholdingTax = new JLabel("Witholding Tax:");
        txtWitholdingTax = new JTextField(20);
        txtWitholdingTax.setEnabled(false);

        lblNetWage = new JLabel("Net Wage:");
        txtNetWage = new JTextField(20);
        txtNetWage.setEnabled(false);
        
        // Define the panel to hold the components  
        JPanel panel2 = new JPanel();
        SpringLayout layout2 = new SpringLayout();
        panel2.setLayout(layout2);
       
        // Add the components to the frame
        panel2.add(lblHeader3);
        panel2.add(lblYear2);
        panel2.add(txtYear2);
        panel2.add(lblMonth2);
        panel2.add(txtMonth);        
        panel2.add(lblGrossWage);
        panel2.add(txtGrossWage);
        panel2.add(lblDeductions);
        panel2.add(txtDeductions);
        panel2.add(lblSSS);
        panel2.add(txtSSS);
        panel2.add(lblPagibig);
        panel2.add(txtPagibig);
        panel2.add(lblPhilHealth);
        panel2.add(txtPhilHealth);
        panel2.add(lblWitholdingTax);
        panel2.add(txtWitholdingTax);
        panel2.add(lblNetWage);
        panel2.add(txtNetWage);
        
        // Put constraint on components       
        // Employee Details Section
        // Set label and textfield position: top and bottom
        layout2.putConstraint(SpringLayout.NORTH, lblHeader3, 20, SpringLayout.NORTH, panel2);
        layout2.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblHeader3, 0, SpringLayout.HORIZONTAL_CENTER, panel2);

        layout2.putConstraint(SpringLayout.NORTH, lblYear2, 20, SpringLayout.SOUTH, lblHeader3);
        layout2.putConstraint(SpringLayout.WEST, lblYear2, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, txtYear2, 16, SpringLayout.SOUTH, lblHeader3);
        layout2.putConstraint(SpringLayout.WEST, txtYear2, 10, SpringLayout.EAST, lblYear2);

        layout2.putConstraint(SpringLayout.NORTH, lblMonth2, 20, SpringLayout.SOUTH, lblHeader3);
        layout2.putConstraint(SpringLayout.WEST, lblMonth2, 20, SpringLayout.EAST, txtYear2);
        layout2.putConstraint(SpringLayout.NORTH, txtMonth, 16, SpringLayout.SOUTH, lblHeader3);
        layout2.putConstraint(SpringLayout.WEST, txtMonth, 10, SpringLayout.EAST, lblMonth2);

        layout2.putConstraint(SpringLayout.NORTH, lblGrossWage, 20, SpringLayout.SOUTH, lblYear2);
        layout2.putConstraint(SpringLayout.WEST, lblGrossWage, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, txtGrossWage, 16, SpringLayout.SOUTH, txtYear2);
        layout2.putConstraint(SpringLayout.EAST, txtGrossWage, -10, SpringLayout.EAST, panel2);

        layout2.putConstraint(SpringLayout.NORTH, lblDeductions, 10, SpringLayout.SOUTH, lblGrossWage);
        layout2.putConstraint(SpringLayout.WEST, lblDeductions, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, txtDeductions, 6, SpringLayout.SOUTH, txtGrossWage);
        layout2.putConstraint(SpringLayout.EAST, txtDeductions, -10, SpringLayout.EAST, panel2);

        layout2.putConstraint(SpringLayout.NORTH, lblSSS, 10, SpringLayout.SOUTH, lblDeductions);
        layout2.putConstraint(SpringLayout.WEST, lblSSS, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, txtSSS, 6, SpringLayout.SOUTH, txtDeductions);
        layout2.putConstraint(SpringLayout.EAST, txtSSS, -10, SpringLayout.EAST, panel2);

        layout2.putConstraint(SpringLayout.NORTH, lblPagibig, 10, SpringLayout.SOUTH, lblSSS);
        layout2.putConstraint(SpringLayout.WEST, lblPagibig, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, txtPagibig, 6, SpringLayout.SOUTH, txtSSS);
        layout2.putConstraint(SpringLayout.EAST, txtPagibig, -10, SpringLayout.EAST, panel2);

        layout2.putConstraint(SpringLayout.NORTH, lblPhilHealth, 10, SpringLayout.SOUTH, lblPagibig);
        layout2.putConstraint(SpringLayout.WEST, lblPhilHealth, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, txtPhilHealth, 6, SpringLayout.SOUTH, txtPagibig);
        layout2.putConstraint(SpringLayout.EAST, txtPhilHealth, -10, SpringLayout.EAST, panel2);

        layout2.putConstraint(SpringLayout.NORTH, lblWitholdingTax, 10, SpringLayout.SOUTH, lblPhilHealth);
        layout2.putConstraint(SpringLayout.WEST, lblWitholdingTax, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, txtWitholdingTax, 6, SpringLayout.SOUTH, txtPhilHealth);
        layout2.putConstraint(SpringLayout.EAST, txtWitholdingTax, -10, SpringLayout.EAST, panel2);

        layout2.putConstraint(SpringLayout.NORTH, lblNetWage, 10, SpringLayout.SOUTH, lblWitholdingTax);
        layout2.putConstraint(SpringLayout.WEST, lblNetWage, 10, SpringLayout.WEST, panel2);
        layout2.putConstraint(SpringLayout.NORTH, txtNetWage, 6, SpringLayout.SOUTH, txtWitholdingTax);
        layout2.putConstraint(SpringLayout.EAST, txtNetWage, -10, SpringLayout.EAST, panel2);

        mainPanel.add(panel2);
        panel2.setVisible(false);
        frame.add(mainPanel);
        frame.setVisible(true);

        // Add an ActionListener to the button
        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	int year = Integer.parseInt(txtYear.getText());
                	int month = cbMonth.getSelectedIndex();

                    if (year > (Year.now().getValue() - 5) && year <= Year.now().getValue()) {
                    	displayComputation(frame, panel2, employee, year, month);
                    } else {
                        panel2.setVisible(false);
                        frame.setSize(450, 450);
                        frame.setLocationRelativeTo(null);
                    	JOptionPane.showMessageDialog(null, "Invalid Year Input", "ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                	
                } catch (NumberFormatException e1) {
                    panel2.setVisible(false);
                    frame.setSize(450, 450);
                    frame.setLocationRelativeTo(null);
                    Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e1);
                	JOptionPane.showMessageDialog(null, "Invalid Year Input", "ERROR!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
	}
	

	private void displayComputation (JFrame frame, JPanel panel2, Employee employee, int year, int month) {

        List<Attendance> attendances = getMonthlyAttendance(employee, month, year);
        if (!attendances.isEmpty()) {
            frame.setSize(900, 450);
            panel2.setVisible(true);
            frame.setLocationRelativeTo(null);
            
            Salary salary = Salary.calculateSalary(employee, attendances);
            txtYear2.setText(String.valueOf(year));
            txtMonth.setText(MONTHS[month]);
            txtGrossWage.setText(String.valueOf(String.format("%.2f", salary.getGrossWage())));
            txtDeductions.setText(String.valueOf(String.format("%.2f", salary.getSalaryDeduction().getTotalDeductions())));
            txtSSS.setText(String.valueOf(String.format("%.2f", salary.getSalaryDeduction().getSSSContribution())));
            txtPagibig.setText(String.valueOf(String.format("%.2f", salary.getSalaryDeduction().getPagibigContribution())));
            txtPhilHealth.setText(String.valueOf(String.format("%.2f", salary.getSalaryDeduction().getPhilHealthContribution())));
            txtWitholdingTax.setText(String.valueOf(String.format("%.2f", salary.getSalaryDeduction().getWitholdingTax())));
            txtNetWage.setText(String.valueOf(String.format("%.2f", salary.getNetWage())));

        }
        else {
            panel2.setVisible(false);
            frame.setSize(450, 450);
            frame.setLocationRelativeTo(null);
        	JOptionPane.showMessageDialog(null, "No attendance record found for " + MONTHS[month] + " " + year, "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
	}

    // Method used for getting monthly attendance depending on the selected month
    private List<Attendance> getMonthlyAttendance (Employee employee, int month, int year) {
    	resetData();
    	readCSVFiles();
    	
        // Initialize variables need for this method
        String attendanceRow = "";
        List<String> allEmployeeAttendance = new ArrayList<String>();
        List<Attendance> monthlyEmployeeAttendance = new ArrayList<Attendance>();
        
        try {
            // loop through attendance csv
            while ((attendanceRow = attendanceReader.readLine()) != null) {
                String[] splitAttendance = attendanceRow.split(",");
                
                // check if data row is equal to the entered employee number
                // if true, add row to attendances variable
                if (Integer.parseInt(splitAttendance[0]) == employee.getEmployeeNumber()) {
                    allEmployeeAttendance.add(attendanceRow);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(EmployeeDetailsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Get all attendances with same month and year
        for (int i = 0; i < allEmployeeAttendance.size(); i++) {
            String date = allEmployeeAttendance.get(i).split(",")[1];
            String timeIn = allEmployeeAttendance.get(i).split(",")[2];
            String timeOut = allEmployeeAttendance.get(i).split(",")[3];
            
            int dateMonth = Integer.parseInt(date.split("/")[0]);
            int dateDay = Integer.parseInt(date.split("/")[1]);
            int dateYear = Integer.parseInt(date.split("/")[2]);
                    
            if(dateMonth == (month + 1) && dateYear == year) {
                
            	Attendance attendance = new Attendance(year, month + 1, dateDay, timeIn, timeOut);
            	
                monthlyEmployeeAttendance.add(attendance);
            }
        }
        
        return monthlyEmployeeAttendance;
    }


    // Method used for reseting data used in the system
    private void resetData () {
        attendanceReader = null;
    }

    // Method used for reading CSV files
    private void readCSVFiles() {
        try {
            attendanceReader = new BufferedReader(new FileReader(ATTENDANCE_CSV));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

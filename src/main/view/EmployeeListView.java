package main.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import main.MotorPH;
import main.classes.Employee;

public class EmployeeListView {

    // Constant Variables
    private static final String EMPLOYEE_DETAILS_CSV = System.getProperty("user.dir") + "/src/main/resources/employee_details.csv";
    
    // Variables needed for the Search Employee View
    private BufferedReader employeeDetailsReader = null;
    private JLabel lblHeader;
    private JButton viewButton, addButton, updateButton, deleteButton;
    
    JTable table;
    String[] columnNames = {"Employee Number", "Last Name", "First Name", "SSS No.", "PhilHealth No", "TIN", "Pagibig No."};
    
	public EmployeeListView () {
		
		JFrame frame = new JFrame();
        frame.setSize(700, 600);
        frame.setTitle("MotorPH Employee App");
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        // Create the components
        // Create labels and textfields
        lblHeader = new JLabel("MotorPH Employee App");
        lblHeader.setFont(new Font("Calibri", Font.BOLD, 20));

        Object[][] data = getEmployeesList();
    	JTable table = new JTable(data, columnNames);
    	//table.setPreferredSize(new java.awt.Dimension(700,400));
    	
        //getEmployeesList(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new java.awt.Dimension(650,400));

        // Set Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        viewButton = new JButton("View Employee");
        addButton = new JButton("Add Employee");
        updateButton = new JButton("Update Employee");
        deleteButton = new JButton("Delete Employee");
        
        buttonPanel.add(viewButton);
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
       
        // Define the panel to hold the components  
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
       
        // Add the components to the frame
        panel.add(lblHeader);
        panel.add(buttonPanel);
        panel.add(sp);
 
        // Put constraint on components       
        // Set label and textfield position: top and bottom
        layout.putConstraint(SpringLayout.NORTH, lblHeader, 20, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblHeader, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        
        layout.putConstraint(SpringLayout.NORTH, sp, 20, SpringLayout.SOUTH, lblHeader);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, sp, 0, SpringLayout.HORIZONTAL_CENTER, panel);
       
        // Set button position
        layout.putConstraint(SpringLayout.NORTH, buttonPanel, 20, SpringLayout.SOUTH, sp);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonPanel, 0, SpringLayout.HORIZONTAL_CENTER, panel);


        //Add panel to frame
        frame.add(panel);
        frame.setVisible(true);

        // Add an ActionListener to the button
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
                	int selectedTableRow = table.getSelectedRow();
                	int employeeNumber = Integer.parseInt(table.getModel().getValueAt(selectedTableRow, 0).toString());

            		new EmployeeDetailsView(getEmployee(employeeNumber));
            	}
            	catch (NullPointerException e1) {
                    Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e1);
            		JOptionPane.showMessageDialog(null, "Select an employee from the list.", "ERROR!", JOptionPane.ERROR_MESSAGE);
            	}
            	catch (ArrayIndexOutOfBoundsException e2) {
                    Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e2);
            		JOptionPane.showMessageDialog(null, "Select an employee from the list.", "ERROR!", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });

        // Add an ActionListener to the button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	new AddEmployeeView();
        		frame.dispose();
            }
        });

        // Add an ActionListener to the button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	try {
                	int selectedTableRow = table.getSelectedRow();
                	int employeeNumber = Integer.parseInt(table.getModel().getValueAt(selectedTableRow, 0).toString());
                	
                	new UpdateEmployeeView(getEmployee(employeeNumber), selectedTableRow);
            		frame.dispose();
            	}
            	catch (NullPointerException e1) {
                    Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e1);
            		JOptionPane.showMessageDialog(null, "Select an employee from the list.", "ERROR!", JOptionPane.ERROR_MESSAGE);
            	}
            	catch (ArrayIndexOutOfBoundsException e2) {
                    Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e2);
            		JOptionPane.showMessageDialog(null, "Select an employee from the list.", "ERROR!", JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
	}

    // Method used for getting Employee
    private Object[][] getEmployeesList () {    	   	
    	
		resetData();
		readCSVFiles();
		
		List<Employee> list = new ArrayList<Employee>();
        String employeeDetailsRow = "";
    	
        try {
            // read each row of the CSV file
            while ((employeeDetailsRow = employeeDetailsReader.readLine()) != null) {
                // replace commas inside string
                String employeeDetails = employeeDetailsRow.replaceAll(",(?!(([^\"]*\"){2})*[^\"]*$)", ";x;");
                String[] splitEmployeeDetails = employeeDetails.split(",");

                String employeeNumber = cleanString(splitEmployeeDetails[0]);
                String firstName = cleanString(splitEmployeeDetails[2]);
                String lastName = cleanString(splitEmployeeDetails[1]);
                String sss = cleanString(splitEmployeeDetails[6]);
                String philHealth = cleanString(splitEmployeeDetails[7]);
                String tin = cleanString(splitEmployeeDetails[8]);
                String pagibig = cleanString(splitEmployeeDetails[9]);
                
                list.add(new Employee(Integer.parseInt(employeeNumber), firstName, lastName, sss, philHealth, tin, pagibig));
            }
            
            Object[][] data = new Object[list.size()][columnNames.length];
            for (int i = 0; i < list.size(); i++) {
            	data[i][0] = list.get(i).getEmployeeNumber();
            	data[i][1] = list.get(i).getLastName();
            	data[i][2] = list.get(i).getFirstName();
            	data[i][3] = list.get(i).getSSS();
            	data[i][4] = list.get(i).getPhilHealth();
            	data[i][5] = list.get(i).getTIN();
            	data[i][6] = list.get(i).getPagibig();
            }
            
            return data;
        } catch (IOException e) {
        	Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e);
    		resetData();
    		return null;
        } catch (NumberFormatException e1) {
            Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e1);
    		resetData();
    		return null;
        }
    }

    // Method used for getting Employee
    private Employee getEmployee (int employeeNumber) {

		resetData();
		readCSVFiles();
    	Employee employee = null;
        String employeeDetailsRow = "";
    	
        try {
            
            // read each row of the CSV file
            while ((employeeDetailsRow = employeeDetailsReader.readLine()) != null) {
                // replace commas inside string
                String employeeDetails = employeeDetailsRow.replaceAll(",(?!(([^\"]*\"){2})*[^\"]*$)", ";x;");
                String[] splitEmployeeDetails = employeeDetails.split(",");

                // check if employee number matches row data
                if (Integer.parseInt(splitEmployeeDetails[0]) == employeeNumber) {
                    String firstName = cleanString(splitEmployeeDetails[2]);
                    String lastName = cleanString(splitEmployeeDetails[1]);
                    String birthday = cleanString(splitEmployeeDetails[3]);
                    double hourlyRate = Double.parseDouble(cleanString(splitEmployeeDetails[splitEmployeeDetails.length - 1]));
                    double basicSalary = Double.parseDouble(cleanString(splitEmployeeDetails[splitEmployeeDetails.length - 6]));
                    String sss = cleanString(splitEmployeeDetails[6]);
                    String philHealth = cleanString(splitEmployeeDetails[7]);
                    String tin = cleanString(splitEmployeeDetails[8]);
                    String pagibig = cleanString(splitEmployeeDetails[9]);
                    String position = cleanString(splitEmployeeDetails[11]);
                    
                    // Instantiate Employee Object
                   employee = new Employee(employeeNumber, firstName, lastName, sss, philHealth, tin, pagibig, birthday, hourlyRate, basicSalary, position);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e);
        		resetData();
                return null;
        } catch (NumberFormatException e1) {
            Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, e1);
    		resetData();
          	return null;
        }
        return employee;
    }

    // Method used for reseting data used in the system
    private void resetData () {
        employeeDetailsReader = null;
    }

    // Method used for reading CSV files
    private void readCSVFiles() {
        try {
            employeeDetailsReader = new BufferedReader(new FileReader(EMPLOYEE_DETAILS_CSV));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MotorPH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Method used for removing unnecessary characters in a string
    private String cleanString (String input) {
    
        input = input.replaceAll(";x;", "");
        input = input.replaceAll("\"", "");
        
        return input;
    }
}

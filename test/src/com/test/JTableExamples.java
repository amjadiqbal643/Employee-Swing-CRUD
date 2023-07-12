package com.test;



//Packages to import
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableExamples {
	// frame
	JFrame f;
	// Table
	JTable j;

	// Constructor
	JTableExamples(DBUtil dbUtil)
	{
		// Frame initialization
		f = new JFrame();

		// Frame Title
		f.setTitle("JTable Example");

		// Data to be displayed in the JTable
		//1 //2d array data
		//2 //Dataset using table
		//3 //when dont know number of column = table model
		//4 //you want add a jbutton inside table jcomponent using ing table

		String[][] data = dbUtil.showAllEmployee();
		
		
					

		
		
		
		//method declare with two dimensional array
		//learn how to store data in two dimensional array
		//how to read data from two dimensional array
		//String[][] data = dbUtil.getAllData();//return two dimensional array

		// Column Names
		String[] columnNames = { "ID","Name", "Salary", "Address", "Departments" };
		
		
		

		// Initializing the JTable
		j = new JTable(data, columnNames);
		j.setBounds(30, 40, 200, 300);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.add(sp);
		// Frame Size
		f.setSize(500, 200);
		// Frame Visible = true
		f.setVisible(true);
	}

	
	
	
	
	
	
	
	// Driver  method
	public static void main(String[] args)
	{
		//new JTableExamples();
	}
}
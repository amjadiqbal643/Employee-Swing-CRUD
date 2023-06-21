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
	JTableExamples()
	{
		// Frame initialization
		f = new JFrame();

		// Frame Title
		f.setTitle("JTable Example");

		// Data to be displayed in the JTable
		String[][] data = {
				{ "1","Kundan Kumar Jha", "27800", "Hyd" },//row 1
				{ "2","Anand Jha", "32540", "Karachi" }//row 2
		};
		
		//method declare with two dimensional array
		//learn how to store data in two dimensional array
		//how to read data from two dimensional array
		//String[][] data = dbUtil.getAllData();//return two dimensional array

		// Column Names
		String[] columnNames = { "ID","Name", "Salary", "Address" };

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
		new JTableExamples();
	}
}
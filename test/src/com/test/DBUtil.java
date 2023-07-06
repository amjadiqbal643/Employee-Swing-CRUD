package com.test;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class DBUtil {
	
	private Connection con;
	
	public DBUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//JOptionPane.showMessageDialog(null,"Driver is loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","admin");
			//JOptionPane.showMessageDialog(null,"Database Connected");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "DB Driver Class Not Found");
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed to Create Db Connection");
			e.printStackTrace();
		}

	}
	
	
	
	// Add data into database
	public void employeedb_insert(String name, String salaryStr, String address) {
		
		try {
			
			Statement st=con.createStatement();
			//int salary=Integer.parseInt(salaryStr);
			String Query="insert into employee (Name,Salary,Address)"+
			"values('"+name+"',"+salaryStr+",'"+address+"')";
			System.out.println(Query);
			st.executeUpdate(Query);
			
			JOptionPane.showMessageDialog(null, "Employee Added Succesfully...");
		} catch (SQLException e) { 
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	// Update data into database
   public void employeedb_update(String Empid ,String name, String salaryStr, String address ) {
		
		try {
			
			Statement st=con.createStatement();
			int salary=Integer.parseInt(salaryStr);
			
			int id=Integer.parseInt(Empid);
			String Query="update employee set Name='"+name+"', Salary='"+salaryStr+"',Address='"+address+"' where EmpId="+Empid;
			System.out.println(Query);
			st.executeUpdate(Query);
		
			JOptionPane.showMessageDialog(null, "Employee update Succesfully...");
		} catch (SQLException e) { 
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
   // delete record from database
   public void employeedb_Delete(String Empid ) {
		
		try {
			
			Statement st=con.createStatement();
			
			int id=Integer.parseInt(Empid);
			String Query="delete from employee  where EmpId="+Empid;
			
			st.executeUpdate(Query);
		
			JOptionPane.showMessageDialog(null, "Employee Record Deleted Succesfully...");
		} catch (SQLException e) { 
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
// Search data from database
 //  return type method
   public String[] searchEmployee(String Empid) {
	   
	   String values[] = new String[4];
	   
	   try {
		   
			Statement st=con.createStatement();
			String query = "select * from employee where EmpId="+Empid;
			ResultSet rs= st.executeQuery(query);
		

			while(rs.next()) {
				 int    id = rs.getInt("EmpId");
				String name = rs.getString("Name");
				double salary = rs.getDouble("Salary");
				String address = rs.getString("Address");
				
				values[0] = ""+id;
				values[1] = name;
				values[2] = ""+salary;
				values[3] = address;
				
				/*System.out.print(id+" ");
				System.out.print(name+" ");
				System.out.print(salary+" ");
				System.out.print(address+" ");*/
			}
			
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	   return values;
	
   }

public  String[][] showAllEmployee() {
	
	String values[][] = null;
	
	try {
		
		int count = 0;
	Statement st=con.createStatement();
	String countQuery = "select count(*) as rowCount from employee";
	
	ResultSet rset = st.executeQuery(countQuery);
	if(rset.next())
		count = rset.getInt("rowCount");
	
	

	 values = new String[count][4];
	      
			
			
			String query = "select * from employee";
			ResultSet rs= st.executeQuery(query);
			

			
			int row   = 0;
			
			while(rs.next()) {
				int column = 0;
				int    id = rs.getInt("EmpId");
				String name = rs.getString("Name");
				double salary = rs.getDouble("Salary");
				String address = rs.getString("Address");
				
				
				
				
				values[row][column] = ""+id;
				column++;
				values[row][column] = name;
				column++;
				values[row][column] = ""+salary;
				column++;
				values[row][column] = address;
				
				row++;
			}
			
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	
	return values;
	
   }


}
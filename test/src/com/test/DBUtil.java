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
	public void employeedb_insert(String name, String salaryStr, String address, int departments) {
		
		try {
			
			Statement st=con.createStatement();
			//int salary=Integer.parseInt(salaryStr);
			String Query="insert into employee (Name,Salary,Address,Department)"+
			"values('"+name+"',"+salaryStr+",'"+address+"',"+departments+")";
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
   public void employeedb_update(String Empid ,String name, String salaryStr, String address, int departments ) {
		
		try {
			
			Statement st=con.createStatement();
			
			int id=Integer.parseInt(Empid);
			String Query="update employee set Name='"+name+"', Salary='"+salaryStr+"',Address='"+address+"',Department='"+departments+"' where EmpId="+Empid;
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
	   
	   String values[] = new String[5];
	   
	   try {
		   
			Statement st=con.createStatement();
			String query = "select * from employee where EmpId="+Empid;
			ResultSet rs= st.executeQuery(query);
		

			while(rs.next()) {
				 int    id = rs.getInt("EmpId");
				String name = rs.getString("Name");
				double salary = rs.getDouble("Salary");
				String address = rs.getString("Address");
				int depId = rs.getInt("Department");
				
				values[0] = ""+id;
				values[1] = name;
				values[2] = ""+salary;
				values[3] = address;
				values[4] = ""+depId;
				
				
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
	
	

	 values = new String[count][5];
	      
			
			
			String query = "select * from employee";
			ResultSet rs= st.executeQuery(query);
			

			
			int row   = 0;
			
			while(rs.next()) {
				int column = 0;
				int    id = rs.getInt("EmpId");
				String name = rs.getString("Name");
				double salary = rs.getDouble("Salary");
				String address = rs.getString("Address");
				//int departments = 
				
				
				
				values[row][column] = ""+id;
				column++;
				values[row][column] = name;
				column++;
				values[row][column] = ""+salary;
				column++;
				values[row][column] = address;
				column++;
				values[row][column] ="";//departments;
				row++;
			}
			
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
	   
	
	return values;
	
   }


public String[] getDepartments() {
    String[] data = null;
    try {
        Statement statement = con.createStatement();
        String query = "SELECT dep_name FROM departments";
        ResultSet resultSet = statement.executeQuery(query);

        // Get the count of rows in the result set
        int rowCount = 0;
        while(resultSet.next()) {
            rowCount++;
        }
        
        resultSet = statement.executeQuery(query);

        // Create an array to store the data
        data = new String[rowCount];

        // Iterate through the result set and fetch the data
        int index = 0;
        while (resultSet.next()) {
            String value = resultSet.getString("dep_name");
            data[index] = value;
            index++;
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return data;
}



public String[] getDepartmentByName(String departName) {
	String[] data = new String[2];;
    try {
        Statement statement = con.createStatement();
        String query = "SELECT * FROM departments where dep_name = '"+departName+"'";
        ResultSet resultSet = statement.executeQuery(query);


        // Create an array to store the data
        

        // Iterate through the result set and fetch the data
        
        if (resultSet.next()) {
            String dep_name    = resultSet.getString("dep_name");
            String departId = ""+resultSet.getInt("dep_Id");
           
            data[0] = departId;
            data[1] = dep_name;
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return data;
}

public String[] getDepartmentByID(int depId) {
	String[] data = new String[2];;
    try {
        Statement statement = con.createStatement();
        String query = "SELECT * FROM departments where dep_Id = "+depId;
        ResultSet resultSet = statement.executeQuery(query);


        // Create an array to store the data
        

        // Iterate through the result set and fetch the data
        
        
        if (resultSet.next()) {
            String dep_name    = resultSet.getString("dep_name");
            String departId = ""+resultSet.getInt("dep_Id");
           
            data[0] = departId;
            data[1] = dep_name;
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return data;
}



/*
public void getDepartments() {
	
	try {
		
		Statement st=con.createStatement();
		
		String query = "select dep_name from departments";
		ResultSet rs= st.executeQuery(query);
		while (rs.next()) {
			String name= rs.getString("dep_name");
			
		}
	
	} catch (SQLException e) { 
		e.printStackTrace();
	}
}
*/

}
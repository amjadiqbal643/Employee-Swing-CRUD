package com.test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JFrameDemo implements ActionListener {
	
	
	private DBUtil dbUtil = new DBUtil();
	
	
	
	
	JFrame record= new JFrame();
	JTable table=new JTable();
	
	
	JButton Button1=new JButton();
	JButton Button3= new JButton();
	 JButton Button4= new JButton();
	 JButton Button5= new JButton();
	 JButton search= new JButton();
	 JButton clear= new JButton();
	 JButton Button2 = new JButton();
	 JButton Button = new JButton();
	 
	 
	 JTextField search_bar=new JTextField();
	JTextField text=new JTextField();
	 JTextField text2=new JTextField();
	 JTextField text3=new JTextField();
	 JTextField text4=new JTextField();
	public JFrameDemo() {
		
		JLabel label= new JLabel();
		label.setText("Employee ID :  ");
	    label.setFont(new Font("Comic Sans",Font.BOLD,16));
	    label.setBounds(20, 10, 170, 30);
	    
	    
	    text.setFont(new Font("Comic Sans",Font.BOLD,16)); 
		text.setBounds(180, 10, 350, 30);
		
		JLabel label2= new JLabel();
		label2.setText("Employee Name :");
	    label2.setFont(new Font("Comic Sans",Font.BOLD,16));
	    label2.setBounds(20, 110, 170, 30);
	    
	   
	   
	    text2.setFont(new Font("Comic Sans",Font.BOLD,16));
		text2.setBounds(180, 110, 350, 30);
		
		JLabel label3= new JLabel();
		label3.setText("Employee Salary :");
	    label3.setFont(new Font("Comic Sans",Font.BOLD,16));
	    label3.setBounds(20, 210, 170, 30);
	    
	    
	    text3.setFont(new Font("Comic Sans",Font.BOLD,16));
		text3.setBounds(180, 210, 350, 30);
		
		JLabel label4= new JLabel();
		label4.setText("Employee Address :");
	    label4.setFont(new Font("Comic Sans",Font.BOLD,16));
	    label4.setBounds(20, 310, 170, 30);
	    
	   
	    
	    text4.setFont(new Font("Comic Sans",Font.BOLD,16));
		text4.setBounds(180, 280, 350, 100);
		
		search_bar.setFont(new Font("Comic Sans",Font.BOLD,16));
		search_bar.setBounds(30, 600, 300, 40);
		
		 
	       
		       
		
		

		 Button.setSize(50,30);
		 Button.setBounds(10, 400, 150, 50);
		 Button.setText("Previous");
		 Button.setFont(new Font("Comic Sans",Font.BOLD,16));
		 Button.addActionListener(this); 
		
		 Button1.setSize(50,30);
		 Button1.setBounds(180, 400, 150, 50);
		 Button1.setText("All Record");
		 Button1.setFont(new Font("Comic Sans",Font.BOLD,16));
		 Button1.addActionListener(this);
		 
		 
		 
		 Button2.setSize(50,30);
		 Button2.setBounds(360, 400, 150, 50);
		 Button2.setText("Next");
		 Button2.setFont(new Font("Comic Sans",Font.BOLD,16));
		 Button2.addActionListener(this);
		 
		 Button3.setSize(50,30);
		 Button3.setBounds(10, 500, 150, 50);
		 Button3.setText("Add Employee");
		 Button3.setFont(new Font("Comic Sans",Font.BOLD,16));
		 Button3.addActionListener(this); 
		
		 

		 Button4.setSize(50,30);
		 Button4.setBounds(180, 500, 150, 50);
		 Button4.setText("Update");
		 Button4.setFont(new Font("Comic Sans",Font.BOLD,16));
		 Button4.addActionListener(this); 
		
		 
		 Button5.setSize(50,30);
		 Button5.setBounds(360, 500, 150, 50);
		 Button5.setText("Delete");
		 Button5.setFont(new Font("Comic Sans",Font.BOLD,16));
		 Button5.addActionListener(this);  
		 
		 search.setSize(50,30);
		 search.setBounds(340, 600, 100, 30);
		 search.setText("Search ");
		 search.setFont(new Font("Comic Sans",Font.BOLD,16));
		 search.addActionListener(this); 
	    
		 
		 clear.setSize(50,30);
		 clear.setBounds(450, 600, 100, 30);
		 clear.setText("Clear ");
		 clear.setFont(new Font("Comic Sans",Font.BOLD,16));
		 clear.addActionListener(this);
		
		
		JFrame frame= new JFrame();
		frame.setTitle("Employee Record System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,700);
		frame.setLayout(null);
		
		
		frame.add(label);
		frame.add(text);
        
		frame.add(label2);
		frame.add(text2);
        
		frame.add(label3);
		frame.add(text3);
	    
		frame.add(label4);
		frame.add(text4);
		
		frame.add(search_bar);
	
		
		frame.add(Button);
		frame.add(Button1);
		frame.add(Button2);
		frame.add(Button3);
		frame.add(Button4);
		frame.add(Button5);
		frame.add(search);
		frame.add(clear);
		frame.setVisible(true);
		
		
		
		
		
		 
		 
		
		
		record.setTitle(" All Employee Record ");
		record.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		record.setSize(400,400);
		record.setLayout(null);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource().equals(Button1)) {

			record.setVisible(true);
		
		}else if(e.getSource().equals(Button3)) {
			
	
			String name=text2.getText();
			String salary=text3.getText();
			String add=text4.getText();
			dbUtil.employeedb_insert( name, salary, add);
			
		}else if(e.getSource().equals(Button4)) {
			
            String id= text.getText();
			String name=text2.getText(); 
			String salary=text3.getText();
			String add=text4.getText();
			dbUtil.employeedb_update(id , name , salary,add);
		
			
		}else if(e.getSource().equals(Button5)) {
       
			int res=JOptionPane.showConfirmDialog( null,"Do you want to delete record");       
			if(res==JOptionPane.YES_OPTION) {
				String id= text.getText();
				dbUtil.employeedb_Delete(id);
			}
	
		}else if(e.getSource().equals(search)) {
			
			//System.out.println("Search");
			String Empid=search_bar.getText();
			
			String values[] =  dbUtil.searchEmployee(Empid);
			
			if(values[0] == null) {

				JOptionPane.showMessageDialog(null, "No Data found for This Entry");
			}else {
			 text.setText(values[0]);
			 text2.setText(values[1]);
			 text3.setText(values[2]);
			 text4.setText(values[3]);
			}
			
			 
		}else if(e.getSource().equals(Button)) {
			
			System.out.println("Prevoius");
			
			int Empid=Integer.parseInt(text.getText());
			Empid = Empid-1;
			
			String values[] =  dbUtil.searchEmployee(Empid+"");
			
			if(values[0] == null) {

				JOptionPane.showMessageDialog(null, "No Data found for This Entry");
			}else {
			 text.setText(values[0]);
			 text2.setText(values[1]);
			 text3.setText(values[2]);
			 text4.setText(values[3]);
			}
			

			
		}else if(e.getSource().equals(Button2)) {

			
			System.out.println("Next");
			int Empid = Integer.parseInt(text.getText());
			Empid = Empid + 1;
			String values[] =  dbUtil.searchEmployee(Empid+"");
			
			if(values[0] == null) {

				JOptionPane.showMessageDialog(null, "No Data found for This Entry");
			}else{
			 text.setText(values[0]);
			 text2.setText(values[1]);
			 text3.setText(values[2]);
			 text4.setText(values[3]);
			}
		
		}
		
		else if(e.getSource().equals(clear)) {
			
			text.setText(" ");
			text2.setText(" ");
		    text3.setText(" ");
			text4.setText(" ");
			search_bar.setText(" ");
			
			
		}
		
	}

	
	
}

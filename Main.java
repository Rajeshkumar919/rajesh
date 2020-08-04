import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MyFrame implements ActionListener{
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet reslutSet = null;
    JFrame frame = new JFrame("BANK MANAGMENT");
    Container con = frame.getContentPane();
    JLabel lmainhead,lname,lbalance,lmobile,laccountType,ldob,laccountNo,lregistration,lImage,lacNo;
    JTextField tname,tbalance,tmobile,tdelete,tsearch;
    JPasswordField taccountNo;
    JRadioButton r1,r2;
    ButtonGroup accountType = new ButtonGroup();
    JComboBox day,month,year;
    JCheckBox term;
    JButton submit,reset,login,delete,search;
    JTextArea display;
    MyFrame(){
        frame.setBounds(150,90,1000,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        con.setLayout(null);
       // con.setBackground(Color.GREEN);
	     
		
	   

        Font f =new Font("Time New Roman",Font.BOLD,30);
        lmainhead= new JLabel("BANK MANAGMENT");
        lmainhead.setBounds(395,5,400,35);
        lmainhead.setFont(f);
        con.add(lmainhead);
		
        lname= new JLabel("Name");
        lname.setBounds(50,50,60,30);
        con.add(lname);

        lbalance= new JLabel("Balance");
        lbalance.setBounds(50,250,60,30);
        con.add(lbalance);

        lmobile = new JLabel("Mobile No");
        lmobile.setBounds(50,200,60,30);
        con.add(lmobile);

        laccountType = new JLabel("Account Type");
        laccountType.setBounds(50,100,60,30);
        con.add(laccountType);

        ldob = new JLabel("DOB");
        ldob.setBounds(50,150,60,30);
        con.add(ldob);

        laccountNo = new JLabel("CNIC");
        laccountNo.setBounds(50,300,60,30);
        con.add(laccountNo);

        tname = new JTextField();
        tname.setBounds(130,53,180,20);
        con.add(tname);

        r1 = new JRadioButton("Current");
        r1.setBounds(130,103,80,30);
        r1.setBackground(Color.WHITE);
        con.add(r1);

        r2 = new JRadioButton("Saving");
        r2.setBounds(230,103,80,30);
        r2.setBackground(Color.WHITE);
        con.add(r2);

        accountType.add(r1);
        accountType.add(r2);

        tbalance = new JTextField();
        tbalance.setBounds(130,253,180,20);
        con.add(tbalance);

        tmobile = new JTextField();
        tmobile.setBounds(130,203,180,20);
        con.add(tmobile);

        taccountNo = new JPasswordField();
        taccountNo.setBounds(130,303,180,20);
        con.add(taccountNo);

        String[] daylist = new String[31];
        for(int i=1; i<=31; i++)
        {
            daylist[i-1] = Integer.toString(i);
        }
        day= new JComboBox(daylist);
        day.setBounds(130,153,40,25);
        day.setEditable(true);
        con.add(day);

        String[] monthlist ={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        month = new JComboBox(monthlist);
        month.setBounds(185,153,50,25);
        month.setEditable(true);
        con.add(month);

        String[] yearlist = new String[100];
        for(int i=1951; i<=2050; i++)
        {
            yearlist[i-1951]=Integer.toString(i);


        }
        year = new JComboBox(yearlist);
        year.setBounds(250,153,60,25);
        year.setEditable(true);
        con.add(year);

        term = new JCheckBox("I accept terms and conditions");
        term.setBounds(70,340,250,25);
        term.setBackground(Color.WHITE);
        con.add(term);

        submit = new JButton("SUBMIT");
        submit.setBounds(100,380,80,25);
        con.add(submit);

        reset = new JButton("Reset");
        reset.setBounds(200,380,80,25);
        con.add(reset);

		lregistration = new JLabel("Registration");
        lregistration.setBounds(90,420,200,50);
        lregistration.setFont(f);
        con.add(lregistration);

        Color cc = new Color(170,170,170);
        Font ff = new Font("Times New Roman",Font.BOLD,15);
        display = new JTextArea();
        display.setBounds(660,50,300,450);
        con.add(display);
        display.setFont(ff);
        display.setBackground(cc);
        display.setForeground(Color.WHITE);
        display.setEditable(false);
			
		 lacNo = new JLabel();
        lacNo.setBounds(370,80,200,30);
        con.add(lacNo);	
			
			
       /* login = new JButton("Log In");
        login.setBounds(370,130,200,30);
        con.add(login);
	*/

        search = new JButton("SEARCH");
        search.setBounds(390,240,140,30);
        con.add(search);
		
		  tsearch = new JTextField(20);
          tsearch.setBounds(390,300,140,30);
          con.add(tsearch);
		


         delete= new JButton("DELETE");
        delete.setBounds(390,400,140,30);
        con.add(delete);
		
		   tdelete= new JTextField(20);
          tdelete.setBounds(390,460,140,30);
          con.add(tdelete);
		

		
		 ImageIcon imag = new ImageIcon("pic.jpg");
		 lImage = new JLabel(imag);	
		lImage.setBounds(0,0,imag.getIconWidth(),imag.getIconHeight());
		con.add(lImage);
		
		

        submit.addActionListener(this);
        reset.addActionListener(this);
     //   login.addActionListener(this);
		search.addActionListener(this);
        delete.addActionListener(this);
		
		

    }
    public void actionPerformed(ActionEvent e)
    {   	
        String ch = e.getActionCommand();
        if(ch=="SUBMIT")
        {
			JOptionPane.showMessageDialog(null,"Your Account No is your CNIC NO: ");
            if (term.isSelected()) {
                String name = tname.getText();
                String balance = tbalance.getText();
                String mobile = tmobile.getText();
                String accountNo = taccountNo.getText();
                String accountType = "Current";
                if (r2.isSelected()) {
                    accountType = "Saving";
                }
                String date = (String) day.getSelectedItem();
                String mon = (String) month.getSelectedItem();
                String yr = (String) year.getSelectedItem();
                 Connection connection=null;
		          Statement statement=null;
		          ResultSet resultSet=null;
	             
		
		   try
		   {
		   
			 
	        
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledb", "root","");
			
			 //String createTable="Create table data"+
			//"(Name VARCHAR(32),balance VARCHAR(32),mobile VARCHAR(32),accountNum VARCHAR(32),accounttype  VARCHAR(32),date VARCHAR(32),month VARCHAR(32),year VARCHAR(32))";
			//statement.executeUpdate(createTable);
			String sql="Insert into personal(name,accountNo,mobile,balance,accountType,date,month,year) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstatement=connection.prepareStatement(sql);
			pstatement.setString(1,name);
			pstatement.setString(2,accountNo);
			pstatement.setString(3,mobile);
			pstatement.setString(4,balance);
			pstatement.setString(5,accountType);
			pstatement.setString(6,date);
			pstatement.setString(7,mon);
			pstatement.setString(8,yr);
			pstatement.executeUpdate();
			
		    //resultSet=statement.executeQuery();
			display.setText("Registration Successful");
			display.setText("\n\nName: "+name+"\nBalance: "+balance+"\nMobile: "+mobile+"\nDate of Birth: "+date+" "+mon+" "+yr+"\nAccount No: "+accountNo+"\n"+"\nAccount Type: "+accountType+"\n");
			
			System.out.println("Record updated");
			
			
			
		}
		catch(SQLException sql)
		{
		   sql.printStackTrace();
		}	
		catch(ClassNotFoundException ce)
		{
		ce.printStackTrace();
		}
		finally
		{
			try{
				resultSet.close();
				statement.close();
				connection.close();
			
				}
				catch(Exception exc)
				{
				exc.printStackTrace();
				
				}
			}
			
			
			
			}
	
	
						
			

			   
            else {
                display.setText("Please Agree Our Terms and Conditions");
            }
	
        
}
        
        else if(ch=="SEARCH"){
          System.out.println("ok");   
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		try
		{
	       
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledb", "root","");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from personal");

		while(rs.next())
		{
		if(rs.getString(2).equals(tsearch.getText()))
		{
		display.setText("\n\nName: "+rs.getString(2)+"\nAccount Number: "+rs.getString(3)+"\nMobile: "+rs.getString(4)+"\nBalance: "+rs.getString(5)+"\nAccount Type: "+rs.getString(6)+"\nDate of Birth: "+rs.getString(7)+"  "+rs.getString(8)+" "+rs.getString(9));
		}

		}
		rs.close();
		st.close();
		con.close();
		}
		catch(SQLException sql)
		{
		   sql.printStackTrace();
		}	
		catch(ClassNotFoundException ce)
		{
		ce.printStackTrace();
		}
		finally
		{
			try{
				resultSet.close();
				statement.close();
				connection.close();
			
				}
				catch(Exception en)
				{
				en.printStackTrace();
				
				}
			}

   
		}
        else if(ch=="DELETE"){
		     System.out.println("ok"); 
		System.out.println("DELETE");
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
	
		
		    try
		    {
			  
	               
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledb", "root","");
			statement=connection.createStatement();
			String s=tdelete.getText();
			String sql="delete from personal where name= ?";
			PreparedStatement pstatement=connection.prepareStatement(sql);
			pstatement.setString(1,s);
			pstatement.executeUpdate();
			
			display.setText("Deleted Successfully");   
			System.out.println("Data delected");
			// display.setText("\n\nName: "+name+"\nBalance: "+balance+"\nMobile: "+mobile+"\nDate of Birth: "+date+" "+mon+" "+yr+"\nAccount Type: "+accType+"\n"+"\nAccount No: "+accNum+"\n");
			
			
			}
		
		catch(SQLException sql)
		{
		   sql.printStackTrace();
		}	
		catch(ClassNotFoundException ce)
		{
		ce.printStackTrace();
		}
		finally
		{
			try{
				resultSet.close();
				statement.close();
				connection.close();
			
				}
				catch(Exception en)
				{
				en.printStackTrace();
				
				}
			}
		
		
		}
        else
        {
            tname.setText(null);
            tbalance.setText(null);
            tmobile.setText(null);
            taccountNo.setText(null);
            display.setText(null);

            accountType.clearSelection();
            term.setSelected(false);
            day.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        }

    }

}
public class Main {

    public static void main(String[] args)
    {
        MyFrame myframe = new MyFrame();
		


    }
}

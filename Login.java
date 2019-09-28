package com;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.applet.Applet;
/*<applet code="Login" width=450 height=350> </applet>*/

public class Login extends Applet implements ActionListener
{
	Panel p,p1,p2,p3;
	Label l,l1,l2;
	TextField tf1,tf2;
	Button b1,b2;
	Font f1,f2;
	public void init()
	{
		setLayout(new GridLayout(4,1));
		p=new Panel();
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		
		f1=new Font("Verdana",Font.BOLD,24);
		f2=new Font("Arial",Font.BOLD,18);
		
		l=new Label("Login");
		l.setFont(f1);
		
		l1=new Label("UserID");
		l1.setFont(f2);
		
		l2=new Label("Password");
		l2.setFont(f2);
		
		tf1=new TextField(12);
		tf2=new TextField(12);
		tf2.setEchoChar('*');
		tf1.setFont(f2);
		tf2.setFont(f2);
		
		b1=new Button("Submit");
		b2=new Button("Reset");
		b1.setFont(f2);
		b2.setFont(f2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		p.add(l1);
		p.add(tf1);
		
		p2.add(l2);
		p2.add(tf2);
		
		p3.add(b1);
		p3.add(b2);
		
		add(p);
		add(p1);
		add(p2);
		add(p3);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String userid=tf1.getText();
		String pass=tf2.getText();
		if(ae.getSource()==b1)
		{
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","Oracle");
				PreparedStatement ps=cn.prepareStatement("insert into Login values (?,?)");
				ps.setString(1,userid);
				ps.setString(2,pass);
				ps.executeUpdate();
				ps.close();
				cn.close();
		}catch(Exception e)
			{
			e.printStackTrace();
			}
		}else {
			tf1.setText("");
			tf2.setText("");
		}
		
	}
}
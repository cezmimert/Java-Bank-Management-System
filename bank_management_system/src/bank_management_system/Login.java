package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JButton login,clear,signup;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login(){
		
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dino.png"));
		Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		JLabel cardno=new JLabel("Card No.");
		cardno.setFont(new Font("Raleway", Font.BOLD,28));
		cardno.setBounds(120,150,400,40);
		add(cardno);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300,150,250,30);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin=new JLabel("PIN");
		pin.setFont(new Font("Raleway", Font.BOLD,28));
		pin.setBounds(120,200,400,40);
		add(pin );
		
		pinTextField=new JPasswordField();
		pinTextField.setBounds(300,200,250,30);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		login =new JButton("SIGN IN");
		login.setBounds(300,250,100,30);
		login.setBackground(Color.darkGray);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear =new JButton("CLEAR");
		clear.setBounds(450,250,100,30);
		clear.setBackground(Color.darkGray);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		signup =new JButton("SIGN UP");
		signup.setBounds(300,300,250,30);
		signup.setBackground(Color.darkGray);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.pink);
		
		
		setSize(800,480);
		setLocation(350,200);
		setVisible(true);
		
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(ae.getSource()==login) {
				Conn conn=new Conn();
				String cardnumber=cardTextField.getText();
				String pinnumber=pinTextField.getText();
				String query="select * from login where cardnumber ='"+cardnumber+"' and pin = '"+pinnumber+"'";
				try {
					ResultSet tl=conn.s.executeQuery(query);
					if(tl.next()) {
						setVisible(false);
						new Transactions(pinnumber).setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
					}
					
				}catch(Exception e) {
					System.out.println(e);
				}
		}
		else if(ae.getSource()==signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
		
		
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> new Login());
		new JFrame();
		
	}

}

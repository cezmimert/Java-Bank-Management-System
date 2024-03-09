package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*; 
import java.util.*;
import java.security.SecureRandom;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;




public class SignupOne extends JFrame implements ActionListener{

	SecureRandom random;
	JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
	JButton next;
	JRadioButton male,female,other,married,unmarried;
	JDateChooser dateChooser;
	
	SignupOne(){
		
		setLayout(null);
		
		random=new SecureRandom();
		
		
		JLabel formno = new JLabel("APPLICATION FORM NO. "+random.nextInt(100000));
		formno.setFont(new Font("Raleway",Font.BOLD,38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		
		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway",Font.BOLD,20));
		personDetails.setBounds(290,80,300,30);
		add(personDetails);

		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		nameTextField =new JTextField();
		nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		
		JLabel fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		fnameTextField =new JTextField();
		fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway",Font.BOLD,20));
		dob.setBounds(100,240,200,30);
		add(dob);
		
		dateChooser= new JDateChooser();
		dateChooser.setBounds(300, 240, 300, 30);
		dateChooser.setForeground(new Color(105,105,105));	
		add(dateChooser);
		

		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290,60, 30);
		male.setBackground(Color.pink);
		add(male);

		female 	= new JRadioButton("Female");
		female.setBounds(450, 290,90, 30);
		female.setBackground(Color.pink);
		add(female);
		
		other 	= new JRadioButton("Other");
		other.setBounds(600, 290,90, 30);
		other.setBackground(Color.pink);
		add(other);
		

		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female); 
		gendergroup.add(other); 
		
		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		emailTextField =new JTextField();
		emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);

		JLabel marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		married= new JRadioButton("Married");
		married.setBounds(300, 390,90, 30);
		married.setBackground(Color.pink);
		add(married);

		unmarried 	= new JRadioButton("Unmarried");
		unmarried.setBounds(450, 390,90, 30);
		unmarried.setBackground(Color.pink);
		add(unmarried);
		

		

		ButtonGroup maritalgroup=new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway",Font.BOLD,20));
		address.setBounds(100,440,200,30);
		add(address);
		
		addressTextField =new JTextField();
		addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway",Font.BOLD,20));
		city.setBounds(100,490,200,30);
		add(city);
		
		cityTextField =new JTextField();
		cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway",Font.BOLD,20));
		state.setBounds(100,540,200,30);
		add(state);
		
		stateTextField =new JTextField();
		stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		JLabel pincode = new JLabel("Pin Code:");
		pincode.setFont(new Font("Raleway",Font.BOLD,20));
		pincode.setBounds(100,590,200,30);
		add(pincode);
		
		pincodeTextField =new JTextField();
		pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
		pincodeTextField.setBounds(300,590,400,30);
		add(pincodeTextField);
		
		next =new JButton("Next");
		next.setBackground(Color.DARK_GRAY);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.setBounds(620, 660,80, 30);
		next.addActionListener(this);
		add(next);
		
		
		getContentPane().setBackground(Color.pink);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String formno= ""+random.nextInt(100000);
		String name=nameTextField.getText();
		String fname=fnameTextField.getText();
		String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}
		else if(female.isSelected()) {
			gender="Female";
		}
		String email=emailTextField.getText();
		String marital=null;
		if(married.isSelected()) {
			marital="Married";
		}
		else if(unmarried.isSelected()) {
			marital="Unmarried";
		}
		else if(other.isSelected()) {
			marital="Other";
		}
		
		String address=addressTextField.getText();
		String city=cityTextField.getText();
		String state=stateTextField.getText();
		String pin=pincodeTextField.getText();
		
		try{
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is required");
			}
			else {
				Conn c=new Conn();
				String query = "INSERT INTO signup VALUES ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		
		new SignupOne();

	}

}

package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*; 

import java.awt.event.*;




public class SignupTwo extends JFrame implements ActionListener{

	
	JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
	JButton next;
	JRadioButton sno,syes,eyes,eno;
	JComboBox occupation, education,income; 
	String formno;
	
	
	SignupTwo(String formno){
		this.formno=formno;
		
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM PAGE-2");
		
		

		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
		additionalDetails.setBounds(290,80,300,30);
		add(additionalDetails);

		JLabel name = new JLabel("Income:");
		name.setFont(new Font("Raleway",Font.BOLD,20));
		name.setBounds(100,140,100,30);
		add(name);
		
		String incomecategory[]= {"Null","<15.000","<25.000","<50.000","<100.000","Up to 100.000"};
		income=new JComboBox(incomecategory);
		income.setBounds(300,140,400,30);
		income.setBackground(Color.white);
		add(income);
			
		JLabel fname = new JLabel("Education:");
		fname.setFont(new Font("Raleway",Font.BOLD,20));
		fname.setBounds(100,190,200,30);
		add(fname);
		
		String educationcategory[]= {"Null","Non-Graduation","Graduation","Post-Graduation","Docrate","Others"};
		education=new JComboBox(educationcategory);
		education.setBounds(300,190,400,30);
		education.setBackground(Color.white);
		add(education);
		

		JLabel gender = new JLabel("Occupation:");
		gender.setFont(new Font("Raleway",Font.BOLD,20));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		String occupationcategory[]= {"Null","Salaried","Self-Employed","Bussiness","Student","Others"};
		occupation=new JComboBox(occupationcategory);
		occupation.setBounds(300,290,400,30);
		occupation.setBackground(Color.white);
		add(occupation);
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JLabel email = new JLabel("Senior Citizen:");
		email.setFont(new Font("Raleway",Font.BOLD,20));
		email.setBounds(100,340,200,30);
		add(email);
		
		syes= new JRadioButton("Yes");
		syes.setBounds(300, 340,90, 30);
		syes.setBackground(Color.pink);
		add(syes);

		sno 	= new JRadioButton("No");
		sno.setBounds(450, 340,90, 30);
		sno.setBackground(Color.pink);
		add(sno);
		
		ButtonGroup maritalgroup=new ButtonGroup();
		maritalgroup.add(syes);
		maritalgroup.add(sno);
		

		JLabel marital = new JLabel("Existing Account:");
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,390,200,30);
		add(marital);
		
		eyes= new JRadioButton("Yes");
		eyes.setBounds(300, 390,90, 30);
		eyes.setBackground(Color.pink);
		add(eyes);

		eno = new JRadioButton("No");
		eno.setBounds(450, 390,90, 30);
		eno.setBackground(Color.pink);
		add(eno);
		
		ButtonGroup emaritalgroup=new ButtonGroup();
		emaritalgroup.add(eyes);
		emaritalgroup.add(eno);
				
	
		next =new JButton("Next");
		next.setBackground(Color.DARK_GRAY);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.setBounds(620, 440,80, 30);
		next.addActionListener(this);
		add(next);
		
		
		getContentPane().setBackground(Color.pink);
		
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		String sincome=(String)income.getSelectedItem();
		String seducation=(String)education.getSelectedItem();
		String soccupation=(String)occupation.getSelectedItem();
		String seniorcitizen=null;

		if(syes.isSelected()) {
			seniorcitizen="Yes";
		}
		else if(sno.isSelected()) {
			seniorcitizen="No";
		}
		
		String existingaccount=null;
		if(eyes.isSelected()) {
			existingaccount="Yes";
		}
		else if(eno.isSelected()) {
			existingaccount="Yes";
		}


		try{		
			Conn c=new Conn();
			String query = "INSERT INTO signuptwo VALUES ('" + formno + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + seniorcitizen + "','" + existingaccount+ "')";
			c.s.executeUpdate(query);	
			
			setVisible(false);
			new SignupThree(formno).setVisible(true);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		
		new SignupTwo("");

	}



}

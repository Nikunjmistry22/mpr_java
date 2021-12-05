package hotel.management.system;

import java.awt.EventQueue;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEmployee extends JFrame { // Third Frame

	JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
	JComboBox c1;

	public AddEmployee() {
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Add Employee Details");

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(778, 486);
		getContentPane().setLayout(null);

		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Name.setBounds(60, 30, 150, 27);
		add(Name);

		textField = new JTextField();
		textField.setBounds(200, 30, 150, 27);
		add(textField);

		JButton Save = new JButton("Save");
		Save.setBounds(200, 420, 150, 30);
		Save.setBackground(Color.BLACK);
		Save.setForeground(Color.WHITE);
		add(Save);

		JLabel Age = new JLabel("Age");
		Age.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Age.setBounds(60, 80, 150, 27);
		add(Age);

		textField_1 = new JTextField();
		textField_1.setBounds(200, 80, 150, 27);
		add(textField_1);

		JLabel Gender = new JLabel("Gender");
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Gender.setBounds(60, 120, 150, 27);
		add(Gender);

		JRadioButton Male = new JRadioButton("Male");
		Male.setBackground(Color.WHITE);
		Male.setBounds(200, 120, 70, 27);
		add(Male);

		JRadioButton Female = new JRadioButton("Female");
		Female.setBackground(Color.WHITE);
		Female.setBounds(280, 120, 70, 27);
		add(Female);

		ButtonGroup bg = new ButtonGroup();
		bg.add(Male);
		bg.add(Female);

		JLabel Job = new JLabel("Job");
		Job.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Job.setBounds(60, 170, 150, 27);
		add(Job);

		String course[] = { "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service",
				"Waiter/Waitress", "Manager", "Accountant", "Chef" };
		c1 = new JComboBox(course);
		c1.setBackground(Color.WHITE);
		c1.setBounds(200, 170, 150, 30);
		add(c1);

		JLabel Salary = new JLabel("Salary");
		Salary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Salary.setBounds(60, 220, 150, 27);
		add(Salary);

		textField_3 = new JTextField();
		textField_3.setBounds(200, 220, 150, 27);
		add(textField_3);

		JLabel Phone = new JLabel("Phone");
		Phone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Phone.setBounds(60, 270, 150, 27);
		add(Phone);

		textField_4 = new JTextField();
		textField_4.setBounds(200, 270, 150, 27);
		add(textField_4);

		JLabel Aadhar = new JLabel("Aadhar");
		Aadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Aadhar.setBounds(60, 320, 150, 27);
		add(Aadhar);

		textField_5 = new JTextField();
		textField_5.setBounds(200, 320, 150, 27);
		add(textField_5);

		JLabel email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		email.setBounds(60, 370, 150, 27);
		add(email);

		textField_6 = new JTextField();
		textField_6.setBounds(200, 370, 150, 27);
		add(textField_6);

		setVisible(true);

		/*JLabel AddEmployeeDetails = new JLabel("Add Employee Details");
		AddEmployeeDetails.setForeground(Color.BLUE);
		AddEmployeeDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
		AddEmployeeDetails.setBounds(450, 24, 442, 35);
		add(AddEmployeeDetails);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
		Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel image = new JLabel(i2);
		image.setBounds(410, 80, 480, 410);
		add(image);*/

		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String name = textField.getText();
				String age = textField_1.getText();
				String salary = textField_3.getText();
				String phone = textField_4.getText();
				String aadhar = textField_5.getText();
				String email = textField_6.getText();

				String gender = null;

				if (Male.isSelected()) {
					gender = "male";

				} else if (Female.isSelected()) {
					gender = "female";
				}

				String s6 = (String) c1.getSelectedItem();

				try {
					conn c = new conn();
					String str = "INSERT INTO employee values( '" + name + "', '" + age + "', '" + gender + "','" + s6
							+ "', '" + salary + "', '" + phone + "','" + aadhar + "', '" + email + "')";

					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Employee Added");
					setVisible(false);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		setSize(450, 600);
		setVisible(true);
		setLocation(500, 150);

	}

	public static void main(String[] args) {
		new AddEmployee();
	}
}
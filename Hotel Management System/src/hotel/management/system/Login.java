package hotel.management.system;

import java.awt.*; //used for coloring foreground and background
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	JLabel l1, l2; // labels
	JTextField t1; // text field object
	JPasswordField t2; // password field object
	JButton b1, b2, b3;

	Login() {

		super("Login");

		setLayout(null);

		l1 = new JLabel("Username");
		l1.setBounds(40, 20, 100, 30);
		add(l1);

		l2 = new JLabel("Password");
		l2.setBounds(40, 70, 100, 30);
		add(l2);

		t1 = new JTextField();
		t1.setBounds(150, 20, 150, 30);
		add(t1);

		t2 = new JPasswordField();
		t2.setBounds(150, 70, 150, 30);
		add(t2);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(400, 10, 150, 150);
		add(l3);

		b1 = new JButton("Login");
		b1.setBounds(40, 140, 120, 30);
		b1.setFont(new Font("Tahoma", Font.BOLD, 15));
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);

		b2 = new JButton("Cancel");
		b2.setBounds(180, 140, 120, 30);
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		b2.setBackground(Color.BLACK); // used from awt
		b2.setForeground(Color.WHITE);
		add(b2);

		b2.addActionListener(this);

		b3 = new JButton("Create");
		b3.setBounds(420, 180, 120, 30);
		b3.setFont(new Font("Tahoma", Font.BOLD, 15));
		b3.setBackground(Color.BLACK); // used from awt
		b3.setForeground(Color.WHITE);
		add(b3);

		b3.addActionListener(this);

		getContentPane().setBackground(Color.WHITE);

		setLayout(null);
		setBounds(600, 300, 600, 260);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			try {
				conn c = new conn();
				String username = t1.getText();
				String password = t2.getText();

				String q = "select * from login where username ='" + username + "' and password='" + password + "'";

				ResultSet rs = c.s.executeQuery(q);
				if (rs.next()) {
					new Dashboard().setVisible(true);
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid login id or password");
					// setVisible(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == b2) {
			System.gc();
			java.awt.Window win[] = java.awt.Window.getWindows();// checking for all open windows and closes all
			for (int i = 0; i < win.length; i++) {
				win[i].dispose();
				win[i] = null;
			}
			System.exit(0);
		}

		else if (ae.getSource() == b3) {
			new UserRegistration().setVisible(true);
			setVisible(false);
		}

	}

	public static void main(String[] args) {
		new Login();
	}
}

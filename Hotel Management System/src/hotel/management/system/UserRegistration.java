package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class UserRegistration extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwordField;
	private JButton btnNewButton, b2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public UserRegistration() {

		super("New User Registration");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLayout(null);
		setBounds(600, 300, 600, 260);
		contentPane.setBackground(Color.WHITE);
		setResizable(false);
		setVisible(true);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(400, 10, 150, 150);
		add(l3);

		JLabel l1 = new JLabel("Username");
		l1.setBounds(40, 20, 100, 30);
		contentPane.add(l1);

		JLabel l2 = new JLabel("Password");
		l2.setBounds(40, 70, 100, 30);
		contentPane.add(l2);

		username = new JTextField();
		username.setBounds(150, 20, 150, 30);
		contentPane.add(username);

		passwordField = new JPasswordField();
		passwordField.setBounds(150, 70, 150, 30);
		contentPane.add(passwordField);

		btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = username.getText();
				String password = passwordField.getText();

				String msg = " \n";

				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root",
							"12345678");

					String query = "INSERT INTO login values('" + userName + "','" + password + "')";

					Statement sta = connection.createStatement();
					int x = sta.executeUpdate(query);
					System.out.println(x + "= value");
					if (x != 1) {
						JOptionPane.showMessageDialog(btnNewButton, "This account already exist");
					} else {
						JOptionPane.showMessageDialog(btnNewButton,
								"Welcome, " + msg + "Your account was created sucessfully");

						setVisible(false);
						new Login().setVisible(true);
					}
					connection.close();
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(btnNewButton, "This account already exist");
					exception.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(40, 140, 120, 30);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		b2 = new JButton("Cancel");
		b2.setBounds(180, 140, 120, 30);
		b2.setFont(new Font("Tahoma", Font.BOLD, 15));
		b2.setBackground(Color.BLACK); // used from awt
		b2.setForeground(Color.WHITE);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		add(b2);
	}
}
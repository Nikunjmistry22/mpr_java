package hotel.management.system;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class CheckOut extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
	Choice c1;

//ADD JFRAME FOR INTERACTION ANF JLABEL FOR STRING
//USE AWT FOR GUI INTERFACE//	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // END THREADS START GUI INTERACTION FUNCTION
			public void run() {
				try {
					CheckOut frame = new CheckOut(); // FUNCTION STARTS
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		this.dispose(); // DESTROY FRAME //
	}

	public CheckOut() throws SQLException {
		// conn = Javaconnect.getDBConnection();//
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 350, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
		Image i3 = i1.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT);
		ImageIcon i2 = new ImageIcon(i3);
		JLabel l1 = new JLabel(i2);
		l1.setBounds(300, 0, 500, 225);
		add(l1);*/

		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);

		JLabel lblName = new JLabel("Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);

		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while (rs.next()) {
				c1.add(rs.getString("number"));
			} // FETCH DATA FROM DATABASE IN SQL//
				// SQL PANEL//
		} catch (Exception e) {
		}
		c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);

		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
		Image i5 = i4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JButton l2 = new JButton(i6);
		l2.setBounds(290, 82, 20, 20);
		add(l2);

		l2.addActionListener(new ActionListener() {
			// USER CLICK WAIT//
			public void actionPerformed(ActionEvent ae) {
				System.out.println("Hi");
				try {
					// LINK THE DATABASE//
					// CHECK WETHER NUMBER IS AVAILABLE IN DATABASE OR NOT RUN CATCH ELSE//
					conn c = new conn();
					String number = c1.getSelectedItem();
					ResultSet rs = c.s.executeQuery("select * from customer where number = " + "'" + number + "'");

					if (rs.next()) {
						System.out.println("clicked");
						t1.setText(rs.getString("room"));
					}
				} catch (Exception e) {
				}
			}
		});

		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setBounds(20, 132, 86, 20);
		contentPane.add(lblRoomNumber);

		t1 = new JTextField();
		t1.setBounds(130, 132, 150, 20);
		contentPane.add(t1);

		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pending = 1;
				String s1 = t1.getText();
				String id = c1.getSelectedItem();
				String total = "select price from room where room_number = '" + s1 + "'";
				String deposit = "select deposit from customer where number = '" + id + "'";
				conn c = new conn();
				try {
					ResultSet rs1 = c.s.executeQuery("select * from customer where room = " + s1);
					while (rs1.next()) {
						deposit = rs1.getString("deposit");

					}
					ResultSet rs2 = c.s.executeQuery("select * from room where room_number = " + s1);
					while (rs2.next()) {
						total = rs2.getString("price");

					}
//					deposit = rs2.getString("deposit");
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				if (Integer.parseInt(total) == Integer.parseInt(deposit)) {

					String deleteSQL = "Delete from customer where number = " + "'" + id + "'";
					String q2 = "update room set available = 'Available' where room_number = " + s1;

					try {
						// USER LEAVES THE HOTEL PULL A CHECK OUT TRY AND CATCH//

						c.s.executeUpdate(deleteSQL);
						c.s.executeUpdate(q2);
						JOptionPane.showMessageDialog(null, "Check Out Successful");
						new Reception().setVisible(true);
						setVisible(false);
					} catch (SQLException e1) {
						System.out.println(e1.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Total money not deposted");
				}
			}
		});// COLUMN DELETED SUCCESSFULLY//
		btnCheckOut.setBounds(50, 200, 100, 25);
		btnCheckOut.setBackground(Color.BLACK);
		btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);

		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reception().setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setBounds(160, 200, 100, 25);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
	}

}
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

	JMenuBar mb;
	JMenu m1, m2;
	JMenuItem i1, i2, i3, i4;

	Dashboard() {

		mb = new JMenuBar();
		add(mb);

		m1 = new JMenu("Hotel Management");
		m1.setForeground(Color.RED);
		mb.add(m1);

		m2 = new JMenu("Admin");
		m2.setForeground(Color.BLUE);
		mb.add(m2);

		i1 = new JMenuItem("Reception");
		m1.add(i1);

		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new Reception();
			}
		});

		i2 = new JMenuItem("Add Employee");
		m2.add(i2);

		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new AddEmployee().setVisible(true);
				} catch (Exception e) {
				}
			}
		});

		i3 = new JMenuItem("Add Rooms");
		m2.add(i3);

		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new AddRoom().setVisible(true);
				} catch (Exception e) {
				}
			}
		});

		i4 = new JMenuItem("Add Drivers");
		m2.add(i4);

		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new AddDrivers().setVisible(true);
				} catch (Exception e) {
				}
			}
		});

		mb.setBounds(0, 0, 1920, 20);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Hotel/Management/System/icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(-300, 0, 1920, 1080);
		add(l1);

		JLabel l2 = new JLabel("Welcome to the Hotel Management System");
		l2.setBounds(400, 60, 1100, 60);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("SansSerif", Font.BOLD, 50));
		l1.add(l2);

		setLayout(null);
		setBounds(0, 0, 1920, 1050);
		//setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Dashboard().setVisible(true);
	}
}

package project;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;


public class AddDrivers extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField t1, t2, t3, t4, t5;
    private JComboBox comboBox, comboBox_1;
    JButton b1, b2;
    Choice c1;

    public static void main(String[] args) throws IOException {
        new AddDrivers().setVisible(true);
    }

    public AddDrivers() throws IOException {
        setBounds(350, 150, 450, 500);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l10 = new JLabel("Add Drivers");
        l10.setFont(new Font("Serif-san", Font.BOLD, 20));
        l10.setBounds(194, 10, 200, 30);
        contentPane.add(l10);

        JLabel l1 = new JLabel("Name");
        l1.setForeground(new Color(25, 25, 112));
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(64, 70, 102, 22);
        contentPane.add(l1);

        // It adds text box where information is added
        t1 = new JTextField();
        t1.setBounds(174, 70, 156, 20);
        contentPane.add(t1);

        // Adds label
        JLabel l2 = new JLabel("Age");
        l2.setForeground(new Color(25, 25, 112));
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(64, 110, 102, 22);
        contentPane.add(l2);

        t2 = new JTextField();
        t2.setBounds(174, 110, 156, 20);
        contentPane.add(t2);

        JLabel l3 = new JLabel("Gender");
        l3.setForeground(new Color(25, 25, 112));
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(64, 150, 102, 22);
        contentPane.add(l3);

        // Adds dropdown to select the gender
        comboBox = new JComboBox(new String[] { "Male", "Female" });
        comboBox.setBounds(176, 150, 154, 20);
        contentPane.add(comboBox);

        JLabel l4 = new JLabel("Car Company");
        l4.setForeground(new Color(25, 25, 112));
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(64, 190, 102, 22);
        contentPane.add(l4);

        t3 = new JTextField();
        t3.setBounds(174, 190, 156, 20);
        contentPane.add(t3);

        JLabel l5 = new JLabel("Car Model");
        l5.setForeground(new Color(25, 25, 112));
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(64, 230, 102, 22);
        contentPane.add(l5);

        t4 = new JTextField();
        t4.setBounds(174, 230, 156, 20);
        contentPane.add(t4);

        JLabel l6 = new JLabel("Available");
        l6.setForeground(new Color(25, 25, 112));
        l6.setFont(new Font("Tahoma", Font.BOLD, 14));
        l6.setBounds(64, 270, 102, 22);
        contentPane.add(l6);

        comboBox_1 = new JComboBox(new String[] { "Yes", "No" });
        comboBox_1.setBounds(176, 270, 154, 20);
        contentPane.add(comboBox_1);

        JLabel l7 = new JLabel("Location");
        l7.setForeground(new Color(25, 25, 112));
        l7.setFont(new Font("Tahoma", Font.BOLD, 14));
        l7.setBounds(64, 310, 102, 22);
        contentPane.add(l7);

        t5 = new JTextField();
        t5.setBounds(174, 310, 156, 20);
        contentPane.add(t5);

        // Adds button to submit the information
        b1 = new JButton("Add");
        b1.addActionListener(this);
        b1.setBounds(64, 380, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        contentPane.add(b1);

        b2 = new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(198, 380, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        contentPane.add(b2);

        contentPane.setBackground(Color.WHITE);

    }

    // It adds the information provided in the mysql databases
    public void actionPerformed(ActionEvent ae) {
        try {

            if (ae.getSource() == b1) {
                try {
                    conn c = new conn();
                    String name = t1.getText();
                    String age = t2.getText();
                    String gender = (String) comboBox.getSelectedItem();
                    String company = t3.getText();
                    String brand = t4.getText();
                    String available = (String) comboBox_1.getSelectedItem();
                    String location = t5.getText();
                    String str = "INSERT INTO driver values( '" + name + "', '" + age + "', '" + gender + "','"
                            + company + "', '" + brand + "', '" + available + "','" + location + "')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                    this.setVisible(false);

                } catch (Exception ee) {
                    System.out.println(ee);
                }
            } else if (ae.getSource() == b2) {
                this.setVisible(false);
            }
        } catch (Exception eee) {

        }
    }
}

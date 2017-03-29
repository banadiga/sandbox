package com.banadiga.swing.form;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
  private final JTextField login = new JTextField(15);
  private final JTextField password = new JPasswordField(15);

  private final ApplicationForm applicationForm;

  public LoginForm(ApplicationForm applicationForm) {
    setTitle("LOGIN FORM");
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    JPanel grid = new JPanel(new GridLayout(3, 1));

    grid.add(new JLabel("Username:"));
    grid.add(login);

    grid.add(new JLabel("Password:"));
    grid.add(password);

    JButton submit = new JButton("Login");
    grid.add(submit);

    add(grid, BorderLayout.CENTER);
    submit.addActionListener(new LoginListener(this));

    this.applicationForm = applicationForm;
  }


  private class LoginListener implements ActionListener {
    JFrame frame;

    LoginListener(JFrame frame) {
      this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      String userName = login.getText();
      String userPass = password.getText();
      if (userName.equals("admin") && userPass.equals("password")) {
        frame.setVisible(false);
        applicationForm.login(userName);
      } else {
        System.out.println("Entered the valid username and password");
        JOptionPane.showMessageDialog(frame, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}

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

class LoginForm extends JFrame {
  private boolean logined = false;
  private final JTextField login = new JTextField(15);
  private final JTextField password = new JPasswordField(15);

  LoginForm() {
    setTitle("LOGIN FORM");

    JPanel grid = new JPanel(new GridLayout(3, 1));

    grid.add(new JLabel("Username:"));
    grid.add(login);

    grid.add(new JLabel("Password:"));
    grid.add(password);

    JButton login = new JButton("Login");
    login.addActionListener(new OnLoginActionListener(this));
    grid.add(login);
    grid.add(new JLabel("admin/password"));

    add(grid, BorderLayout.CENTER);
  }

  String getCurrentUser() {
    if (!logined) {
      return null;
    }
    return login.getText();
  }

  private class OnLoginActionListener implements ActionListener {
    private LoginForm loginForm;

    OnLoginActionListener(LoginForm loginForm) {
      this.loginForm = loginForm;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      String userName = loginForm.login.getText();
      String userPass = loginForm.password.getText();
      if (userName.equals("admin") && userPass.equals("password")) {
        loginForm.logined = true;
        loginForm.setVisible(false);
      } else {
        System.out.println("Entered the valid username and password");
        JOptionPane.showMessageDialog(loginForm, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}

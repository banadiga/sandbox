package com.banadiga.swing.form;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationForm extends JFrame {
  private JLabel userName = new JLabel();

  public ApplicationForm() {
    setTitle("Welcome to application");
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    JPanel grid = new JPanel(new GridLayout(3, 2));
    grid.add(new JLabel("Welcome user:"));
    grid.add(userName);

    add(grid, BorderLayout.CENTER);

    LoginForm loginForm = new LoginForm(this);
    JDialog d5 = new JDialog(loginForm, true);
    d5.setVisible(true);
    d5.pack();

  }

  public void login(String userName) {
    this.userName.setText(userName);
  }
}

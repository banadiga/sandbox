package com.banadiga.swing.form;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationForm extends JFrame {
  private final JButton login = new JButton("Login...");
  private final JButton logout = new JButton("Logout...");
  private final JLabel userName = new JLabel();

  public ApplicationForm() {
    setTitle("Welcome to application");
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    JPanel grid = new JPanel(new GridLayout(2, 2));
    grid.add(new JLabel("Welcome user:"));
    grid.add(userName);

    login.addActionListener(new OnLoginActionListener());
    grid.add(login);

    logout.addActionListener(new OnLogoutActionListener());
    logout.setVisible(false);
    grid.add(logout);

    add(grid, BorderLayout.CENTER);
  }

  private class OnLogoutActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      userName.setText("");
      login.setVisible(true);
      logout.setVisible(false);
    }
  }

  private class OnLoginActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent ae) {
      LoginForm frame = new LoginForm();
      frame.addComponentListener(new LoginComponentListener(frame));
      frame.pack();
      frame.setVisible(true);
    }
  }

  private class LoginComponentListener implements ComponentListener {

    private LoginForm loginForm;

    LoginComponentListener(LoginForm loginForm) {
      this.loginForm = loginForm;
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
      String currentUse = loginForm.getCurrentUser();
      if (currentUse != null) {
        userName.setText(currentUse);
        login.setVisible(false);
        logout.setVisible(true);
      }
    }
  }
}

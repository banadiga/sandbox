package com.banadiga.swing;

import com.banadiga.swing.form.ApplicationForm;

import javax.swing.JFrame;

public class HelloWorldSwing {


  private static void createApplication() {
    JFrame frame = new ApplicationForm();
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(HelloWorldSwing::createApplication);
  }
}

package com.sanifrey.test1;
import javax.swing.JFrame;
public class PanelCreator {
private void CreatePanel(JFrame frame, boolean arg, String Title) {
frame.setVisible(arg);
frame.setTitle(Title);
frame.setBounds(100, 100, 480, 313);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
frame.setResizable(false);
}
public void PCreatePanel(JFrame frame, boolean arg, String Title) {
CreatePanel(frame, arg, Title);
}
}
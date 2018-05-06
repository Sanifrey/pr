package com.sanifrey.test1;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class ComponentsCreator {
private JFrame plframe;
public ComponentsCreator(JFrame frame) {
this.plframe = frame;
}
private void JTextFieldSettings(JTextField textField, boolean bool, int x, int y, int xw, int yh) {
textField.setBounds(x, y, xw, yh);
textField.setColumns(10);
textField.setEditable(bool);
plframe.getContentPane().add(textField);
if (bool == true)
DigitFilter.PTextFilter(textField, 9);
}
private void JLabelSettings(JLabel label, String text, int x, int y, int xw, int yh) {
label.setBounds(x, y, xw, yh);
label.setText(text);
plframe.getContentPane().add(label);
}
private void JButtonSettings(JButton button, String text, int x, int y, int xw, int yh) {
button.setBounds(x, y, xw, yh);
button.setText(text);
plframe.getContentPane().add(button);
}
public void PJTextFieldSettings(JTextField textField, boolean bool, int x, int y, int xw, int yh) {
JTextFieldSettings(textField, bool, x, y, xw, yh);
}
public void PJLabelSettings(JLabel label, String text, int x, int y, int xw, int yh) {
JLabelSettings(label, text, x, y, xw, yh);
}
public void PJButtonSettings(JButton button, String text, int x, int y, int xw, int yh) {
JButtonSettings(button, text, x, y, xw, yh);
}
}
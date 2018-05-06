package com.sanifrey.test1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Otdel {
private JFrame frame;
private JButton button_save;
private JButton button_Menu;
private JTextField textField_AllArea;
private JTextField textField_FreeArea;
private JLabel label_AllArea;
private JLabel label_FreeArea;
private SaveFile sf;
private ComponentsCreator cc;
private PanelCreator pc;
private JButton ButtonName[] = { button_save, button_Menu };
private String Button_keys_label[] = { "Сохранить", "В меню" };
private int Button_Bounds[] = { 10, 180, 105, 23, 340, 227, 84, 23 };
private JTextField TextFieldName[] = { textField_AllArea, textField_FreeArea };
private int TextField_Bounds[] = { 10, 31, 86, 20, 10, 77, 86, 20 };
private boolean TextField_Editable[] = { false, false };
private JLabel JLabelName[] = { label_AllArea, label_FreeArea };
private int JLabel_Bounds[] = { 10, 11, 137, 14, 10, 57, 137, 14 };
private String JLabel_text[] = { "Общая площадь", "Свободная площадь" };
private eHandler handler = new eHandler();
private int Counter;
public Otdel() {
initialize();
}
private void initialize() {
frame = new JFrame();
cc = new ComponentsCreator(frame);
pc = new PanelCreator();
for (int i = 0; i <= 1; i++) {
ButtonName[i] = new JButton();
cc.PJButtonSettings(ButtonName[i], Button_keys_label[i], Button_Bounds[Counter + i],
Button_Bounds[Counter + i + 1], Button_Bounds[Counter + i + 2], Button_Bounds[Counter + i + 3]);
ButtonName[i].addActionListener(handler);
Counter += 3;
}
Counter = 0;
for (int i = 0; i <= 1; i++) {
TextFieldName[i] = new JTextField();
cc.PJTextFieldSettings(TextFieldName[i], TextField_Editable[i], TextField_Bounds[Counter + i],
TextField_Bounds[Counter + i + 1], TextField_Bounds[Counter + i + 2],
TextField_Bounds[Counter + i + 3]);
Counter += 3;
}
Counter = 0;
for (int i = 0; i <= 1; i++) {
JLabelName[i] = new JLabel();
cc.PJLabelSettings(JLabelName[i], JLabel_text[i], JLabel_Bounds[Counter + i],
JLabel_Bounds[Counter + i + 1], JLabel_Bounds[Counter + i + 2], JLabel_Bounds[Counter + i + 3]);
Counter += 3;
}
Counter = 0;
pc.PCreatePanel(frame, false, "Отделочник");
}
private class eHandler implements ActionListener {
public void actionPerformed(ActionEvent e) {
if (e.getSource() == getButtonName(0)) {
SaveInFile();
}
else if (e.getSource() == getButtonName(1)) {
frame.setVisible(false);
}
}
}
private void UpdateTextFields() {
setTextField(0, String.valueOf(Formula.getAllArea()));
setTextField(1, String.valueOf(Formula.getFreeArea()));
}
private void SaveInFile() {
sf = new SaveFile();
sf.PSaveInFile();
}
public JButton getButtonName(int i) {
return ButtonName[i];
}
public void setTextField(int i, String text) {
this.TextFieldName[i].setText(text);
}
public void Visiable(boolean arg) {
frame.setVisible(arg);
UpdateTextFields();
}
}
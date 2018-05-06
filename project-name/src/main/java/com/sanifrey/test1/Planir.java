package com.sanifrey.test1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Planir {
private JFrame frame;
private JTextField textField_AllArea;
private JTextField textField_WidthObj;
private JTextField textField_LengthObj;
private JTextField textField_FreeArea;
private JTextField textField_AmountObj;
private eHandler handler = new eHandler();
private JLabel label_AllArea;
private JLabel label_ParametersObj;
private JLabel label_WidthObj;
private JLabel label_LengthObj;
private JLabel label_AmountObj;
private JButton button_AddObject;
private JButton button_CountFreeArea;
private JButton button_GoToMainMenu;
private JButton button_DeleteAllObjects;
private ComponentsCreator cc;
private PanelCreator pc;
private Formula fl;
private JButton ButtonName[] = { button_AddObject, button_CountFreeArea, button_GoToMainMenu,
button_DeleteAllObjects };
private String Button_keys_label[] = { "Добавить объект", "Расчёт свободной площади", "В меню",
"Удалить все объекты" };
private int Button_Bounds[] = { 10, 193, 150, 23, 10, 227, 230, 23, 361, 240, 93, 23, 170, 193, 164, 23 };
private JTextField TextFieldName[] = { textField_AllArea, textField_WidthObj, textField_LengthObj,
textField_FreeArea, textField_AmountObj };
private int TextField_Bounds[] = { 10, 20, 86, 20, 10, 109, 86, 20, 10, 155, 86, 20, 248, 228, 86, 20, 308, 58, 44,
20 };
private boolean TextField_Editable[] = { true, true, true, false, false };
private JLabel JLabelName[] = { label_AllArea, label_ParametersObj, label_WidthObj, label_LengthObj,
label_AmountObj };
private int JLabel_Bounds[] = { 10, 0, 434, 14, 10, 61, 123, 14, 10, 89, 69, 14, 10, 135, 69, 14, 168, 61, 130,
14 };
private String JLabel_text[] = { "Введите площадь всей комнаты", "Параметры объекта", "Ширина", "Длина",
"Количество объектов:" };
private int Counter;
public Planir() {
initialize();
}
private void initialize() {
frame = new JFrame();
fl = new Formula();
cc = new ComponentsCreator(frame);
pc = new PanelCreator();
Counter = 0;
for (int i = 0; i <TextFieldName.length; i++) {
TextFieldName[i] = new JTextField();
cc.PJTextFieldSettings(TextFieldName[i], TextField_Editable[i], TextField_Bounds[Counter + i],
TextField_Bounds[Counter + i + 1], TextField_Bounds[Counter + i + 2],
TextField_Bounds[Counter + i + 3]);
Counter += 3;
}
Counter = 0;
for (int i = 0; i<ButtonName.length; i++) {
ButtonName[i] = new JButton();
cc.PJButtonSettings(ButtonName[i], Button_keys_label[i], Button_Bounds[Counter + i],
Button_Bounds[Counter + i + 1], Button_Bounds[Counter + i + 2], Button_Bounds[Counter + i + 3]);
ButtonName[i].addActionListener(handler);
Counter += 3;
}
Counter = 0;
for (int i = 0; i <JLabelName.length; i++) {
JLabelName[i] = new JLabel();
cc.PJLabelSettings(JLabelName[i], JLabel_text[i], JLabel_Bounds[Counter + i],
JLabel_Bounds[Counter + i + 1], JLabel_Bounds[Counter + i + 2], JLabel_Bounds[Counter + i + 3]);
Counter += 3;
}
pc.PCreatePanel(frame, false, "Планировщик");
FirstLoad();
}
private class eHandler implements ActionListener {
public void actionPerformed(ActionEvent e) {
if (e.getSource() == getButtonName(0)) {
setTextField(4, fl.PublicAddObject(getTextFieldName(1), getTextFieldName(2)));
}
else if (e.getSource() == getButtonName(1)) {
setTextField(3, fl.PFormula(getTextFieldName(0)));
}
else if (e.getSource() == getButtonName(2)) {
frame.setVisible(false);
}
else if (e.getSource() == getButtonName(3)) {
setTextField(4, fl.PublicDeleteObjects());
}
}
}
public void setTextField(int i, String text) {
this.TextFieldName[i].setText(text);
}
private void FirstLoad() {
setTextField(4, String.valueOf(Formula.getAmount()));
}
public String getTextFieldName(int i) {
return TextFieldName[i].getText();
}
public void Visiable(boolean arg) {
frame.setVisible(arg);
}
public JButton getButtonName(int i) {
return ButtonName[i];
}
public JFrame getframe() {
return frame;
}
}
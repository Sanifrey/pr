package com.sanifrey.test1;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
public class MainMenu {
private JFrame frame;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
MainMenu window = new MainMenu();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public MainMenu() {
initialize();
}
private eHandler handler = new eHandler();
private JButton button_Planirov;
private JButton button_Otdelochnik;
private ComponentsCreator cc;
private int Counter;
private JButton ButtonName[]= {button_Planirov,button_Otdelochnik};
private String Button_keys_label[] = {"Планировщик","Отделочник"};
private int Button_Bounds[] = {11, 0, 150, 271,300, 0, 150, 270};
private void initialize() {
frame = new JFrame();
PanelCreator pc = new PanelCreator();
pc.PCreatePanel(frame, true, "Главное меню");
cc = new ComponentsCreator(frame);
Counter = 0;
for(int i=0;i<ButtonName.length;i++) {
ButtonName[i] = new JButton();
cc.PJButtonSettings(ButtonName[i],Button_keys_label[i], Button_Bounds[Counter+i], Button_Bounds[Counter+i+1], Button_Bounds[Counter+i+2], Button_Bounds[Counter+i+3]);
ButtonName[i].addActionListener(handler);
Counter+=3;
}
}
private class eHandler implements ActionListener {
Otdel ot = new Otdel();
Planir mp = new Planir();
public void actionPerformed(ActionEvent e) {
if (e.getSource() == ButtonName[0]) {
mp.Visiable(true);
}
else if(e.getSource() == ButtonName[1]){
ot.Visiable(true);
}
}
}
}
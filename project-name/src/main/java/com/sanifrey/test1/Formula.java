package com.sanifrey.test1;
import javax.swing.JOptionPane;
public class Formula {
private static float FreeArea;
private static float AllArea;
private static int Amount = 0;
private static Objects[] Obj = new Objects[1024];
private int number=1;
private String AddObject(float width, float length) {
if (width != 0.0 && length != 0.0) {
Amount += 1;
Obj[Amount] = new Objects();
Obj[Amount].setArea(width * length);
Obj[Amount].setWidth(width);
Obj[Amount].setLength(length);
} else {
JOptionPane.showMessageDialog(null, "Заполните поля ненулевыми значениями!");
}
return String.valueOf(Amount);
}
private String DeleteObjects() {
Amount = 0;
FreeArea = AllArea;
return String.valueOf(Amount);
}
private String FormulaFree(float area) {
AllArea = area;
FreeArea = AllArea;
for (number = 1; number < Amount+1; number++) {
FreeArea = FreeArea - Obj[number].getArea();
}
if (FreeArea < 0)
FreeArea = 0;
return String.valueOf(FreeArea);
}
public String PFormula(String area) {
try {
FormulaFree(Float.parseFloat(area));
} 
catch (Exception e) {
JOptionPane.showMessageDialog(null, "Ошибка в расчёте свободной площади! \nПоля заполнены неверно!");
}
return String.valueOf(FreeArea);
}
public static float getFreeArea() {
return FreeArea;
}
public static float getAllArea() {
return AllArea;
}
public String PublicAddObject(String width, String length) {
try {
AddObject(Float.parseFloat(width), Float.parseFloat(length));
} 
catch (Exception e) {
JOptionPane.showMessageDialog(null, "Ошибка во время добавления объекта! \nПоля заполнены неверно!");
}
return String.valueOf(Amount);
}
public String PublicDeleteObjects() {
return DeleteObjects();
}
public static Objects[] getObj() {
return Obj;
}
public static int getAmount() {
return Amount;
}
}
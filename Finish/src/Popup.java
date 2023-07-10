import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Popup implements Serializable
{
    JPopupMenu popupPtr;

    Popup(String title) {
        popupPtr = new JPopupMenu();
        popupPtr.add(title);
        popupPtr.addSeparator();
    }
    public void popup(JPanel view,int x,int y)
    {
        popupPtr.show(view,x,y);
    }
}

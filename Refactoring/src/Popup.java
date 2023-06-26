import javax.swing.*;

public class Popup {
    DrawerView view;
    JPopupMenu popupPtr;

    Popup(String title) {
        popupPtr = new JPopupMenu();

        popupPtr.add(title);
        popupPtr.addSeparator();
    }

    public void popup(JPanel view, int x, int y) {
        popupPtr.show(view,x,y);

    }
}

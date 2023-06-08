import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FigurePopup extends Popup {


    FigurePopup(DrawerView view,String title, boolean fillFlag) {

        super(title);

        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener((evt) -> view.deleteFigure());
        popupPtr.add(deleteItem);

    }

}

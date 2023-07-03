import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FigurePopup extends Popup {


    FigurePopup(DrawerView view,String title, boolean fillFlag) {

        super(title);

        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener((evt) -> view.deleteFigure());
        popupPtr.add(deleteItem);


        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener((evt) -> view.copyFigure());
        popupPtr.add(copyItem);

        JMenu colorMenu = new JMenu("Colors");
        popupPtr.add(colorMenu);

        JMenuItem blackItem = new JMenuItem("Black");
        blackItem.addActionListener((evt) -> view.setColorForSeletedFigure(Color.BLACK));
        colorMenu.add(blackItem);

        JMenuItem redItem = new JMenuItem("Red");
        redItem.addActionListener((evt) -> view.setColorForSeletedFigure(Color.RED));
        colorMenu.add(redItem);

        JMenuItem greenItem = new JMenuItem("Green");
        greenItem.addActionListener((evt) -> view.setColorForSeletedFigure(Color.GREEN));
        colorMenu.add(greenItem);

        JMenuItem blueItem = new JMenuItem("Blue");
        blueItem.addActionListener((evt) -> view.setColorForSeletedFigure(Color.BLUE));
        colorMenu.add(blueItem);

        JMenuItem chooseItem = new JMenuItem("Chooser");
        chooseItem.addActionListener((evt) ->view.showColorChooser());
        colorMenu.add(chooseItem);

        if(fillFlag == true)
        {
            JMenuItem fillItem = new JMenuItem("Fill");
            fillItem.addActionListener((evt) -> view.fillFigure());
            popupPtr.add(fillItem);
        }
    }

}

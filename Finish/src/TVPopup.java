import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TVPopup extends FigurePopup
{

    TVPopup(DrawerView view) {
        super(view,"Tv",false);

        JMenuItem powerItem = new JMenuItem("ON/OFF");
        powerItem.addActionListener((evt) -> view.onOffTV());
        popupPtr.add(powerItem);

        JMenuItem antennaItem = new JMenuItem("Antenna");
        antennaItem.addActionListener((evt) -> view.setAntenna());
        popupPtr.add(antennaItem);
    }
}

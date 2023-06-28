import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StatusBar extends JPanel {

    JTextField position;
    JTextField figureType;
    JTextField viewSize;

    StatusBar() {

        setLayout(new BorderLayout());
        position = new JTextField("Position", 8);
        position.setEnabled(false);
        position.setHorizontalAlignment(JTextField.CENTER);
        figureType = new JTextField("Type", 8);
        figureType.setEnabled(false);
        figureType.setHorizontalAlignment(JTextField.CENTER);
        viewSize = new JTextField("Size", 8);
        viewSize.setEnabled(false);
        viewSize.setHorizontalAlignment(JTextField.CENTER);

        //class full name
        javax.swing.Box box1 = javax.swing.Box.createHorizontalBox();

        box1.add(javax.swing.Box.createHorizontalStrut(20));
        box1.add(position);
        box1.add(figureType);

        javax.swing.Box box2 = javax.swing.Box.createHorizontalBox();
        box2.add(viewSize);
        box2.add(javax.swing.Box.createHorizontalStrut(20));

        add(box1, "West");
        add(box2, "East");

        setBorder(BorderFactory.createEtchedBorder());


        }
    public void writePosition(String s) {
        position.setText(s);
    }
    public void writeFigureType(String s) {
        figureType.setText(s);
    }
    public void writeSize(String s) {
        viewSize.setText(s);
    }
}


import javax.swing.*;
import java.awt.*;

public class DrawerFrame extends JFrame {
    DrawerFrame() {
        setTitle("Drawer");
        setSize(700,500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(new MyMouseListener(this));
        getContentPane().setBackground(new Color(220,239,241,255));
    }
}

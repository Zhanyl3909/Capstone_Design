import javax.swing.*;

public class DrawerFrame extends JFrame {
    DrawerFrame() {
        setTitle("Drawer");
        setSize(700,500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(new MyMouseListener(this));
    }
}

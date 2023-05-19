import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawerFrame extends JFrame {
    DrawerFrame() {
        setTitle("Drawer");
        setSize(700,500);
        setLocation(100, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener( new MouseAdapter() {  //anonymous object

                              public void mousePressed(MouseEvent e) {
                                  System.out.println("mousePressed");
                                  int x = e.getX();
                                  int y = e.getY();

                                  Graphics g = getGraphics();
                                  g.drawLine(x-10, y-10, x+10, y+10);
                                  g.drawLine(x+10, y-10, x-10, y+10);
                              }


                     }
            );

       }

    }


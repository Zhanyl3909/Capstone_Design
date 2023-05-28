import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawerView extends JPanel
    implements MouseListener, MouseMotionListener
{

    //Constructor for DrawerView
    int startX;
    int startY;
    DrawerView() {

        addMouseListener(this);
        addMouseMotionListener(this);

    }
    public void paintComponent(Graphics g) {    //paintComponent Event Handling (hook function )
        super.paintComponent(g);
      //  g.drawLine(0,0,200,200);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();  //gets clicked location
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int endX = e.getX();
        int endY = e.getY();

        int minX = Math.min(startX, endX);
        int minY = Math.min(startY, endY);
        int width = Math.abs(endX- startX);
        int height = Math.abs(endY - startY );

        Graphics g = getGraphics();
        g.drawRect(minX, minY,width, height);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    //Mouse Motion Listener
    @Override
    public void mouseDragged(MouseEvent e) {
        int endX = e.getX();
        int endY = e.getY();

        int minX = Math.min(startX, endX);
        int minY = Math.min(startY, endY);
        int width = Math.abs(endX - startX);
        int height = Math.abs(endY - startY );

        Graphics g = getGraphics();
        g.drawRect(minX, minY,width, height);

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

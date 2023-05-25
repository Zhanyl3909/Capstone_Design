import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.lang.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class DrawerView extends JPanel
    implements MouseListener, MouseMotionListener
{

    int MAX = 100;
    Box pBox;

    //Arraylist
    ArrayList<Box> boxes = new ArrayList<Box>();
    DrawerView() {
        pBox = null;
        addMouseListener(this);
        addMouseMotionListener(this);

    }
    public void paintComponent(Graphics g) {
       super.paintComponent(g);

       for(int i=0; i<boxes.size(); i++) {
           Box p = boxes.get(i);
           p.draw(g);

       }

     }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pBox = new Box(e.getX(), e.getY());
        boxes.add(pBox);


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        Graphics g = getGraphics();
        pBox.setXY2(e.getX(),e.getY());
        pBox.draw(g);

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
        Graphics g = getGraphics();
        g.setXORMode(getBackground());
        pBox.drawing(g,e.getX(),e.getY());

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}

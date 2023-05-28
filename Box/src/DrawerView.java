import javax.swing.*;
import java.awt.*;
import java.lang.Math;
import java.lang.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class DrawerView extends JPanel
    implements MouseListener, MouseMotionListener
{

    public static int DRAW_BOX = 1; //macro
    public static int DRAW_LINE = 2;
    private int whatToDraw;
    private Box pBox;
    private ArrayList<Box> boxes = new ArrayList<Box>();

    private Line pLine;
    private ArrayList<Line> lines =  new ArrayList<Line>();


    DrawerView() {
        addMouseListener(this);
        addMouseMotionListener(this);

    }
    public void paintComponent(Graphics g) {
       super.paintComponent(g);

       for(int i=0; i<boxes.size(); i++) {
           Box p = boxes.get(i);
           p.draw(g);
       }

        for(int i=0; i<lines.size(); i++) {
            Line pLine = lines.get(i);
            pLine.draw(g);
        }
     }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(whatToDraw == DRAW_BOX) {
            pBox = new Box(e.getX(), e.getY());
            boxes.add(pBox);

        } else if(whatToDraw == DRAW_LINE) {
            pLine = new Line(e.getX(), e.getY());
            lines.add(pLine);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        Graphics g = getGraphics();

        if(whatToDraw == DRAW_BOX) {
            pBox.setXY2(e.getX(),e.getY());
            pBox.draw(g);

        } else if(whatToDraw == DRAW_LINE) {
            pLine.setXY2(e.getX(),e.getY());
            pLine.draw(g);
        }

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


        if(whatToDraw == DRAW_BOX) {
            pBox.drawing(g,e.getX(),e.getY());

        } else if(whatToDraw == DRAW_LINE) {
            pLine.drawing(g,e.getX(),e.getY());

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    void setWhatToDraw(int figType) {
        whatToDraw = figType;
    }
}

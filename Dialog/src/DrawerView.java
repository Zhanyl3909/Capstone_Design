import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class DrawerView extends JPanel
        implements MouseListener, MouseMotionListener
{
    public static int DRAW_BOX = 1;
    public static int DRAW_LINE = 2;


    private int whatToDraw;
    private Figure currentFigure;
    private ArrayList<Figure> figures = new ArrayList<Figure>();


    DrawerView() {
        addMouseListener(this);
        addMouseMotionListener(this);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        //Dynamic binding
        for(int i=0; i<figures.size(); i++) {
            Figure pFigure = figures.get(i);
            pFigure.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    //dynamic binding
    @Override
    public void mousePressed(MouseEvent e) {
        if(whatToDraw == DRAW_BOX) {
            currentFigure = new Box(e.getX(), e.getY());

        } else if(whatToDraw == DRAW_LINE) {
            currentFigure = new Line(e.getX(), e.getY());
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        Graphics g = getGraphics();
        currentFigure.setXY2(e.getX(), e.getY());
        currentFigure.draw(g);
        figures.add(currentFigure); //polymorphic collection (container)
        currentFigure = null;
    }

    public void addFigure(Figure newFigure) {
        figures.add(newFigure);
        repaint();
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
        currentFigure.drawing(g,e.getX(),e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    void setWhatToDraw(int figType) {
        whatToDraw = figType;
    }
}

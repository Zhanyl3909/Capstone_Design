
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
    public static int ID_POINT = 0;
    public static int ID_BOX = 1;
    public static int ID_LINE = 2;
    public static int ID_CIRCLE = 3;

    public static int NOTHING = 0;
    public static int DRAWING = 1;
    public static int MOVING = 2;
    private int actionMode;
    private int whatToDraw;
    private Figure selectedFigure;
    private Popup mainPopup;
    private Popup boxPopup;
    private Popup linePopup;
    private Popup circlePopup;
    private Popup pointPopup;
    private ArrayList<Figure> figures = new ArrayList<Figure>();


    private int currentX;
    private int currentY;

    private SelectAction boxAction;
    private DrawerFrame mainFrame;
    DrawerView(DrawerFrame mainFrame) {

        this.mainFrame = mainFrame;
        boxAction =    new SelectAction("Box(B)",new ImageIcon("src/img/box.gif"), this, ID_BOX);
        mainPopup = new MainPopup(this);
        pointPopup = new FigurePopup(this,"Point", false);
        boxPopup = new FigurePopup(this,"Box",true);
        linePopup = new FigurePopup(this, "Line",false);
        circlePopup = new FigurePopup(this,"Circle",true);


        actionMode = NOTHING;
        addMouseListener(this);
        addMouseMotionListener(this);

    }
    public SelectAction getBoxAction() {
        return boxAction;
    }
    Popup boxPopup() {
        return boxPopup;
    }
    Popup linePopup() {
        return linePopup;
    }
    Popup circlePopup() {
        return circlePopup;
    }
    Popup pointPopup() {
        return pointPopup;
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
        int x = e.getX();
        int y = e.getY();

        if(e.getButton() == MouseEvent.BUTTON3) {
            actionMode = NOTHING;
            return;
        } else {

        }

        selectedFigure = find(x,y);
        if(selectedFigure != null) {
            actionMode = MOVING;
            currentX = x;
            currentY = y;
            figures.remove(selectedFigure);
            //   repaint();
            return;
        }

        if(whatToDraw == ID_BOX) {
            selectedFigure = new Box(Color.BLACK,x,y);
            selectedFigure.setPopup(boxPopup);
        } else if(whatToDraw == ID_LINE) {
            selectedFigure = new Line(Color.BLACK,x,y);
            selectedFigure.setPopup(linePopup);
        } else if (whatToDraw == ID_CIRCLE) {
            selectedFigure = new Circle(Color.BLACK,x,y);
            selectedFigure.setPopup(circlePopup);
        } else if (whatToDraw == ID_POINT) {
            selectedFigure = new Point(Color.BLACK,x,y);
            selectedFigure.setPopup(pointPopup);
        }
        actionMode = DRAWING;


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();



        if(e.isPopupTrigger()) {

            selectedFigure = find(x,y);

            if(selectedFigure == null) {
                mainPopup.popup(this,x,y);
            } else {
                selectedFigure.popup(this,x,y);
            }



            return;


        }
        Graphics g = getGraphics();
        if(actionMode == DRAWING) {
            selectedFigure.setXY2(x,y);
        }

        selectedFigure.draw(g);
        addFigure(selectedFigure);
        selectedFigure = null;

    }

    public void addFigure(Figure newFigure) {
        newFigure.makeRegion();
        figures.add(newFigure);
        repaint();
    }

    public void deleteFigure() {
        if(selectedFigure == null) return;
        figures.remove(selectedFigure);
        selectedFigure = null;
        repaint();
    }
    public void copyFigure() {
       if(selectedFigure == null) return;
       Figure newFigure = selectedFigure.copy();
       addFigure(newFigure);
       selectedFigure = newFigure;

    }

    public void fillFigure() {
        if(selectedFigure == null) return;
        selectedFigure.setFill();
        repaint();
    }


    public void showColorChooser() {
        Color color = JColorChooser.showDialog(this,"Color Chooser",Color.BLACK);
        setColorForSelectedFigure(color);
    }
    void setColorForSelectedFigure(Color color) {
        if(selectedFigure == null) return;
        selectedFigure.setColor(color);
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
        int x = e.getX();
        int y = e.getY();

        Graphics g = getGraphics();
        g.setXORMode(getBackground());
        if(actionMode == DRAWING) {
            selectedFigure.drawing(g,x,y);

        } else if (actionMode == MOVING) {
            selectedFigure.move(g,x-currentX,y-currentY);
            currentX = x;
            currentY = y;
        }

    }

    private Figure find(int x, int y) {
        for(int i=0; i<figures.size(); i++) {
            Figure pFigure = figures.get(i);
            if(pFigure.contains(x,y)) {
                return pFigure;
            }
        }
        return null;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        selectedFigure = find(x,y);
        if(selectedFigure != null) {
            setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

        } else {
            setCursor(Cursor.getDefaultCursor());
        }

    //  statusBar.writePosition("[" + x + "," + y + "]");
        mainFrame.writePosition("[" + x + "," + y + "]");
    }
    void setWhatToDraw(int figType) {
        whatToDraw = figType;
    }


}
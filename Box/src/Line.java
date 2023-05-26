import java.awt.*;

public class Line{
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    Line(){

    }
    Line(int x, int y) {
        x1 = x2 = x;
        y1 = y2 = y;
    }

    //Getters & Setters


    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    void draw(Graphics g) {

        g.drawLine(x1,y1,x2,y2);


    }

    public void setXY2(int x, int y) {
        setX2(x);
        setY2(y);
    }

    public void drawing(Graphics g, int newX, int newY) {
        draw(g);
        setXY2(newX, newY);
        draw(g);
    }
}

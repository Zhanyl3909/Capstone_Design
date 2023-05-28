import java.awt.*;

public class Box {
    private int x1;
    private int y1;
    private int x2;
     private int y2;


   Box(){

    }
    Box(int x, int y) {
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

           int minX = Math.min(x1,x2);
           int minY = Math.min(y1, y2);
           int width = Math.abs(x2-x1);
           int height = Math.abs(y2-y1);
           g.drawRect(minX,minY,width,height);


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

import java.awt.*;

public abstract class Figure {
    Figure() {

    }
    abstract void draw(Graphics g);
    public void drawing(Graphics g, int newX, int newY) {
        draw(g);
        setXY2(newX, newY);
        draw(g);
    }

    abstract void setXY2(int newX, int newY);
}

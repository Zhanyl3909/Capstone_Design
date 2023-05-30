import java.awt.*;

public abstract class Figure {
    public Polygon region;

    Figure() {
        region = null;

    }


    abstract void setXY2(int newX, int newY);
    abstract void draw(Graphics g);
    abstract void makeRegion();
    boolean contains(int x, int y) {
        if(region == null) return false;
        return region.contains(x, y);
    }
    public void drawing(Graphics g, int newX, int newY) {
        draw(g);
        setXY2(newX, newY);
        draw(g);
    }

}
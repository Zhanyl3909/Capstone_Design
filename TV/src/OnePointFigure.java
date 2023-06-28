import java.awt.*;

public abstract class OnePointFigure extends Figure {
    protected boolean fillFlag;
    protected int x1;
    protected int y1;
    protected int GAP = 3;


    OnePointFigure(Color color) {
        super(color);
    }
    OnePointFigure(Color color,int x, int y) {
        super(color);
        x1 = x;
        y1 = y;
    }

    void move(int dx, int dy) {
        x1 = x1 + dx;
        y1 = y1 + dy;

    }
    void makeRegion() {

        int xpoints[] = new int[4];
        int ypoints[] = new int[4];

        xpoints[0] = x1 - GAP;
        ypoints[0] = y1 - GAP;

        xpoints[1] = x1 + GAP;
        ypoints[1] = y1 - GAP;


        xpoints[2] = x1 + GAP;
        ypoints[2] = y1 + GAP;

        xpoints[3] = x1 - GAP;
        ypoints[3] = y1 + GAP;


        region = new Polygon(xpoints,ypoints,4);

    }

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


    public void setXY2(int x, int y) {
        setX1(x);
        setY1(y);
    }


}
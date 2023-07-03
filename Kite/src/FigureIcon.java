import javax.swing.*;
import java.awt.*;

class FigureIcon implements Icon
{
    static int WIDTH = 16;
    static int HEIGHT = 16;
    String figureType;
    public FigureIcon(String figureType) {
        this.figureType = figureType;
    }
    public int getIconHeight() { return WIDTH; }
    public int getIconWidth() { return HEIGHT; }
    public void paintIcon(Component c,Graphics g,int x,int y) {
        g.setColor(Color.black);
        if (figureType.equals(DrawerView.figureType[0])) // Point
        {
            g.drawOval(x+WIDTH/2-1,y+HEIGHT/2-1,2,2);
            g.fillOval(x+WIDTH/2-1,y+HEIGHT/2-1,2,2);
        } else if (figureType.equals(DrawerView.figureType[1])) // Box
        {
            g.drawRect(x,y,WIDTH,HEIGHT);
        } else if (figureType.equals(DrawerView.figureType[2])) // Line
        {
            g.drawLine(x,y,x+WIDTH,y+HEIGHT);
        } else if (figureType.equals(DrawerView.figureType[3])) // Circle
        {
            g.drawOval(x,y,WIDTH,HEIGHT);
        } else if (figureType.equals(DrawerView.figureType[4])) // TV
        {
            g.drawLine(x+WIDTH*3/4,y,x+WIDTH/2,y+4);
            g.drawLine(x+WIDTH/4,y,x+WIDTH/2,y+4);
            g.drawRect(x+2,y+6,WIDTH-6,HEIGHT-10);
            g.drawRect(x+14,y+8,1,1);
            g.drawRect(x+14,y+11,1,1);
            g.drawRect(x,y+4,WIDTH,HEIGHT-6);
        } else if (figureType.equals(DrawerView.figureType[5])) // Kite
        {
            g.drawLine(x,y,x+WIDTH,y+HEIGHT);
            g.drawLine(x+WIDTH/2,y,x+WIDTH/2,y+HEIGHT);
            g.drawLine(x+WIDTH,y,x,y+HEIGHT);
            g.drawLine(x,y+HEIGHT/2,x+WIDTH,y+HEIGHT/2);
            g.drawOval(x+WIDTH/4,y+HEIGHT/4,WIDTH/2,HEIGHT/2);
            g.drawRect(x,y,WIDTH,HEIGHT);
        } else if (figureType.equals(DrawerView.figureType[6])) // Text
        {
            Font oldFont = g.getFont();
            g.setFont(new Font("Times New Roman",Font.PLAIN,20));
            g.drawString("T",x+1,y+15);
            g.setFont(oldFont);
        } else { // Undefined
            Font oldFont = g.getFont();
            g.setFont(new Font("Times New Roman",Font.BOLD,20));
            g.drawString("?",x+1,y+15);
            g.setFont(oldFont);
        }
    }
}

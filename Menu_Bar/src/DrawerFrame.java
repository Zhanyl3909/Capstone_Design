import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawerFrame extends JFrame {
    DrawerFrame() {
        setTitle("Drawer");
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setSize(screenHeight*2/3, screenWidth*2/3);
        setLocation(screenWidth/6, screenHeight/6);

        //menuBar
        JMenuBar menus = new JMenuBar();  //create menu bar
        setJMenuBar(menus);

       //menu
        JMenu fileMenu = new JMenu("File(F)");
        menus.add(fileMenu); //menus is a menu-bar (for files menu)

        //Adding items to menu
        JMenuItem newFile = new JMenuItem("New File");
        fileMenu.add(newFile);
        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New File");
            }
        });

        JMenuItem openFile = new JMenuItem("Open");
        fileMenu.add(openFile);
        JMenuItem closeFile = new JMenuItem("Close");
        fileMenu.add(closeFile);
        JMenuItem saveFile = new JMenuItem("Save");
        fileMenu.add(saveFile);
        JMenuItem deleteFile = new JMenuItem("Delete");
        fileMenu.add(deleteFile);

        JMenuItem exitFile = new JMenuItem("Exit");
        fileMenu.add(exitFile);
        exitFile.addActionListener(new ActionListener() { //Even Handling for exit
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }
}


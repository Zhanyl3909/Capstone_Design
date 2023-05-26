import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawerFrame extends JFrame {

    //data member
    DrawerView canvas;
    DrawerFrame() {
        setTitle("Drawer");

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setSize(screenHeight*2/3, screenWidth*2/3);
        setLocation(screenWidth/6, screenHeight/6);




        //icon
        Image img = tk.getImage("src/main.jpg");
        setIconImage(img);

        Container container = this.getContentPane();
        DrawerView canvas = new DrawerView();
        container.add(canvas);


        //menuBar
        JMenuBar menus = new JMenuBar();  //create menu bar
        setJMenuBar(menus);

        //menu
        JMenu fileMenu = new JMenu("File(F)");
        menus.add(fileMenu); //menus is a menu-bar (for files menu)

        //Adding items to menu
        JMenuItem newFile = new JMenuItem("New File (N)");
        fileMenu.add(newFile);
        newFile.setMnemonic('N');

        newFile.setIcon(new ImageIcon("src/newfile.gif"));
        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));

        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New File (N)");
            }
        });

        JMenuItem openFile = new JMenuItem("Open (O)");
        fileMenu.add(openFile);
        openFile.setMnemonic('O');
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        openFile.setIcon(new ImageIcon("src/openFile.gif"));

        //lambda expression
        openFile.addActionListener( (e) ->
                System.out.println("open (o)")
        );

        JMenuItem saveFile = new JMenuItem("Save (S)");
        fileMenu.add(saveFile);
        saveFile.setMnemonic('S');
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        saveFile.setIcon(new ImageIcon("src/save.gif"));


        JMenuItem saveAs = new JMenuItem("Save As (A)");
        fileMenu.add(saveAs);
        saveAs.setMnemonic('A');
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        saveAs.setIcon(new ImageIcon("src/save.gif"));
        fileMenu.addSeparator();

        JMenuItem exitFile = new JMenuItem("Exit (E)");
        fileMenu.add(exitFile);
        exitFile.addActionListener(e ->
                System.exit(0));

        exitFile.setMnemonic('E');
        exitFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        exitFile.setIcon(new ImageIcon("src/exit.gif"));

        exitFile.addActionListener(new ActionListener() { //Even Handling for exit
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JMenu figureMenu = new JMenu("Figure(F)");
        menus.add(figureMenu);

        JMenuItem box = new JMenuItem("Box(b)");
        figureMenu.add(box);
        box.addActionListener( (e) ->
                canvas.setWhatToDraw(DrawerView.DRAW_BOX));

        JMenuItem line = new JMenuItem("Line(l)");
        figureMenu.add(line);
        line.addActionListener( (e) ->
                canvas.setWhatToDraw(DrawerView.DRAW_LINE));



        //helper menu
        JMenu helperMenu = new JMenu("Help(H)");
        menus.add(helperMenu);



        //add items for helper
        JMenuItem aboutHelp = new JMenuItem("About (a)");
        helperMenu.add(aboutHelp);
        aboutHelp.setMnemonic('a');
        //dialog
        aboutHelp.addActionListener((e) ->
                {JOptionPane.showMessageDialog(null, "Context\r\n here", "Title", JOptionPane.INFORMATION_MESSAGE);}
        );



        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}


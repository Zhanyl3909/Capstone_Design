import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DrawerFrame extends JFrame {

    //data member
    DrawerView canvas;
    StatusBar statusBar;
    FigureDialog dialog;

    public void writePosition(String s) {
        //delegation
        statusBar.writePosition(s);
    }
    DrawerFrame() {
        setTitle("Drawer");

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setSize(screenHeight*2/3, screenWidth*2/3);
        setLocation(screenWidth/6, screenHeight/6);




        //icon
        Image img = tk.getImage("src/img/main.jpg");
        setIconImage(img);

        Container container = this.getContentPane();

        statusBar = new StatusBar();
        container.add(statusBar, "South");

        canvas = new DrawerView(this);
        container.add(canvas, "Center");

        JScrollPane sp = new JScrollPane(canvas);
        container.add(sp,"Center");


        //Page Down Key for Scroll Bar
        sp.registerKeyboardAction(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JScrollBar scrollBar = sp.getVerticalScrollBar();
                        scrollBar.setValue(scrollBar.getValue() + scrollBar.getBlockIncrement());
                    }
                }
                , KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, 0)
                , JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        //Page Up key for Scroll Bar
        sp.registerKeyboardAction(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JScrollBar scrollBar = sp.getVerticalScrollBar();
                        scrollBar.setValue(scrollBar.getValue() - scrollBar.getBlockIncrement());
                    }
                }
                , KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, 0)
                , JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        //Left Scroll
        sp.registerKeyboardAction(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JScrollBar scrollBar = sp.getHorizontalScrollBar();
                        scrollBar.setValue(scrollBar.getValue() + scrollBar.getBlockIncrement());
                    }
                }
                , KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, InputEvent.CTRL_MASK)
                , JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        //Right Scroll
        sp.registerKeyboardAction(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JScrollBar scrollBar = sp.getHorizontalScrollBar();
                        scrollBar.setValue(scrollBar.getValue() - scrollBar.getBlockIncrement());
                    }
                }
                , KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, InputEvent.CTRL_MASK)
                , JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        //Resizing height
        sp.registerKeyboardAction(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.increaseHeight();
                    }
                }
                , KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, InputEvent.ALT_MASK)
                , JComponent.WHEN_IN_FOCUSED_WINDOW
        );

        //Resizing width
        sp.registerKeyboardAction(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        canvas.increaseWidth();
                    }
                }
                , KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, InputEvent.ALT_MASK)
                , JComponent.WHEN_IN_FOCUSED_WINDOW
        );



        JToolBar selectToolBar = new JToolBar();
        selectToolBar.add(canvas.getPointAction());
        selectToolBar.add(canvas.getBoxAction());
        selectToolBar.add(canvas.getLineAction());
        selectToolBar.add(canvas.getCircleAction());
        selectToolBar.add(canvas.getTVAction());
        selectToolBar.add(canvas.getKiteAction());

        container.add(selectToolBar,BorderLayout.NORTH);


        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Dimension sz = canvas.getSize();
                String s = "" + sz.width + " X " +  sz.height + "px";
                statusBar.writeSize(s);
            }
        });

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

        newFile.setIcon(new ImageIcon("src/img/new.gif"));
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
        openFile.setIcon(new ImageIcon("src/img/open.gif"));

        //lambda expression
        openFile.addActionListener( (e) ->
                System.out.println("open (o)")
        );

        JMenuItem saveFile = new JMenuItem("Save (S)");
        fileMenu.add(saveFile);
        saveFile.setMnemonic('S');
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        saveFile.setIcon(new ImageIcon("src/img/save.gif"));


        JMenuItem saveAs = new JMenuItem("Save As (A)");
        fileMenu.add(saveAs);
        saveAs.setMnemonic('A');
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        saveAs.setIcon(new ImageIcon("src/img/save.gif"));
        fileMenu.addSeparator();

        JMenuItem exitFile = new JMenuItem("Exit (E)");
        fileMenu.add(exitFile);
        exitFile.addActionListener(e ->
                System.exit(0));

        exitFile.setMnemonic('E');
        exitFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        exitFile.setIcon(new ImageIcon("src/img/ball.gif"));

        exitFile.addActionListener(new ActionListener() { //Even Handling for exit
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JMenu figureMenu = new JMenu("Figure(F)");
        menus.add(figureMenu);

        JMenuItem point = new JMenuItem(canvas.getPointAction());
        figureMenu.add(point);

        JMenuItem box = new JMenuItem(canvas.getBoxAction());
        figureMenu.add(box);

        JMenuItem line = new JMenuItem(canvas.getLineAction());
        figureMenu.add(line);

        JMenuItem circle = new JMenuItem(canvas.getCircleAction());
        figureMenu.add(circle);

        JMenuItem tv = new JMenuItem(canvas.getTVAction());
        figureMenu.add(tv);

        JMenuItem kite = new JMenuItem(canvas.getKiteAction());
        figureMenu.add(kite);


        //Tool Menu
        JMenu toolMenu = new JMenu("Tool(T)");
        menus.add(toolMenu);

        JMenuItem modalTool = new JMenuItem("Modal(M)");
        toolMenu.add(modalTool);
        modalTool.addActionListener((e) -> {
                    if(dialog == null) {
                        dialog = new FigureDialog("Figure Dialog",canvas);
                    }
                    dialog.setModal(true);
                    dialog.setVisible(true);
                });

        JMenuItem modalessTool = new JMenuItem("Modaless(M)");
        toolMenu.add(modalessTool);
        modalessTool.addActionListener((e) -> {
            if(dialog == null) {
                dialog = new FigureDialog("Figure Dialog",canvas);
            }
            dialog.setModal(false);
            dialog.setVisible(true);
        });






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

    public void writeFigureType(String point) {
        statusBar.writeFigureType(point);
    }
}
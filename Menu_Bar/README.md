
# MenuBar

The JMenuBar class is used to display menubar on the window or frame. It may have several menus.

The object of JMenu class is a pull down menu component which is displayed from the menu bar. It inherits the JMenuItem class.


The object of JMenuItem class adds a simple labeled menu item. The items used in a menu must belong to the JMenuItem or any of its subclass.


## Declaration 
```java
JMenuBar menus = new JMenuBar();  //create menuBar
setJMenuBar(menus);
```

```java

 //menu create
        JMenu fileMenu = new JMenu("File(F)");
        menus.add(fileMenu); //menus is a menu-bar (for files menu)

        //Adding items to menu
        JMenuItem newFile = new JMenuItem("New File");
        fileMenu.add(newFile);
        
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
        exitFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

```

# Result

![App Screenshot](/Menu_Bar/src/MenuBar.png)




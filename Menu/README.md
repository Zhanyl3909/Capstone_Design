
# Menu


### Create a MenuBar

```java
JMenuBar menus = new JMenuBar();  //create menu bar
setJMenuBar(menus);  //set
```

### Create Menu

```java
JMenu fileMenu = new JMenu("File(F)");
menus.add(fileMenu); //add individual menu to MENUBAR
```

### Create Menu Item (Drop-Down)

```java
JMenuItem newFile = new JMenuItem("new file (N)"); // newFile is "fileMenu"s item
fileMenu.add(newFile); //adding newFile item to parent(fileMenu) menu
```

### ActionListener

it respond, when click to certain item

```java
newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New File (N)");
            }
        });
```

```java
//lambda expression
     exitFile.addActionListener(e ->
                System.exit(0));
```

### Shortcuts

 "Open" and set the mnemonic to the letter 'O', which can be used as a keyboard shortcut to click the button.

```java
openFile.setMnemonic('O');
openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
```

### Set Icon

```java
openFile.setIcon(new ImageIcon("src/openFile.jpg")); //path
```






# Result

![App Screenshot](/Menu/src/menu-updated.png)




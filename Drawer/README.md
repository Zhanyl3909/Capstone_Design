
# Drawer

```
 //JFrame = a  GUI window to add components to

        JFrame frame = new JFrame();  //creates a frame
        frame.setTitle("Drawer");  //setting  title of the frame
        frame.setSize(420, 420); //sets the x-demension, and y-demention of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        frame.setVisible(true);  //make frame visible
        frame.setResizable(true); //frame might be resized (depending boolean) false - for preventing

        ImageIcon image = new ImageIcon("logo.png");  //create an ImageIcon
        frame.setIconImage(image.getImage()); //change icon of frame
        frame.getContentPane().setBackground(new Color(171,219,227));;  //chagne color of background
    }

```

# Result

![App Screenshot](/Users/zhanylai11/Pictures/drawer02.png)


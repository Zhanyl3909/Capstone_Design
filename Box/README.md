# Box 


## Update PaintComponent

```java
public void paintComponent(Graphics g) {
       super.paintComponent(g);

       for(int i=0; i<nBox; i++) {

           int minX = Math.min(boxes[i].x1, boxes[i].x2);
           int minY = Math.min(boxes[i].y1,boxes[i].y2);
           int width = Math.abs(boxes[i].x2-boxes[i].x1);
           int height = Math.abs(boxes[i].y2-boxes[i].y1);
           g.drawRect(minX,minY,width,height);
       }

     }
```

## Result

![App Screenshot](/Box/src/box_01.png)

![App Screenshot](/Box/src/box_02.png)




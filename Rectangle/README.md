# Rectangle

### Class Graphics

Allow an application to draw onto components that are realized on various devices, as well as onto off-screen images

### Draw Rectangle Method

```java

drawRect(int x, int y, int width, int height)
```

---

### MouseListener Interface

The Java MouseListener is notified whenever you change the state of mouse. It is notified against MouseEvent. The MouseListener interface is found in `java.awt.event` package. It has five methods.

```java
public abstract void mouseClicked(MouseEvent e);  
public abstract void mouseEntered(MouseEvent e);  
public abstract void mouseExited(MouseEvent e);  
public abstract void mousePressed(MouseEvent e);  
public abstract void mouseReleased(MouseEvent e);
```

### MouseMotionListener Interface

`extends [EventListener](https://docs.oracle.com/javase/8/docs/api/java/util/EventListener.html)`

```java
void mouseDragged(MouseEvent e)
//Invoked when a mouse button is pressed on a component and then dragged.
void	mouseMoved(MouseEvent e)
//Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed.
```

### Parameters

`x` - the *x* coordinate.

`y` - the *y* coordinate.

`width` - the width of the clipping rectangle.

`height` - the height of the clipping rectangle.


# Result

![App Screenshot](/Rectangle/src/rectangle.png)

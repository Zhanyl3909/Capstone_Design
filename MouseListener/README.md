
# MouseListener

MouseListener and MouseMotionListener is an interface in java.awt.event package . 

## Mouse events

마우스를 조작할때 호출되는 이벤트 핸들러들 덩의 

```java
public interface MouseListener {
 public void mouseClicked(MouseEvent e);
 public void mousePressed(MouseEvent e);
 public void mouseReleased(MouseEvent e);
 public void mouseEntered(MouseEvent e);
 public void mouseExited(MouseEvent e);

}
```

마우스를 움직일때 호출되는 이벤트 핸들러들 정의

```java
public interface MouseMotionLisstener {
 public void mouseDragged(MouseEvent e);
 public void mouseMoved(MouseEvent e);
}
```

윈도의 상태 변화와 관련된 이벤트핸들러들 정의

```java
public interface WindowListener {
	public void windowOpened(WindowEvent e);
	public void windowClosing(WindowEvent e);
	public void windowClosed(WindowEvent e);
	public void windowConified(WindowEvent e);
	public void windowDeconified(WindowEvent e);
	public void windowActivated(WindowEvent e);
	public void windowDeactivated(WindowEvent e);
}
```

버튼을 클릭할때 호출되는 이벤트핸들러 정의

```java
public interface ActionsListener {
	public void actionPerformed(ActionEvent e);
}
```

키보드를 누를때 호출되는 이벤트핸들러 정의

```java
	public interface KeyListener {
			public void keyTyped(KeyEvent e);
			public void keyPressed(KeyEvent e);
			public void keyReleased(KeyEvent e);
}
```

Scroll-bar 조작할때 호출되는 이벤트핸들러 정의

```java
public interface AdjustmentListener {
	 public void adjustmentValueChanged(AdjustmentEvent e);
}
```

텍스트에 입력할때 호출되는 이벤트핸들러 정의

```java
public interface TextListener {
	 public void textValueChanged(TextEvent e);
}
```

체크박스나 리스트의 상태 변화시 호출되는 이벤트핸들러 정의

```java
public interface ItemListener {
	void itemStateChanged(ItemEvent e);
}
```

윈도가 활성화 되거나 비활성화 될때 호출되는 이벤트핸들러 정의

```java
public interface FocusListener {
	public void focusGained(FocusEvent e);
	public void focusLost(FocusEvent e);
}
```

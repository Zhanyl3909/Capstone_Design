import javax.swing.*;

class MainPopup extends Popup {


    MainPopup(DrawerView view) {

        super("figure");


        JMenuItem pointItem = new JMenuItem(view.getPointAction());
        popupPtr.add(pointItem);


        JMenuItem boxItem = new JMenuItem(view.getBoxAction());
        popupPtr.add(boxItem);

        JMenuItem circleItem = new JMenuItem(view.getCircleAction());
        popupPtr.add(circleItem);

        JMenuItem lineItem = new JMenuItem(view.getLineAction());
        popupPtr.add(lineItem);
    }

}



import javax.swing.*;

class MainPopup extends Popup {


    MainPopup(DrawerView view) {

        super("figure");


        JMenuItem pointItem = new JMenuItem("Point(P)");
        popupPtr.add(pointItem);
        pointItem.addActionListener( (evt) ->
                view.setWhatToDraw(DrawerView.ID_POINT));


        JMenuItem boxItem = new JMenuItem(view.getBoxAction());
        popupPtr.add(boxItem);

        JMenuItem lineItem = new JMenuItem("Line(L)");
        popupPtr.add(lineItem);
        lineItem.addActionListener( (evt) ->
                view.setWhatToDraw(DrawerView.ID_LINE));

        JMenuItem circleItem = new JMenuItem("Circle(C)");
        popupPtr.add(circleItem);
        circleItem.addActionListener( (evt) ->
                view.setWhatToDraw(DrawerView.ID_CIRCLE));
    }

}



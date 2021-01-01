// Drag Class
// imported libraries
import java.awt.Point;
import java.awt.event.*;
import javax.swing.JFrame;

// class to create function to drag the form on the screen
public class Drag extends MouseAdapter{
    private final JFrame frame;
    private Point mouseDownCompCoords = null;

    public Drag(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }
}
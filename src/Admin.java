// Admin Page Class
// imported libraries
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin extends JFrame{
    
    private final Action action;
    private final JPanel panel;
    private final JLabel[] label;
    private final Color color1, color2, color3;
    private final Font font;
    
    // the class constructor
    public Admin(){
        
        // form implementation
        this.setLocation(500, 120);
        this.setSize(350, 400);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        action = new Action();
        panel = new JPanel();
        label = new JLabel[10];
        color1 = new Color(60, 60, 60);
        color2 = new Color(30, 30, 30);
        color3 = new Color(15, 15, 15);
        font = new Font("seirf", Font.BOLD, 22);
        
        // background implementation
        panel.setBackground(color2);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        this.add(panel);
        
        // labels implementation
        label[0] = new JLabel("  Admin");
        label[0].setBackground(color3);
        label[0].setOpaque(true);
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(0, 0, 120, 35);
        label[0].setFont(new Font("seirf", Font.BOLD, 30));
        panel.add(label[0]);
       
        label[1] = new JLabel("   X");
        label[1].setBackground(color3);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(300, 0, 50, 35);
        label[1].setFont(font);
        panel.add(label[1]);
        label[1].addMouseListener(action);
        
        label[2] = new JLabel("  ---");
        label[2].setBackground(color3);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(250, 0, 50, 35);
        label[2].setFont(font);
        panel.add(label[2]);
        label[2].addMouseListener(action);
        
        label[3] = new JLabel("        Employees");
        label[3].setBackground(color3);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(80, 100, 200, 30);
        label[3].setFont(font);
        panel.add(label[3]);
        label[3].addMouseListener(action);
        
        label[4] = new JLabel("           Books");
        label[4].setBackground(color3);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(80, 150, 200, 30);
        label[4].setFont(font);
        panel.add(label[4]);
        label[4].addMouseListener(action);
        
        label[5] = new JLabel("           Stock");
        label[5].setBackground(color3);
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setBounds(80, 200, 200, 30);
        label[5].setFont(font);
        panel.add(label[5]);
        label[5].addMouseListener(action);
        
        label[6] = new JLabel("           Profile");
        label[6].setBackground(color3);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(80, 250, 200, 30);
        label[6].setFont(font);
        panel.add(label[6]);
        label[6].addMouseListener(action);
        
        label[7] = new JLabel("           Logout");
        label[7].setBackground(color3);
        label[7].setOpaque(true);
        label[7].setForeground(Color.WHITE);
        label[7].setBounds(80, 300, 200, 30);
        label[7].setFont(font);
        panel.add(label[7]);
        label[7].addMouseListener(action);
        
        label[8] = new JLabel("");
        label[8].setBackground(color3);
        label[8].setOpaque(true);
        label[8].setForeground(Color.WHITE);
        label[8].setBounds(120, 0, 130, 35);
        label[8].setFont(new Font("seirf", Font.BOLD, 25));
        panel.add(label[8]);
       
        Drag frameDragListener = new Drag(this);
        label[0].addMouseListener(frameDragListener);
        label[0].addMouseMotionListener(frameDragListener);
        label[8].addMouseListener(frameDragListener);
        label[8].addMouseMotionListener(frameDragListener);
    }
    
    // function to minimize the form
    private void minimize(){
        this.setState(JFrame.ICONIFIED);
    }
    
    // function to go to employee form
    private void toemployee(){
        this.setVisible(false);
        Employee employee = new Employee();
        employee.setVisible(true);
        employee.username(label[8].getText());
    }
    
    // function to go to books form
    private void tobooks(){
        this.setVisible(false);
        Books book = new Books();
        book.setVisible(true);
        book.username(label[8].getText());
    }
    
    // function to go to stock form
    private void tostock(){
        this.setVisible(false);
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.username(label[8].getText());
    }
    
    // function to go to profile form
    private void toprofile(){
        this.setVisible(false);
        Profile profile = new Profile();
        profile.setVisible(true);
        profile.username(label[8].getText(), "admin");
        profile.useradmin();
    }
    
    // username function to get the username from login
    public void username(String user){
        label[8].setText(user);
    }
    
    // function to go to home form
    private void tohome(){
        this.setVisible(false);
        Home home = new Home();
        home.setVisible(true);
    }
    
    // private claas to contain mouse actions
    private class Action implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == label[1]) {
                System.exit(0);
            }
            if (me.getSource() == label[2]) {
                minimize();
            }
            if (me.getSource() == label[3]) {
                toemployee();
            }
            if (me.getSource() == label[4]) {
                tobooks();
            }
            if (me.getSource() == label[5]) {
                tostock();
            }
            if (me.getSource() == label[6]) {
                toprofile();
            }
            if (me.getSource() == label[7]) {
                tohome();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (me.getSource() == label[1]) {
                label[1].setBackground(Color.RED.brighter());
            }
            if (me.getSource() == label[2]) {
                label[2].setBackground(color1.brighter());
            }
            if (me.getSource() == label[3]) {
                label[3].setBackground(color1.brighter());
            }
            if (me.getSource() == label[4]) {
                label[4].setBackground(color1.brighter());
            }
            if (me.getSource() == label[5]) {
                label[5].setBackground(color1.brighter());
            }
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1.brighter());
            }
            if (me.getSource() == label[7]) {
                label[7].setBackground(color1.brighter());
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (me.getSource() == label[1]) {
                label[1].setBackground(Color.RED.darker());
            }
            if (me.getSource() == label[2]) {
                label[2].setBackground(color1);
            }
            if (me.getSource() == label[3]) {
                label[3].setBackground(color1);
            }
            if (me.getSource() == label[4]) {
                label[4].setBackground(color1);
            }
            if (me.getSource() == label[5]) {
                label[5].setBackground(color1);
            }
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1);
            }
            if (me.getSource() == label[7]) {
                label[7].setBackground(color1);
            }
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if (me.getSource() == label[1]) {
                label[1].setBackground(Color.RED.darker());
            }
            if (me.getSource() == label[2]) {
                label[2].setBackground(color1);
            }
            if (me.getSource() == label[3]) {
                label[3].setBackground(color1);
            }
            if (me.getSource() == label[4]) {
                label[4].setBackground(color1);
            }
            if (me.getSource() == label[5]) {
                label[5].setBackground(color1);
            }
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1);
            }
            if (me.getSource() == label[7]) {
                label[7].setBackground(color1);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (me.getSource() == label[1]) {
                label[1].setBackground(color3);
            }
            if (me.getSource() == label[2]) {
                label[2].setBackground(color3);
            }
            if (me.getSource() == label[3]) {
                label[3].setBackground(color3);
            }
            if (me.getSource() == label[4]) {
                label[4].setBackground(color3);
            }
            if (me.getSource() == label[5]) {
                label[5].setBackground(color3);
            }
            if (me.getSource() == label[6]) {
                label[6].setBackground(color3);
            }
            if (me.getSource() == label[7]) {
                label[7].setBackground(color3);
            }
        }
    }
}

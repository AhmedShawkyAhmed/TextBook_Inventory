// the Profile Page Class
// imported libraries
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Profile extends JFrame{

    private final Action action;
    private final JPanel panel;
    private final JLabel[] label;
    private final Color color1, color2, color3;
    private final Font font;
    private Connection connection;
    private PreparedStatement preparedstatement;
    private ResultSet resultset;
    private String sql;
    
    // the class constructor
    public Profile(){
        
        // form implementation
        this.setLocation(400, 100);
        this.setSize(550, 500);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        action = new Action();
        panel = new JPanel();
        label = new JLabel[20];
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
        label[0] = new JLabel("  Profile");
        label[0].setBackground(color3);
        label[0].setOpaque(true);
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(0, 0, 450, 35);
        label[0].setFont(new Font("seirf", Font.BOLD, 30));
        panel.add(label[0]);
       
        label[1] = new JLabel("   X");
        label[1].setBackground(color3);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(500, 0, 50, 35);
        label[1].setFont(font);
        panel.add(label[1]);
        label[1].addMouseListener(action);
        
        label[2] = new JLabel("  ---");
        label[2].setBackground(color3);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(450, 0, 50, 35);
        label[2].setFont(font);
        panel.add(label[2]);
        label[2].addMouseListener(action);
        
        label[3] = new JLabel("  ID:");
        label[3].setBackground(color2);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(50, 100, 150, 30);
        label[3].setFont(font);
        panel.add(label[3]);
        
        label[4] = new JLabel("  Name:");
        label[4].setBackground(color2);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(50, 150, 150, 30);
        label[4].setFont(font);
        panel.add(label[4]);
        
        label[5] = new JLabel("  UserName:");
        label[5].setBackground(color2);
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setBounds(50, 200, 150, 30);
        label[5].setFont(font);
        panel.add(label[5]);
        
        label[6] = new JLabel("  Password:");
        label[6].setBackground(color2);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(50, 250, 150, 30);
        label[6].setFont(font);
        panel.add(label[6]);
        
        label[7] = new JLabel("  Phone:");
        label[7].setBackground(color2);
        label[7].setOpaque(true);
        label[7].setForeground(Color.WHITE);
        label[7].setBounds(50, 300, 150, 30);
        label[7].setFont(font);
        panel.add(label[7]);
        
        label[8] = new JLabel("  Type:");
        label[8].setBackground(color2);
        label[8].setOpaque(true);
        label[8].setForeground(Color.WHITE);
        label[8].setBounds(50, 350, 150, 30);
        label[8].setFont(font);
        panel.add(label[8]);
        
        label[9] = new JLabel("  Salary:");
        label[9].setBackground(color2);
        label[9].setOpaque(true);
        label[9].setForeground(Color.WHITE);
        label[9].setBounds(50, 400, 150, 30);
        label[9].setFont(font);
        panel.add(label[9]);
        
        label[10] = new JLabel("");
        label[10].setBackground(color1);
        label[10].setOpaque(true);
        label[10].setForeground(Color.WHITE);
        label[10].setBounds(210, 100, 250, 30);
        label[10].setFont(font);
        panel.add(label[10]);
        
        label[11] = new JLabel("");
        label[11].setBackground(color1);
        label[11].setOpaque(true);
        label[11].setForeground(Color.WHITE);
        label[11].setBounds(210, 150, 250, 30);
        label[11].setFont(font);
        panel.add(label[11]);
        
        label[12] = new JLabel("");
        label[12].setBackground(color1);
        label[12].setOpaque(true);
        label[12].setForeground(Color.WHITE);
        label[12].setBounds(210, 200, 250, 30);
        label[12].setFont(font);
        panel.add(label[12]);
        
        label[13] = new JLabel("");
        label[13].setBackground(color1);
        label[13].setOpaque(true);
        label[13].setForeground(Color.WHITE);
        label[13].setBounds(210, 250, 250, 30);
        label[13].setFont(font);
        panel.add(label[13]);
        
        label[14] = new JLabel("");
        label[14].setBackground(color1);
        label[14].setOpaque(true);
        label[14].setForeground(Color.WHITE);
        label[14].setBounds(210, 300, 250, 30);
        label[14].setFont(font);
        panel.add(label[14]);
        
        label[15] = new JLabel("");
        label[15].setBackground(color1);
        label[15].setOpaque(true);
        label[15].setForeground(Color.WHITE);
        label[15].setBounds(210, 350, 250, 30);
        label[15].setFont(font);
        panel.add(label[15]);
        
        label[16] = new JLabel("");
        label[16].setBackground(color1);
        label[16].setOpaque(true);
        label[16].setForeground(Color.WHITE);
        label[16].setBounds(210, 400, 250, 30);
        label[16].setFont(font);
        panel.add(label[16]);
        
        label[17] = new JLabel("        Back");
        label[17].setBackground(color3);
        label[17].setOpaque(true);
        label[17].setForeground(Color.WHITE);
        label[17].setBounds(200, 450, 150, 30);
        label[17].setFont(font);
        panel.add(label[17]);
        label[17].addMouseListener(action);
        
        Drag frameDragListener = new Drag(this);
        label[0].addMouseListener(frameDragListener);
        label[0].addMouseMotionListener(frameDragListener);
    }
    
    // username function to get the username from login 
    void username(String user, String type){
        label[12].setText(user);
        label[15].setText(type);
    }
    
    // useradmin function to get admin data from database
    public void useradmin(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT * FROM admin WHERE username = ?";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,label[12].getText());
            resultset = preparedstatement.executeQuery();
            if(resultset.next()){
                label[10].setText(resultset.getString(1));
                label[11].setText(resultset.getString(2));
                label[12].setText(resultset.getString(3));
                label[13].setText(resultset.getString(4));
                label[14].setText(resultset.getString(5));
                label[15].setText(resultset.getString(6));
                label[16].setText(resultset.getString(7));
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // userseller function to get seller data from database
    public void userseller(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT * FROM seller WHERE username = ?";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,label[12].getText());
            resultset = preparedstatement.executeQuery();
            if(resultset.next()){
                label[10].setText(resultset.getString(1));
                label[11].setText(resultset.getString(2));
                label[12].setText(resultset.getString(3));
                label[13].setText(resultset.getString(4));
                label[14].setText(resultset.getString(5));
                label[15].setText(resultset.getString(6));
                label[16].setText(resultset.getString(7));
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // function to minimize the form
    private void minimize(){
        this.setState(JFrame.ICONIFIED);
    }
    
    // function to go back to admin form
    private void backtoadmin(){
        Admin admin = new Admin();
        admin.setVisible(true);
        this.setVisible(true);
        this.setVisible(false);
        admin.username(label[12].getText());
    }
    
    // function to go back to seller form
    private void backtoseller(){
        Seller seller = new Seller();
        seller.setVisible(true);
        this.setVisible(true);
        this.setVisible(false);
        seller.username(label[12].getText());
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
            if (me.getSource() == label[17]) {
                if (label[15].getText().equals("admin")) {
                    backtoadmin();
                }
                else if (label[15].getText().equals("seller")) {
                    backtoseller();
                }
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
            if (me.getSource() == label[17]) {
                label[17].setBackground(color1.brighter());
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
            if (me.getSource() == label[17]) {
                label[17].setBackground(color1);
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
            if (me.getSource() == label[17]) {
                label[17].setBackground(color1);
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
            if (me.getSource() == label[17]) {
                label[17].setBackground(color3);
            }
        }
    }
}

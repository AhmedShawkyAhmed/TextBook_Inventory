// Login Page Class
// imported libraries
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame{

    private final Action action;
    private final JPanel panel;
    private final JLabel[] label;
    private final JTextField textfield0;
    private final JPasswordField passwordfield;
    private final JRadioButton radiobutton0, radiobutton1;
    private final ButtonGroup buttongroup;
    private final Color color1, color2, color3;
    private final Font font;
    private Connection connection;
    private PreparedStatement preparedstatement;
    private ResultSet resultset;
    private String sql;

    // the class constructor
    public Login(){

        // form implementation
        this.setLocation(500, 100);
        this.setSize(450, 450);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        action = new Action();
        panel = new JPanel();
        label = new JLabel[10];
        textfield0 = new JTextField();
        passwordfield = new JPasswordField();
        buttongroup = new ButtonGroup();
        color1 = new Color(60, 60, 60);
        color2 = new Color(30, 30, 30);
        color3 = new Color(15, 15, 15);
        font = new Font("seirf", Font.BOLD, 22);

        // background implementation
        panel.setBackground(color2);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        this.add(panel);

        // radio buttons implementation
        radiobutton0 = new JRadioButton("Admin");
        radiobutton0.setBackground(color2);
        radiobutton0.setBounds(110, 300, 100, 30);
        radiobutton0.setForeground(Color.WHITE);
        radiobutton0.setFont(font);
        buttongroup.add(radiobutton0);
        panel.add(radiobutton0);

        radiobutton1 = new JRadioButton("Seller");
        radiobutton1.setBackground(color2);
        radiobutton1.setBounds(220, 300, 100, 30);
        radiobutton1.setForeground(Color.WHITE);
        radiobutton1.setFont(font);
        buttongroup.add(radiobutton1);
        panel.add(radiobutton1);

        // text field implementation
        textfield0.setBounds(100, 140, 250, 30);
        textfield0.setFont(font);
        panel.add(textfield0);

        passwordfield.setBounds(100, 220, 250, 30);
        passwordfield.setFont(font);
        panel.add(passwordfield);

        // labels implementation
        label[0] = new JLabel("  Login");
        label[0].setBackground(color3);
        label[0].setOpaque(true);
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(0, 0, 350, 35);
        label[0].setFont(new Font("seirf", Font.BOLD, 30));
        panel.add(label[0]);

        label[1] = new JLabel("   X");
        label[1].setBackground(color3);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(400, 0, 50, 35);
        label[1].setFont(font);
        panel.add(label[1]);
        label[1].addMouseListener(action);

        label[2] = new JLabel("  ---");
        label[2].setBackground(color3);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(350, 0, 50, 35);
        label[2].setFont(font);
        panel.add(label[2]);
        label[2].addMouseListener(action);

        label[3] = new JLabel("User Name");
        label[3].setBackground(color2);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(100, 100, 150, 30);
        label[3].setFont(font);
        panel.add(label[3]);

        label[4] = new JLabel("Password");
        label[4].setBackground(color2);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(100, 180, 150, 30);
        label[4].setFont(font);
        panel.add(label[4]);

        label[5] = new JLabel("Type");
        label[5].setBackground(color2);
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setBounds(100, 260, 150, 30);
        label[5].setFont(font);
        panel.add(label[5]);

        label[6] = new JLabel("         Login");
        label[6].setBackground(color3);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(150, 350, 160, 30);
        label[6].setFont(font);
        panel.add(label[6]);
        label[6].addMouseListener(action);

        label[7] = new JLabel("         Back");
        label[7].setBackground(color3);
        label[7].setOpaque(true);
        label[7].setForeground(Color.WHITE);
        label[7].setBounds(150, 390, 160, 30);
        label[7].setFont(font);
        panel.add(label[7]);
        label[7].addMouseListener(action);

        Drag frameDragListener = new Drag(this);
        label[0].addMouseListener(frameDragListener);
        label[0].addMouseMotionListener(frameDragListener);
    }

    // back function to retun to Home Page
    private void back(){
        this.setVisible(false);
        Home home = new Home();
        home.setVisible(true);
    }

    // to admin function to go to Admin form after login
    private void toadmin(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT * FROM admin WHERE username = ? and password = ?";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,textfield0.getText());
            preparedstatement.setString(2,passwordfield.getText());
            resultset = preparedstatement.executeQuery();
            if(resultset.next()){
                String user = textfield0.getText();
                Admin admin = new Admin();
                admin.setVisible(true);
                this.setVisible(true);
                this.setVisible(false);
                admin.username(user);
            }else{
                JOptionPane.showMessageDialog(null, "NO User Found!");
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // to seller function to go to Seller form after login
    private void toseller(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT * FROM seller WHERE username = ? and password = ?";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,textfield0.getText());
            preparedstatement.setString(2,passwordfield.getText());
            resultset = preparedstatement.executeQuery();
            if(resultset.next()){
                String user = textfield0.getText();
                Seller seller = new Seller();
                seller.setVisible(true);
                this.setVisible(true);
                this.setVisible(false);
                seller.username(user);
            }else{
                JOptionPane.showMessageDialog(null, "NO User Found!");
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
            if (me.getSource() == label[6]) {
                if (radiobutton0.isSelected()) {
                    toadmin();
                }else if (radiobutton1.isSelected()) {
                    toseller();
                }
            }
            if (me.getSource() == label[7]) {
                back();
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
            if (me.getSource() == label[6]) {
                label[6].setBackground(color3);
            }
            if (me.getSource() == label[7]) {
                label[7].setBackground(color3);
            }
        }
    }
}

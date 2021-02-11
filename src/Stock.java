// The Stock Page Class
// imported libraries
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.logging.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Stock extends JFrame{
    
    private final Action action;
    private final JPanel panel;
    private final JLabel[] label;
    private final JTextField textfield0, textfield1;
    private final JRadioButton radiobutton0, radiobutton1;
    private final ButtonGroup buttongroup;
    private final JTable table;
    private final JScrollPane scrollPane;
    private final Color color1, color2, color3;
    private final Font font;
    private Connection connection;
    private PreparedStatement preparedstatement;
    private ResultSet resultset;
    private String sql;
    
    // the class constructor
    public Stock(){
        
        // form implementation
        this.setLocation(160, 60);
        this.setUndecorated(true);
        this.setSize(1080, 650);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        action = new Action();
        panel = new JPanel();
        label = new JLabel[10];
        textfield0 = new JTextField();
        textfield1 = new JTextField();
        buttongroup = new ButtonGroup();
        table = new JTable();
        color1 = new Color(60, 60, 60);
        color2 = new Color(30, 30, 30);
        color3 = new Color(15, 15, 15);
        font = new Font("seirf", Font.BOLD, 22);
        
        // call function
        view();
        
        // background implementation
        panel.setBackground(color2);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        this.add(panel);
        
        // scrollPane implementation
        panel.add(table);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(40,140,800,460);
        scrollPane.setEnabled(false);
        panel.add(scrollPane);
        
        // radio buttons implementation
        radiobutton0 = new JRadioButton("Code");
        radiobutton0.setBackground(color2);
        radiobutton0.setBounds(865, 190, 90, 30);
        radiobutton0.setForeground(Color.WHITE);
        radiobutton0.setFont(font);
        buttongroup.add(radiobutton0);
        panel.add(radiobutton0);
        
        radiobutton1 = new JRadioButton("Name");
        radiobutton1.setBackground(color2);
        radiobutton1.setBounds(960, 190, 90, 30);
        radiobutton1.setForeground(Color.WHITE);
        radiobutton1.setFont(font);
        buttongroup.add(radiobutton1);
        panel.add(radiobutton1);
        
        // text field implementation
        textfield0.setBounds(40, 70, 800, 30);
        textfield0.setFont(font);
        panel.add(textfield0);
        
        textfield1.setBounds(860, 420, 190, 30);
        textfield1.setFont(font);
        panel.add(textfield1);
        
        // labels implementation
        label[0] = new JLabel("          Search");
        label[0].setBackground(color3);
        label[0].setOpaque(true);
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(860, 70, 190, 30);
        label[0].setFont(font);
        panel.add(label[0]);
        label[0].addMouseListener(action);
        
        label[1] = new JLabel("      New Search");
        label[1].setBackground(color3);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(860, 140, 190, 30);
        label[1].setFont(font);
        panel.add(label[1]);
        label[1].addMouseListener(action);
        
        label[2] = new JLabel("     Add to Store");
        label[2].setBackground(color3);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(860, 470, 190, 30);
        label[2].setFont(font);
        panel.add(label[2]);
        label[2].addMouseListener(action);
        
        label[3] = new JLabel("      Print Report");
        label[3].setBackground(color3);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(860, 520, 190, 30);
        label[3].setFont(font);
        panel.add(label[3]);
        label[3].addMouseListener(action);
        
        label[4] = new JLabel("           Back");
        label[4].setBackground(color3);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(860, 570, 190, 30);
        label[4].setFont(font);
        panel.add(label[4]);
        label[4].addMouseListener(action);
        
        label[5] = new JLabel("   X");
        label[5].setBackground(color3);
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setBounds(1030, 0, 50, 35);
        label[5].setFont(font);
        panel.add(label[5]);
        label[5].addMouseListener(action);
        
        label[6] = new JLabel("  ---");
        label[6].setBackground(color3);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(980, 0, 50, 35);
        label[6].setFont(font);
        panel.add(label[6]);
        label[6].addMouseListener(action);
        
        label[7] = new JLabel("  Stock");
        label[7].setBackground(color3);
        label[7].setOpaque(true);
        label[7].setForeground(Color.WHITE);
        label[7].setBounds(0, 0, 120, 35);
        label[7].setFont(new Font("seirf", Font.BOLD, 30));
        panel.add(label[7]);
        
        label[8] = new JLabel("");
        label[8].setBackground(color3);
        label[8].setOpaque(true);
        label[8].setForeground(Color.WHITE);
        label[8].setBounds(120, 0, 860, 35);
        label[8].setFont(new Font("seirf", Font.BOLD, 25));
        panel.add(label[8]);
       
        Drag frameDragListener = new Drag(this);
        label[7].addMouseListener(frameDragListener);
        label[7].addMouseMotionListener(frameDragListener);
        label[8].addMouseListener(frameDragListener);
        label[8].addMouseMotionListener(frameDragListener);
    }
    
    // function to minimize the form
    private void minimize(){
        this.setState(JFrame.ICONIFIED);
    }
    
    // function to move books from stock to store
    private void move(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            if (radiobutton0.isSelected()) {
            sql = "UPDATE books SET InStore = (InStore + ?), InStock = (InStock - ?) WHERE code = ? AND InStock >= ?";
            }
            else if(radiobutton1.isSelected()){
            sql = "UPDATE books SET InStore = (InStore + ?), InStock = (InStock - ?) WHERE name = ? AND InStock >= ?";
            }
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, textfield1.getText());
            preparedstatement.setString(2, textfield1.getText());
            preparedstatement.setString(3, textfield0.getText());
            preparedstatement.setString(4, textfield1.getText());
            if (preparedstatement.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null, "Book Transferred to Store Successfully!");
                clear();
            }else{
                JOptionPane.showMessageDialog(null, "The Entered Amount are not Avilable in The Stock!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // back function to return to admin form
    private void back(){
        Admin admin = new Admin();
        admin.setVisible(true);
        this.setVisible(true);
        this.setVisible(false);
        admin.username(label[8].getText());
    }
    
    // username function to get the username from login
    public void username(String user){
        label[8].setText(user);
    }
    
    // clear function to clear all text field after each process
    private void clear(){
        textfield0.setText("");
        textfield1.setText("");
        view();
    }
    
    // view function to view all books in the database
    private void view(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT * FROM books ORDER BY code";
            preparedstatement = connection.prepareStatement(sql);
            resultset = preparedstatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultset));
            connection.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Cannot View!"+ex.getMessage());
        }
    }
    
    // search function to search for specific book data in the database
    private void search(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            if (radiobutton0.isSelected()) {
                sql = "SELECT * FROM books WHERE code = ?";
            }
            else if(radiobutton1.isSelected()){
                sql = "SELECT * FROM books WHERE name = ?";
            }
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,textfield0.getText());
            resultset = preparedstatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultset));
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Please Select Search Method");
        }
    }
    
    // print function to print report with all books data are in the database
    private void print(){
        MessageFormat header = new MessageFormat("Book Report");
        MessageFormat footer = new MessageFormat("Book Report");
        try{
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        }catch(PrinterException ex){
            JOptionPane.showMessageDialog(null, "Cannot Print!"+ex.getMessage());
        }
    }
    
    // private claas to contain mouse actions
    private class Action implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == label[0]) {
                search();
            }
            if (me.getSource() == label[1]) {
                clear();
            }
            if (me.getSource() == label[2]) {
                move();
            }
            if (me.getSource() == label[3]) {
                print();
            }
            if (me.getSource() == label[4]) {
                back();
            }
            if (me.getSource() == label[5]) {
                System.exit(0);
            }
            if (me.getSource() == label[6]) {
                minimize();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (me.getSource() == label[0]) {
                label[0].setBackground(color1.brighter());
            }
            if (me.getSource() == label[1]) {
                label[1].setBackground(color1.brighter());
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
                label[5].setBackground(Color.RED.brighter());
            }
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1.brighter());
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (me.getSource() == label[0]) {
                label[0].setBackground(color1);
            }
            if (me.getSource() == label[1]) {
                label[1].setBackground(color1);
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
                label[5].setBackground(Color.RED.darker());
            }
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1);
            }
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if (me.getSource() == label[0]) {
                label[0].setBackground(color1);
            }
            if (me.getSource() == label[1]) {
                label[1].setBackground(color1);
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
                label[5].setBackground(Color.RED.darker());
            }
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (me.getSource() == label[0]) {
                label[0].setBackground(color3);
            }
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
        }
    }
}

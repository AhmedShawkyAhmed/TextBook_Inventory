// Books Page Class
// imported libraries
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Books extends JFrame{

    private final Action action;
    private final JPanel panel;
    private final JLabel[] label;
    private final JTextField textfield0, textfield1, textfield2, textfield3, textfield4,
            textfield5, textfield6, textfield7, textfield8, textfield9;
    private final JRadioButton radiobutton0, radiobutton1;
    private final ButtonGroup buttongroup;
    private final Color color1, color2, color3;
    private final Font font;
    private Connection connection;
    private PreparedStatement preparedstatement;
    private ResultSet resultset;
    private String sql;
    
    // the class constructor
    public Books(){
        
        // form implementation
        this.setLocation(310, 80);
        this.setSize(800, 600);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        action = new Action();
        panel = new JPanel();
        label = new JLabel[20];
        textfield0 = new JTextField();
        textfield1 = new JTextField();
        textfield2 = new JTextField();
        textfield3 = new JTextField();
        textfield4 = new JTextField();
        textfield5 = new JTextField();
        textfield6 = new JTextField();
        textfield7 = new JTextField();
        textfield8 = new JTextField();
        textfield9 = new JTextField();
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
        radiobutton0 = new JRadioButton("Code");
        radiobutton0.setBackground(color2);
        radiobutton0.setBounds(570, 130, 90, 30);
        radiobutton0.setForeground(Color.WHITE);
        radiobutton0.setFont(font);
        buttongroup.add(radiobutton0);
        panel.add(radiobutton0);
        
        radiobutton1 = new JRadioButton("Name");
        radiobutton1.setBackground(color2);
        radiobutton1.setBounds(665, 130, 90, 30);
        radiobutton1.setForeground(Color.WHITE);
        radiobutton1.setFont(font);
        buttongroup.add(radiobutton1);
        panel.add(radiobutton1);
        
        // text field implementation
        textfield0.setBounds(200, 150, 325, 30);
        textfield0.setFont(font);
        panel.add(textfield0);
        
        textfield1.setBounds(200, 200, 325, 30);
        textfield1.setFont(font);
        panel.add(textfield1);
        
        textfield2.setBounds(200, 250, 325, 30);
        textfield2.setFont(font);
        panel.add(textfield2);
        
        textfield3.setBounds(200, 300, 325, 30);
        textfield3.setFont(font);
        panel.add(textfield3);
        
        textfield4.setBounds(200, 350, 325, 30);
        textfield4.setFont(font);
        panel.add(textfield4);
        
        textfield5.setBounds(200, 400, 325, 30);
        textfield5.setFont(font);
        panel.add(textfield5);
        
        textfield6.setBounds(200, 450, 325, 30);
        textfield6.setFont(font);
        panel.add(textfield6);
        
        textfield7.setBounds(200, 500, 325, 30);
        textfield7.setFont(font);
        panel.add(textfield7);
        
        textfield8.setBounds(200, 550, 325, 30);
        textfield8.setFont(font);
        panel.add(textfield8);
        
        textfield9.setBounds(30, 70, 500, 30);
        textfield9.setFont(font);
        panel.add(textfield9);
        
        // labels implementation
        label[0] = new JLabel("  Book Code");
        label[0].setBackground(color2);
        label[0].setOpaque(true);
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(30, 150, 150, 30);
        label[0].setFont(font);
        panel.add(label[0]);
       
        label[1] = new JLabel("  Book Name");
        label[1].setBackground(color2);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(30, 200, 150, 30);
        label[1].setFont(font);
        panel.add(label[1]);
        
        label[2] = new JLabel("  Category");
        label[2].setBackground(color2);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(30, 250, 150, 30);
        label[2].setFont(font);
        panel.add(label[2]);
        
        label[3] = new JLabel("  Price");
        label[3].setBackground(color2);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(30, 300, 150, 30);
        label[3].setFont(font);
        panel.add(label[3]);
        
        label[4] = new JLabel("  Author Name");
        label[4].setBackground(color2);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(30, 350, 150, 30);
        label[4].setFont(font);
        panel.add(label[4]);
        
        label[5] = new JLabel("  Publisher");
        label[5].setBackground(color2);
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setBounds(30, 400, 150, 30);
        label[5].setFont(font);
        panel.add(label[5]);
        
        label[6] = new JLabel("  Publish Date");
        label[6].setBackground(color2);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(30, 450, 150, 30);
        label[6].setFont(font);
        panel.add(label[6]);
        
        label[7] = new JLabel("  In Store");
        label[7].setBackground(color2);
        label[7].setOpaque(true);
        label[7].setForeground(Color.WHITE);
        label[7].setBounds(30, 500, 150, 30);
        label[7].setFont(font);
        panel.add(label[7]);
        
        label[8] = new JLabel("  In Stock");
        label[8].setBackground(color2);
        label[8].setOpaque(true);
        label[8].setForeground(Color.WHITE);
        label[8].setBounds(30, 550, 150, 30);
        label[8].setFont(font);
        panel.add(label[8]);
        
        label[9] = new JLabel("           Search");
        label[9].setBackground(color3);
        label[9].setOpaque(true);
        label[9].setForeground(Color.WHITE);
        label[9].setBounds(560, 70, 200, 30);
        label[9].setFont(font);
        panel.add(label[9]);
        label[9].addMouseListener(action);
        
        label[10] = new JLabel("      New Search");
        label[10].setBackground(color3);
        label[10].setOpaque(true);
        label[10].setForeground(Color.WHITE);
        label[10].setBounds(560, 350, 200, 30);
        label[10].setFont(font);
        panel.add(label[10]);
        label[10].addMouseListener(action);
        
        label[11] = new JLabel("            Back");
        label[11].setBackground(color3);
        label[11].setOpaque(true);
        label[11].setForeground(Color.WHITE);
        label[11].setBounds(560, 550, 200, 30);
        label[11].setFont(font);
        panel.add(label[11]);
        label[11].addMouseListener(action);
        
        label[12] = new JLabel("        Add Book");
        label[12].setBackground(color3);
        label[12].setOpaque(true);
        label[12].setForeground(Color.WHITE);
        label[12].setBounds(560, 400, 200, 30);
        label[12].setFont(font);
        panel.add(label[12]);
        label[12].addMouseListener(action);
        
        label[13] = new JLabel("        Edit Book");
        label[13].setBackground(color3);
        label[13].setOpaque(true);
        label[13].setForeground(Color.WHITE);
        label[13].setBounds(560, 450, 200, 30);
        label[13].setFont(font);
        panel.add(label[13]);
        label[13].addMouseListener(action);
        
        label[14] = new JLabel("       Delete Book");
        label[14].setBackground(color3);
        label[14].setOpaque(true);
        label[14].setForeground(Color.WHITE);
        label[14].setBounds(560, 500, 200, 30);
        label[14].setFont(font);
        panel.add(label[14]);
        label[14].addMouseListener(action);
        
        label[15] = new JLabel("   X");
        label[15].setBackground(color3);
        label[15].setOpaque(true);
        label[15].setForeground(Color.WHITE);
        label[15].setBounds(750, 0, 50, 35);
        label[15].setFont(font);
        panel.add(label[15]);
        label[15].addMouseListener(action);
        
        label[16] = new JLabel("  ---");
        label[16].setBackground(color3);
        label[16].setOpaque(true);
        label[16].setForeground(Color.WHITE);
        label[16].setBounds(700, 0, 50, 35);
        label[16].setFont(font);
        panel.add(label[16]);
        label[16].addMouseListener(action);
        
        label[17] = new JLabel("  Books");
        label[17].setBackground(color3);
        label[17].setOpaque(true);
        label[17].setForeground(Color.WHITE);
        label[17].setBounds(0, 0, 130, 35);
        label[17].setFont(new Font("seirf", Font.BOLD, 30));
        panel.add(label[17]);
        
        label[18] = new JLabel("");
        label[18].setBackground(color3);
        label[18].setOpaque(true);
        label[18].setForeground(Color.WHITE);
        label[18].setBounds(130, 0, 670, 35);
        label[18].setFont(new Font("seirf", Font.BOLD, 25));
        panel.add(label[18]);
        
        Drag frameDragListener = new Drag(this);
        label[17].addMouseListener(frameDragListener);
        label[17].addMouseMotionListener(frameDragListener);
        label[18].addMouseListener(frameDragListener);
        label[18].addMouseMotionListener(frameDragListener);
    }
    
    // function to minimize the form
    private void minimize(){
        this.setState(JFrame.ICONIFIED);
    }
    
    // back function to return to admin form
    private void back(){
        Admin admin = new Admin();
        admin.setVisible(true);
        this.setVisible(true);
        this.setVisible(false);
        admin.username(label[18].getText());
    }
    
    // username function to get the username from login
    public void username(String user){
        label[18].setText(user);
    }
    
    // clear function to clear all text field after each process
    private void clear(){
        textfield0.setText("");
        textfield1.setText("");
        textfield2.setText("");
        textfield3.setText("");
        textfield4.setText("");
        textfield5.setText("");
        textfield6.setText("");
        textfield7.setText("");
        textfield8.setText("");
        textfield9.setText("");
    }
    
    // insert function to insert book data into the database
    private void insert(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "INSERT INTO books VALUES(?,?,?,?,?,?,?,?,?)";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, textfield0.getText());
            preparedstatement.setString(2, textfield1.getText());
            preparedstatement.setString(3, textfield2.getText());
            preparedstatement.setString(4, textfield3.getText());
            preparedstatement.setString(5, textfield4.getText());
            preparedstatement.setString(6, textfield5.getText());
            preparedstatement.setString(7, textfield6.getText());
            preparedstatement.setString(8, textfield7.getText());
            preparedstatement.setString(9, textfield8.getText());
            if(preparedstatement.executeUpdate()>0){
            JOptionPane.showMessageDialog(null, "Book Data Added Successfully!");
            clear();
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
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
            preparedstatement.setString(1,textfield9.getText());
            resultset = preparedstatement.executeQuery();
            if(resultset.next()){
                textfield0.setText(resultset.getString(1));
                textfield1.setText(resultset.getString(2));
                textfield2.setText(resultset.getString(3));
                textfield3.setText(resultset.getString(4));
                textfield4.setText(resultset.getString(5));
                textfield5.setText(resultset.getString(6));
                textfield6.setText(resultset.getString(7));
                textfield7.setText(resultset.getString(8));
                textfield8.setText(resultset.getString(9));
            }else{
                JOptionPane.showMessageDialog(null, "NO Book Found!");
                clear();
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Please Select Search Method");
        }
    }
    
    // update function to update specific book data in the database
    private void update(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            if (radiobutton0.isSelected()) {
            sql = "UPDATE books SET code = ?, name = ?, category = ?, price = ?, author = ?, publisher = ?,"
                    + " publishDate = ?, InStore = ?, InStock = ? WHERE code = ?";
            }
            else if(radiobutton1.isSelected()){
            sql = "UPDATE books SET code = ?, name = ?, category = ?, price = ?, author = ?, publisher = ?,"
                    + " publishDate = ?, InStore = ?, InStock = ? WHERE name = ?";
            }
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, textfield0.getText());
            preparedstatement.setString(2, textfield1.getText());
            preparedstatement.setString(3, textfield2.getText());
            preparedstatement.setString(4, textfield3.getText());
            preparedstatement.setString(5, textfield4.getText());
            preparedstatement.setString(6, textfield5.getText());
            preparedstatement.setString(7, textfield6.getText());
            preparedstatement.setString(8, textfield7.getText());
            preparedstatement.setString(9, textfield8.getText());
            preparedstatement.setString(10, textfield9.getText());
            if (preparedstatement.executeUpdate()>0) {
                JOptionPane.showMessageDialog(null, "Book Data Updated Successfully!");
                clear();
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // delete function to delete specific book data from the database
    private void delete(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            if (radiobutton0.isSelected()) {
            sql = "DELETE FROM books WHERE code = ?";
            }
            else if(radiobutton1.isSelected()){
            sql = "DELETE FROM books WHERE name = ?";
            }
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,textfield9.getText());
            if(preparedstatement.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Book Data Deleted Successfully!");
                clear();
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // private claas to contain mouse actions
    private class Action implements MouseListener{ 
        
        @Override
        public void mouseClicked(MouseEvent me) {
            if (me.getSource() == label[9]) {
                search();
            }
            if (me.getSource() == label[10]) {
                clear();
            }
            if (me.getSource() == label[11]) {
                back();
            }
            if (me.getSource() == label[12]) {
                insert();
            }
            if (me.getSource() == label[13]) {
                update();
            }
            if (me.getSource() == label[14]) {
                delete();
            }
            if (me.getSource() == label[15]) {
                System.exit(0);
            }
            if (me.getSource() == label[16]) {
                minimize();
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (me.getSource() == label[9]) {
                label[9].setBackground(color1.brighter());
            }
            if (me.getSource() == label[10]) {
                label[10].setBackground(color1.brighter());
            }
            if (me.getSource() == label[11]) {
                label[11].setBackground(color1.brighter());
            }
            if (me.getSource() == label[12]) {
                label[12].setBackground(color1.brighter());
            }
            if (me.getSource() == label[13]) {
                label[13].setBackground(color1.brighter());
            }
            if (me.getSource() == label[14]) {
                label[14].setBackground(color1.brighter());
            }
            if (me.getSource() == label[15]) {
                label[15].setBackground(Color.RED.brighter());
            }
            if (me.getSource() == label[16]) {
                label[16].setBackground(color1.brighter());
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            if (me.getSource() == label[9]) {
                label[9].setBackground(color1);
            }
            if (me.getSource() == label[10]) {
                label[10].setBackground(color1);
            }
            if (me.getSource() == label[11]) {
                label[11].setBackground(color1);
            }
            if (me.getSource() == label[12]) {
                label[12].setBackground(color1);
            }
            if (me.getSource() == label[13]) {
                label[13].setBackground(color1);
            }
            if (me.getSource() == label[14]) {
                label[14].setBackground(color1);
            }
            if (me.getSource() == label[15]) {
                label[15].setBackground(Color.RED.darker());
            }
            if (me.getSource() == label[16]) {
                label[16].setBackground(color1);
            }
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            if (me.getSource() == label[9]) {
                label[9].setBackground(color1);
            }
            if (me.getSource() == label[10]) {
                label[10].setBackground(color1);
            }
            if (me.getSource() == label[11]) {
                label[11].setBackground(color1);
            }
            if (me.getSource() == label[12]) {
                label[12].setBackground(color1);
            }
            if (me.getSource() == label[13]) {
                label[13].setBackground(color1);
            }
            if (me.getSource() == label[14]) {
                label[14].setBackground(color1);
            }
            if (me.getSource() == label[15]) {
                label[15].setBackground(Color.RED.darker());
            }
            if (me.getSource() == label[16]) {
                label[16].setBackground(color1);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (me.getSource() == label[9]) {
                label[9].setBackground(color3);
            }
            if (me.getSource() == label[10]) {
                label[10].setBackground(color3);
            }
            if (me.getSource() == label[11]) {
                label[11].setBackground(color3);
            }
            if (me.getSource() == label[12]) {
                label[12].setBackground(color3);
            }
            if (me.getSource() == label[13]) {
                label[13].setBackground(color3);
            }
            if (me.getSource() == label[14]) {
                label[14].setBackground(color3);
            }
            if (me.getSource() == label[15]) {
                label[15].setBackground(color3);
            }
            if (me.getSource() == label[16]) {
                label[16].setBackground(color3);
            }
        }
    }
}
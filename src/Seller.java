// The Seller Page Class
// imported libraries
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.logging.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Seller extends JFrame{
    
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
    public Seller(){
        
       // form implementation
       this.setLocation(200, 60);
       this.setUndecorated(true);
       this.setSize(950, 650);
       this.setResizable(false);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       action = new Action();
       panel = new JPanel();
       label = new JLabel[30];
       textfield0 = new JTextField();
       textfield1 = new JTextField();
       buttongroup = new ButtonGroup();
       table = new JTable();
       color1 = new Color(60, 60, 60);
       color2 = new Color(30, 30, 30);
       color3 = new Color(15, 15, 15);
       font = new Font("seirf", Font.BOLD, 22);

       // function call
       view();
       
       // background implementation
       panel.setBackground(color2);
       panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       panel.setLayout(null);
       this.add(panel);

       // scrollPane implementation
       panel.add(table);
       scrollPane = new JScrollPane(table);
       scrollPane.setBounds(40,140,600,460);
       scrollPane.setEnabled(false);
       panel.add(scrollPane);

       // radio buttons implementation
       radiobutton0 = new JRadioButton("Code");
       radiobutton0.setBackground(color2);
       radiobutton0.setBounds(700, 150, 90, 30);
       radiobutton0.setForeground(Color.WHITE);
       radiobutton0.setFont(font);
       buttongroup.add(radiobutton0);
       panel.add(radiobutton0);

       radiobutton1 = new JRadioButton("Name");
       radiobutton1.setBackground(color2);
       radiobutton1.setBounds(800, 150, 90, 30);
       radiobutton1.setForeground(Color.WHITE);
       radiobutton1.setFont(font);
       buttongroup.add(radiobutton1);
       panel.add(radiobutton1);

       // text field implementation
       textfield0.setBounds(40, 70, 600, 30);
       textfield0.setFont(font);
       panel.add(textfield0);
       
       textfield1.setBounds(175, 105, 100, 30);
       textfield1.setFont(font);
       panel.add(textfield1);

       // labels implementation
       label[0] = new JLabel("               Search");
       label[0].setBackground(color3);
       label[0].setOpaque(true);
       label[0].setForeground(Color.WHITE);
       label[0].setBounds(660, 70, 250, 30);
       label[0].setFont(font);
       panel.add(label[0]);
       label[0].addMouseListener(action);

       label[1] = new JLabel("                Clear");
       label[1].setBackground(color3);
       label[1].setOpaque(true);
       label[1].setForeground(Color.WHITE);
       label[1].setBounds(660, 110, 250, 30);
       label[1].setFont(font);
       panel.add(label[1]);
       label[1].addMouseListener(action);

       label[2] = new JLabel("             Add Item");
       label[2].setBackground(color3);
       label[2].setOpaque(true);
       label[2].setForeground(Color.WHITE);
       label[2].setBounds(660, 410, 250, 30);
       label[2].setFont(font);
       panel.add(label[2]);
       label[2].addMouseListener(action);

       label[3] = new JLabel("             Print Bill");
       label[3].setBackground(color3);
       label[3].setOpaque(true);
       label[3].setForeground(Color.WHITE);
       label[3].setBounds(660, 450, 250, 30);
       label[3].setFont(font);
       panel.add(label[3]);
       label[3].addMouseListener(action);

       label[4] = new JLabel("               Logout");
       label[4].setBackground(color3);
       label[4].setOpaque(true);
       label[4].setForeground(Color.WHITE);
       label[4].setBounds(660, 570, 250, 30);
       label[4].setFont(font);
       panel.add(label[4]);
       label[4].addMouseListener(action);

       label[5] = new JLabel("   X");
       label[5].setBackground(color3);
       label[5].setOpaque(true);
       label[5].setForeground(Color.WHITE);
       label[5].setBounds(900, 0, 50, 35);
       label[5].setFont(font);
       panel.add(label[5]);
       label[5].addMouseListener(action);

       label[6] = new JLabel("  ---");
       label[6].setBackground(color3);
       label[6].setOpaque(true);
       label[6].setForeground(Color.WHITE);
       label[6].setBounds(850, 0, 50, 35);
       label[6].setFont(font);
       panel.add(label[6]);
       label[6].addMouseListener(action);

       label[7] = new JLabel("  Seller ");
       label[7].setBackground(color3);
       label[7].setOpaque(true);
       label[7].setForeground(Color.WHITE);
       label[7].setBounds(0, 0, 110, 35);
       label[7].setFont(new Font("seirf", Font.BOLD, 30));
       panel.add(label[7]);

       label[8] = new JLabel("           Delete Item");
       label[8].setBackground(color3);
       label[8].setOpaque(true);
       label[8].setForeground(Color.WHITE);
       label[8].setBounds(660, 490, 250, 30);
       label[8].setFont(font);
       panel.add(label[8]);
       label[8].addMouseListener(action);

       label[9] = new JLabel("Code: ");
       label[9].setBackground(color2);
       label[9].setOpaque(true);
       label[9].setForeground(Color.WHITE);
       label[9].setBounds(660, 200, 75, 30);
       label[9].setFont(font);
       panel.add(label[9]);

       label[10] = new JLabel("Name: ");
       label[10].setBackground(color2);
       label[10].setOpaque(true);
       label[10].setForeground(Color.WHITE);
       label[10].setBounds(660, 240, 75, 30);
       label[10].setFont(font);
       panel.add(label[10]);

       label[11] = new JLabel("Price: ");
       label[11].setBackground(color2);
       label[11].setOpaque(true);
       label[11].setForeground(Color.WHITE);
       label[11].setBounds(660, 280, 75, 30);
       label[11].setFont(font);
       panel.add(label[11]);

       label[13] = new JLabel("");
       label[13].setBackground(color2);
       label[13].setOpaque(true);
       label[13].setForeground(Color.YELLOW);
       label[13].setBounds(740, 200, 170, 30);
       label[13].setFont(font);
       panel.add(label[13]);

       label[14] = new JLabel("");
       label[14].setBackground(color2);
       label[14].setOpaque(true);
       label[14].setForeground(Color.YELLOW);
       label[14].setBounds(740, 240, 170, 30);
       label[14].setFont(font);
       panel.add(label[14]);

       label[15] = new JLabel("");
       label[15].setBackground(color2);
       label[15].setOpaque(true);
       label[15].setForeground(Color.YELLOW);
       label[15].setBounds(740, 280, 170, 30);
       label[15].setFont(font);
       panel.add(label[15]);

       label[16] = new JLabel("Total: ");
       label[16].setBackground(color2);
       label[16].setOpaque(true);
       label[16].setForeground(Color.WHITE);
       label[16].setBounds(660, 360, 75, 30);
       label[16].setFont(font);
       panel.add(label[16]);

       label[17] = new JLabel("");
       label[17].setBackground(color2);
       label[17].setOpaque(true);
       label[17].setForeground(Color.YELLOW);
       label[17].setBounds(740, 360, 170, 30);
       label[17].setFont(font);
       panel.add(label[17]);
       
       label[18] = new JLabel("               Profile");
       label[18].setBackground(color3);
       label[18].setOpaque(true);
       label[18].setForeground(Color.WHITE);
       label[18].setBounds(660, 530, 250, 30);
       label[18].setFont(font);
       panel.add(label[18]);
       label[18].addMouseListener(action);
       
       label[19] = new JLabel("Status: ");
       label[19].setBackground(color2);
       label[19].setOpaque(true);
       label[19].setForeground(Color.WHITE);
       label[19].setBounds(660, 320, 80, 30);
       label[19].setFont(font);
       panel.add(label[19]);

       label[20] = new JLabel("");
       label[20].setBackground(color2);
       label[20].setOpaque(true);
       label[20].setForeground(Color.YELLOW);
       label[20].setBounds(740, 320, 170, 30);
       label[20].setFont(font);
       panel.add(label[20]);
       
       label[21] = new JLabel("");
       label[21].setBackground(color3);
       label[21].setOpaque(true);
       label[21].setForeground(Color.WHITE);
       label[21].setBounds(110, 0, 750, 35);
       label[21].setFont(new Font("seirf", Font.BOLD, 25));
       panel.add(label[21]);

       label[22] = new JLabel("Bill Number:");
       label[22].setBackground(color2);
       label[22].setOpaque(true);
       label[22].setForeground(Color.WHITE);
       label[22].setBounds(40, 105, 130, 30);
       label[22].setFont(font);
       panel.add(label[22]);
       
       Drag frameDragListener = new Drag(this);
       label[7].addMouseListener(frameDragListener);
       label[7].addMouseMotionListener(frameDragListener);
       label[21].addMouseListener(frameDragListener);
       label[21].addMouseMotionListener(frameDragListener);
   }
     
    // addhistory function to add items to history
    private void addhistory(){
        try{
           connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
           sql = "INSERT INTO history VALUES(?,?,?,?)";
           preparedstatement = connection.prepareStatement(sql);
           preparedstatement.setString(1, textfield1.getText());
           preparedstatement.setString(2, label[13].getText());
           preparedstatement.setString(3, label[14].getText());
           preparedstatement.setString(4, label[15].getText());
           if(preparedstatement.executeUpdate()>0){
                clear();
                view();
                total();
           }
           connection.close();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
     
    // delete function to delete an item from the history
    private void deletehistory(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            if (radiobutton0.isSelected()) {
                sql = "DELETE FROM history WHERE book_code = ?";
            }
            else if(radiobutton1.isSelected()){
                sql = "DELETE FROM history WHERE book_name = ?";
            }
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,textfield0.getText());
            if(preparedstatement.executeUpdate()>0){
                clear();
                view();
                total();
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // add function to add items to bill
    private void add(){
        try{
           connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
           sql = "INSERT INTO bills VALUES(?,?,?,?)";
           preparedstatement = connection.prepareStatement(sql);
           preparedstatement.setString(1, textfield1.getText());
           preparedstatement.setString(2, label[13].getText());
           preparedstatement.setString(3, label[14].getText());
           preparedstatement.setString(4, label[15].getText());
           if(preparedstatement.executeUpdate()>0){
                move();
                addhistory();
                clear();
                view();
                total();
           }
           connection.close();
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
     
    // delete function to delete an item from the bill
    private void delete(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            if (radiobutton0.isSelected()) {
                sql = "DELETE FROM bills WHERE book_code = ?";
            }
            else if(radiobutton1.isSelected()){
                sql = "DELETE FROM bills WHERE book_name = ?";
            }
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,textfield0.getText());
            if(preparedstatement.executeUpdate()>0){
                returnback();
                deletehistory();
                clear();
                view();
                total();
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // function to move books from store to bill
    private void move(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "UPDATE books SET InStore = (InStore - 1) WHERE code = ? AND InStore >= 1";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, label[13].getText());
            preparedstatement.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // function to return books from bill to store
    private void returnback(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "UPDATE books SET InStore = (InStore + 1) WHERE name = ?";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, textfield0.getText());
            preparedstatement.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // logout function to retun to Home Page
    private void logout(){
        this.setVisible(false);
        Home home = new Home();
        home.setVisible(true);
    }
    
    // username function to get the username from login
    public void username(String user){
        label[21].setText(user);
    }
    
    // profile function to go to user profile
    private void profile(){
        this.setVisible(false);
        Profile profile = new Profile();
        profile.setVisible(true);
        profile.username(label[21].getText(), "seller");
        profile.userseller();
    }
     
    // clear function to clear all text field after each process
    private void clear(){
        textfield0.setText("");
        label[13].setText("");
        label[14].setText("");
        label[15].setText("");
        label[20].setText("");
    }
    
    // trunc function to delete all record in bills table
    private void trunc(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "TRUNCATE TABLE bills";
            preparedstatement = connection.prepareStatement(sql);
            if(preparedstatement.executeUpdate()>0){
                clear();
                view();
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // print function to print bill 
    private void print(){
        MessageFormat header = new MessageFormat("Books Bill");
        MessageFormat footer = new MessageFormat("Total: "+label[17].getText()+"  EGP");
        try{
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            label[17].setText("");
            trunc();
            view();
        }catch(PrinterException ex){
            JOptionPane.showMessageDialog(null, "Cannot Print!"+ex.getMessage());
        }
    }
    
    // function to minimize the form
    private void minimize(){
        this.setState(JFrame.ICONIFIED);
    }
    
    // search function to search for specific book data in the database
    private void search(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            if (radiobutton0.isSelected()) {
                sql = "SELECT code,name,price FROM books WHERE code = ?";
            }
            else if(radiobutton1.isSelected()){
                sql = "SELECT code,name,price FROM books WHERE name = ?";
            }
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,textfield0.getText());
            resultset = preparedstatement.executeQuery();
            if(resultset.next()){
                label[13].setText(resultset.getString(1));
                label[14].setText(resultset.getString(2));
                label[15].setText(resultset.getString(3));
                available();
            }else{
                JOptionPane.showMessageDialog(null, "NO Book Found!");
                clear();
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Please Select Search Method");
        }
    }

    // available function to check if a book is available or not in the store
    private void available(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            if (radiobutton0.isSelected()) {
                sql = "SELECT InStore FROM books WHERE code = ? AND InStore> 0";
            }
            else if(radiobutton1.isSelected()){
                sql = "SELECT InStore FROM books WHERE name = ? AND InStore> 0";
            }
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, textfield0.getText());
            resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                label[20].setText("Available");
            }else{
                label[20].setText("Not Available");
            }
            connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // view function to view all books that was added to the bill
    private void view(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT * FROM bills ORDER BY bill_number";
            preparedstatement = connection.prepareStatement(sql);
            resultset = preparedstatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultset));
            connection.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Cannot View!"+ex.getMessage());
        }
    }
    
    // total function to calculate total price of all books in the bill
    private void total(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT SUM(price) FROM bills";
            preparedstatement = connection.prepareStatement(sql);
            resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                label[17].setText(resultset.getString(1));
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
            if (me.getSource() == label[0]) {
                search();
            }
            if (me.getSource() == label[1]) {
                clear();
            }
            if (me.getSource() == label[2]) {
                add();
            }
            if (me.getSource() == label[3]) {
                print();
            }
            if (me.getSource() == label[4]) {
                logout();
            }
            if (me.getSource() == label[5]) {
                trunc();
                System.exit(0);
            }
            if (me.getSource() == label[6]) {
                minimize();
            }
            if (me.getSource() == label[8]) {
                delete();
            }
            if (me.getSource() == label[18]) {
                profile();
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
            if (me.getSource() == label[8]) {
                label[8].setBackground(color1.brighter());
            }
            if (me.getSource() == label[18]) {
                label[18].setBackground(color1.brighter());
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
            if (me.getSource() == label[8]) {
                label[8].setBackground(color1);
            }
            if (me.getSource() == label[18]) {
                label[18].setBackground(color1);
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
            if (me.getSource() == label[8]) {
                label[8].setBackground(color1);
            }
            if (me.getSource() == label[18]) {
                label[18].setBackground(color1);
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
            if (me.getSource() == label[8]) {
                label[8].setBackground(color3);
            }
            if (me.getSource() == label[18]) {
                label[18].setBackground(color3);
            }
        }
    }
}

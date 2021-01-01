// Home Page Class
// imported libraries
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Home extends JFrame{
    
    private final Action action;
    private final JPanel panel;
    private final JLabel[] label;
    private final JTextField textfield0;
    private final Color color1, color2, color3;
    private final Font font;
    private final JTable table;
    private final JScrollPane scrollPane;
    private final JComboBox combobox;
    private Connection connection;
    private PreparedStatement preparedstatement;
    private ResultSet resultset;
    private String sql;
    
    // the class constructor
    public Home(){
        
        // form implementation
        this.setLocation(280, 80);
        this.setSize(800, 600);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        action = new Action();
        panel = new JPanel();
        label = new JLabel[20];
        textfield0 = new JTextField();
        table = new JTable();
        combobox = new JComboBox();
        color1 = new Color(60, 60, 60);
        color2 = new Color(30, 30, 30);
        color3 = new Color(15, 15, 15);
        font = new Font("seirf", Font.BOLD, 22);
        
        // function call
        viewcategory();
        
        // background implementation
        panel.setBackground(color2);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(null);
        this.add(panel);
        
        // comboBox implementation
        combobox.setBounds(275, 272, 250, 30);
        panel.add(combobox);
        combobox.addMouseListener(action);
        
        // scrollPane implementation
        panel.add(table);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 320, 760, 250);
        scrollPane.setEnabled(false);
        panel.add(scrollPane);

        // text field implementation
        textfield0.setBounds(275, 100, 300, 35);
        textfield0.setFont(font);
        panel.add(textfield0);
       
        // labels implementation
        label[0] = new JLabel("  Home");
        label[0].setBackground(color3);
        label[0].setOpaque(true);
        label[0].setForeground(Color.WHITE);
        label[0].setBounds(0, 0, 700, 35);
        label[0].setFont(new Font("seirf", Font.BOLD, 30));
        panel.add(label[0]);
       
        label[1] = new JLabel("   X");
        label[1].setBackground(color3);
        label[1].setOpaque(true);
        label[1].setForeground(Color.WHITE);
        label[1].setBounds(749, 1, 50, 34);
        label[1].setFont(font);
        panel.add(label[1]);
        label[1].addMouseListener(action);
        
        label[2] = new JLabel("  ---");
        label[2].setBackground(color3);
        label[2].setOpaque(true);
        label[2].setForeground(Color.WHITE);
        label[2].setBounds(699, 1, 50, 34);
        label[2].setFont(font);
        panel.add(label[2]);
        label[2].addMouseListener(action);
        
        label[3] = new JLabel("        LogIn");
        label[3].setBackground(color3);
        label[3].setOpaque(true);
        label[3].setForeground(Color.WHITE);
        label[3].setBounds(605, 50, 150, 35);
        label[3].setFont(font);
        panel.add(label[3]);
        label[3].addMouseListener(action);
        
        label[4] = new JLabel("  Search By Category:");
        label[4].setBackground(color2);
        label[4].setOpaque(true);
        label[4].setForeground(Color.WHITE);
        label[4].setBounds(20, 270, 250, 35);
        label[4].setFont(font);
        panel.add(label[4]);
        
        label[5] = new JLabel("  Search By Book Name:");
        label[5].setBackground(color2);
        label[5].setOpaque(true);
        label[5].setForeground(Color.WHITE);
        label[5].setBounds(20, 100, 250, 35);
        label[5].setFont(font);
        panel.add(label[5]);
        
        label[6] = new JLabel("         Search");
        label[6].setBackground(color3);
        label[6].setOpaque(true);
        label[6].setForeground(Color.WHITE);
        label[6].setBounds(590, 100, 180, 35);
        label[6].setFont(font);
        panel.add(label[6]);
        label[6].addMouseListener(action);
        
        label[7] = new JLabel("Book Code");
        label[7].setBackground(color2);
        label[7].setOpaque(true);
        label[7].setForeground(Color.WHITE);
        label[7].setBounds(30, 170, 150, 30);
        label[7].setFont(font);
        panel.add(label[7]);
        
        label[8] = new JLabel("Book Name");
        label[8].setBackground(color2);
        label[8].setOpaque(true);
        label[8].setForeground(Color.WHITE);
        label[8].setBounds(200, 170, 150, 30);
        label[8].setFont(font);
        panel.add(label[8]);
        
        label[9] = new JLabel("Book Price");
        label[9].setBackground(color2);
        label[9].setOpaque(true);
        label[9].setForeground(Color.WHITE);
        label[9].setBounds(400, 170, 150, 30);
        label[9].setFont(font);
        panel.add(label[9]);
        
        label[10] = new JLabel("Status");
        label[10].setBackground(color2);
        label[10].setOpaque(true);
        label[10].setForeground(Color.WHITE);
        label[10].setBounds(560, 170, 150, 30);
        label[10].setFont(font);
        panel.add(label[10]);
        
        label[11] = new JLabel("");
        label[11].setBackground(color2);
        label[11].setOpaque(true);
        label[11].setForeground(Color.WHITE);
        label[11].setBounds(30, 220, 150, 30);
        label[11].setFont(font);
        panel.add(label[11]);
        
        label[12] = new JLabel("");
        label[12].setBackground(color2);
        label[12].setOpaque(true);
        label[12].setForeground(Color.WHITE);
        label[12].setBounds(200, 220, 300, 30);
        label[12].setFont(font);
        panel.add(label[12]);
        
        label[13] = new JLabel("");
        label[13].setBackground(color2);
        label[13].setOpaque(true);
        label[13].setForeground(Color.WHITE);
        label[13].setBounds(400, 220, 150, 30);
        label[13].setFont(font);
        panel.add(label[13]);
        
        label[14] = new JLabel("");
        label[14].setBackground(color2);
        label[14].setOpaque(true);
        label[14].setForeground(Color.WHITE);
        label[14].setBounds(560, 220, 150, 30);
        label[14].setFont(font);
        panel.add(label[14]);
        
        label[15] = new JLabel("          Apply");
        label[15].setBackground(color3);
        label[15].setOpaque(true);
        label[15].setForeground(Color.WHITE);
        label[15].setBounds(590, 270, 180, 35);
        label[15].setFont(font);
        panel.add(label[15]);
        label[15].addMouseListener(action);
        
        Drag frameDragListener = new Drag(this);
        label[0].addMouseListener(frameDragListener);
        label[0].addMouseMotionListener(frameDragListener);
    }
    
    // login function to go to login form
    private void login(){
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }
    
    // viewcategory function to view all categories in the book table into comboBox
    private void viewcategory(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT DISTINCT category FROM books";
            preparedstatement = connection.prepareStatement(sql);
            resultset = preparedstatement.executeQuery();
            while(resultset.next()){
                String s = resultset.getString("category");
                combobox.addItem(s.trim());
            }
            connection.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Cannot View!"+ex.getMessage());
        }
    }
    
    // view function to view all books with the same category
    private void view(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT code,name,price,InStore AS Available FROM books WHERE category = ? AND InStore > 0";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,combobox.getSelectedItem().toString());
            resultset = preparedstatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(resultset));
            connection.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Cannot View!"+ex.getMessage());
        }
    }
    
    // available function to check if a book is available or not in the store
    private void available(){
        try{
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/textbook", "a", "1234");
            sql = "SELECT InStore FROM books WHERE name = ? AND InStore> 0";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1, textfield0.getText());
            resultset = preparedstatement.executeQuery();
            if (resultset.next()) {
                label[14].setText("Available");
            }else{
                label[14].setText("Not Available");
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
            sql = "SELECT code,name,price FROM books WHERE name = ?";
            preparedstatement = connection.prepareStatement(sql);
            preparedstatement.setString(1,textfield0.getText());
            resultset = preparedstatement.executeQuery();
            if(resultset.next()){
                label[11].setText(resultset.getString(1));
                label[12].setText(resultset.getString(2));
                label[13].setText(resultset.getString(3));
                available();
            }else{
                available();
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
            if (me.getSource() == label[3]) {
                login();
            }
            if (me.getSource() == label[6]) {
                search();
            }
            if (me.getSource() == label[15]) {
                view();
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
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1.brighter());
            }
            if (me.getSource() == label[15]) {
                label[15].setBackground(color1.brighter());
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
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1);
            }
            if (me.getSource() == label[15]) {
                label[15].setBackground(color1);
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
            if (me.getSource() == label[6]) {
                label[6].setBackground(color1);
            }
            if (me.getSource() == label[15]) {
                label[15].setBackground(color1);
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
            if (me.getSource() == label[6]) {
                label[6].setBackground(color3);
            }
            if (me.getSource() == label[15]) {
                label[15].setBackground(color3);
            }
        }
    }
}

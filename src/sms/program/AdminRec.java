/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.program;

import java.awt.Checkbox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import sms.program.Panels.ContactSearch;

/**
 *
 * @author Admin
 */
public class AdminRec extends javax.swing.JFrame {

    int mousepX;
    int mousepY;
    public Connection conn1 = null;
    public Statement stmt1 = null;
    
    /**
     * Creates new form AdminRec
     */
    public AdminRec() {
        initComponents();
        showtable();
    }
    
    public ArrayList<EmployeeDatabase> getEmployeeDatabase() throws SQLException 
    {
        Connection conn = null;
        ArrayList<EmployeeDatabase> EmployeeDatabaseList = new ArrayList<EmployeeDatabase>();
        
        // Connecting to the database and executing query:
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("SELECT * FROM APP.EMPDB");
            ResultSet rs = prestmt.executeQuery();
            EmployeeDatabase EmployeeDatabase;
            while(rs.next())
            {
                EmployeeDatabase = new EmployeeDatabase(rs.getInt("EMP_ID"),rs.getString("EMAIL"),rs.getString("PASSWORD"),rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),rs.getString("GENDER"),rs.getString("DATEOFBIRTH"),rs.getString("OCCUPATION"),rs.getString("PHONENUMBER"));
                EmployeeDatabaseList.add(EmployeeDatabase);
            }
            } catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex);
            }
            finally{
                try {
                    conn.close();
                } catch (SQLException ex) 
                {
                    Logger.getLogger(ContactSearch.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        return EmployeeDatabaseList;
    }
    
    public void showtable()
    {
        // Displaying data from database:
        try {
            ArrayList<EmployeeDatabase> EmployeeDatabaselist = getEmployeeDatabase();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] row = new Object[9];
            for(int i =0; i<EmployeeDatabaselist.size(); i++)
            {
                row[0] = EmployeeDatabaselist.get(i).getEmp_ID();
                row[1] = EmployeeDatabaselist.get(i).getEmail();
                row[2] = EmployeeDatabaselist.get(i).getPassword();
                row[3] = EmployeeDatabaselist.get(i).getFirstname();
                row[4] = EmployeeDatabaselist.get(i).getLastname();
                row[5] = EmployeeDatabaselist.get(i).getGender();
                row[6] = EmployeeDatabaselist.get(i).getDateofBirth();
                row[7] = EmployeeDatabaselist.get(i).getOccupation();
                row[8] = EmployeeDatabaselist.get(i).getPhonenumber();
                model.addRow(row);
            }
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Table could not be found");
        } 
    }
    
    public void executeSQLQuery(String query, String message) throws SQLException
    {
        conn1 = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
        try
        {
            stmt1 = conn1.createStatement();
            if(stmt1.executeUpdate(query) == 1)
            {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                showtable();
                JOptionPane.showMessageDialog(null, "Data " +message+" Successfully!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Data " +message+" is unsuccessfully!");
            }
        } catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Query can not be executed");
        }
         finally{
                try {
                    conn1.close();
                } catch (SQLException ex) 
                {
                    Logger.getLogger(ContactSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\nat.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(231, 231, 231));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 39)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(170, 161, 82));
        jLabel8.setText("SMS Program");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\icons8_Close_Window_48px_2.png")); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\icons8_Minimize_Window_48px_1.png")); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1133, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel9))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel4.setLayout(null);

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Untitled.png")); // NOI18N
        jPanel4.add(jLabel21);
        jLabel21.setBounds(30, 10, 234, 232);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Registration_48px.png")); // NOI18N
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(290, 920, 140, 60);

        jPanel3.setBackground(new java.awt.Color(229, 229, 229));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Fields:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel14.setText("Occupation:");

        jLabel16.setText("First name:");

        jLabel17.setText("E-mail:");

        jLabel18.setText("Last name:");

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jTextField11))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap())
        );

        jPanel4.add(jPanel3);
        jPanel3.setBounds(30, 660, 347, 240);

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Field contents:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setText("User Name:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel5.setText("Password:");

        jLabel6.setText("First Name:");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel11.setText("Last Name: ");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Gender:");

        jLabel12.setText("Phone Number:");

        jLabel13.setText("E-mail:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel15.setText("Employee_ID:");

        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });

        jLabel19.setText("Occupation:");

        jCheckBox1.setText("    Show Password ");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(jTextField7)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addComponent(jTextField12)
                            .addComponent(jTextField1)
                            .addComponent(jTextField3)
                            .addComponent(jPasswordField1)))
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jPanel4.add(jPanel2);
        jPanel2.setBounds(30, 260, 347, 390);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Edit_48px.png")); // NOI18N
        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);
        jButton3.setBounds(30, 920, 160, 60);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Search_48px.png")); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(760, 920, 130, 57);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Broom_48px.png")); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(960, 920, 130, 60);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee_ID", "User Name", "Password", "First Name", "Last Name", "Gender", "Date of Birth", "Occupation", "Phone Number", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(400, 110, 1110, 790);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Admin/Employee Records");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(510, 10, 469, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Please edit, input, search and delete Admin/Employee records:");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(500, 70, 500, 22);

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Delete File_48px.png")); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);
        jButton5.setBounds(1140, 920, 130, 60);

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Refresh_48px.png")); // NOI18N
        jButton6.setText("Refresh Table");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);
        jButton6.setBounds(500, 920, 165, 57);

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Enter_48px.png")); // NOI18N
        jButton7.setText("Go to Welcome Page");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7);
        jButton7.setBounds(1297, 920, 210, 57);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\bg-samarew1.png")); // NOI18N
        jPanel4.add(jLabel1);
        jLabel1.setBounds(0, 0, 1530, 1440);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        //This button is used for clearing all the fields:
        jTextField1.setText("");
        jPasswordField1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int k;
        String txt1 = jTextField1.getText();
        String txt2 = String.valueOf(jPasswordField1.getPassword());
        String txt3 = jTextField3.getText();
        String txt4 = jTextField4.getText();
        String txt5 = jTextField5.getText();
        String txt6 = jTextField6.getText();
        String txt7 = jTextField13.getText();
        String txt8 = jTextField7.getText();
        String JP = "Admin";

        Connection conn = null;
        Connection conn2 = null;

        // Error messages in case there are error inputting information:
        if (txt1.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter First Name");
        } else if (txt2.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter Last Name");
        } else if (txt3.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter Phone number");
        } else if (txt4.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter Occupation");
        } else if (txt5.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Please Enter E-mail");
        } else if(txt1.equals("") && txt2.equals("") && txt3.equals("") && txt4.equals("") && txt5.equals(""))
        {
            System.out.println("Fill the missing fields");
            JOptionPane.showMessageDialog(this,"Registeration Unsuccessful","Error",JOptionPane.ERROR_MESSAGE);
        } else
        {
            System.out.println("Registration Complete");
        }
        
        String txt6cck = txt6.toString();
        if(txt6cck.equals(JP))
        {
            try
            {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn2 = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            String sql2 = "INSERT INTO APP.ADMINDB (EMAIL, PASSWORD, FIRSTNAME, LASTNAME, JOBPOSITION) values (?,?,?,?,?)";
            PreparedStatement st2 = conn2.prepareStatement(sql2);
            st2.setString(1, jTextField7.getText());
            st2.setString(2, String.valueOf(jPasswordField1.getPassword()));
            st2.setString(3, jTextField3.getText());
            st2.setString(4, jTextField4.getText());
            st2.setString(5, jTextField6.getText());

            // Providing Confirmation message of completing the sign up:
            st2.execute();
            st2.executeUpdate();
            k = st2.executeUpdate();
            if (k > 0)
            {
                JOptionPane.showMessageDialog(null, "Registeration for Admin has been Successfull");
            } else
            {
                JOptionPane.showMessageDialog(null, "Registeration for Admin has been  Unsuccessfull");
            }
            }catch(Exception e)
            {
                System.err.println("Got an exception for Admin reg!");
                System.err.println(e.getMessage());
            }
            // Closing the connection to database and closing the panel:
            finally
            {
                try {
                    conn.close();
                } catch (SQLException ex)
                {
                    Logger.getLogger(AdminRec.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else
        {
            // Establishing a connection with database and store information in the database:
            try
            {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                System.out.println("Going to connect to database");
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
                System.out.println("Connection Successfull");
                String sql = "INSERT INTO APP.EMPDB (EMAIL, PASSWORD, FIRSTNAME, LASTNAME, GENDER, DATEOFBIRTH, OCCUPATION, PHONENUMBER) values (?,?,?,?,?,?,?,?)";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, jTextField1.getText());
                st.setString(2, String.valueOf(jPasswordField1.getPassword()));
                st.setString(3, jTextField3.getText());
                st.setString(4, jTextField4.getText());
                st.setString(5, jTextField5.getText());
                st.setString(6, jTextField6.getText());
                st.setString(7, jTextField13.getText());
                st.setString(8, jTextField7.getText());

                 // Providing Confirmation message of completing the sign up:
                int i = st.executeUpdate();
                if (i > 0)
                {
                    JOptionPane.showMessageDialog(null, "Registeration Successfull");
                } else
                {
                    JOptionPane.showMessageDialog(null, "Registeration Unsuccessfull");
                }
            } catch(Exception e){
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
            finally
            {
                try {
                    conn2.close();
                } catch (SQLException ex)
                {
                    Logger.getLogger(AdminRec.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        jTextField12.setText(model.getValueAt(i,0).toString());
        jTextField12.setEditable(false);
        jTextField1.setText(model.getValueAt(i,1).toString());
        jPasswordField1.setText(model.getValueAt(i,2).toString());
        jTextField3.setText(model.getValueAt(i,3).toString());
        jTextField4.setText(model.getValueAt(i,4).toString());
        jTextField5.setText(model.getValueAt(i,5).toString());
        jTextField6.setText(model.getValueAt(i,6).toString());
        jTextField13.setText(model.getValueAt(i,7).toString());
        jTextField7.setText(model.getValueAt(i,8).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("UPDATE APP.EMPDB SET EMAIL = ?, PASSWORD = ?, FIRSTNAME = ?, LASTNAME = ?, GENDER = ?, DATEOFBIRTH = ?, OCCUPATION = ?, PHONENUMBER = ? WHERE EMP_ID = ?");
            prestmt.setString(1, jTextField1.getText());
            prestmt.setString(2, String.valueOf(jPasswordField1.getPassword()));
            prestmt.setString(3, jTextField3.getText());
            prestmt.setString(4, jTextField4.getText());
            prestmt.setString(5, jTextField5.getText());
            prestmt.setString(6, jTextField6.getText());
            prestmt.setString(7, jTextField13.getText());
            prestmt.setString(8, jTextField7.getText());
            prestmt.setString(9, jTextField12.getText());
            prestmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record has been updated");
            model.setRowCount(0);
            showtable();
        } catch (Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
        //Attendee_ID = 0;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int Xcoordinate = evt.getXOnScreen();
        int Ycoordinate = evt.getYOnScreen();

        this.setLocation(Xcoordinate - mousepX, Ycoordinate - mousepY);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;

        // Connecting to the database and selecting the information:
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("SELECT * FROM APP.EMPDB where FIRSTNAME = ? or LASTNAME = ? or OCCUPATION = ? or EMAIL = ?");
            prestmt.setString(1, String.valueOf(jTextField8.getText()));
            prestmt.setString(2, String.valueOf(jTextField9.getText()));
            prestmt.setString(3, String.valueOf(jTextField10.getText()));
            prestmt.setString(4, String.valueOf(jTextField11.getText()));
            ResultSet rs = prestmt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            prestmt.close();
        } catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        } finally
        {
            try
            {
                conn.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(AdminRec.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        int row = jTable1.getSelectedRow();
        String cell = jTable1.getValueAt(row, 0).toString();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        if(jTable1.getSelectedRowCount() == 1)
        {  
            try
            {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                System.out.println("Going to connect to database");
                conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
                System.out.println("Connection Successfull");
//                PreparedStatement prestmt = conn.prepareStatement("DELETE FROM APP.EMPDB WHERE EMP_ID ='"+jTextField12+"'");
                PreparedStatement prestmt = conn.prepareStatement("DELETE FROM APP.EMPDB WHERE EMP_ID ='"+cell+"'");
                model.removeRow(row);
                prestmt.execute();
                prestmt.executeUpdate();
                jTextField1.setText("");
                jPasswordField1.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jTextField13.setText("");
                jTextField7.setText("");
                jTextField12.setText("");
                JOptionPane.showMessageDialog(null, "Record has been deleted");
            } catch (Exception ex)
            {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, ex);
            }
        } else
        {
            if(jTable1.getSelectedRowCount() == 0)
            {
                JOptionPane.showMessageDialog(null, "Table is Empty");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please select single row");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;

        // Connecting to the database and executing query:
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("SELECT * FROM APP.EMPDB");
            ResultSet rs = prestmt.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally{
            try {
                conn.close();
            } catch (SQLException ex)
            {
                Logger.getLogger(ContactSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
        {
            jPasswordField1.setEchoChar((char)0);
        } else if (!jCheckBox1.isSelected())
        {
            jPasswordField1.setEchoChar('*');
        } else
        {
            jPasswordField1.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        AdminRec prevpage = new AdminRec();
        dispose();
        BetweenPages page = new BetweenPages();
        //page.setInt(Employee_ID);
        page.setVisible(true);
        page.getContentPane();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminRec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminRec().setVisible(true);
            }
        });
    }

    void setInt(int Employee_ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms.program.Panels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import sms.program.AttendeeDatabase;

/**
 *
 * @author Admin
 */
public class ContactSearch extends javax.swing.JPanel {
       public Connection conn1 = null;
       public Connection constm = null;
       public Statement stmt1 = null;
       //int Attendee_ID;
       
    /**
     * Creates new form ContactSearch
     */
    public ContactSearch() {
        initComponents();
        showtable();
    }
    
    public ArrayList<AttendeeDatabase> getAttendeeDatabase() throws SQLException 
    {
        Connection conn = null;
        ArrayList<AttendeeDatabase> AttendeeDatabaseList = new ArrayList<AttendeeDatabase>();
        
        // Connecting to the database and executing query:
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("SELECT * FROM APP.ATENDB");
            ResultSet rs = prestmt.executeQuery();
            AttendeeDatabase AttendeeDatabase;
            while(rs.next())
            {
                AttendeeDatabase = new AttendeeDatabase(rs.getInt("ATTENDEE_ID"),rs.getString("FIRSTNAME"),rs.getString("LASTNAME"),rs.getString("GENDER"),rs.getString("DATEOFBIRTH"),rs.getString("PHONENUMBER"),rs.getString("OCCUPATION"),rs.getString("EMAIL"));
                AttendeeDatabaseList.add(AttendeeDatabase);
                //Attendee_ID = rs.getInt("Attendee_ID");
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
        return AttendeeDatabaseList;
    }
    
    public void showtable()
    {
        // Displaying data from database:
        try {
            ArrayList<AttendeeDatabase> AttendeeDatabaselist = getAttendeeDatabase();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            Object[] row = new Object[8];
            for(int i =0; i<AttendeeDatabaselist.size(); i++)
            {
                row[0] = AttendeeDatabaselist.get(i).getAttendee_ID();
                row[1] = AttendeeDatabaselist.get(i).getFirstName();
                row[2] = AttendeeDatabaselist.get(i).getLastName();
                row[3] = AttendeeDatabaselist.get(i).getGender();
                row[4] = AttendeeDatabaselist.get(i).getDateofBirth();
                row[5] = AttendeeDatabaselist.get(i).getPhoneNumber();
                row[6] = AttendeeDatabaselist.get(i).getOccupation();
                row[7] = AttendeeDatabaselist.get(i).getEmail();
                model.addRow(row);
            }
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Table could not be found");
        } 
    }
    
    public ArrayList<AttendeeDatabase> AttendeesList(String ValToSearch1, String ValToSearch2, String ValToSearch3, String ValToSearch4)
    {        
        ArrayList<AttendeeDatabase> attendeesList = new ArrayList<AttendeeDatabase>();
        try
        {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        System.out.println("Going to connect to database");
        constm = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
        System.out.println("Connection Successfull");
        Statement stm = constm.createStatement();
     //  ResultSet rlst = stm.executeQuery("SELECT * FROM APP.ATENDB WHERE CONCAT('ATTENDEE_ID','FIRSTNAME','LASTNAME','GENDER','DATEOFBIRTH','PHONENUMBER','OCCUPATION','EMAIL') REGEXP '"+ValToSearch1+"'|'"+ValToSearch2+"'|'"+ValToSearch3+"'|'"+ValToSearch4+"'");
     ResultSet rlst = stm.executeQuery("SELECT * FROM APP.ATENDB WHERE ('ATTENDEE_ID','FIRSTNAME','LASTNAME','GENDER','DATEOFBIRTH','PHONENUMBER','OCCUPATION','EMAIL') LIKE '"+ValToSearch1+"'|'"+ValToSearch2+"'|'"+ValToSearch3+"'|'"+ValToSearch4+"'");
     AttendeeDatabase attendeeDatabase;
        while(rlst.next())
        {
            attendeeDatabase = new AttendeeDatabase(
            rlst.getInt("ATTENDEE_ID"),
            rlst.getString("FIRSTNAME"),
            rlst.getString("LASTNAME"),
            rlst.getString("GENDER"),
            rlst.getString("DATEOFBIRTH"),
            rlst.getString("PHONENUMBER"),
            rlst.getString("OCCUPATION"),
            rlst.getString("EMAIL")
            );
            attendeesList.add(attendeeDatabase);
        }
                } catch(Exception ex){
                     JOptionPane.showMessageDialog(null, ex);
                }
        return attendeesList;
    }
    
    public void searchAttendees()
    {
        ArrayList<AttendeeDatabase> attendeesList = AttendeesList(jTextField8.getText(), jTextField9.getText(), jTextField10.getText(), jTextField11.getText());
        DefaultTableModel model =  new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"ATTENDEE_ID","FIRSTNAME","LASTNAME","GENDER","DATEOFBIRTH","PHONENUMBER","OCCUPATION","EMAIL"});
        Object[] row = new Object[8];
        for(int i =0; i<attendeesList.size(); i++)
            {
                row[0] = attendeesList.get(i).getAttendee_ID();
                row[1] = attendeesList.get(i).getFirstName();
                row[2] = attendeesList.get(i).getLastName();
                row[3] = attendeesList.get(i).getGender();
                row[4] = attendeesList.get(i).getDateofBirth();
                row[5] = attendeesList.get(i).getPhoneNumber();
                row[6] = attendeesList.get(i).getOccupation();
                row[7] = attendeesList.get(i).getEmail();
                model.addRow(row);
            }
        jTable1.setModel(model);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1330, 710));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel1.setText("Contact Database:");
        add(jLabel1);
        jLabel1.setBounds(509, 0, 230, 31);

        jLabel2.setText("Please input field required for search,editing or delete record");
        add(jLabel2);
        jLabel2.setBounds(452, 38, 349, 16);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Search_48px.png")); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(190, 660, 130, 50);
        add(jLabel3);
        jLabel3.setBounds(1319, 262, 0, 0);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Edit_48px.png")); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(10, 600, 160, 50);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Delete File_48px.png")); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(190, 600, 130, 50);

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Field contents:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setText("First name:");

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

        jLabel5.setText("Last name:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jLabel6.setText("Gender:");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel10.setText("Date of Birth:");

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

        jLabel7.setText("Phone number:");

        jLabel8.setText("Occupation:");

        jLabel9.setText("E-mail:");

        jLabel15.setText("Attendee_ID:");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jTextField1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel1);
        jPanel1.setBounds(12, 61, 310, 310);

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Database:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Attendee_ID", "First Name", "Last Name", "Gender", "Date of Birth", "Phone Number", "Occupation", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 978, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        add(jPanel2);
        jPanel2.setBounds(330, 60, 990, 650);

        jPanel3.setBackground(new java.awt.Color(229, 229, 229));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Fields:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel13.setText("Occupation:");

        jLabel11.setText("First name:");

        jLabel14.setText("E-mail:");

        jLabel12.setText("Last name:");

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
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField8)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField10)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        add(jPanel3);
        jPanel3.setBounds(10, 380, 310, 210);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Refresh_48px.png")); // NOI18N
        jButton4.setText("Refresh Table");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4);
        jButton4.setBounds(10, 660, 165, 50);

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\bg-samarew1.png")); // NOI18N
        add(jLabel16);
        jLabel16.setBounds(-2, 0, 1340, 1440);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;

        // Connecting to the database and selecting the information:
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("SELECT * FROM APP.ATENDB where FIRSTNAME = ? or LASTNAME = ? or OCCUPATION = ? or EMAIL = ?");
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
                Logger.getLogger(ContactSearch.class.getName()).log(Level.SEVERE, null, ex);
            }    
        }
        //searchAttendees();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        jTextField12.setText(model.getValueAt(i,0).toString());
        jTextField12.setEditable(false);
        //String Attendee_ID = jTextField12.getText();
        jTextField1.setText(model.getValueAt(i,1).toString());
        jTextField2.setText(model.getValueAt(i,2).toString());
        jTextField3.setText(model.getValueAt(i,3).toString());
        jTextField4.setText(model.getValueAt(i,4).toString());
        jTextField5.setText(model.getValueAt(i,5).toString());
        jTextField6.setText(model.getValueAt(i,6).toString());
        jTextField7.setText(model.getValueAt(i,7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        
        // Connecting to the database and executing query:
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("SELECT * FROM APP.ATENDB");
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        int row = jTable1.getSelectedRow();
        //String FName = jTable1.getModel().getValueAt(row, 0).toString();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("DELETE FROM APP.ATENDB WHERE ATTENDEE_ID ='"+jTextField12+"");
            //prestmt.setString(1, FName);
            prestmt.executeUpdate();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            //jTextField12.setText("");
            model.removeRow(row);
            //Attendee_ID = 0;
            JOptionPane.showMessageDialog(null, "Record has been deleted");
        } catch (Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            System.out.println("Going to connect to database");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/SMS Database;create=true");
            System.out.println("Connection Successfull");
            PreparedStatement prestmt = conn.prepareStatement("UPDATE APP.ATENDB SET FIRSTNAME = ?, LASTNAME = ?, GENDER = ?, DATEOFBIRTH = ?, PHONENUMBER = ?, OCCUPATION = ?, EMAIL = ? WHERE ATTENDEE_ID = ?");
            prestmt.setString(1, jTextField1.getText());
            prestmt.setString(2, jTextField2.getText());
            prestmt.setString(3, jTextField3.getText());
            prestmt.setString(4, jTextField4.getText());
            prestmt.setString(5, jTextField5.getText());
            prestmt.setString(6, jTextField6.getText());
            prestmt.setString(7, jTextField7.getText());
            prestmt.setString(8, jTextField12.getText());
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}

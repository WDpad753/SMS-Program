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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Admin
 */
public class BulkSMSWelcome extends javax.swing.JFrame {

    int mousepX;
    int mousepY;
    
    /**
     * Creates new form BulkSMSWelcome
     */
    public BulkSMSWelcome() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 670));
        getContentPane().setLayout(null);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sms/program/Registration_48px.png"))); // NOI18N
        jButton2.setText("Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(80, 480, 240, 60);

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(170, 161, 82));
        jLabel7.setText("V 1.0");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(660, 330, 70, 30);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Login_48px.png")); // NOI18N
        jButton1.setText("Admin Login Page");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(760, 480, 243, 60);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Login_48px.png")); // NOI18N
        jButton3.setText("Employee Login Page");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(420, 480, 243, 60);

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(171, 162, 81));
        jLabel5.setText("SMS System");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(360, 330, 300, 58);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\Untitled.png")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(410, 80, 260, 233);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1100, 610);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\SMS Program\\src\\sms\\program\\White-Background.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 50, 1100, 620);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 700, Short.MAX_VALUE)
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

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1100, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        EmpReg page = new EmpReg();
        dispose();
        page.setVisible(true);
        page.getContentPane();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdminSignInPage page = new AdminSignInPage();
        dispose();
        page.setVisible(true);
        page.getContentPane();
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        EmpSignInPage page = new EmpSignInPage();
        dispose();
        page.setVisible(true);
        page.getContentPane();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(BulkSMSWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BulkSMSWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BulkSMSWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BulkSMSWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BulkSMSWelcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

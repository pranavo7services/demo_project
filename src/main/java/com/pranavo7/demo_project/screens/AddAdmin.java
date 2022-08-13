/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pranavo7.demo_project.screens;

import com.pranavo7.demo_project.database_connectivity.ConnectionClass;
import com.pranavo7.demo_project.models.UserModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author macbookpro2014
 */
public class AddAdmin extends javax.swing.JFrame {

    /**
     * Creates new form AddAdmin
     */
    public AddAdmin() {
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

        titleLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        passwordTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        titleLabel.setText("Add Admin");
        getContentPane().add(titleLabel);
        titleLabel.setBounds(160, 40, 65, 17);

        emailLabel.setText("Email");
        getContentPane().add(emailLabel);
        emailLabel.setBounds(50, 100, 32, 17);

        passwordLabel.setText("Password");
        getContentPane().add(passwordLabel);
        passwordLabel.setBounds(50, 150, 70, 17);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(130, 210, 72, 23);
        getContentPane().add(passwordTF);
        passwordTF.setBounds(180, 147, 130, 23);
        getContentPane().add(emailTF);
        emailTF.setBounds(180, 100, 130, 23);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String email = emailTF.getText();
        String password = passwordTF.getText();
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter email");
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter password");
        } else {
            final String searchStatement = "SELECT * from users where email=?";
            
            try {
                PreparedStatement searchPreparedStatement = ConnectionClass.getInstance().connection.prepareStatement(searchStatement);
                searchPreparedStatement.setString(1, email);
                
                ResultSet searhResultSet = searchPreparedStatement.executeQuery();
                
                while (searhResultSet.next()) {
                    JOptionPane.showMessageDialog(null, "Email already exists");
                    return;
                }
                
                final String insertStatement = "INSERT INTO users(name, email, password, address, role) values(?,?,?,?,?)";
                PreparedStatement preparedStatement = ConnectionClass.getInstance().connection.prepareStatement(insertStatement);
                preparedStatement.setString(1, "");
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, "");
                preparedStatement.setInt(5, 1);

                final int isAdded = preparedStatement.executeUpdate();

                if (isAdded > 0) {
                    JOptionPane.showMessageDialog(null, "Value Added");
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            } catch (SQLException ex) {
                System.out.println("error in " + AddAdmin.class.getName() + " = " + ex);
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTF;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

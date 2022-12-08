/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package views;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anaclita
 */
public class ManagerPanel extends javax.swing.JInternalFrame {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public static HashMap<String, Integer> cashierMap = new HashMap<>();

    /**
     * Creates new form TableCashier
     */
    public ManagerPanel() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        getManagersFromDB();
    }

    public void getManagersFromDB() {
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT CONCAT(FirstName, ' ', LastName) AS Name, ContactNumber, Username, Password FROM user WHERE UserType = 'Manager'";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("Name");
                String contactNumber = rs.getString("ContactNumber");
                String userName = rs.getString("Username");
                String password = rs.getString("Password");

                String[] data = {name, contactNumber, userName, password};

                DefaultTableModel tblModel = (DefaultTableModel) tblManager.getModel();
                tblModel.addRow(data);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
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

        btnAddManager = new javax.swing.JButton();
        btnEditManager = new javax.swing.JButton();
        btnDeleteManager = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblManager = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setVisible(true);

        btnAddManager.setBackground(new java.awt.Color(0, 153, 0));
        btnAddManager.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAddManager.setForeground(new java.awt.Color(255, 255, 255));
        btnAddManager.setText("ADD MANAGER");
        btnAddManager.setFocusable(false);
        btnAddManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddManagerActionPerformed(evt);
            }
        });

        btnEditManager.setBackground(new java.awt.Color(255, 255, 0));
        btnEditManager.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEditManager.setText("EDIT MANAGER");
        btnEditManager.setFocusable(false);
        btnEditManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditManagerActionPerformed(evt);
            }
        });

        btnDeleteManager.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteManager.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteManager.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteManager.setText("DELETE MANAGER");
        btnDeleteManager.setFocusable(false);
        btnDeleteManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteManagerActionPerformed(evt);
            }
        });

        tblManager.setAutoCreateRowSorter(true);
        tblManager.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Contact Number", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblManager.setMinimumSize(new java.awt.Dimension(50, 0));
        jScrollPane1.setViewportView(tblManager);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddManager)
                        .addGap(82, 82, 82)
                        .addComponent(btnEditManager)
                        .addGap(79, 79, 79)
                        .addComponent(btnDeleteManager))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddManager)
                    .addComponent(btnEditManager)
                    .addComponent(btnDeleteManager))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddManagerActionPerformed
        // TODO add your handling code here:
        new AddManagerDialog(null, true);
    }//GEN-LAST:event_btnAddManagerActionPerformed

    private void btnEditManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditManagerActionPerformed
        // TODO add your handling code here:

        DefaultTableModel tblModel = (DefaultTableModel) tblManager.getModel();

        if (tblManager.getSelectedRowCount() == 1) {
            String userName = tblModel.getValueAt(tblManager.getSelectedRow(), 2).toString();
            new EditManagerDialog(null, true, getManagerID(userName));
        } else {
            if (tblManager.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single row!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditManagerActionPerformed


    private void btnDeleteManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteManagerActionPerformed
        // TODO add your handling code here:

        if (tblManager.getSelectedRowCount() == 1) {

            DefaultTableModel tblModel = (DefaultTableModel) tblManager.getModel();

            String name = tblModel.getValueAt(tblManager.getSelectedRow(), 0).toString();
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + name + "?", "Delete", JOptionPane.YES_NO_OPTION);

            if (answer == 0) {
                String userName = tblModel.getValueAt(tblManager.getSelectedRow(), 2).toString();

                int toDeleteID = getManagerID(userName);
                int deletedID = deleteManagerFromDB(toDeleteID);

                System.out.println(toDeleteID);
                if (deletedID > 0) {
                    tblModel.removeRow(tblManager.getSelectedRow());

                    JOptionPane.showMessageDialog(null, "Manager deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Manager not deleted successfully!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            if (tblManager.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single row!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteManagerActionPerformed

    private int getManagerID(String userName) {
        int toDeleteID = 0;
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT UserID FROM user WHERE UserType = 'Manager' AND  Username = '" + userName + "'";
            rs = stmt.executeQuery(sql);

            rs.next();
            toDeleteID = rs.getInt("UserID");

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return toDeleteID;
    }

    private int deleteManagerFromDB(int deleteID) {
        int deletedRows = 0;
        try {
            String sql = "DELETE FROM user WHERE UserID = ?  AND UserType = 'Manager'";

            pstmt = DBConnect.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, deleteID);

            int rowAffected = pstmt.executeUpdate();
            deletedRows = rowAffected;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return deletedRows;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddManager;
    private javax.swing.JButton btnDeleteManager;
    private javax.swing.JButton btnEditManager;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblManager;
    // End of variables declaration//GEN-END:variables
}

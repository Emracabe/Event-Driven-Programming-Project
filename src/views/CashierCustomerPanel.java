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
public class CashierCustomerPanel extends javax.swing.JInternalFrame {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public static HashMap<String, Integer> cashierMap = new HashMap<>();
    private int addressID = 0;

    /**
     * Creates new form TableCashier
     */
    public CashierCustomerPanel() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        getCustomersFromDB();
    }

    public void getCustomersFromDB() {
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT CONCAT(FirstName, ' ',  LastName) AS 'Name', ContactNumber, CONCAT(Street, ', ', Barangay, ', ', Municity) AS 'Address' FROM customer INNER JOIN address ON customer.AddressID = address.AddressID";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("Name");
                String contactNumber = rs.getString("ContactNumber");
                String address = rs.getString("Address");

                String[] data = {name, contactNumber, address};

                DefaultTableModel tblModel = (DefaultTableModel) tblCustomer.getModel();
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

        btnAddCustomer = new javax.swing.JButton();
        btnEditCustomer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        txtSearchCustomer = new javax.swing.JTextField();
        btnSearchCustomer = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setVisible(true);

        btnAddCustomer.setBackground(new java.awt.Color(0, 153, 0));
        btnAddCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCustomer.setText("ADD CUSTOMER");
        btnAddCustomer.setFocusable(false);
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        btnEditCustomer.setBackground(new java.awt.Color(255, 255, 0));
        btnEditCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEditCustomer.setText("EDIT CUSTOMER");
        btnEditCustomer.setToolTipText("");
        btnEditCustomer.setFocusable(false);
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });

        tblCustomer.setAutoCreateRowSorter(true);
        tblCustomer.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Contact Number", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomer.setMinimumSize(new java.awt.Dimension(50, 0));
        jScrollPane1.setViewportView(tblCustomer);

        txtSearchCustomer.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtSearchCustomer.setPreferredSize(new java.awt.Dimension(211, 25));
        txtSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchCustomerActionPerformed(evt);
            }
        });

        btnSearchCustomer.setBackground(new java.awt.Color(0, 102, 255));
        btnSearchCustomer.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnSearchCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchCustomer.setText("SEARCH CUSTOMER");
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchCustomer)))
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddCustomer)
                .addGap(49, 49, 49)
                .addComponent(btnEditCustomer)
                .addGap(191, 191, 191))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCustomer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCustomer)
                    .addComponent(btnEditCustomer))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        // TODO add your handling code here:
        new AddCustomerDialog(null, true);
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed
        // TODO add your handling code here:

        DefaultTableModel tblModel = (DefaultTableModel) tblCustomer.getModel();

        if (tblCustomer.getSelectedRowCount() == 1) {
            String contactNumber = tblModel.getValueAt(tblCustomer.getSelectedRow(), 1).toString();
            new EditCustomerDialog(null, true, getCustomerID(contactNumber));
        } else {
            if (tblCustomer.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single row!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditCustomerActionPerformed

    private void txtSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchCustomerActionPerformed

    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed
        // TODO add your handling code here:

        String toSearch = txtSearchCustomer.getText();

        if (toSearch.equals("")) {
            removeAllRowsTableCustomer();
            getCustomersFromDB();
        } else {
            DefaultTableModel tblModel = (DefaultTableModel) tblCustomer.getModel();

            removeAllRowsTableCustomer();

            try {
                stmt = DBConnect.getInstance().createStatement();

                String sql = "SELECT CONCAT(FirstName, ' ', LastName) AS 'Name', ContactNumber, CONCAT(Street, ', ', Barangay, ', ', Municity) AS 'Address' FROM Customer INNER JOIN Address ON Customer.AddressID = Address.AddressID WHERE LastName LIKE '"
                        + toSearch + "%'";

                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String name = rs.getString("Name");
                    String contactNumber = rs.getString("ContactNumber");
                    String address = rs.getString("Address");

                    String[] data = {name, contactNumber, address};

                    tblModel.addRow(data);
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void removeAllRowsTableCustomer() {
        DefaultTableModel tblModel = (DefaultTableModel) tblCustomer.getModel();

        int rowsToRemove = tblModel.getRowCount();
        //remove rows from the bottom one by one
        for (int i = rowsToRemove - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }
    }

    private int getCashierID(String userName) {
        int toDeleteID = 0;
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT UserID FROM user WHERE UserType = 'Cashier' AND Username = '" + userName + "'";
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

    private int getCustomerID(String contactNumber) {
        int customerID = 0;
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT CustomerID FROM customer WHERE ContactNumber = '" + contactNumber + "'";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);

            rs.next();
            customerID = rs.getInt("CustomerID");

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customerID;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtSearchCustomer;
    // End of variables declaration//GEN-END:variables
}

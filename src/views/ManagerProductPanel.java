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
import static views.CashierCustomerPanel.tblCustomer;

/**
 *
 * @author Anaclita
 */
public class ManagerProductPanel extends javax.swing.JInternalFrame {

    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public static HashMap<String, Integer> cashierMap = new HashMap<>();

    /**
     * Creates new form TableCashier
     */
    public ManagerProductPanel() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        getProductsFromDB();
    }

    public void getProductsFromDB() {
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT * FROM product";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String containerType = rs.getString("ContainerType");
                String waterType = rs.getString("WaterType");
                float price = rs.getFloat("Price");

                String[] data = {containerType, waterType, "Php " + price + "0"};

                DefaultTableModel tblModel = (DefaultTableModel) tblProduct.getModel();
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

        btnAddProduct = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        btnEditProduct = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setVisible(true);

        btnAddProduct.setBackground(new java.awt.Color(0, 153, 0));
        btnAddProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setText("ADD PRODUCT");
        btnAddProduct.setFocusable(false);
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnDeleteProduct.setBackground(new java.awt.Color(255, 0, 0));
        btnDeleteProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteProduct.setText("DELETE PRODUCT");
        btnDeleteProduct.setToolTipText("");
        btnDeleteProduct.setFocusable(false);
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });

        tblProduct.setAutoCreateRowSorter(true);
        tblProduct.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Container Type", "Water Type", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.setMinimumSize(new java.awt.Dimension(50, 0));
        jScrollPane1.setViewportView(tblProduct);

        btnEditProduct.setBackground(new java.awt.Color(255, 255, 0));
        btnEditProduct.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnEditProduct.setText("EDIT PRODUCT");
        btnEditProduct.setToolTipText("");
        btnEditProduct.setFocusable(false);
        btnEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddProduct)
                .addGap(30, 30, 30)
                .addComponent(btnEditProduct)
                .addGap(27, 27, 27)
                .addComponent(btnDeleteProduct)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct)
                    .addComponent(btnDeleteProduct)
                    .addComponent(btnEditProduct))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:
        new AddProductDialog(null, true);
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        // TODO add your handling code here:

        if (tblProduct.getSelectedRowCount() == 1) {

            DefaultTableModel tblModel = (DefaultTableModel) tblProduct.getModel();

            String containerType = tblModel.getValueAt(tblProduct.getSelectedRow(), 0).toString();
            String waterType = tblModel.getValueAt(tblProduct.getSelectedRow(), 1).toString();
            String priceString = tblModel.getValueAt(tblProduct.getSelectedRow(), 2).toString();
            float price = Float.parseFloat(priceString.replaceAll("[Php]", ""));
            String productName = containerType + " " + waterType;
            int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + productName + "?", "Delete", JOptionPane.YES_NO_OPTION);

            if (answer == 0) {

                int toDeleteProductID = getProductID(containerType, waterType);
                int rowAffected = deleteProductFromDB(toDeleteProductID);

                if (rowAffected > 0) {
                    tblModel.removeRow(tblProduct.getSelectedRow());

                    JOptionPane.showMessageDialog(null, "Product deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Product not deleted successfully!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else {
            if (tblProduct.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single row!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private int deleteProductFromDB(int customerID) {
        int deletedRows = 0;
        try {
            String sql = "DELETE FROM product WHERE ProductID = ?";

            pstmt = DBConnect.getInstance().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, customerID);

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

    private void btnEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProductActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tblModel = (DefaultTableModel) tblProduct.getModel();

        if (tblProduct.getSelectedRowCount() == 1) {
            String containerType = tblModel.getValueAt(tblProduct.getSelectedRow(), 0).toString();
            String waterType = tblModel.getValueAt(tblProduct.getSelectedRow(), 1).toString();
            new EditProductDialog(null, true, getProductID(containerType, waterType));
        } else {
            if (tblProduct.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please select a single row!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditProductActionPerformed

    private void removeAllRowsTableCustomer() {
        DefaultTableModel tblModel = (DefaultTableModel) tblProduct.getModel();

        int rowsToRemove = tblModel.getRowCount();
        //remove rows from the bottom one by one
        for (int i = rowsToRemove - 1; i >= 0; i--) {
            tblModel.removeRow(i);
        }
    }

    private int getProductID(String containerType, String waterType) {
        int foundProductID = 0;
        try {
            stmt = DBConnect.getInstance().createStatement();

            String sql = "SELECT ProductID FROM product WHERE "
                    + "ContainerType = '" + containerType + "' "
                    + "AND WaterType = '" + waterType + "' ";

            rs = stmt.executeQuery(sql);

            rs.next();
            foundProductID = rs.getInt("ProductID");
            System.out.println(foundProductID);

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return foundProductID;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btnEditProduct;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}

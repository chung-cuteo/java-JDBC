/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jdbc.exercise;

import com.jdbc.exercise.model.Nationality;
import com.jdbc.helper.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhnn
 */
public class MainFrame extends javax.swing.JFrame {
    private DefaultComboBoxModel<Nationality> model;
    private DefaultTableModel tblModel;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        loadNationality();
        
        initTable();
        
        loadTable();
    }
    
    private void loadNationality(){
        model = new DefaultComboBoxModel<>();
        
        model.addElement(new Nationality("vn", "Vietnam"));
        model.addElement(new Nationality("jp", "Japan"));
        model.addElement(new Nationality("us", "USA"));
        model.addElement(new Nationality("la", "Laos"));
        model.addElement(new Nationality("cm", "Compodia"));
        
        cbxNationality.setModel(model);
    }

    private void initTable(){
        tblModel = new DefaultTableModel();
        
        tblModel.setColumnIdentifiers(new String[]{"ID", "Name","Gender", "Address", "Tel", "Nationality"});

        tblList.setDefaultEditor(Object.class, null);
        
        tblList.setModel(tblModel);
    }
    
    private void loadTable(){
        String sql = "SELECT * FROM Persons";
        try (Connection con = DBHelper.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            
            try(ResultSet rs = pstmt.executeQuery();){
                tblModel.setRowCount(0);
                while (rs.next()){
                    Object[] row = new Object[]{
                       rs.getInt("id"),
                       rs.getString("name"),
                       rs.getBoolean("gender")? "Male": "Female",
                       rs.getString("address"),
                       rs.getString("tel"),
                       rs.getString("Nationality")
                    };
                    tblModel.addRow(row);
                }
                tblModel.fireTableDataChanged();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
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

        bgGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cbxNationality = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        txtId.setEditable(false);

        jLabel2.setText("Name:");

        jLabel3.setText("Address:");

        jLabel4.setText("Tel:");

        jLabel5.setText("Gender:");

        bgGender.add(rdbMale);
        rdbMale.setSelected(true);
        rdbMale.setText("Male");

        bgGender.add(rdbFemale);
        rdbFemale.setText("Female");

        jLabel6.setText("Nationality:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                                    .addComponent(txtName))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(rdbMale)
                        .addComponent(rdbFemale))
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        txtAddress.setText("");
        txtId.setText("");
        txtName.setText("");
        txtTel.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String sql = "INSERT INTO Persons(name, address, tel, gender, nationality) "
                + " values(?,?,?,?,?)";
        try (Connection con = DBHelper.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql, 
                        PreparedStatement.RETURN_GENERATED_KEYS)){
            
            pstmt.setString(1, txtName.getText());
            pstmt.setString(2, txtAddress.getText());
            pstmt.setString(3, txtTel.getText());
            
            pstmt.setBoolean(4, rdbMale.isSelected());
            var selected = (Nationality) cbxNationality.getSelectedItem();
            pstmt.setString(5, selected.getId());
            
            int rows = pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                txtId.setText("" + id);
            }
            
            JOptionPane.showMessageDialog(this, "Information is saved", 
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you want to update?",
                "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                == JOptionPane.NO_OPTION){
            return;
        }
        
        String sql = "UPDATE Persons set name=?, address = ?, tel =?, gender = ?, "
                + " nationality = ? where id = ?";
        try (Connection con = DBHelper.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1, txtName.getText());
            pstmt.setString(2, txtAddress.getText());
            pstmt.setString(3, txtTel.getText());
            
            pstmt.setBoolean(4, rdbMale.isSelected());
            var selected = (Nationality) cbxNationality.getSelectedItem();
            pstmt.setString(5, selected.getId());
            
            pstmt.setInt(6, Integer.parseInt(txtId.getText()));
            
            int rows = pstmt.executeUpdate();
                        
            JOptionPane.showMessageDialog(this, "Information is saved", 
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            loadTable();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Do you want to delete?",
                "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                == JOptionPane.NO_OPTION){
            return;
        }
        
        String sql = "DELETE FROM Persons where id = ?";
        try (Connection con = DBHelper.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setInt(1, Integer.parseInt(txtId.getText()));
            
            int rows = pstmt.executeUpdate();
                        
            JOptionPane.showMessageDialog(this, "Information is saved", 
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            loadTable();
            btnNewActionPerformed(evt);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        if (evt.getClickCount() ==  2){
            int selectRow = tblList.getSelectedRow();
            
            if (selectRow>= 1){
                txtId.setText(tblList.getValueAt(selectRow, 0).toString());
                txtName.setText(tblList.getValueAt(selectRow, 1).toString());
                var isMale = tblList.getValueAt(selectRow, 2).toString()
                                .equals("Male");
                rdbMale.setSelected(isMale);
                rdbFemale.setSelected(!isMale);
                txtAddress.setText(tblList.getValueAt(selectRow, 3).toString());
                txtTel.setText(tblList.getValueAt(selectRow, 4).toString());
                
                for (int i = 0; i < cbxNationality.getItemCount(); i++) {
                    var item= cbxNationality.getItemAt(i);
                    var selectedId = tblList.getValueAt(selectRow, 5).toString();

                    if (selectedId.trim().equals(item.getId())){
                        cbxNationality.setSelectedItem(item);
                        break;
                    }
                }
              
            }
        }
    }//GEN-LAST:event_tblListMouseClicked

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGender;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<Nationality> cbxNationality;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTable tblList;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
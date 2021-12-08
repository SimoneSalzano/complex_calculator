/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softwareengineering.assignment2021;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


public class PersonalizedOperationsWindow extends javax.swing.JPanel {

    private Manager manager;
    private DefaultTableModel model;
    private String keyModified;
    
    public PersonalizedOperationsWindow() {
        initComponents();
        manager = Manager.getManager();
        model = (DefaultTableModel)table.getModel();
        buildTable();
        
        //this anonymous class returns the key and the value of the selected row
        table.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent m){
                int row = table.getSelectedRow();
                keyModified = table.getModel().getValueAt(row, 0).toString();
            }
        });
        
        //this anonymous class is used to change the run-time operations, when the table is modified 
        table.getModel().addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e) {
                if(keyModified != null ){
                    try {
                        String newKey = model.getValueAt(e.getLastRow(),0).toString();
                        String newValue = model.getValueAt(e.getLastRow(),1).toString();
                        manager.editPersonalizedOperation(keyModified, newKey, newValue);
                    } catch (PersonalizedOperationException ex) {
                        keyModified = null;
                        buildTable();
                        JOptionPane.showMessageDialog(table, ex.getMessage());
                    }
                }
            }
        });  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        addOpButton = new javax.swing.JButton();
        removeOpButton = new javax.swing.JButton();
        clearOpButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        loadButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setName("Personalised Operation"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 72, 121));

        table.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240), new java.awt.Color(240, 240, 240)));
        table.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        table.setForeground(new java.awt.Color(0, 72, 121));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME ", "OPERATIONS"
            }
        ));
        table.setRowHeight(28);
        table.setRowMargin(2);
        table.setSelectionBackground(new java.awt.Color(255, 255, 255));
        table.setSelectionForeground(new java.awt.Color(128, 0, 128));
        table.setShowGrid(true);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel2.setBackground(new java.awt.Color(45, 161, 200));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        addOpButton.setBackground(new java.awt.Color(207, 237, 242));
        addOpButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addOpButton.setForeground(new java.awt.Color(0, 72, 121));
        addOpButton.setText("ADD");
        addOpButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        addOpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOpButtonActionPerformed(evt);
            }
        });

        removeOpButton.setBackground(new java.awt.Color(207, 237, 242));
        removeOpButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removeOpButton.setForeground(new java.awt.Color(0, 72, 121));
        removeOpButton.setText("REMOVE");
        removeOpButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        removeOpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeOpButtonActionPerformed(evt);
            }
        });

        clearOpButton.setBackground(new java.awt.Color(207, 237, 242));
        clearOpButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearOpButton.setForeground(new java.awt.Color(0, 72, 121));
        clearOpButton.setText("CLEAR");
        clearOpButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        clearOpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearOpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addOpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeOpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clearOpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearOpButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(removeOpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addOpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(55, 200, 180));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        saveButton.setBackground(new java.awt.Color(207, 237, 242));
        saveButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 72, 121));
        saveButton.setText("SAVE FILE");
        saveButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        loadButton1.setBackground(new java.awt.Color(207, 237, 242));
        loadButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loadButton1.setForeground(new java.awt.Color(0, 72, 121));
        loadButton1.setText("LOAD FILE");
        loadButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        loadButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loadButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(207, 237, 242));
        jSeparator1.setForeground(new java.awt.Color(207, 237, 242));
        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(207, 237, 242), new java.awt.Color(207, 237, 242), new java.awt.Color(207, 237, 242), new java.awt.Color(207, 237, 242)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method is used to save on file the run-time operations, showing a pop-up to ask for confirmation  
     * @param evt 
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Object[] options = {"yes","no"};
        int response = JOptionPane.showOptionDialog(table, "Are you sure you want to save?", "Saving", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "");
        if(response == 0){
            try {
                manager.saveMapToFile();
            } catch (ClassNotFoundException | IOException ex) {
                JOptionPane.showMessageDialog(table, ex.getMessage());
            }
            
        }
    }//GEN-LAST:event_saveButtonActionPerformed
    /**
     * This method is used to add new personalized operations to run-time by using pop-up to ask the name and operands of the operations. 
     * @param evt 
     */
    private void addOpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOpButtonActionPerformed
        keyModified = null;
        String name = JOptionPane.showInputDialog("Insert operation name");
        if(name != null){
            String operations = JOptionPane.showInputDialog("Insert operations separated by space");
            try {
                String newKey=manager.insertPersonalizedOperation(name,operations);
                model.addRow(new Object[]{newKey,operations});
            } catch (PersonalizedOperationException ex) {
                JOptionPane.showMessageDialog(table, ex.getMessage());
            }
        }
    }//GEN-LAST:event_addOpButtonActionPerformed
    /**
     * This method is used to load from file the run-time operations, showing a pop-up to ask for confirmation
     * @param evt 
     */
    private void loadButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButton1ActionPerformed
        keyModified = null;
        Object[] options = {"yes","no"};
        int response = JOptionPane.showOptionDialog(table, "Are you sure you want to load from file?", "Loading", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "");
        if(response == 0){
            try {
                manager.LoadMapToFile();
            } catch (ClassNotFoundException | IOException ex) {
                JOptionPane.showMessageDialog(table, ex.getMessage());
            }
        }
        buildTable();
        
    }//GEN-LAST:event_loadButton1ActionPerformed

    /**
     * This method is used to remove the selected personalized operations from run-time. 
     * @param evt 
     */
    private void removeOpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeOpButtonActionPerformed
        
        if(keyModified == null)
            JOptionPane.showMessageDialog(table, "You have to select the row you want to delete");
        else{
            try {
            manager.deletePersonalizedOperation(keyModified);
            buildTable();
            } catch (PersonalizedOperationException ex) {
            JOptionPane.showMessageDialog(table, ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_removeOpButtonActionPerformed

    /**
     * This method is used to remove all the personalized operations from run-time. 
     * @param evt 
     */
    private void clearOpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearOpButtonActionPerformed
        keyModified = null;
        Object[] options = {"yes","no"};
        int response = JOptionPane.showOptionDialog(table, "Are you sure you want to delete all operations? Unsaved operations into file will be deleted", "Clear", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "");
        if(response == 0){
            manager.clearMap();
            buildTable();
        }
    }//GEN-LAST:event_clearOpButtonActionPerformed

    //----------------------------------------------------------- Private methods -----------------------------------------------------------
    /**
     * This methods fill the table with the run-time operations
     */
    private void buildTable(){
        keyModified = null;
        model.setRowCount(0);
        Iterator<String> itr = manager.getPersonalizedOperations();
        while(itr.hasNext()){
            String[] words = itr.next().split(":");
            model.addRow(new Object[]{words[0],words[1]});
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOpButton;
    private javax.swing.JButton clearOpButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loadButton1;
    private javax.swing.JButton removeOpButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}




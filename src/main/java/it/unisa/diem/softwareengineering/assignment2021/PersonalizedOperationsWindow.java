/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softwareengineering.assignment2021;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andre
 */
public class PersonalizedOperationsWindow extends javax.swing.JPanel {

    private Manager manager;
    private DefaultTableModel model;
    private String keyModified;
    
    
    /**
     * Creates new form PersonalizedOperationsWindow
     */
    public PersonalizedOperationsWindow() {
        initComponents();
        manager = Manager.getManager();
        
        model = (DefaultTableModel)table.getModel();
        
        Iterator<String> itr = manager.getPersonalizedOperations();
        while(itr.hasNext()){
            String[] words = itr.next().split(":");
            model.addRow(new Object[]{words[0],words[1]});
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent m){
                int row = table.getSelectedRow();
                keyModified = table.getModel().getValueAt(row, 0).toString();
            }
        });
        
        table.getModel().addTableModelListener(new TableModelListener(){

            @Override
            public void tableChanged(TableModelEvent e) {
                //aggiornare il valore in base alla chiave
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        addOpButton = new javax.swing.JButton();
        loadButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 72, 121));

        table.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME ", "OPERATIONS"
            }
        ));
        table.setShowGrid(true);
        jScrollPane1.setViewportView(table);

        jSeparator1.setBackground(new java.awt.Color(45, 161, 200));

        jPanel1.setBackground(new java.awt.Color(45, 161, 200));

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

        addOpButton.setBackground(new java.awt.Color(207, 237, 242));
        addOpButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addOpButton.setForeground(new java.awt.Color(0, 72, 121));
        addOpButton.setText("ADD OPERATIONS");
        addOpButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        addOpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOpButtonActionPerformed(evt);
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
                .addGap(22, 22, 22)
                .addComponent(addOpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(loadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addOpButton, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                        .addComponent(loadButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Object[] options = {"yes","no"};
        int n = JOptionPane.showOptionDialog(saveButton, "Are you sure you want to save?", "Saving", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "");
        if(n == 0){
            //manager.saveMapToFile();
            
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void addOpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOpButtonActionPerformed
        String name = JOptionPane.showInputDialog("Insert operation name");
        String operations = JOptionPane.showInputDialog("Insert operations separated by space");
        try {
            manager.insertPersonalizedOperation(name,operations);
            model.addRow(new Object[]{name,operations});
        } catch (PersonalizedOperationException ex) {
            Logger.getLogger(PersonalizedOperationsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addOpButtonActionPerformed

    private void loadButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOpButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loadButton1;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}


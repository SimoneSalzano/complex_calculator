package it.unisa.diem.softwareengineering.assignment2021;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class GUI extends javax.swing.JFrame {
    
    
    Manager manager;
    private final static int readlimiter = 12; //.... 
    PersonalizedOperationsWindow opPane = new PersonalizedOperationsWindow();
        JFrame fram = new JFrame();
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        manager = Manager.getManager();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        inputTextField = new javax.swing.JTextField();
        computeButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        clearButton = new javax.swing.JButton();
        dropButton = new javax.swing.JButton();
        dupButton = new javax.swing.JButton();
        overButton = new javax.swing.JButton();
        swapButton = new javax.swing.JButton();
        memoButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Complex Calculator");

        jPanel1.setBackground(new java.awt.Color(0, 72, 121));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("DialogInput", 1, 20)); // NOI18N
        textArea.setForeground(new java.awt.Color(10, 82, 121));
        textArea.setRows(5);
        textArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(207, 237, 242), new java.awt.Color(207, 237, 242), null, null));
        textArea.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(textArea);

        jPanel2.setBackground(new java.awt.Color(45, 161, 200));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(207, 237, 242), 1, true));

        inputTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inputTextField.setForeground(new java.awt.Color(0, 72, 121));
        inputTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        inputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputTextFieldKeyPressed(evt);
            }
        });

        computeButton.setBackground(new java.awt.Color(207, 237, 242));
        computeButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        computeButton.setForeground(new java.awt.Color(0, 72, 121));
        computeButton.setText("COMPUTE");
        computeButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        computeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(computeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(inputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(computeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addContainerGap())
        );

        jSeparator1.setBackground(new java.awt.Color(45, 161, 200));
        jSeparator1.setForeground(new java.awt.Color(207, 237, 242));

        jPanel3.setBackground(new java.awt.Color(45, 161, 200));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(207, 237, 242), 1, true));

        clearButton.setBackground(new java.awt.Color(207, 237, 242));
        clearButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clearButton.setForeground(new java.awt.Color(0, 72, 121));
        clearButton.setText("CLEAR");
        clearButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        dropButton.setBackground(new java.awt.Color(207, 237, 242));
        dropButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dropButton.setForeground(new java.awt.Color(0, 72, 121));
        dropButton.setText("DROP");
        dropButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        dropButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropButtonActionPerformed(evt);
            }
        });

        dupButton.setBackground(new java.awt.Color(207, 237, 242));
        dupButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dupButton.setForeground(new java.awt.Color(0, 72, 121));
        dupButton.setText("DUP");
        dupButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        dupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dupButtonActionPerformed(evt);
            }
        });

        overButton.setBackground(new java.awt.Color(207, 237, 242));
        overButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        overButton.setForeground(new java.awt.Color(0, 72, 121));
        overButton.setText("OVER");
        overButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        overButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overButtonActionPerformed(evt);
            }
        });

        swapButton.setBackground(new java.awt.Color(207, 237, 242));
        swapButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        swapButton.setForeground(new java.awt.Color(0, 72, 121));
        swapButton.setText("SWAP");
        swapButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        swapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                swapButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(dropButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dupButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(overButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(swapButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dropButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overButton, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(swapButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        memoButton.setBackground(new java.awt.Color(207, 237, 242));
        memoButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        memoButton.setForeground(new java.awt.Color(0, 72, 121));
        memoButton.setText("MEMO");
        memoButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 72, 121), 0, true));
        memoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(memoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(memoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method is called when the button is pressed or when in the inputTextFiled area the "enter" key
     * is pressed, it is used to insert a new number, operator or function in the memory, (take it from the inputTextField) 
     * @param evt 
     */
    private void computeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computeButtonActionPerformed

        if(computeButton.isEnabled())
            runTask(inputTextField.getText());
    }
    
//GEN-LAST:event_computeButtonActionPerformed
    /**
     * This method is called when the user press the "enter" key inside the inputTextField.
     * This is the equivalent of clicking on the button "compute" 
     * @param evt 
     */
    private void inputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextFieldKeyPressed
        if(KeyEvent.VK_ENTER == evt.getKeyCode()){
            computeButton.doClick();
        }
    }//GEN-LAST:event_inputTextFieldKeyPressed

    /**
     * This method clear the memory
     * @param evt 
     */
    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        runTask("clear");
    }//GEN-LAST:event_clearButtonActionPerformed
    /**
     * This method drop the last element inserted in the memory
     * @param evt 
     */
    private void dropButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropButtonActionPerformed
        runTask("drop");
    }//GEN-LAST:event_dropButtonActionPerformed
    /**
     * This method duplicate the last element inserted in the memory
     * @param evt 
     */
    private void dupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dupButtonActionPerformed
        runTask("dup");
    }//GEN-LAST:event_dupButtonActionPerformed
    /**
     * This method duplicate the penultimate element inserted in the memory
     * @param evt 
     */
    private void overButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overButtonActionPerformed
        runTask("over");
    }//GEN-LAST:event_overButtonActionPerformed
    /**
     * This method swap the last and the penultimate element inserted in the memory
     * @param evt 
     */
    private void swapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_swapButtonActionPerformed
        runTask("swap");
    }//GEN-LAST:event_swapButtonActionPerformed

    private void memoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memoButtonActionPerformed

        fram.add(opPane);
        fram.setVisible(true);
        fram.pack();
    }//GEN-LAST:event_memoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
                
            }
        });
    }
    
    //------------------------------------------- Private methods ------------------------------------------------------------------
    
    /**
     * This methods check if the input (operators, function, operators) is valid and run the task required or, it will notificate an error through a pop-up notification
     * @param text 
     */
    private void runTask(String text){
        computeButton.setEnabled(false);
        clearButton.setEnabled(false);
        dropButton.setEnabled(false);
        dupButton.setEnabled(false);
        overButton.setEnabled(false);
        swapButton.setEnabled(false);
        
        try{ 
            manager.processInput(text);
            
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "The inserted element is neither a number nor an operation!");
            
        } catch (NotEnoughOperatorsException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(rootPane, "Arithmetic Error: " + ex.getMessage());
            
        }finally{
            printOnTextArea();
            computeButton.setEnabled(true);
            clearButton.setEnabled(true);
            dropButton.setEnabled(true);
            dupButton.setEnabled(true);
            overButton.setEnabled(true);
            swapButton.setEnabled(true);
        }
    }
    
    /**
     * This method is called whenever a methods needs to update the Output in the textArea (it also clean the inputTextfield). 
     */ 
    private void printOnTextArea(){
        inputTextField.setText(""); //clean the inputTextField
        Iterator<ComplexNumber> memory = manager.getMemory();
        int flag = 0;
        String str = "";
        while (memory.hasNext() && flag < readlimiter){
            ComplexNumber a = memory.next();
            str = a.toString() +"\n" + str;
            flag += 1;
        }
        textArea.setText(str);
            
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearButton;
    private javax.swing.JButton computeButton;
    private javax.swing.JButton dropButton;
    private javax.swing.JButton dupButton;
    private javax.swing.JTextField inputTextField;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton memoButton;
    private javax.swing.JButton overButton;
    private javax.swing.JButton swapButton;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}

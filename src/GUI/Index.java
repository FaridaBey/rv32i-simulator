/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;


/**
 *
 * @author Hassan
 */
public class Index extends javax.swing.JFrame {
 public static Map <Integer, Integer> Data_Memory_UserI;
    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
        Data_Memory_UserI=new LinkedHashMap<>();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Test1 = new javax.swing.JButton();
        Test2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        StartingAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AssemblyCode = new javax.swing.JTextArea();
        Submit = new javax.swing.JButton();
        Data_Entry = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RISC V SIM");
        setName("Index"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(48, 52, 112));
        jPanel1.setForeground(new java.awt.Color(48, 52, 112));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/10872782.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RISC-V Simulator");

        Test1.setBackground(new java.awt.Color(255, 153, 0));
        Test1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Test1.setForeground(new java.awt.Color(255, 255, 255));
        Test1.setText("Factorial");
        Test1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Test1ActionPerformed(evt);
            }
        });

        Test2.setBackground(new java.awt.Color(255, 153, 0));
        Test2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Test2.setForeground(new java.awt.Color(255, 255, 255));
        Test2.setText("String Copy");
        Test2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Test2ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_________________________________");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tests : ");
        jLabel7.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(Test1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Test2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(46, 46, 46)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(Test1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Test2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Enter Starting Address :");

        jLabel4.setText("________________________________________________________________________");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Enter RISC-V Assembly Code : ");

        AssemblyCode.setColumns(20);
        AssemblyCode.setRows(5);
        jScrollPane1.setViewportView(AssemblyCode);

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        Data_Entry.setText("Enter Data");
        Data_Entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Data_EntryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Data_Entry, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StartingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(StartingAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit)
                    .addComponent(Data_Entry))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
     if(AssemblyCode.getText().isEmpty()){
     JOptionPane.showMessageDialog(this, "Must Enter Assembly Code" , "Empty Field",  JOptionPane.WARNING_MESSAGE);
     }
     else{
        String Assembly_Code = AssemblyCode.getText();
        
        String Starting_AddressTEMP = StartingAddress.getText();
        try{
        int Starting_Address=Integer.parseInt(Starting_AddressTEMP);
        Viewer v = new Viewer(Assembly_Code, Starting_Address, Data_Memory_UserI){}; 
        v.setVisible(true);
        this.dispose();
        }
        catch(NumberFormatException e){
        
         JOptionPane.showMessageDialog(this, "Must Enter Starting Address" , "Empty Starting Address",  JOptionPane.WARNING_MESSAGE);
        
        }
     }
    }//GEN-LAST:event_SubmitActionPerformed

    private void Test1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Test1ActionPerformed
        // TODO add your handling code here:
        AssemblyCode.setText("");
        StartingAddress.setText("96");
        AssemblyCode.setText("addi x10,x10,2"+"\n"+"addi x2,x2,-8" + "\n"+ "sw x1,4 (x2)"+"\n" + "sw x10,0 (x2)" + "\n"+ "sltiu x5,x10,1"+"\n"+ "beq x5,x0,132"+"\n"+ "addi x10,x0,1"+"\n"+ "addi x2,x2,8"+"\n"+ "FENCE"+"\n"+ "addi x10,x10,-1"
        +"\n"+ "jal x1,100" +"\n"+ "addi x5,x10,0" +"\n"+ "lw x10,0 (x2)"+"\n"+ "lw x1,4 (x2)"+"\n"+ "addi x2,x2,8"+"\n"+ "mul x10,x10,8"+"\n"+ "FENCE" //Needs to be reworked
        
        );
        
    }//GEN-LAST:event_Test1ActionPerformed

    private void Data_EntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Data_EntryActionPerformed
        // TODO add your handling code here:
        
        Data_Entry_GUI DEG = new Data_Entry_GUI();
        DEG.setVisible(true);
    }//GEN-LAST:event_Data_EntryActionPerformed

    private void Test2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Test2ActionPerformed
        // TODO add your handling code here:

        AssemblyCode.setText("");
        
        AssemblyCode.setText("addi x2,x2,-4" + "\n"+ "sw x8,0 (x2)"+"\n" + "add x8,x0,x0" + "\n"+ "add x6,x8,x11"+"\n"+ "lbu x7,0 (x6)"+"\n"+ "add x28,x8,x10"+"\n"+ "sb x7,0 (x28)"+"\n"+ "beq x6,x0,144"+"\n"+ "addi x8,x8,1"
        +"\n"+ "beq x0,x0,112" +"\n"+ "lw x8,0 (x2)" +"\n"+ "addi x2,x2,4"+"\n"+ "lw x1,4 (x2)"+"\n"+ "ECALL"); //Needs to be reworked
        
    }//GEN-LAST:event_Test2ActionPerformed

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AssemblyCode;
    private javax.swing.JButton Data_Entry;
    private javax.swing.JTextField StartingAddress;
    private javax.swing.JButton Submit;
    private javax.swing.JButton Test1;
    private javax.swing.JButton Test2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

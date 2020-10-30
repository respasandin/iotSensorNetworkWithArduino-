package com.core;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App extends javax.swing.JFrame {
    public  String time;
    static int timeinterval;
    
    public App() {
        initComponents();
        }   
          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        connect = new javax.swing.JButton();
        data = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        connect.setBackground(new java.awt.Color(153, 204, 255));
        connect.setText("Conectar");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        data.setBackground(new java.awt.Color(153, 204, 255));
        data.setText("Base de datos");
        data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataActionPerformed(evt);
            }
        });

        jLabel1.setText("Intervalo de actualización");

        jMenuBar1.setForeground(new java.awt.Color(0, 153, 204));

        jMenu1.setForeground(new java.awt.Color(0, 153, 204));
        jMenu1.setText("INICIO");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(connect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(data))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connect)
                    .addComponent(data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
           time = jTextField1.getText(); 
           timeinterval = Integer.parseInt(time);
        try {
            saltar();
        } catch (IOException | InterruptedException | SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_connectActionPerformed
    public void saltar() throws IOException, InterruptedException, SQLException{
          final connection rec = new connection("");
          rec.pack();
    }
    private void dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataActionPerformed
        time = jTextField1.getText(); 
        timeinterval = Integer.parseInt(time);
        try {
            refmenu2=new receiveData(this,true);
            refmenu2.setVisible(true);
            this.setVisible(false);
        } catch (IOException | InterruptedException | SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_dataActionPerformed

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
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
receiveData refmenu2=null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connect;
    private javax.swing.JButton data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}

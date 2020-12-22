package com.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Ventana3 extends javax.swing.JFrame {
    App refventanainicial=null;
    public ResultSet rs;
    public Statement stmt;
    public Connection con;
    DefaultTableModel modelo;
    public ResultSet rs2;
    public Statement stmt2;
    public Connection con2;
    DefaultTableModel modelo2;  
    String []datos2 = new String [2];
    String []datos = new String [2];  
    ChartPanel frame;
    ChartPanel frame2;
    DefaultCategoryDataset data2;
    DefaultCategoryDataset data;
    private String host = "127.0.0.1";
    private int db_port = 8889;
    
    public Ventana3(java.awt.Frame parent, boolean modal) throws IOException, InterruptedException, SQLException {
        initComponents();
        refventanainicial= (App)parent;
        DatosTabla();
        Receive();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exit2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exit2.setBackground(new java.awt.Color(153, 204, 255));
        exit2.setText("Volver");
        exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Valor"
            }
        ));
        jTable1.setName("Sensor de PH"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setText("Refrescar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Valor"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sensor de PH");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Sensor de conductividade");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(153, 204, 255));
        jButton2.setText("Gráficas tempo real");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(95, 95, 95)
                            .addComponent(jButton2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exit2)
                            .addGap(3, 3, 3))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(51, 51, 51)))
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit2)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void Receive() throws IOException, InterruptedException{
        final connection rec = new connection("");
        rec.pack();
        connection.demo.setVisible(false);
        connection.demo2.setVisible(false);
    } 
    private void exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit2ActionPerformed
       this.setVisible(false); 
       new App().setVisible(true);
       frame2.setVisible(false);
       frame.setVisible(false);
       connection.demo.setVisible(false);
       connection.demo2.setVisible(false);
    }//GEN-LAST:event_exit2ActionPerformed
    public void DatosTabla() {
        modelo= new DefaultTableModel();
        modelo.addColumn("Fecha");
        modelo.addColumn("Valor");
    
        jTable1.setModel(modelo);
        TableColumn column1 =  jTable1.getColumn("Valor");
        column1.setPreferredWidth(1);

        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + db_port + "/'" + App.host + "'?user=root&password=root");
            stmt=con.createStatement();
            rs =stmt.executeQuery("SELECT * FROM ph");
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                modelo.addRow(datos);
            }
            jTable1.setModel(modelo);
        }catch (SQLException ex) {
            Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modelo2= new DefaultTableModel(); 
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Valor (μS/m)");
        
    
        jTable2.setModel(modelo2);
        TableColumn column =  jTable2.getColumn("Valor (μS/m)");
        column.setPreferredWidth(1);
        try {
            con2 = DriverManager.getConnection("jdbc:mysql://" + host + ":" + db_port + "/'" + App.host + "'?user=root&password=root");
            stmt2=con2.createStatement();
            rs2 =stmt2.executeQuery("SELECT * FROM conductividade");
            while(rs2.next()){
                datos2[0]=rs2.getString(1);
                datos2[1]=rs2.getString(2);
                modelo2.addRow(datos2);
            }
            jTable2.setModel(modelo2);
        }catch (SQLException ex) {
            Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
        }
        drawPH();
        drawC();
  }          
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modelo= new DefaultTableModel();
        modelo2= new DefaultTableModel();
        DatosTabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        connection.demo.setVisible(true);
        connection.demo2.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    @SuppressWarnings("empty-statement")
    private void drawPH(){
        data = new DefaultCategoryDataset();
        int i;

        for ( i = 0; i < modelo.getRowCount(); i++){
                String valor = modelo.getValueAt(i,0).toString();
                Double dia = Double.valueOf(modelo.getValueAt(i ,1).toString().trim());
                data.addValue(dia, "", valor);
        }
            JFreeChart Chart = ChartFactory.createLineChart("Sensor de PH",
                    "", "PH", data, PlotOrientation.VERTICAL,
                    false, false, false);  
            jPanel1.setLayout(new BorderLayout());
            frame = new ChartPanel(Chart);
            frame.setFont(new Font("Serif", Font.PLAIN, 11));
            frame.setPreferredSize(new java.awt.Dimension(1050, 200));
            Chart.setBackgroundPaint(Color.WHITE);
            jPanel1.add(frame,BorderLayout.CENTER);
            frame.setVerticalAxisTrace(true);
            jPanel1.validate();       
        }       
    private void drawC(){
        data2 = new DefaultCategoryDataset();
        int i2;
        
        for ( i2 = 0; i2 < modelo2.getRowCount(); i2++){
                String valor2 = modelo2.getValueAt(i2,0).toString();
                Double dia2 = Double.valueOf(modelo2.getValueAt(i2 , 1).toString());
                data2.addValue(dia2, "", valor2);
        }

            JFreeChart Chart2 = ChartFactory.createLineChart("Sensor condutividade",
                    "", "µS/cm", data2, PlotOrientation.VERTICAL, 
                    false, false, false);
            jPanel2.setLayout(new BorderLayout());
            frame2 = new ChartPanel(Chart2);
            Chart2.setBackgroundPaint(Color.WHITE);
            frame2.setPreferredSize(new java.awt.Dimension(1050, 200));
            frame2.setBackground(Color.WHITE);
            frame2.setVerticalAxisTrace(true);
            jPanel2.add(frame2,BorderLayout.CENTER);
            jPanel2.validate();
    }
  
    

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
            Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventana3 dialog = null;
                try {
                    dialog = new Ventana3(new javax.swing.JFrame(), true);
                } catch (IOException ex) {
                    Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana3.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

}

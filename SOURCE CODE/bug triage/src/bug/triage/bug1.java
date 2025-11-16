/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bug.triage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author admin
 */
public class bug1 extends javax.swing.JFrame {
    static final String url = "jdbc:mysql://localhost:3306/bug";
    static final String driver = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String passw = "root";
    int t[]=new int[1000];
    String u[]=new String[1000];
    String v[]=new String[1000];
    String x[]=new String[1000];
    String a[]=new String[1000];
    String w[]=new String[1000];
    String l[]=new String[1000];
    String kl[]=new String[1000];
    Double se1[]=new Double[1000];
    Double se2[]=new Double[1000];
    Double se3[]=new Double[1000];
    Double se4[]=new Double[1000];
    /**
     * Creates new form bug1
     */
    public bug1() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "----------Select IS Data---------", "JPA", "MRSE", "Foundati", "UI", "MRSE", "Sourwst.xsd", "Debug", "cdt-core", "Tasks", "Compiler", "Outline", "Debugger", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(280, 110, 220, 40);

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 200, 790, 310);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Data Reduction of Instance Selection");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(230, 30, 330, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Computational Data");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 110, 140, 40);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(680, 530, 100, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bug/triage/partner_icon1.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(600, 0, 250, 220);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
          try{
            int i=0;
            Connection con = null;
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passw);
            stmt =(Statement) con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bug1");
            while(rs.next())
            {
                t[i]=rs.getInt("id");
                u[i]=rs.getString("product");
                v[i]=rs.getString("comp");
                x[i]=rs.getString("assignee");
                a[i]=rs.getString("triage");
                w[i]=rs.getString("resolution");
                l[i]=rs.getString("summary");
                kl[i]=rs.getString("changed");
                i++;
            }
            DefaultTableModel model=new DefaultTableModel();
            jTable1.setModel(model);
            model.addColumn("id");
            model.addColumn("product");
            model.addColumn("comp");
            model.addColumn("resolution");
            model.addColumn("summary");
            model.addColumn("changed");
            String str=(String)jComboBox2.getSelectedItem();
            for(int j=0;j<i;j++)
            {
                if(str.equals(v[j]))
                {
                    //                   ResultSet results = stmt.executeQuery("select id,product,comp, resolution from bug1");
                    //            jTable1.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(results));
                    model.addRow(new Object[] {t[j],u[j],v[j],w[j],l[j],kl[j]});
                   // stmt.executeUpdate("Insert into `bug1`(`id`,`product`,`comp`,`resolution`,`summary`,`changed`) values ('" +t[j]+ "','" +u[j]+ "','"+v[j]+"','"+w[j]+"','"+l[j]+"','"+kl[j]+"')");

                }
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new bug2().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(bug1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bug1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bug1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bug1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bug1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

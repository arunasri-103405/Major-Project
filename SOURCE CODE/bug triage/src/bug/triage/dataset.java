
package bug.triage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class dataset extends javax.swing.JFrame {
    Connection con;
    static Statement st;
    static ResultSet rs, rs1;
    static int row;
    static String s, name;
    private String tname;
    private int i;
    private String o;
    private String fn;
    JFileChooser chooser;
    String filename;
    File input, splitInput;
    FileReader fr;
  
    public dataset() {
        initComponents();
            try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "bug";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url + db, "root", "root");
            st = (Statement) con.createStatement();
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTable1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(360, 140, 610, 330);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setOpaque(false);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 140, 330, 330);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 530, 130, 40);

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Load Dataset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(290, 530, 170, 40);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(550, 530, 120, 40);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("Next");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(770, 530, 110, 40);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("DataSet Collection And Loading into DB");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(290, 60, 360, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bug/triage/Scholarship-icon1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(794, 11, 170, 120);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1010, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            try {
            JFileChooser jf = new JFileChooser();
            jf.showOpenDialog(null);
            File f = jf.getSelectedFile();
            s = f.getPath();
            name = f.getName();
            FileReader fr;
            String str = null;
            fr = new FileReader(s);
            filename = s;
            BufferedReader br = new BufferedReader(fr);
            while ((str = br.readLine()) != null) {
            jTextArea1.append("\n" + str);
            }
            } catch (Exception e) {
            System.err.println(e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            try {
            Vector col = new Vector();
            Vector data = new Vector();
            System.out.println("Connected to the database");
            rs = (ResultSet) st.executeQuery("select * from bug1");
            ResultSetMetaData md = (ResultSetMetaData) rs.getMetaData();
            int columns = md.getColumnCount();
            for(int i = 1; i <= columns; i++) {
            col.addElement(md.getColumnName(i));
            }
            while(rs.next()) {
            Vector row = new Vector(columns);
            for(int i = 1; i <= columns; i++) {
            row.addElement(rs.getObject(i));
            }
            data.addElement(row);
            }
            DefaultTableModel model = new DefaultTableModel(data, col);
            jTable1.setModel(model);
            JOptionPane.showMessageDialog(null, "Datas has been successfully viewed");
            }catch(Exception e){
            System.out.println(e.getMessage());
            }
            try {
            String url = "jdbc:mysql://localhost:3306/";
            String db = "bug";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url + db, "root", "root");
            st = (Statement) con.createStatement();
            }catch (Exception e) {
            System.out.println(e.getMessage());
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            try {
            String g;
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bug", "root", "root");
            PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement("truncate table bug1");
            ps1.executeUpdate();
            ps1.close();
            BufferedReader br = new BufferedReader(new FileReader(filename));
            g = br.readLine();
            while ((g = br.readLine()) != null) {
            String str = g;
            String str1 = str.replaceAll("\\s+", "");
            System.out.println("items " + str1);
            String[] tokens = str1.split(",");
            Statement st = (Statement) conn.createStatement();
            for (i = 0; i < tokens.length; i += 8) {
            if (tokens[3].length() < 2) {
            tokens[3] = "" + 0;
            }
            System.out.println(tokens.length);
          
            st.executeUpdate("Insert into bug1 values('" + tokens[i] + "','" + tokens[i + 1] + "','" + tokens[i + 2] + "','" + tokens[i + 3] + "','" + tokens[i + 4] + "','" + tokens[i + 5] + "','" + tokens[i + 6] + "','" + tokens[i + 7] + "')");
         
            System.out.println(i);
            }
            }
            JOptionPane.showMessageDialog(null, "Datas has been loaded");
            } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            new preprocess().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(dataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dataset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

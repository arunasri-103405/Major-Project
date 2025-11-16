/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bug.triage;
import java.sql.*;




public class jdbcConn {
    public static String output1;
    public static void main(String[] args) throws Exception{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection
      ("jdbc:mysql://localhost:3306/bug", "root", "root");
      Statement stmt = con.createStatement();
      String query[] ={"SELECT * FROM bug1 where id=1", 
      "select product from bug1 ",
      "select product from bug1 "};
      for(String q : query){
         ResultSet rs = stmt.executeQuery(q);
         System.out.println("Names for query "+q+" are");
         while (rs.next()) {
            String name = rs.getString("product");
           System.out.print( name+"  ");
            output1=name;
         }
        // System.out.println();
      }
   }
}
//where product like 'EclipseL_'"
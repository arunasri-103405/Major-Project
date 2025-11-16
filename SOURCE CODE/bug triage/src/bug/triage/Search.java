/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bug.triage;
import java.io.*;
import java.sql.*;
import java.util.*;
/**
 *
 * @author admin
 */
public class Search {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    try {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bug", "user", "root");
        Statement stmt = (Statement) con.createStatement();
        System.out.print("enter search: ");
        String name = input.next();
        String SQL = "SELECT * FROM  bug1 where product LIKE '" + name + "'";
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            System.out.println("Product: " +rs.getString("product"));
            System.out.println("comp:  " + rs.getString("comp") );
            System.out.println("assignee: " + rs.getString("assignee"));
        }
    } catch (Exception e) {
        System.out.println("ERROR: " + e.getMessage());
    }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kai
 */
public class SqlQuery {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection con = DriverManager.getConnection("jdbc:h2:/home/kai/NetBeansProjects/testProject/demo-sakila", "sa", "");
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from ACTOR");
        printRS(rs);
    }
    private static void printRS(ResultSet rs) throws SQLException {
        for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            System.out.print(rs.getMetaData().getColumnName(i) + "\t");
        }
        System.out.println();
        while(rs.next()) {
            for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                System.out.print(rs.getObject(i) + "\t");
            }
            System.out.println();
        }
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kai
 */
public class SqlQueryTable {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SwingUtilities.invokeLater(() -> {
            try {
                rmain();
            } catch (SQLException ex) {
                Logger.getLogger(SqlQueryTable.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SqlQueryTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    private static void rmain() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection con = DriverManager.getConnection("jdbc:h2:/home/kai/NetBeansProjects/testProject/demo-sakila", "sa", "");
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from ACTOR");
        
        DefaultTableModel dataModel = new DefaultTableModel();

        for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            dataModel.addColumn(rs.getMetaData().getColumnName(i));
        }
        
        while(rs.next()) {
            Object[] row = new Object[rs.getMetaData().getColumnCount()];
            for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row[i-1] = rs.getObject(i);
            }
            dataModel.addRow(row);
        }
        
        
        JFrame frame = new JFrame("Yo yo");
        
        
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);
        
        frame.setContentPane(scrollpane);
        
        scrollpane.setVisible(true);
        table.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author kai
 */
public class TestProject {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    //createAndShowGUI();
                    rmain();
                } catch (InterruptedException ex) {
                    Logger.getLogger(TestProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public static void rmain() throws InterruptedException {
        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() {
                return 10;
            }

            public int getRowCount() {
                return 10;
            }

            public Object getValueAt(int row, int col) {
                return new Integer(row * col);
            }
        };
        
        JFrame frame = new JFrame("Yo yo");
        
        
        JTable table = new JTable(dataModel);
        //JScrollPane scrollpane = new JScrollPane(table);
        //JPanel panel = new JPanel(new GridLayout(1,0));
        JPanel panel = new JPanel();
        //panel.add(scrollpane);
        panel.add(table);
        
        frame.setContentPane(panel);
        
        //scrollpane.setVisible(true);
        table.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        Thread.sleep(3000);
    }
}

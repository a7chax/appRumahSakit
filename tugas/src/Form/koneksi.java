/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 
/**
 *
 * @author asus
 */
public class koneksi {
    Connection c;
    
    public Connection getKoneksi(){
        try {
            c = DriverManager.getConnection(
                "jdbc:mysql:/localhost/appPasienRawatJalan","root","asusa442u");
            
            JOptionPane.showMessageDialog(
                    null, "Koneksi berasil","Status koneksi", 
                    JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }
}

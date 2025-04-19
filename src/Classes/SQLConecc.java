
package Classes;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author manu_
 */
public class SQLConecc {
    Connection con;

    public Connection establecconecction(){
        
    try{
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/negocio_bd", "root", "a@_1e?i5-T!c8");
    //JOptionPane.showMessageDialog(null, "Se conecto correctamente a la base de datos");
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, "Problemas en la conexion"+ e.toString());
    }
    return con;
    }
    
}

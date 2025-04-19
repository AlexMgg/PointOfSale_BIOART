package Classes;

import app.AdminOpts;
import app.Admin_Login;
import app.Generacion_De_Tickets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author manu_
 */
public class Login {

    public static boolean ismngr=false;

    public void validadUser(JTextField user, JPasswordField password) {

        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            Classes.SQLConecc objtConct = new Classes.SQLConecc();
            String consulta = "select * from admin where admin.Username =(?) and admin.Password=(?);";
            ps = objtConct.establecconecction().prepareStatement(consulta);
            String conrasenia = String.valueOf(password.getPassword());
            ps.setString(1, user.getText());
            ps.setString(2, conrasenia);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bienvenid@ a la Base de Datos");
                AdminOpts optionsobjtc = new AdminOpts();
                optionsobjtc.setVisible(true);
                ismngr = true;
            } else {
                JOptionPane.showMessageDialog(null, "El Usuario o contraseña es incorrecto");
                ismngr = false;
            }
        } catch (Exception e) {
            //mensaje de error
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }

    }

    public void validademploy(JTextField user, JPasswordField password) {

        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            Classes.SQLConecc objtConct = new Classes.SQLConecc();
            String consulta = "select * from empleado where empleado.EmpleadoUsrname =(?) and empleado.EmpleadoPsswrd=(?);";
            ps = objtConct.establecconecction().prepareStatement(consulta);
            String conrasenia = String.valueOf(password.getPassword());
            ps.setString(1, user.getText());
            ps.setString(2, conrasenia);
            rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bienvenid@ a el Sistema BIOART");


                ismngr = true;
                Generacion_De_Tickets g = new Generacion_De_Tickets();
                
                g.empnom.setText(rs.getNString("EmpleadoNombr"));
                g.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "El Usuario o contraseña es incorrecto");
                ismngr = false;
            }
        } catch (Exception e) {
            //mensaje de error
            JOptionPane.showMessageDialog(null, "ERROR: " + e.toString());
        }

    }
}

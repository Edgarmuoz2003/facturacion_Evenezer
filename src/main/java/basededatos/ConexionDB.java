package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    public static Connection conectar(){
        Connection conexion =null;
        try {
            String url="jdbc:mysql://localhost:3306/fact";
            String usuario="root";
            String clave="";
            
            conexion = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }       
}

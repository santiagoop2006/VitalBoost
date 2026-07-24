package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    // Datos de tu base de datos en Railway
    String url = "mysql://root:PoVLzuJGGwMgixvpNbFnGyuPCsCKfIAc@sakura.proxy.rlwy.net:43241/railway";
    String user = "root";
    String pass = "PoVLzuJGGwMgixvpNbFnGyuPCsCKfIAc";

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("¡Conexión exitosa a la base de datos de Railway!");
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e);
        }
        return con;
    }
}

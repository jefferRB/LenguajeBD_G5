package com.example.demo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
<<<<<<< Updated upstream
import javax.swing.JOptionPane;


=======
>>>>>>> Stashed changes

public class Conexion {

    private static Connection conn = null;
<<<<<<< Updated upstream
    private static String login = "JAVA";
    private static String clave = "JAVA";
    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl1";
    
    public static Connection getConnection(){
=======
    private static final String LOGIN = "JAVA";
    private static final String CLAVE = "JAVA";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";

    public static Connection getConnection() {
>>>>>>> Stashed changes
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(URL, LOGIN, CLAVE);
            conn.setAutoCommit(false);
            System.out.println(conn != null ? "Conexion Exitosa" : "Conexion Erronea");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Conexion fallida: " + e.getMessage());
        }
        return conn;
    }

    public void desconexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconexion Exitosa");
            }
        } catch (SQLException e) {
            System.err.println("Error al desconectar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
    }
}

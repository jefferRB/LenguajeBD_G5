package com.example.demo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conn = null;
    private static final String LOGIN = "SYSTEM";
    private static final String CLAVE = "12345"; // Cambia por la contraseña de tu usuario
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; // Cambia "XE" por tu SID si es diferente

    // Método para obtener la conexión
    public static Connection getConnection() {
        try {
            // Cargar el driver de Oracle
            Class.forName("oracle.jdbc.OracleDriver");

            // Establecer la conexión a la base de datos
            conn = DriverManager.getConnection(URL, LOGIN, CLAVE);
            conn.setAutoCommit(false); // Desactivar auto-commit para gestionar las transacciones manualmente
            System.out.println(conn != null ? "Conexión Exitosa" : "Conexión Errónea");
        } catch (ClassNotFoundException | SQLException e) {
            // Manejo de errores de conexión
            System.err.println("Conexión fallida: " + e.getMessage());
        }
        return conn;
    }

    // Método para cerrar la conexión
    public void desconexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconexión Exitosa");
            }
        } catch (SQLException e) {
            // Manejo de errores al cerrar la conexión
            System.err.println("Error al desconectar: " + e.getMessage());
        }
    }

    // Método principal de prueba de conexión
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();  // Establecer conexión
        c.desconexion();    // Cerrar la conexión
    }
}

package com.example.demo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection conn = null;
    private static final String LOGIN = "JAVA"; 
    private static final String CLAVE = "JAVA"; 
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl"; 

   
    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver"); 
            conn = DriverManager.getConnection(URL, LOGIN, CLAVE); 
            conn.setAutoCommit(false); 
            System.out.println(conn != null ? "Conexión Exitosa" : "Conexión Errónea");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Conexión fallida: " + e.getMessage());
        }
        return conn;
    }

   
    public void desconexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconexión Exitosa");
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
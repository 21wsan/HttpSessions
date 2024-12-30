package org.wsan.apiservlet.webapp.headers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    //configuración de conexión a base de datos
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Bogota";
    private static String username = "root";
    private static String password = "Colombia2024";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    //configuración para conectar a base de datos mysql
}

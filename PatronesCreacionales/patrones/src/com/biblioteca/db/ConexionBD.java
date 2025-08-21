package com.biblioteca.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD instancia;
    private Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String password = "123456";

    private ConexionBD() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al cargar el driver: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConexionBD getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBD();
        } else if (instancia.getConnection().isClosed()) {
            instancia = new ConexionBD();
        }
        return instancia;
    }
}

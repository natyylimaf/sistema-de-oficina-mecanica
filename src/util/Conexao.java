package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nathália lima
 */

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/oficinaMecanica";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
        } catch (SQLException e) {
            System.out.println( "Erro conexão: " + e.getMessage());

            return null;
        }
    }
}
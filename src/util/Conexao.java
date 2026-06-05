package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/oficinaMecanica";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Método responsável por criar e retornar uma conexão com o banco
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
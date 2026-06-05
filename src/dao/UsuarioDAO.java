package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    // Método responsável por validar o login do usuário
    public boolean login(
            String usuario,
            String senha
    ) {

        // Consulta SQL para verificar se existe um usuário
        String sql =
                "SELECT * FROM usuarios "
              + "WHERE nome_usuario = ? "
              + "AND senha_usuario = ?";

        try (
                // Cria a conexão com o banco de dados
                Connection conn = Conexao.conectar();
                // Prepara a consulta SQL
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            // Substitui os parâmetros (?) pelos valores recebidos
            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            // Executa a consulta
            ResultSet rs = stmt.executeQuery();

            // Retorna true se encontrou um registro
            // Retorna false se não encontrou nenhum registro
            return rs.next();

        } catch (Exception e) {

            System.out.println(
                    "Erro login: "
                    + e.getMessage()
            );

            return false;
        }
    }
}
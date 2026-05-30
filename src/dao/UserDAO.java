package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean login(
            String usuario,
            String senha
    ) {

        String sql =
            "SELECT * FROM users "
          + "WHERE name_user = ? "
          + "AND password_user = ?";

        try {

            Connection conn =
                    Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            ResultSet rs =
                    stmt.executeQuery();

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
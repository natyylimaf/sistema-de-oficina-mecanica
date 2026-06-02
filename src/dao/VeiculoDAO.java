package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VeiculoDAO {

    public boolean salvar(

            String nomeMotorista,
            String cpfMotorista,
            String telefoneMotorista,
            String modelo,
            String placa,
            String cor,
            int ano,
            String dataChegada,
            String motivo,
            String diagnostico,
            String tipoVeiculo

    ) {

        String sql =
                "INSERT INTO veiculos ("
              + "nome_motorista, "
              + "cpf_motorista, "
              + "telefone_motorista, "
              + "modelo, "
              + "placa, "
              + "cor, "
              + "ano, "
              + "data_chegada, "
              + "motivo, "
              + "diagnostico, "
              + "tipo_veiculo"
              + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, nomeMotorista);
            stmt.setString(2, cpfMotorista);
            stmt.setString(3, telefoneMotorista);
            stmt.setString(4, modelo);
            stmt.setString(5, placa);
            stmt.setString(6, cor);
            stmt.setInt(7, ano);
            stmt.setString(8, dataChegada);
            stmt.setString(9, motivo);
            stmt.setString(10, diagnostico);
            stmt.setString(11, tipoVeiculo);

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Erro ao salvar veículo: "
                    + e.getMessage()
            );

            return false;
        }
    }
}
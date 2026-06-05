package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VeiculoDAO {

    // Método responsável por salvar um veículo no banco de dados
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

        // Comando SQL para inserir os dados na tabela veiculos
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
                // Cria a conexão com o banco de dados
                Connection conn = Conexao.conectar();
                // Prepara o comando SQL
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            // Define os valores que substituirão os parâmetros (?) da query
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

            // Executa o comando INSERT no banco
            stmt.executeUpdate();

            // Retorna true indicando que o cadastro foi realizado com sucesso
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
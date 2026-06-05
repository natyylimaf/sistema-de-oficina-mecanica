package dao;

import model.Moto;
import java.sql.*;
import java.time.LocalDate;

public class MotoDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public MotoDAO(Connection conn) {
        this.conn = conn;
    }

    // Método responsável por salvar uma moto no banco de dados
    public void salvar(Moto moto) {

        // Verifica se a conexão foi criada corretamente
        if (conn == null) {
            System.out.println("Erro: conexão com banco é nula.");
            return;
        }

        // SQL para inserir os dados gerais do veículo
        String sqlVeiculo =
                "INSERT INTO veiculos " +
                "(nome_motorista, cpf_motorista, telefone_motorista, modelo, placa, cor, ano, data_chegada, motivo, diagnostico, tipo_veiculo, status_cadastro) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // SQL para inserir os dados específicos da moto
        String sqlMoto =
                "INSERT INTO motos (id_veiculo, cilindradas) VALUES (?, ?)";

        try {

            // Inicia uma transação no banco
            conn.setAutoCommit(false);

            // Variável que armazenará o ID gerado na tabela veiculos
            int idVeiculo = 0;

            // Prepara o comando SQL para inserir o veículo
            try (PreparedStatement stmtVeiculo = conn.prepareStatement(sqlVeiculo, Statement.RETURN_GENERATED_KEYS)) {

                stmtVeiculo.setString(1, moto.getNomeMotorista());
                stmtVeiculo.setString(2, moto.getCpfMotorista());
                stmtVeiculo.setString(3, moto.getTelefoneMotorista());
                stmtVeiculo.setString(4, moto.getModelo());
                stmtVeiculo.setString(5, moto.getPlaca());
                stmtVeiculo.setString(6, moto.getCor());
                stmtVeiculo.setInt(7, moto.getAno());

                LocalDate data = moto.getDataChegada();

                if (data == null) {
                    throw new RuntimeException("Data de chegada não pode ser vazia.");
                }

                stmtVeiculo.setDate(8, java.sql.Date.valueOf(data));

                stmtVeiculo.setString(9, moto.getMotivo());
                stmtVeiculo.setString(10, moto.getDiagnostico());
                stmtVeiculo.setString(11, "MOTO");
                stmtVeiculo.setString(12, moto.getStatusCadastro());

                // Executa o INSERT na tabela veiculos
                stmtVeiculo.executeUpdate();

                // Recupera o ID gerado automaticamente pelo banco
                try (ResultSet rs = stmtVeiculo.getGeneratedKeys()) {
                    if (rs.next()) {
                        idVeiculo = rs.getInt(1);
                    }
                }
            }

            // Prepara o comando SQL para inserir os dados específicos da moto
            try (PreparedStatement stmtMoto = conn.prepareStatement(sqlMoto)) {

                stmtMoto.setInt(1, idVeiculo);
                stmtMoto.setInt(2, moto.getCilindradas());

                // Executa o INSERT na tabela motos
                stmtMoto.executeUpdate();
            }

            // Confirma a transação no banco
            conn.commit();

        } catch (Exception e) {

            // Em caso de erro, desfaz todas as alterações da transação
            try {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Erro ao salvar moto: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
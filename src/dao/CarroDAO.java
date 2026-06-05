package dao;

import model.Carro;
import java.sql.*;
import java.time.LocalDate;

public class CarroDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public CarroDAO(Connection conn) {
        this.conn = conn;
    }

    // Método responsável por salvar um carro no banco de dados
    public void salvar(Carro carro) {
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

        // SQL para inserir os dados específicos do carro
        String sqlCarro =
                "INSERT INTO carros (id_veiculo, quantidade_portas) VALUES (?, ?)";

        try {

            // Inicia uma transação no banco
            conn.setAutoCommit(false);
            
            // Variável que armazenará o ID gerado na tabela veiculos
            int idVeiculo = 0;

            // Prepara o comando SQL para inserir o veículo
            try (PreparedStatement stmtVeiculo = conn.prepareStatement(sqlVeiculo, Statement.RETURN_GENERATED_KEYS)) {

                // Preenche os parâmetros da query com os dados do objeto Carro
                stmtVeiculo.setString(1, carro.getNomeMotorista());
                stmtVeiculo.setString(2, carro.getCpfMotorista());
                stmtVeiculo.setString(3, carro.getTelefoneMotorista());
                stmtVeiculo.setString(4, carro.getModelo());
                stmtVeiculo.setString(5, carro.getPlaca());
                stmtVeiculo.setString(6, carro.getCor());
                stmtVeiculo.setInt(7, carro.getAno());

                LocalDate data = carro.getDataChegada();

                if (data == null) {
                    throw new RuntimeException("Data de chegada não pode ser vazia.");
                }

                stmtVeiculo.setDate(8, java.sql.Date.valueOf(data));

                stmtVeiculo.setString(9, carro.getMotivo());
                stmtVeiculo.setString(10, carro.getDiagnostico());
                stmtVeiculo.setString(11, "CARRO");
                stmtVeiculo.setString(12, carro.getStatusCadastro());

                // Executa o INSERT na tabela veiculos
                stmtVeiculo.executeUpdate();

                // Recupera o ID gerado automaticamente pelo banco
                try (ResultSet rs = stmtVeiculo.getGeneratedKeys()) {
                    if (rs.next()) {
                        idVeiculo = rs.getInt(1);
                    }
                }
            }

            // Prepara o comando SQL para inserir os dados específicos do carro
            try (PreparedStatement stmtCarro = conn.prepareStatement(sqlCarro)) {

                stmtCarro.setInt(1, idVeiculo);
                stmtCarro.setInt(2, carro.getQuantidadePortas());

                // Executa o INSERT na tabela carros
                stmtCarro.executeUpdate();
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

            System.out.println("Erro ao salvar carro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
package dao;

import model.Carro;
import java.sql.*;
import util.ValidacaoVeiculo;

public class CarroDAO {

    private Connection conn;

    // Construtor que recebe a conexão
    public CarroDAO(Connection conn) {
        this.conn = conn;
    }

    // Método responsável por salvar um carro no banco de dados
    public boolean salvar(Carro carro) {

        if (conn == null) {
            throw new RuntimeException("Conexão com banco é nula.");
        }

        String sqlVeiculo =
                "INSERT INTO veiculos "
                + "(nome_motorista, cpf_motorista, telefone_motorista, "
                + "modelo, placa, cor, ano, data_chegada, motivo, "
                + "diagnostico, tipo_veiculo, status_cadastro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlCarro =
                "INSERT INTO carros "
                + "(id_veiculo, quantidade_portas) "
                + "VALUES (?, ?)";

        // Validações
        ValidacaoVeiculo.validarNome(carro.getNomeMotorista());
        ValidacaoVeiculo.validarCpf(carro.getCpfMotorista());
        ValidacaoVeiculo.validarTelefone(carro.getTelefoneMotorista());
        ValidacaoVeiculo.validarAno(carro.getAno());
        ValidacaoVeiculo.validarData(carro.getDataChegada());
        ValidacaoVeiculo.validarQuantidadePortas(carro.getQuantidadePortas());

        try {
            conn.setAutoCommit(false);

            int idVeiculo = 0;

            try (PreparedStatement stmtVeiculo =
                    conn.prepareStatement(sqlVeiculo, Statement.RETURN_GENERATED_KEYS)) {

                stmtVeiculo.setString(1, carro.getNomeMotorista());
                stmtVeiculo.setString(2, carro.getCpfMotorista());
                stmtVeiculo.setString(3, carro.getTelefoneMotorista());
                stmtVeiculo.setString(4, carro.getModelo());
                stmtVeiculo.setString(5, carro.getPlaca());
                stmtVeiculo.setString(6, carro.getCor());
                stmtVeiculo.setInt(7, carro.getAno());
                stmtVeiculo.setDate(8, Date.valueOf(carro.getDataChegada()));
                stmtVeiculo.setString(9, carro.getMotivo());
                stmtVeiculo.setString(10, carro.getDiagnostico());
                stmtVeiculo.setString(11, "CARRO");
                stmtVeiculo.setString(12, carro.getStatusCadastro());

                stmtVeiculo.executeUpdate();

                try (ResultSet rs = stmtVeiculo.getGeneratedKeys()) {
                    if (rs.next()) {
                        idVeiculo = rs.getInt(1);
                    }
                }
            }

            try (PreparedStatement stmtCarro = conn.prepareStatement(sqlCarro)) {
                stmtCarro.setInt(1, idVeiculo);
                stmtCarro.setInt(2, carro.getQuantidadePortas());
                stmtCarro.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao desfazer transação: " + ex.getMessage(), ex);
            }
            throw new RuntimeException("Erro ao salvar carro no banco: " + e.getMessage(), e);

        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao restaurar conexão: " + e.getMessage(), e);
            }
        }
    }
}

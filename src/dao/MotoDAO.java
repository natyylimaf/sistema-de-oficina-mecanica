package dao;

import java.sql.*;

import model.Moto;
import util.ValidacaoVeiculo;

public class MotoDAO {
    private Connection conn;

    // Construtor que recebe a conexão
    public MotoDAO(Connection conn) {
        this.conn = conn;
    }
   

    // Método responsável por salvar uma moto no banco de dados
    public boolean salvar(Moto moto) {

        if (conn == null) {
            throw new RuntimeException("Conexão com banco é nula.");
        }

        String sqlVeiculo =
                "INSERT INTO veiculos "
                + "(nome_motorista, cpf_motorista, telefone_motorista, "
                + "modelo, placa, cor, ano, data_chegada, motivo, "
                + "diagnostico, tipo_veiculo, status_cadastro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlMoto =
                "INSERT INTO motos (id_veiculo, cilindradas) VALUES (?, ?)";

        // Validações — executadas ANTES de qualquer coisa com o banco
        ValidacaoVeiculo.validarNome(moto.getNomeMotorista());
        ValidacaoVeiculo.validarCpf(moto.getCpfMotorista());
        ValidacaoVeiculo.validarTelefone(moto.getTelefoneMotorista());
        ValidacaoVeiculo.validarAno(moto.getAno());
        ValidacaoVeiculo.validarData(moto.getDataChegada());
        ValidacaoVeiculo.validarCilindradas(moto.getCilindradas());

        try {
            conn.setAutoCommit(false);

            int idVeiculo = 0;

            try (PreparedStatement stmtVeiculo =
                    conn.prepareStatement(sqlVeiculo, Statement.RETURN_GENERATED_KEYS)) {

                stmtVeiculo.setString(1, moto.getNomeMotorista());
                stmtVeiculo.setString(2, moto.getCpfMotorista());
                stmtVeiculo.setString(3, moto.getTelefoneMotorista());
                stmtVeiculo.setString(4, moto.getModelo());
                stmtVeiculo.setString(5, moto.getPlaca());
                stmtVeiculo.setString(6, moto.getCor());
                stmtVeiculo.setInt(7, moto.getAno());
                stmtVeiculo.setDate(8, Date.valueOf(moto.getDataChegada()));
                stmtVeiculo.setString(9, moto.getMotivo());
                stmtVeiculo.setString(10, moto.getDiagnostico());
                stmtVeiculo.setString(11, "MOTO");
                stmtVeiculo.setString(12, moto.getStatusCadastro());

                stmtVeiculo.executeUpdate();

                try (ResultSet rs = stmtVeiculo.getGeneratedKeys()) {
                    if (rs.next()) {
                        idVeiculo = rs.getInt(1);
                    }
                }
            }

            try (PreparedStatement stmtMoto = conn.prepareStatement(sqlMoto)) {
                stmtMoto.setInt(1, idVeiculo);
                stmtMoto.setInt(2, moto.getCilindradas());
                stmtMoto.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao desfazer transação: " + ex.getMessage(), ex);
            }
            throw new RuntimeException("Erro ao salvar moto no banco: " + e.getMessage(), e);

        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao restaurar conexão: " + e.getMessage(), e);
            }
        }
    }
}

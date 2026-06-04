package dao;

import model.Carro;
import java.sql.*;
import java.time.LocalDate;

public class CarroDAO {

    private Connection conn;

    public CarroDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvar(Carro carro) {

        if (conn == null) {
            System.out.println("Erro: conexão com banco é nula.");
            return;
        }

        String sqlVeiculo =
                "INSERT INTO veiculos " +
                "(nome_motorista, cpf_motorista, telefone_motorista, modelo, placa, cor, ano, data_chegada, motivo, diagnostico, tipo_veiculo, status_cadastro) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlCarro =
                "INSERT INTO carros (id_veiculo, quantidade_portas) VALUES (?, ?)";

        try {

            conn.setAutoCommit(false);

            // =========================
            // 1. INSERIR EM VEICULOS
            // =========================
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

                // =========================
                // DATA DO JSPINNER (SEGURA)
                // =========================
                LocalDate data = carro.getDataChegada();

                if (data == null) {
                    throw new RuntimeException("Data de chegada não pode ser vazia.");
                }

                stmtVeiculo.setDate(8, java.sql.Date.valueOf(data));

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

            // =========================
            // 2. INSERIR EM CARROS
            // =========================
            try (PreparedStatement stmtCarro =
                         conn.prepareStatement(sqlCarro)) {

                stmtCarro.setInt(1, idVeiculo);
                stmtCarro.setInt(2, carro.getQuantidadePortas());

                stmtCarro.executeUpdate();
            }

            conn.commit();

        } catch (Exception e) {

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
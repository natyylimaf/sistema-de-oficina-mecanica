package dao;

import model.Moto;
import java.sql.*;
import java.time.LocalDate;

public class MotoDAO {

    private Connection conn;

    public MotoDAO(Connection conn) {
        this.conn = conn;
    }

    public void salvar(Moto moto) {

        if (conn == null) {
            System.out.println("Erro: conexão com banco é nula.");
            return;
        }

        String sqlVeiculo =
                "INSERT INTO veiculos " +
                "(nome_motorista, cpf_motorista, telefone_motorista, modelo, placa, cor, ano, data_chegada, motivo, diagnostico, tipo_veiculo, status_cadastro) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlMoto =
                "INSERT INTO motos (id_veiculo, cilindradas) VALUES (?, ?)";

        try {

            conn.setAutoCommit(false);

            int idVeiculo = 0;

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

        } catch (Exception e) {

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
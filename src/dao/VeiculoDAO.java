package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author nathália lima
 */
public class VeiculoDAO {

    public boolean salvar(
        String nome,
        String cpf,
        String telefone,
        String tipo,
        String modelo,
        String placa,
        String cor,
        int ano,
        String data,
        String motivo,
        String diagnostico
    ) {

        String sql = "INSERT INTO vehicles (" +
                "name_driver, cpf_driver, phone_driver, " +
                "type_vehicle, model_vehicle, plate_vehicle, color_vehicle, year_vehicle, " +
                "date_arrival_vehicle, reason_vehicle, diagnosis_vehicle" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.setString(4, tipo);
            stmt.setString(5, modelo);
            stmt.setString(6, placa);
            stmt.setString(7, cor);
            stmt.setInt(8, ano);
            stmt.setString(9, data);
            stmt.setString(10, motivo);
            stmt.setString(11, diagnostico);

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao salvar veículo: " + e.getMessage());
            return false;
        }
    }
}

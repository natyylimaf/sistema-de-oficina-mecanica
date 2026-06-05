package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    
    // Método responsável por buscar veículos com filtros
    public List<Object[]> buscarVeiculos(
            String pesquisa,
            String tipo,
            String status
    ) {

        List<Object[]> lista = new ArrayList<>();

        StringBuilder sql = new StringBuilder(
                "SELECT id_veiculo, tipo_veiculo, modelo, placa, "
                + "nome_motorista, status_cadastro "
                + "FROM veiculos WHERE 1=1 "
        );

        // Filtro de tipo
        if (!tipo.equals("Todos")) {
            sql.append(" AND tipo_veiculo = ? ");
        }

        // Filtro de status
        if (!status.equals("Todos")) {

            if (status.equals("DESATIVADO")) {
                sql.append(" AND registro_ativo = FALSE ");
            } else {
                sql.append(" AND status_cadastro = ? ");
                sql.append(" AND registro_ativo = TRUE ");
            }

        } else {
            sql.append(" AND registro_ativo = TRUE ");
        }

        // Pesquisa
        if (!pesquisa.trim().isEmpty()) {

            sql.append(
                    " AND ("
                    + "nome_motorista LIKE ? "
                    + "OR cpf_motorista LIKE ? "
                    + "OR telefone_motorista LIKE ? "
                    + "OR modelo LIKE ? "
                    + "OR placa LIKE ?"
                    + ")"
            );
        }

        try (
                Connection conn = Conexao.conectar();
                PreparedStatement stmt =
                        conn.prepareStatement(sql.toString())
        ) {

            int indice = 1;

            if (!tipo.equals("Todos")) {
                stmt.setString(indice++, tipo);
            }

            if (!status.equals("Todos")
                    && !status.equals("DESATIVADO")) {

                stmt.setString(indice++, status);
            }

            if (!pesquisa.trim().isEmpty()) {

                String termo = "%" + pesquisa + "%";

                stmt.setString(indice++, termo);
                stmt.setString(indice++, termo);
                stmt.setString(indice++, termo);
                stmt.setString(indice++, termo);
                stmt.setString(indice++, termo);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                lista.add(new Object[]{
                    rs.getInt("id_veiculo"),
                    rs.getString("tipo_veiculo"),
                    rs.getString("modelo"),
                    rs.getString("placa"),
                    rs.getString("nome_motorista"),
                    rs.getString("status_cadastro")
                });
            }

        } catch (Exception e) {

            System.out.println(
                    "Erro ao buscar veículos: "
                    + e.getMessage()
            );
        }

        return lista;
    }
}
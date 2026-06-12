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
        // Evita NullPointerException
if (pesquisa == null) {
    pesquisa = "";
}

if (tipo == null) {
    tipo = "Todos";
}

if (status == null) {
    status = "Todos";
}

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
    
    
    public Object[] buscarPorId(int idVeiculo) {

        String sql
                = "SELECT v.*, c.quantidade_portas, m.cilindradas "
                + "FROM veiculos v "
                + "LEFT JOIN carros c ON v.id_veiculo = c.id_veiculo "
                + "LEFT JOIN motos m ON v.id_veiculo = m.id_veiculo "
                + "WHERE v.id_veiculo = ?";

        try (
                Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idVeiculo);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                return new Object[]{
                    rs.getInt("id_veiculo"),
                    rs.getString("nome_motorista"),
                    rs.getString("cpf_motorista"),
                    rs.getString("telefone_motorista"),
                    rs.getString("modelo"),
                    rs.getString("placa"),
                    rs.getString("cor"),
                    rs.getInt("ano"),
                    rs.getDate("data_chegada"),
                    rs.getString("motivo"),
                    rs.getString("diagnostico"),
                    rs.getString("tipo_veiculo"),
                    rs.getString("status_cadastro"),
                    rs.getObject("quantidade_portas"),
                    rs.getObject("cilindradas")
                };
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return null;
    }
    
    
    
    // Método responsável por atualizar os dados de um veículo
public boolean atualizarVeiculo(
        int idVeiculo,
        String nomeMotorista,
        String cpf,
        String telefone,
        String modelo,
        String placa,
        String cor,
        int ano,
        String motivo,
        String diagnostico,
        String status
) {

    // Verifica se o ID é válido
    if (idVeiculo <= 0) {

        throw new IllegalArgumentException(
                "ID do veículo inválido.");
    }

    // Verifica se o nome do motorista foi informado
    if (nomeMotorista == null ||
        nomeMotorista.trim().isEmpty()) {

        throw new IllegalArgumentException(
                "Nome do motorista obrigatório.");
    }

    // Verifica se o CPF foi informado
    if (cpf == null ||
        cpf.trim().isEmpty()) {

        throw new IllegalArgumentException(
                "CPF obrigatório.");
    }

    // Remove pontos e traços do CPF
    cpf = cpf.replace(".", "")
             .replace("-", "");

    // Verifica se possui exatamente 11 números
    if (!cpf.matches("\\d{11}")) {

        throw new IllegalArgumentException(
                "CPF inválido.");
    }

    // Verifica se o telefone foi informado
    if (telefone == null ||
        telefone.trim().isEmpty()) {

        throw new IllegalArgumentException(
                "Telefone obrigatório.");
    }

    // Remove caracteres especiais do telefone
    telefone = telefone.replace("(", "")
                       .replace(")", "")
                       .replace("-", "")
                       .replace(" ", "");

    // Verifica se possui 10 ou 11 números
    if (!telefone.matches("\\d{10,11}")) {

        throw new IllegalArgumentException(
                "Telefone inválido.");
    }

    // Verifica se a placa foi informada
    if (placa == null ||
        placa.trim().isEmpty()) {

        throw new IllegalArgumentException(
                "Placa obrigatória.");
    }

    // Verifica se o ano informado é válido
    if (ano < 1900 ||
        ano > 2035) {

        throw new IllegalArgumentException(
                "Ano inválido.");
    }

    // SQL responsável pela atualização
    String sql
            = "UPDATE veiculos SET "
            + "nome_motorista=?, "
            + "cpf_motorista=?, "
            + "telefone_motorista=?, "
            + "modelo=?, "
            + "placa=?, "
            + "cor=?, "
            + "ano=?, "
            + "motivo=?, "
            + "diagnostico=?, "
            + "status_cadastro=? "
            + "WHERE id_veiculo=?";

    try (

            // Cria conexão com o banco
            Connection conn = Conexao.conectar();

            // Prepara o comando SQL
            PreparedStatement stmt =
                    conn.prepareStatement(sql)

    ) {

        // Define os parâmetros da query
        stmt.setString(1, nomeMotorista);
        stmt.setString(2, cpf);
        stmt.setString(3, telefone);
        stmt.setString(4, modelo);
        stmt.setString(5, placa);
        stmt.setString(6, cor);
        stmt.setInt(7, ano);
        stmt.setString(8, motivo);
        stmt.setString(9, diagnostico);
        stmt.setString(10, status);
        stmt.setInt(11, idVeiculo);

        // Executa o UPDATE
        stmt.executeUpdate();

        // Retorna sucesso
        return true;

    } catch (IllegalArgumentException e) {

        // Captura erros de validação
        System.out.println(
                "Erro de validação: "
                + e.getMessage());

        return false;

    } catch (Exception e) {

        // Captura erros relacionados ao banco
        System.out.println(
                "Erro ao atualizar veículo: "
                + e.getMessage());

        return false;
    }
}
}

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

    // Método responsável por validar os dados do carro
    private void validarCarro(Carro carro) {

        // Verifica se o objeto carro foi informado
        if (carro == null) {
            throw new IllegalArgumentException(
                    "Dados do carro inválidos.");
        }
        
        
         // Validação do CPF
    String cpf = carro.getCpfMotorista();

    if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {

        throw new IllegalArgumentException(
                "CPF deve estar no formato 000.000.000-00");
    }
         // Validação do telefone
    String telefone = carro.getTelefoneMotorista();

    if (!telefone.matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}")) {

        throw new IllegalArgumentException(
                "Telefone deve estar no formato (XX)XXXXX-XXXX");
    }

        // Verifica se a data de chegada foi informada
        if (carro.getDataChegada() == null) {
            throw new IllegalArgumentException(
                    "Dados do carro inválidos.");
        }

        // Verifica se a quantidade de portas é válida
        if (carro.getQuantidadePortas() <= 0) {
            throw new IllegalArgumentException(
                    "Dados do carro inválidos.");
        }
    }

    // Método responsável por salvar um carro no banco de dados
    public void salvar(Carro carro) {

        // Verifica se a conexão foi criada corretamente
        if (conn == null) {
            System.out.println(
                    "Erro: conexão com banco é nula.");
            return;
        }

        // Executa as validações antes de salvar
        validarCarro(carro);

        // SQL para inserir os dados gerais do veículo
        String sqlVeiculo =
                "INSERT INTO veiculos "
                + "(nome_motorista, cpf_motorista, telefone_motorista, "
                + "modelo, placa, cor, ano, data_chegada, motivo, "
                + "diagnostico, tipo_veiculo, status_cadastro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // SQL para inserir os dados específicos do carro
        String sqlCarro =
                "INSERT INTO carros "
                + "(id_veiculo, quantidade_portas) "
                + "VALUES (?, ?)";

        try {

            // Inicia uma transação no banco
            conn.setAutoCommit(false);

            // Variável que armazenará o ID gerado
            int idVeiculo = 0;

            // Prepara o INSERT da tabela veiculos
            try (
                    PreparedStatement stmtVeiculo =
                    conn.prepareStatement(
                            sqlVeiculo,
                            Statement.RETURN_GENERATED_KEYS)
            ) {

                // Preenche os parâmetros da query
                stmtVeiculo.setString(
                        1,
                        carro.getNomeMotorista());

                stmtVeiculo.setString(
                        2,
                        carro.getCpfMotorista());

                stmtVeiculo.setString(
                        3,
                        carro.getTelefoneMotorista());

                stmtVeiculo.setString(
                        4,
                        carro.getModelo());

                stmtVeiculo.setString(
                        5,
                        carro.getPlaca());

                stmtVeiculo.setString(
                        6,
                        carro.getCor());

                stmtVeiculo.setInt(
                        7,
                        carro.getAno());

                LocalDate data =
                        carro.getDataChegada();

                stmtVeiculo.setDate(
                        8,
                        Date.valueOf(data));

                stmtVeiculo.setString(
                        9,
                        carro.getMotivo());

                stmtVeiculo.setString(
                        10,
                        carro.getDiagnostico());

                stmtVeiculo.setString(
                        11,
                        "CARRO");

                stmtVeiculo.setString(
                        12,
                        carro.getStatusCadastro());

                // Executa o INSERT
                stmtVeiculo.executeUpdate();

                // Recupera o ID gerado automaticamente
                try (
                        ResultSet rs =
                        stmtVeiculo.getGeneratedKeys()
                ) {

                    if (rs.next()) {
                        idVeiculo = rs.getInt(1);
                    }
                }
            }

            // Prepara o INSERT da tabela carros
            try (
                    PreparedStatement stmtCarro =
                    conn.prepareStatement(sqlCarro)
            ) {

                stmtCarro.setInt(
                        1,
                        idVeiculo);

                stmtCarro.setInt(
                        2,
                        carro.getQuantidadePortas());

                // Executa o INSERT
                stmtCarro.executeUpdate();
            }

            // Confirma a transação
            conn.commit();

        } catch (IllegalArgumentException e) {

            // Captura erros de validação dos dados
            System.out.println(
                    "Erro de validação: "
                    + e.getMessage());

        } catch (SQLException e) {

            // Captura erros relacionados ao banco de dados
            try {

                // Desfaz todas as alterações realizadas
                // durante a transação
                if (conn != null) {
                    conn.rollback();
                }

            } catch (SQLException ex) {

                System.out.println(
                        "Erro ao desfazer transação: "
                        + ex.getMessage());
            }

            System.out.println(
                    "Erro ao salvar carro: "
                    + e.getMessage());

        } finally {

            try {

                // Restaura o comportamento padrão da conexão
                if (conn != null) {
                    conn.setAutoCommit(true);
                }

            } catch (SQLException e) {

                System.out.println(
                        "Erro ao restaurar conexão.");
            }
        }
    }
}
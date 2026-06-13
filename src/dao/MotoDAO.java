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
    
    
    private void validarMoto(Moto moto) {

        // Verifica se o objeto moto foi informado
        if (moto == null) {
            throw new IllegalArgumentException("Dados da moto inválidos.");
        }
        
        // Verifica campos obrigatórios
        if (moto.getNomeMotorista() == null ||
            moto.getNomeMotorista().trim().isEmpty() ||

            moto.getModelo() == null ||
            moto.getModelo().trim().isEmpty() ||

            moto.getPlaca() == null ||
            moto.getPlaca().trim().isEmpty() ||

            moto.getCor() == null ||
            moto.getCor().trim().isEmpty() ||

            moto.getMotivo() == null ||
            moto.getMotivo().trim().isEmpty()) {

            throw new IllegalArgumentException("Todos os campos são obrigatórios.");
        }

        // Validação do CPF
        // Aceita apenas o formato 000.000.000-00
        String cpf = moto.getCpfMotorista();

       if (cpf == null ||
    !cpf.matches("(\\d{11})|(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})")) {

    throw new IllegalArgumentException("CPF inválido.");
}

        // Validação do telefone
        String telefone = moto.getTelefoneMotorista();

if (telefone == null) {

    throw new IllegalArgumentException("Telefone inválido.");
}

// Remove caracteres de formatação
telefone = telefone.replace("(", "")
                   .replace(")", "")
                   .replace("-", "")
                   .replace(" ", "");

// Verifica se possui apenas números
if (!telefone.matches("\\d{10,11}")) {

    throw new IllegalArgumentException("Telefone inválido.");
}
        

        // Verifica se a data de chegada foi informada
        if (moto.getDataChegada() == null) {

            throw new IllegalArgumentException("Data de chegada obrigatória.");
        }

        // Verifica se a cilindrada é válida
        if (moto.getCilindradas() <= 0) {

            throw new IllegalArgumentException("Cilindrada inválida.");
        }
    }

    // Método responsável por salvar uma moto no banco de dados
    public boolean salvar(Moto moto) {

        // Verifica se a conexão foi criada corretamente
        if (conn == null) {
            System.out.println("Erro: conexão com banco é nula.");
            return false;
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
            // Executa as validações antes de salvar
            validarMoto(moto);

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

            return true;

            } catch (SQLException e) {

                try {

                    if (conn != null) {
                        conn.rollback();
                    }

                } catch (SQLException ex) {

                    System.out.println("Erro ao desfazer transação: " + ex.getMessage());
                }

                System.out.println("Erro ao salvar moto: " + e.getMessage());

                return false;

            } finally {

                try {

                    if (conn != null) {
                        conn.setAutoCommit(true);
                    }

                } catch (SQLException e) {

                    System.out.println("Erro ao restaurar conexão.");
                }
            }
    } 
}

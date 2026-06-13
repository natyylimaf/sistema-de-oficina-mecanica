package model;

import java.time.LocalDate;

public class Carro extends Veiculo {
    private int quantidadePortas;
    private static final double MAO_DE_OBRA = 850.0;

    // Construtor utilizado para carregar um carro já existente no banco
    public Carro(
            int idVeiculo,
            String nomeMotorista,
            String cpfMotorista,
            String telefoneMotorista,
            String modelo,
            String placa,
            String cor,
            int ano,
            LocalDate dataChegada,
            String motivo,
            String diagnostico,
            String tipoVeiculo,
            String statusCadastro,
            int quantidadePortas
    ) {
        super(
                idVeiculo,
                nomeMotorista,
                cpfMotorista,
                telefoneMotorista,
                modelo,
                placa,
                cor,
                ano,
                dataChegada,
                motivo,
                diagnostico,
                tipoVeiculo,
                statusCadastro
        );
        this.quantidadePortas = quantidadePortas;
    }

    // Construtor utilizado para cadastrar um novo carro
    public Carro(
            String nomeMotorista, 
            String cpfMotorista, 
            String telefoneMotorista, 
            String modelo, 
            String placa, 
            String cor, 
            int ano, 
            LocalDate dataChegada, 
            String motivo, 
            String diagnostico, 
            String statusCadastro, 
            int quantidadePortas
    ) {
        super(
                0, 
                nomeMotorista, 
                cpfMotorista, 
                telefoneMotorista, 
                modelo, 
                placa, 
                cor, 
                ano, 
                dataChegada, 
                motivo, 
                diagnostico, 
                "CARRO", 
                statusCadastro
        );
        this.quantidadePortas = quantidadePortas;
    }

    
    public int getQuantidadePortas() { return quantidadePortas; }
    public void setQuantidadePortas(int quantidadePortas) { this.quantidadePortas = quantidadePortas; }
    
    public static double getMaoDeObra() { return MAO_DE_OBRA; }

    
    @Override
    public String toString() {
        return "Carro{" +
                super.toString() +
                ", quantidadePortas=" + quantidadePortas +
                ", orcamento=" + getOrcamento() +
                '}';
    }
    
    
    @Override
    public double gerarOrcamento(double valorPecas) {
        setOrcamento(MAO_DE_OBRA + valorPecas);
        return getOrcamento();
    }
}
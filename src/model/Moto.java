package model;

import java.time.LocalDate;

public class Moto extends Veiculo {
    private int cilindradas;
    private static final double MAO_DE_OBRA = 500.0;

    // Construtor utilizado para carregar uma moto já existente no banco
    public Moto(
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
            int cilindradas
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
        this.cilindradas = cilindradas;
    }

    // Construtor utilizado para cadastrar uma nova moto
    public Moto(
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
            int cilindradas
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
                "MOTO",
                statusCadastro
        );
        this.cilindradas = cilindradas;
    }

    
    public int getCilindradas() { return cilindradas; }
    public void setCilindradas(int cilindradas) { this.cilindradas = cilindradas; }
    
    public static double getMaoDeObra() { return MAO_DE_OBRA; }

    
    @Override
    public String toString() {
        return "Moto{" +
                super.toString() +
                ", cilindradas=" + cilindradas +
                ", orcamento=" + getOrcamento() +
                '}';
    }
    
    
    @Override
    public double gerarOrcamento(double valorPecas) {
        setOrcamento(MAO_DE_OBRA + valorPecas);
        return getOrcamento();
    }
}
package model;

import java.time.LocalDate;

public class Carro extends Veiculo {
    private int quantidadePortas;
    private double orcamento;
    private static final double MAO_DE_OBRA = 850.0;

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
    
    public double getOrcamento() { return orcamento; }
    
    public static double getMaoDeObra() { return MAO_DE_OBRA; }

    
    @Override
    public String toString() {
        return "Carro{" +
                "idVeiculo=" + getIdVeiculo() +
                ", nomeMotorista='" + getNomeMotorista() + '\'' +
                ", cpfMotorista='" + getCpfMotorista() + '\'' +
                ", telefoneMotorista='" + getTelefoneMotorista() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", placa='" + getPlaca() + '\'' +
                ", cor='" + getCor() + '\'' +
                ", ano=" + getAno() +
                ", dataChegada=" + getDataChegada() +
                ", motivo='" + getMotivo() + '\'' +
                ", diagnostico='" + getDiagnostico() + '\'' +
                ", tipoVeiculo='" + getTipoVeiculo() + '\'' +
                ", statusCadastro='" + getStatusCadastro() + '\'' +
                ", quantidadePortas=" + getQuantidadePortas() +
                ", orcamento=" + getOrcamento() +
                '}';
    }
    
    
    @Override
    public double gerarOrcamento(double valorPecas) {
        orcamento = MAO_DE_OBRA + valorPecas;
        return orcamento;
    }
}
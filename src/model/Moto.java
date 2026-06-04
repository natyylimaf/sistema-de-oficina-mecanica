package model;

import java.time.LocalDate;

public class Moto extends Veiculo {

    private int cilindradas;

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

    @Override
    public double gerarOrcamento() {
        return 500.00;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return "Moto [cilindradas=" + cilindradas + ", gerarOrcamento()=" + gerarOrcamento() + ", getCilindradas()="
                + getCilindradas() + ", getIdVeiculo()=" + getIdVeiculo() + ", getNomeMotorista()="
                + getNomeMotorista()
                + ", getCpfMotorista()=" + getCpfMotorista() + ", getTelefoneMotorista()="
                + getTelefoneMotorista()
                + ", getModelo()=" + getModelo() + ", getPlaca()=" + getPlaca() + ", getCor()=" + getCor()
                + ", getAno()=" + getAno() + ", getDataChegada()=" + getDataChegada() + ", getMotivo()="
                + getMotivo()
                + ", getClass()=" + getClass() + ", getDiagnostico()=" + getDiagnostico()
                + ", getTipoVeiculo()="
                + getTipoVeiculo() + ", getStatusCadastro()=" + getStatusCadastro() + ", isRegistroAtivo()="
                + isRegistroAtivo() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}
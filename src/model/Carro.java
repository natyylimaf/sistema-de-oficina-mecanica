package model;

import java.time.LocalDate;

public class Carro extends Veiculo {

    private int quantidadePortas;

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

    @Override
    public double gerarOrcamento() {
        return 850.00;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public String toString() {
        return "Carro [quantidadePortas=" + quantidadePortas + ", gerarOrcamento()=" + gerarOrcamento()
                + ", getQuantidadePortas()=" + getQuantidadePortas() + ", getIdVeiculo()=" + getIdVeiculo()
                + ", getNomeMotorista()=" + getNomeMotorista() + ", getCpfMotorista()=" + getCpfMotorista()
                + ", getTelefoneMotorista()=" + getTelefoneMotorista() + ", getModelo()=" + getModelo()
                + ", getPlaca()=" + getPlaca() + ", getCor()=" + getCor() + ", getAno()=" + getAno()
                + ", getDataChegada()=" + getDataChegada() + ", getMotivo()=" + getMotivo() + ", getClass()="
                + getClass() + ", getDiagnostico()=" + getDiagnostico() + ", getTipoVeiculo()=" + getTipoVeiculo()
                + ", getStatusCadastro()=" + getStatusCadastro() + ", isRegistroAtivo()=" + isRegistroAtivo()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}
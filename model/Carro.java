package model;

import java.time.LocalDate;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(int idVeiculo, String nomeMotorista, String cpfMotorista, String telefoneMotorista, String modelo,
            String placa, String cor, int ano, LocalDate dataChegada, String motivo, String diagnostico,
            String tipoVeiculo, String statusCadastro) {
        super(idVeiculo, nomeMotorista, cpfMotorista, telefoneMotorista, modelo, placa, cor, ano, dataChegada,
                motivo, diagnostico, tipoVeiculo, statusCadastro);
    }

    @Override
    public double gerarOrcamento() {
        return 850.00;

    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    @Override
    public String toString() {
        return "Carro [numeroPortas=" + numeroPortas + ", gerarOrcamento()=" + gerarOrcamento()
                + ", getNumeroPortas()=" + getNumeroPortas() + ", getIdVeiculo()=" + getIdVeiculo()
                + ", getNomeMotorista()=" + getNomeMotorista() + ", getCpfMotorista()=" + getCpfMotorista()
                + ", getTelefoneMotorista()=" + getTelefoneMotorista() + ", getModelo()=" + getModelo()
                + ", getPlaca()=" + getPlaca() + ", getCor()=" + getCor() + ", getAno()=" + getAno()
                + ", getDataChegada()=" + getDataChegada() + ", getMotivo()=" + getMotivo() + ", getClass()="
                + getClass() + ", getDiagnostico()=" + getDiagnostico() + ", getTipoVeiculo()=" + getTipoVeiculo()
                + ", getStatusCadastro()=" + getStatusCadastro() + ", isRegistroAtivo()=" + isRegistroAtivo()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

}

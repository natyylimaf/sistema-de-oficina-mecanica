package model;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String placa, String modelo, int ano, String cor, int numeroPortas) {
        super(placa, modelo, ano, cor);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() { return numeroPortas; }
    public void setNumeroPortas(int numeroPortas) { this.numeroPortas = numeroPortas; }

    @Override
    public String problemaVeiculo() {
        return "Problema específico do carro.";
    }

    @Override
    public String toString() {
        return "Carro [placa="
                + getPlaca()
                + ", modelo="
                + getModelo()
                + ", ano="
                + getAno()
                + ", cor="
                + getCor()
                + ", portas="
                + numeroPortas
                + "]";
    }
}
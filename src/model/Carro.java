package model;

/**
 *
 * @author bryan
 */
public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String placa, String modelo, int ano, int numeroPortas) {
        super(placa, modelo, ano);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

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
                + ", portas="
                + numeroPortas
                + "]";
    }
}
package model;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String modelo, int ano, String cor, int cilindradas) {
        super(placa, modelo, ano, cor);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {return cilindradas; }
    public void setCilindradas(int cilindradas) {this.cilindradas = cilindradas; }

    @Override
    public String problemaVeiculo() {
        return "Problema específico da moto.";
    }

    @Override
    public String toString() {
        return "Moto [placa="
                + getPlaca()
                + ", modelo="
                + getModelo()
                + ", ano="
                + getAno()
                + ", cor="
                + getCor()
                + ", cilindradas="
                + cilindradas
                + "]";
    }
}
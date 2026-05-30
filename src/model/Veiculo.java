package model;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    private int ano;
    private String cor;
    
    public Veiculo(String placa, String modelo, int ano, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) {this.placa = placa; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getCor() { return cor;}
    public void setCor(String cor) { this.cor = cor; }

    
    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", modelo=" + modelo + ", ano=" + ano + ", cor=" + cor + '}';
    }
    
    public abstract String problemaVeiculo();  

}

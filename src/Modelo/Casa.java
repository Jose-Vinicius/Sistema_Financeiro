package Modelo;

public class Casa extends Financiamento{
    private int desconto;

    private double areaConstruida;

    private double tamanhoTerreno;

    public Casa(double valorImovel, double taxaJuros, int prazoFinanciamento, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, taxaJuros, prazoFinanciamento);
        setAreaConstruida(areaConstruida);
        setTamanhoTerreno(tamanhoTerreno);
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    public void setTamanhoTerreno(double tamanhoTerreno) {
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public double calculoDesconto(){
        setDesconto(100);
        double parcela = this.parcelaMensal();
        return parcela - this.getDesconto();
    }

    @Override
    protected double valorImovelTotal() {
        return (calculoDesconto() * this.getPrazoFinanciamento());
    }
}

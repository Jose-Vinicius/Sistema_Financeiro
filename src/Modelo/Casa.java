package Modelo;

public class Casa extends Financiamento{
    private int desconto;

    public Casa(double valorImovel, double taxaJuros, int prazoFinanciamento) {
        super(valorImovel, taxaJuros, prazoFinanciamento);
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

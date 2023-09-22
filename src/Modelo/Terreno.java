package Modelo;

public class Terreno extends Financiamento{

    public Terreno(double valorImovel, double taxaJuros, int prazoFinanciamento) {
        super(valorImovel, taxaJuros, prazoFinanciamento);
    }

    @Override
    protected double valorImovelTotal() {
        return (((super.valorImovelTotal() / 100) * 2) + super.valorImovelTotal());
    }
}

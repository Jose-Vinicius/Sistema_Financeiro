package Modelo;

public class Apartamento extends Financiamento{

    public Apartamento(double valorImovel, double taxaJuros, int prazoFinanciamento) {
        super(valorImovel, taxaJuros, prazoFinanciamento);
    }

    private double jurosDecrescentes(){
        double valorParcelaSomado = 0;
        for (int i = 1; i <= getPrazoFinanciamento(); i++) {
            double valorDecrescente = (getValorImovel() / getPrazoFinanciamento()) * (1 + ((getTaxaJurosAnual() / i) / 12)); // calculo parcela por parcela
            valorParcelaSomado += valorDecrescente;
        }
        return valorParcelaSomado;
    }

    @Override
    protected double valorImovelTotal() {
        return jurosDecrescentes();
    }

    @Override
    public void showParcelaMensal() {
        for (int i = 1; i <= getPrazoFinanciamento(); i++) {
            double jurosMensalDecrescente = getTaxaJurosAnual() / i;
            double parcelaDecrescente = (getValorImovel() / getPrazoFinanciamento()) * (1 + (jurosMensalDecrescente / 12));
            System.out.printf("Valor da %dº parcela mensal: R$ %,.2f \n",i, parcelaDecrescente);
        }
    }
}

package Modelo;

import Exceptions.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento{

    private double areaConstruida;

    private double tamanhoTerreno;

    public Casa(double valorImovel, double taxaJuros, int prazoFinanciamento, double tamanhoTerreno, double areaConstruida) {
        super(valorImovel, taxaJuros, prazoFinanciamento);
        setTamanhoTerreno(tamanhoTerreno);
        setAreaConstruida(areaConstruida);
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

    public double calculoDesconto() throws DescontoMaiorDoQueJurosException{
        double valorDesconto;
        double desconto = 100;
        double parcela = this.parcelaMensal();
        valorDesconto = parcela - desconto;
        try{
            if(desconto > parcela){
                throw new DescontoMaiorDoQueJurosException();
            }
        }catch (Exception err){
            throw new RuntimeException(err);
        }
        return valorDesconto;
    }

    @Override
    protected double valorImovelTotal() {
        try {
            return (calculoDesconto() * this.getPrazoFinanciamento());
        } catch (DescontoMaiorDoQueJurosException e) {
            throw new RuntimeException(e);
        }
    }
}

package Modelo;

import Exceptions.DescontoMaiorDoQueJurosException;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {

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

    // Calcula o desconto, e trata caso o desconto for maior que o valor da parcela
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

    //calcula o valor da casa somando todas as parcelas
    @Override
    protected double valorImovelTotal() {
        try {
            return (calculoDesconto() * this.getPrazoFinanciamento());
        } catch (DescontoMaiorDoQueJurosException e) {
            throw new RuntimeException(e);
        }
    }

    //Apresenta as propriedades exclusivas da casa
    @Override
    public String showPropsFinanciamentos() {
        return String.format("Area construida: %,.2f m2\nTamanho do terreno %,.2f m2", this.getAreaConstruida(),this.getTamanhoTerreno());
    }
}

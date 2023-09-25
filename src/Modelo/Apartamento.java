package Modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {

    private int vagasGaragem;
    private int numeroAndar;
    public Apartamento(double valorImovel, double taxaJuros, int prazoFinanciamento, int vagasGaragem, int numeroAndar) {
        super(valorImovel, taxaJuros, prazoFinanciamento);
        setVagasGaragem(vagasGaragem);
        setNumeroAndar(numeroAndar);
    }
    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    public void setNumeroAndar(int numeroAndar) {
        this.numeroAndar = numeroAndar;
    }

    // Calculo dos juros decrescente do apartamento, retorna a soma das parcelas decrescentes
    private double jurosDecrescentes(){
        double valorParcelaSomado = 0;
        for (int i = 1; i <= getPrazoFinanciamento(); i++) {
            double valorDecrescente = (getValorImovel() / getPrazoFinanciamento()) * (1 + ((getTaxaJurosAnual() / i) / 12)); // calculo parcela por parcela
            valorParcelaSomado += valorDecrescente;
        }
        return valorParcelaSomado;
    }

    //Retorna uma string com os dados das parcelas mês a mês
    private String parcelasApartamento(){
        StringBuilder stringParcelaApartamento = new StringBuilder();
        for (int i = 1; i <= getPrazoFinanciamento(); i++) {
            double jurosMensalDecrescente = getTaxaJurosAnual() / i;
            double parcelaDecrescente = (getValorImovel() / getPrazoFinanciamento()) * (1 + (jurosMensalDecrescente / 12));
            stringParcelaApartamento.append(String.format("Valor da %dº parcela mensal: R$ %,.2f \n",i, parcelaDecrescente));
        }
        return stringParcelaApartamento.toString();
    }

    // Retorna a soma dos juros do apartamento
    @Override
    protected double valorImovelTotal() {
        return jurosDecrescentes();
    }

    //retorna a string formatada com todas as parcelas do apartamento
    @Override
    public String showParcelaMensal() {
        return parcelasApartamento();
    }

    //Apresenta as propriedades exclusivas do apartamento
    @Override
    public String showPropsFinanciamentos() {
        return String.format("Vagas Garagem: %d \nNumero Andar: %d", this.getVagasGaragem(),this.getNumeroAndar());
    }
}

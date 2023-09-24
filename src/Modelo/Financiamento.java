package Modelo;



import java.util.ArrayList;

public abstract class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // constructor
    public Financiamento(double valorImovel, double taxaJuros, int prazoFinanciamento){
        setValorImovel(valorImovel);
        setTaxaJurosAnual(taxaJuros);
        setPrazoFinanciamento(prazoFinanciamento);
    }

    double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    private void setTaxaJurosAnual(Double taxaJurosAnual){
        this.taxaJurosAnual = taxaJurosAnual;
    }

    protected double getValorImovel() {
        return valorImovel;
    }

    private void setValorImovel(Double valorImovel){
        this.valorImovel = valorImovel;
    }

    protected int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    private void setPrazoFinanciamento(int prazoFinanciamento){
        this.prazoFinanciamento = prazoFinanciamento;
    }

    // Função responsável por calcular a soma do valor do imovel + valor do financiamento
    protected double valorImovelTotal(){
        return parcelaMensal() * getPrazoFinanciamento();
    }

    // Função responsável por calcular a parcela do financiamento
    protected double parcelaMensal(){
        return (getValorImovel() / getPrazoFinanciamento()) * (1 + (getTaxaJurosAnual() / 12));
    }

    //Função responsável por exibir parcela do imovel do financiamento
    public void showParcelaMensal(){
        System.out.printf("Valor da parcela mensal: R$ %,.2f \n", parcelaMensal());
    }

    //Função responsável por exibir valor do imovel do financiamento
    public void showPagamentoTotal(){
        System.out.printf("Valor total a ser pago: R$ %,.2f \n", valorImovelTotal());
    }

    // Função responsável por exibir os financiamentos e o valor somado dos mesmos
    public void showInfoFinanciamento(ArrayList<Financiamento> arr){
        double somaFinanciamento = 0;
        double somaValorImoveis = 0;

        for (int i = 0; i < arr.size(); i++) {
            System.out.println("Financiamento: " + (i+1));
            arr.get(i).showParcelaMensal();
            arr.get(i).showPagamentoTotal();
            System.out.println("-----------------");
        }

        for (Financiamento financiamento : arr) {
            somaFinanciamento += financiamento.valorImovelTotal();
        }

        for (Financiamento financiamento : arr) {
            somaValorImoveis += financiamento.getValorImovel();
        }

        System.out.printf("Valor total dos financiamentos é: R$ %,.2f \n", somaFinanciamento);
        System.out.printf("Valor total dos imoveis é: R$ %,.2f \n", somaValorImoveis);
    }

    public void showTamanhoTerreno(){

    }
}




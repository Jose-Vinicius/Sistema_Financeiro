package Modelo;

import Usuario.Usuario;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // constructor
    public Financiamento(){
        Usuario user = new Usuario();
        setValorImovel(user.precoImovel());
        setTaxaJurosAnual(user.taxaJuros());
        setPrazoFinanciamento(user.prazoFinanciamento());
        System.out.println("=== Financiamento cadastrado ===");
    }

    double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    private void setTaxaJurosAnual(Double taxaJurosAnual){
        this.taxaJurosAnual = taxaJurosAnual;
    }

    private double getValorImovel() {
        return valorImovel;
    }

    private void setValorImovel(Double valorImovel){
        this.valorImovel = valorImovel;
    }

    private int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    private void setPrazoFinanciamento(int prazoFinanciamento){
        this.prazoFinanciamento = prazoFinanciamento;
    }

    // Função responsável por calcular a soma do valor do imovel + valor do financiamento
    private double valorImovelTotal(){
        return parcelaMensal() * getPrazoFinanciamento();
    }

    // Função responsável por calcular a parcela do financiamento
    private double parcelaMensal(){
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
    public void showInfoFinanciamento(Financiamento[] arr){
        double somaFinanciamento = 0;
        double somaValorImoveis = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Financiamento: " + (i+1));
            arr[i].showParcelaMensal();
            arr[i].showPagamentoTotal();
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
}




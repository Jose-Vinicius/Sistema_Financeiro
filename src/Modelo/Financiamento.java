package Modelo;
import Usuario.Usuario;
public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    public Financiamento(){
        Usuario user = new Usuario();
        setValorImovel(user.precoImovel());
        setTaxaJurosAnual(user.taxaJuros());
        setPrazoFinanciamento(user.prazoFinanciamento());
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

    private double valorImovelTotal(){
        return (getValorImovel() * Math.pow((1 + (getTaxaJurosAnual() / 100)), getPrazoFinanciamento()));
    }

    private double parcelaMensal(){
        return (valorImovelTotal() / getPrazoFinanciamento());
    }

    public void showParcelaMensal(){
        System.out.printf("Valor da parcela mensal: R$ %.2f \n", parcelaMensal());
    }

    public void showPagamentoTotal(){
        System.out.printf("Valor total a ser pago: R$ %,.2f \n", valorImovelTotal());
    }
}

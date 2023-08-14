public class Financiamento {
    final double valorImovel;
    final int prazoFinanciamento;
    final double taxaJurosAnual;
    public Financiamento(){
        Usuario user = new Usuario();
        this.valorImovel = user.precoImovel();
        this.prazoFinanciamento = user.prazoFinanciamento();
        this.taxaJurosAnual = user.taxaJuros();
    }

    private double valorImovelTotal(){
        return (this.valorImovel * Math.pow((1 + (this.taxaJurosAnual / 100)), this.prazoFinanciamento));
    }

    private double parcelaMensal(){
        return (valorImovelTotal() / this.prazoFinanciamento);
    }

    protected void showParcelaMensal(){
        System.out.printf("Valor da parcela mensal: R$ %.2f \n", parcelaMensal());
    }

    protected void showPagamentoTotal(){
        System.out.printf("Valor total a ser pago: R$ %,.2f \n", valorImovelTotal());
    }
}

public class Financiamento {
    final double valorImovel;
    final int prazoFinanciamento;
    final double taxaJurosAnual;
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    private double pagamentoMensal(){
        return (this.valorImovel / this.prazoFinanciamento) * (1 + (this.taxaJurosAnual) / 12);
    }

    private double totalPagamento(){
        return (this.pagamentoMensal() * this.prazoFinanciamento);
    }

    public void showParcelaMensal(){
        System.out.println(pagamentoMensal());
    }

    public void showPagamentoTotal(){
        System.out.println(totalPagamento());
    }
}

public class Main {
    public static void main(String[] args) {
        Financiamento finan1 = new Financiamento(20000, 3, 6);

        finan1.showParcelaMensal();
        finan1.showPagamentoTotal();
    }
}
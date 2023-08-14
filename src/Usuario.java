import java.util.Scanner;

public class Usuario implements InterfaceUsuario{
    public static Scanner sc = new Scanner(System.in);

    @Override
    public double precoImovel() {
        System.out.println("==== Informe o preço do imovel ====");
        return sc.nextDouble();
    }

    @Override
    public int prazoFinanciamento() {
        System.out.println("==== Informe o numero de parcelas ====");
        return sc.nextInt();
    }

    @Override
    public double taxaJuros() {
        System.out.println("==== Informe a taxa de juros mensal ====");
        return sc.nextDouble();
    }
}

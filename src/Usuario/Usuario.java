package Usuario;
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


        while(true) {
            int answer = 0;
            try {
                System.out.println("==== Informe o numero de parcelas ====");
                answer = sc.nextInt();
                if(answer <= 0){
                    System.out.println("O valor não pode ser negativo ou zero");
                } else{
                    return answer;
                }
            } catch (Exception err) {

            }

        }
    }

    @Override
    public double taxaJuros() {
        System.out.println("==== Informe a taxa de juros mensal ====");
        return sc.nextDouble();
    }
}

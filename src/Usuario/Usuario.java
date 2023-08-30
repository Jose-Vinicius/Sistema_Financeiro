package Usuario;
import java.util.Scanner;

public class Usuario implements InterfaceUsuario{
    public static Scanner sc = new Scanner(System.in);

    // Função para tratar o preço do imovel
    @Override
    public double precoImovel() {
        while(true){
            double answer;
            try{
                System.out.println("==== Informe o preço do imovel ====");
                answer = sc.nextDouble();
                if(answer <= 0){
                    System.out.println("O valor não pode ser negativo ou zero");
                } else{
                    return answer;
                }

            }catch(Exception err){
                System.out.println("Valor invalido");
                sc.nextLine();
            }
        }
    }
    // Função para tratar o prazo do financiamento
    @Override
    public int prazoFinanciamento() {
        while(true) {
            int answer;
            try {
                System.out.println("==== Informe o numero de parcelas ====");
                answer = sc.nextInt();
                if(answer <= 0){
                    System.out.println("O valor não pode ser negativo ou zero");
                } else{
                    return answer;
                }
            } catch (Exception err) {
                System.out.println("Valor invalido");
                sc.nextLine();
            }

        }
    }

    // Função para tratar a taxa de juros
    @Override
    public double taxaJuros() {
        while(true) {
            double answer;
            try {
                System.out.println("==== Informe a taxa de juros mensal ====");
                answer = sc.nextDouble();
                if (answer > 100) {
                    System.out.println("O valor é muito alto tente reduzir");
                } else if (answer <= 0) {
                    System.out.println("O juros não pode ser menor ou igual a zero");
                } else {
                    return answer;
                }
            } catch (Exception err) {
                System.out.println("Valor invalido");
                sc.nextLine();
            }
        }
    }
}

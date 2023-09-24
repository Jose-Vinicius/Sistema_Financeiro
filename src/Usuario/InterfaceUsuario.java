package Usuario;

import java.util.Scanner;

public interface InterfaceUsuario {
    public static Scanner sc = new Scanner(System.in);

    public default double precoImovel(){
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
    };
    public default int prazoFinanciamento(){
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
    };

    public default double taxaJuros(){
        while(true) {
            double answer;
            try {
                System.out.println("==== Informe a taxa de juros anual ====");
                answer = sc.nextDouble();
                if (answer > 30) {
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
    };

    public default double tamanhoTerreno(){
        while(true) {
            double answer;
            try {
                System.out.println("==== Informe o tamanho do terreno ====");
                answer = sc.nextDouble();
                if (answer <= 0) {
                    System.out.println("O tamanho do terreno não pode ser menor ou igual a 0");
                } else {
                    return answer;
                }
            } catch (Exception err) {
                System.out.println("Valor invalido");
                sc.nextLine();
            }
        }
    }


    public default double areaConstruida(){
        while(true) {
            double answer;
            try {
                System.out.println("==== Informe o tamanho da area construída ====");
                answer = sc.nextDouble();
                if (answer < 0) {
                    System.out.println("A area construída não pode ser menor que 0");
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

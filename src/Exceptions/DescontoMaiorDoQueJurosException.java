package Exceptions;
public class  DescontoMaiorDoQueJurosException extends Throwable{
    @Override
    public String getMessage(){
        return "O valor da parcela não pode ser maior que o do desconto";
    }
}

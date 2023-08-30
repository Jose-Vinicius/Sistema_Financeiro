package Main;

import Modelo.Financiamento;
public class Main {
    public static void main(String[] args) {
        Financiamento[] arrayFinanciamento = new Financiamento[4];

        arrayFinanciamento[0] = new Financiamento();
        arrayFinanciamento[1] = new Financiamento();
        arrayFinanciamento[2] = new Financiamento();
        arrayFinanciamento[3] = new Financiamento();

        arrayFinanciamento[0].showInfoFinanciamento(arrayFinanciamento);
    }
}



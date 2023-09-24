package Main;

import Modelo.Apartamento;
import Modelo.Casa;
import Modelo.Financiamento;
import Modelo.Terreno;
import Usuario.Usuario;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Usuario user = new Usuario();

        ArrayList<Financiamento> arrayListFinanciamento = new ArrayList<>();

//        arrayListFinanciamento.add(new Casa(user.precoImovel(), user.taxaJuros(), user.prazoFinanciamento(), user.tamanhoTerreno(), user.areaConstruida()));
        arrayListFinanciamento.add(new Casa(400000.00, 10.5, 360, 300.75, 250));
        arrayListFinanciamento.add(new Casa(500000.00, 4.5, 360, 110.75, 150));

        arrayListFinanciamento.add(new Apartamento(500000.00, 4.5, 10, 2, 3));
        arrayListFinanciamento.add(new Apartamento(400000.00, 3.2, 10, 1, 5));

        arrayListFinanciamento.add(new Terreno(750000.00, 4.0, 480, "Comercial"));

        arrayListFinanciamento.get(0).criarArquivoTxt(arrayListFinanciamento);
        arrayListFinanciamento.get(0).lerArquivoTxt();

    }

}



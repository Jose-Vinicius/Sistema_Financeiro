package Main;

import Modelo.Apartamento;
import Modelo.Casa;
import Modelo.Financiamento;
import Modelo.Terreno;
import Serial.Serializacao;
import Usuario.Usuario;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException {
        Usuario user = new Usuario();

        ArrayList<Financiamento> arrayListFinanciamento = new ArrayList<>();

        arrayListFinanciamento.add(new Casa(user.precoImovel(), user.taxaJuros(), user.prazoFinanciamento(), user.tamanhoTerreno(), user.areaConstruida()));

        arrayListFinanciamento.add(new Casa(400000.00, 10.5, 360, 300.75, 250));
        arrayListFinanciamento.add(new Casa(500000.00, 4.5, 100, 110.75, 150));

        arrayListFinanciamento.add(new Apartamento(500000.00, 4.5, 20, 2, 3));
        arrayListFinanciamento.add(new Apartamento(400000.00, 3.2, 10, 1, 5));

        arrayListFinanciamento.add(new Terreno(750000.00, 4.0, 480, "Comercial"));

        Serializacao serialMain = new Serializacao();

        serialMain.serializarArquivo(arrayListFinanciamento);

        ArrayList<Financiamento> serializedArrayFinanciamento;
        serializedArrayFinanciamento = serialMain.desserializar();
        serializedArrayFinanciamento.get(0).criarArquivoTxt(serializedArrayFinanciamento);
        serializedArrayFinanciamento.get(0).lerArquivoTxt();

    }

}



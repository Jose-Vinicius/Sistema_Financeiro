package Main;

import Modelo.Apartamento;
import Modelo.Casa;
import Modelo.Financiamento;
import Modelo.Terreno;
import Usuario.Usuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Usuario user = new Usuario();

        ArrayList<Financiamento> arrayListFinanciamento = new ArrayList<>();

        arrayListFinanciamento.add(new Casa(user.precoImovel(), user.taxaJuros(), user.prazoFinanciamento()));
        arrayListFinanciamento.add(new Casa(500000.00, 4.5, 360));

        arrayListFinanciamento.add(new Apartamento(500000.00, 4.5, 360));
        arrayListFinanciamento.add(new Apartamento(400000.00, 3.2, 180));

        arrayListFinanciamento.add(new Terreno(750000.00, 4.0, 480));

        arrayListFinanciamento.get(0).showInfoFinanciamento(arrayListFinanciamento);

    }
}



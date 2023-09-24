package Serial;

import Modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class Serializacao{
    public void serializarArquivo(ArrayList<Financiamento> arr){

        String filePath = new File("").getAbsolutePath();
        String path = filePath + "/src/Arquivos/Main_serializado.dat";
        try (
            FileOutputStream arquivo = new FileOutputStream(path);
            ObjectOutputStream saida = new ObjectOutputStream(arquivo)) {
                saida.writeObject(arr);
                System.out.println("Objeto serializado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Financiamento> desserializar() {
        String filePath = new File("").getAbsolutePath();
        String arq = filePath + "/src/Arquivos/financas_serializado.dat";
        ArrayList<Financiamento> objeto = null;
        try (
            FileInputStream arquivo = new FileInputStream(arq);
            ObjectInputStream entrada = new ObjectInputStream(arquivo)) {

            objeto = (ArrayList<Financiamento>) entrada.readObject();
            System.out.println("Objeto desserializado com sucesso.");
            return objeto;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objeto;
    }
}

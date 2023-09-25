package Serial;

import Modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;

public class Serializacao{
    final String arqName = "financas_serializado.dat";

    //função responsavel por criar e escrever o arquivo serializado
    public void serializarArquivo(ArrayList<Financiamento> arr){
        String filePath = new File("").getAbsolutePath();
        String path = filePath + "/src/Arquivos/" + arqName;
        try (
            FileOutputStream arquivo = new FileOutputStream(path);
            ObjectOutputStream saida = new ObjectOutputStream(arquivo)) {
                saida.writeObject(arr);
                System.out.println("Objeto serializado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // função responsavel por desserializar o arquivo e retornar para leitura
    public ArrayList<Financiamento> desserializar() {
        String filePath = new File("").getAbsolutePath();
        String arq = filePath + "/src/Arquivos/" + arqName;
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

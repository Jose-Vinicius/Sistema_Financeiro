package Modelo;

import java.io.*;
import java.util.ArrayList;

public abstract class Financiamento implements Serializable{
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // constructor
    public Financiamento(double valorImovel, double taxaJuros, int prazoFinanciamento){
        setValorImovel(valorImovel);
        setTaxaJurosAnual(taxaJuros);
        setPrazoFinanciamento(prazoFinanciamento);
    }

    double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    private void setTaxaJurosAnual(Double taxaJurosAnual){
        this.taxaJurosAnual = taxaJurosAnual;
    }

    protected double getValorImovel() {
        return valorImovel;
    }

    private void setValorImovel(Double valorImovel){
        this.valorImovel = valorImovel;
    }

    protected int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    private void setPrazoFinanciamento(int prazoFinanciamento){
        this.prazoFinanciamento = prazoFinanciamento;
    }

    // Função responsável por calcular a soma do valor do imovel + valor do financiamento
    protected double valorImovelTotal(){
        return parcelaMensal() * getPrazoFinanciamento();
    }

    // Função responsável por calcular a parcela do financiamento
    protected double parcelaMensal(){
        return (getValorImovel() / getPrazoFinanciamento()) * (1 + (getTaxaJurosAnual() / 12));
    }

    //Função responsável por exibir parcela do imovel do financiamento
    public String showParcelaMensal(){
        return String.format("Valor da parcela mensal: R$ %,.2f \n", parcelaMensal());
    }

    //Função responsável por exibir valor do imovel do financiamento
    public String showPagamentoTotal(){
        return String.format("Valor total a ser pago: R$ %,.2f \n", valorImovelTotal());
    }

    // Função responsável por exibir os financiamentos e o valor somado dos mesmos
    public String showInfoFinanciamento(ArrayList<Financiamento> arr){
        double somaFinanciamento = 0;
        double somaValorImoveis = 0;

        for (Financiamento financiamento : arr) {
            somaFinanciamento += financiamento.valorImovelTotal();
        }

        for (Financiamento financiamento : arr) {
            somaValorImoveis += financiamento.getValorImovel();
        }

        return String.format("Valor total dos financiamentos é: R$ %,.2f \nValor total dos imoveis é: R$ %,.2f \n", somaFinanciamento, somaValorImoveis);

    }

    public String showPropsFinanciamentos(){
        return "Sem propriedades";
    }

    public void criarArquivoTxt(ArrayList<Financiamento> arr) throws IOException {
        String filePath = new File("").getAbsolutePath();
        FileWriter arq = new FileWriter(filePath + "/src/Arquivos/dadosFinanciamento.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        StringBuilder stringDadosFinanciamento = new StringBuilder();
        for(int i = 0; i < arr.size(); i++){
            String classeFinanciamento = arr.get(i).getClass().getSimpleName();
            stringDadosFinanciamento.append(
                    String.format(
                            "Financiamento: " + (i + 1) + " " + classeFinanciamento + "\n" +
                            arr.get(i).showParcelaMensal() +
                            arr.get(i).showPagamentoTotal() +
                            arr.get(i).showPropsFinanciamentos() + "\n"+
                            "------------------------------------- \n"
                    )
            );
        }
        gravarArq.println(
                stringDadosFinanciamento + "\n" +
                showInfoFinanciamento(arr)
        );

        arq.close();

    }

    public void lerArquivoTxt() throws IOException {
        String filePath = new File("").getAbsolutePath();
        String arq = filePath + "/src/Arquivos/dadosFinanciamento.txt";
        try (BufferedReader leitor = new BufferedReader(new FileReader(arq))){
            String linhaArquivo;
            while ((linhaArquivo = leitor.readLine()) != null) {
                System.out.println(linhaArquivo);
            }
        }catch(IOException err){
            err.printStackTrace();
        }
    }
}




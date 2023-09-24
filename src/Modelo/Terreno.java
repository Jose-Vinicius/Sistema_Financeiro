package Modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private String tipoArea;

    public String getTipoArea() {
        return tipoArea;
    }

    public void setTipoArea(String tipoArea) {
        this.tipoArea = tipoArea;
    }

    public Terreno(double valorImovel, double taxaJuros, int prazoFinanciamento, String tipoArea) {
        super(valorImovel, taxaJuros, prazoFinanciamento);
        setTipoArea(tipoArea);
    }

    @Override
    protected double valorImovelTotal() {
        return (((super.valorImovelTotal() / 100) * 2) + super.valorImovelTotal());
    }

    @Override
    public String showPropsFinanciamentos() {
        return String.format("Tipo Area: %s", this.getTipoArea());
    }
}

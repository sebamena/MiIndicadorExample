package cl.sebastianmena.miindicadorexample.models;

/**
 * Created by Sebastián Mena on 29-09-2017.
 */

public class Indicator {

    private String fecha;
    private double valor;

    public Indicator() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

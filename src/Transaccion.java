import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.Date;


public class Transaccion {

    private final String monedaInicial;
    private final String monedaFinal;
    private double valorEnMonedaInicial;
    private double valorEnMonedaFinal;
    private final double tasaDeCambio;
    private LocalDate fechaTransaccion;

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Transaccion(String monedaInicial, String monedaFinal, double valorEnMonedaInicial, double tasaDeCambio) {
        this.monedaInicial = monedaInicial;
        this.monedaFinal = monedaFinal;
        this.valorEnMonedaInicial = valorEnMonedaInicial;
        this.tasaDeCambio = tasaDeCambio;
    }

    public Transaccion(ExChTransaccion exTran1) {
        this.monedaInicial= exTran1.base_code();
        this.monedaFinal= exTran1.target_code();
        this.tasaDeCambio = exTran1.conversion_rate();
    }

    public void setValorEnMonedaInicial(double valorEnMonedaInicial) {
        this.valorEnMonedaInicial = valorEnMonedaInicial;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }

    public void setValorEnMonedaFinal(double valorEnMonedaFinal) {
        this.valorEnMonedaFinal = valorEnMonedaFinal;
    }

    public double getValorEnMonedaInicial() {
        return valorEnMonedaInicial;
    }
    public void convertirValores(double valorAConvertir){
        this.valorEnMonedaInicial=valorAConvertir;
        this.valorEnMonedaFinal = valorAConvertir*tasaDeCambio;
    }

    public double getValorEnMonedaFinal() {
        return valorEnMonedaFinal;
    }

    @Override
    public String toString() {
        return "Fecha= " + fechaTransaccion + '\'' +
                "monedaInicial='" + monedaInicial + '\'' +
                ", monedaFinal='" + monedaFinal + '\'' +
                ", valorEnMonedaInicial=" + valorEnMonedaInicial +
                ", valorEnMonedaFinal=" + valorEnMonedaFinal +
                ", tasaDeCambio=" + tasaDeCambio;
    }
}


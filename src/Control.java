
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Control {
    List<Transaccion> transacciones = new ArrayList();
    BusquedaDeCotizaciones bdc = new BusquedaDeCotizaciones();
    double var;
    public double gestor(String monedaInicial, String monedaFinal, double valorAConvertir){
        Transaccion tr1 = bdc.busqueda(monedaInicial, monedaFinal);
        tr1.convertirValores(valorAConvertir);
        tr1.setFechaTransaccion(LocalDate.now());
        var = tr1.getTasaDeCambio();
        transacciones.add(tr1);
        return tr1.getValorEnMonedaFinal();
    }

    public double tasa(){
        return var;
    }

    public void listado(){
        for (Transaccion op: transacciones){
            System.out.println(op.toString());
        }
    }
}


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Control ctrl = new Control();

        String presentacion = """
                ****************************************
                                
                BIENVENIDO/A AL CONVERSOR DE MONEDA
                              
                ****************************************""";

        String menu = """
                **Elija una de las siguientes opciones:**
                                
                1 - Dólar =>> Peso Argentino
                2 - Peso Argentino =>> Dolar
                3 - Dolar =>> Real Brasileño
                4 - Real Brasileño =>> Dolar
                5 - Dolar =>> Peso Colombiano
                6 - Peso Colombiano =>> Dolar
                7 - Dólar =>> Euro
                8 - Euro =>> Dólar
                9 - Salir
                                
                *****************************************
                
                """;
        System.out.println(presentacion);
        String monedaInicial = "";
        String monedaFinal = "";
        double valorAConvertir = 0;
        double valorConvertido = 0;
        int opcion=0;
        boolean flag = true;
        boolean flag1 = true;

        while (flag) {

            System.out.println(menu);
            try {
                opcion = leer.nextInt();
            }catch(InputMismatchException e){
                System.out.println("\nIngresa solo algún número entero que corresponda a una opción del menú \n");
                // La linea de código que sigue sirve para resetear el scanner puesto que sinó sigue anclado y el programa entra en un loop infinito
                leer.next();
                flag1=false;
            }
            switch (opcion) {
                case 1:
                    monedaInicial = "USD";
                    monedaFinal = "ARS";

                    break;
                case 2:
                    monedaInicial = "ARS";
                    monedaFinal = "USD";

                    break;
                case 3:
                    monedaInicial = "USD";
                    monedaFinal = "BRL";

                    break;
                case 4:
                    monedaInicial = "BRL";
                    monedaFinal = "USD";

                    break;
                case 5:
                    monedaInicial = "USD";
                    monedaFinal = "COP";

                    break;
                case 6:
                    monedaInicial = "COP";
                    monedaFinal = "USD";
                    break;
                case 7:
                    monedaInicial = "USD";
                    monedaFinal = "EUR";
                    break;
                case 8:
                    monedaInicial = "EUR";
                    monedaFinal = "USD";
                    break;
                case 9:
                    System.out.println("Gracias por utilizar nuestro servicio");
                    System.out.println("Estas son todas las transacciones realizadas en esta sesión");
                    ctrl.listado();
                    flag = false;
                    break;
                default:
                    System.out.println("La opción ingresada no es válida prueba nuevamente");
                    flag1 = false;
            }
            if (flag && flag1) {
                System.out.println("\nIngresa el valor que deseas convertir\n ");
                try {
                    valorAConvertir = leer.nextDouble();
                    valorConvertido = ctrl.gestor(monedaInicial, monedaFinal, valorAConvertir);
                    System.out.println("\nEl valor de " + valorAConvertir + "[" + monedaInicial + "] corresponde al valor final de =>> " + valorConvertido + "[" + monedaFinal + "]\n"+
                            " la tasa de conversion es: "+ctrl.tasa()+"\n");
                }catch(InputMismatchException e){
                    System.out.println("Ingresa solo valores numéricos");
                    // La linea de código que sigue sirve para resetear el scanner puesto que sinó sigue anclado y el programa entra en un loop infinito
                    leer.next();
                }
            } else if (!flag1) {
                flag1 = true;
                continue;
            } else {
                break;
            }

        }
    }
}

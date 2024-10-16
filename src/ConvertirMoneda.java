import java.util.Scanner;

public class ConvertirMoneda {

    public static void convertir(String monedaBase, String monedaTarget, ConsultarMoneda consulta, Scanner lectura){
        double cantidad;
        double cantidadConvertida;

        Monedas monedas = consulta.buscarMoneda(monedaBase, monedaTarget);
        System.out.println("La tasa de conversión para el día es\n1 "+monedaBase+ " = "+monedas.conversion_rate()+" "+monedaTarget);
        cantidad = obtenerCantidadValida(lectura, monedaBase);
        //System.out.println("Ingrese la cantidad de " + monedaBase);
        //cantidad = Double.parseDouble(lectura.nextLine());
        cantidadConvertida = cantidad * monedas.conversion_rate();
        System.out.println(cantidad+" "+monedaBase +" = " + cantidadConvertida + " " + monedas.target_code());
    }
    public static void convertirOtraMoneda(ConsultarMoneda consulta, Scanner lectura){
        System.out.println("Ingrese el código de otra moneda base, ejemplo para Euro EUR, para Peso Mexicano MXN: ");
        String monedaBase = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese el código de la moneda objetivo: ");
        String monedaObjetivo = lectura.nextLine().toUpperCase();
        convertir(monedaBase, monedaObjetivo, consulta, lectura);
    }
    private static double obtenerCantidadValida(Scanner lectura, String monedaBase) {
        double cantidad = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Ingrese la cantidad de " + monedaBase + ": ");
                cantidad = Double.parseDouble(lectura.nextLine());
                if (cantidad <= 0) {
                    System.out.println("Por favor, ingrese un número mayor a 0.");
                } else {
                    entradaValida = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Debe ingresar un número.");
            }
        }
        return cantidad;
    }
}

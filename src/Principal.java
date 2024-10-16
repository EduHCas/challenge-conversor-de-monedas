import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        int opcion=0;
        while (opcion !=8){
            System.out.println("**************************************\n" +
                    "Bienvenido al Conversor de Monedas\n\n" +
                    "Ingrese la conversion que desea realizar\n\n" +
                    "1. Dollar a Peso Argentino\n" +
                    "2. Peso Argentino a Dollar\n" +
                    "3. Dollar a Real Brasileno\n" +
                    "4. Real Brasileno a Dollar\n" +
                    "5. Dollar a Peso Colombiano\n" +
                    "6. Peso Colombiano a Dollar\n" +
                    "7. Convertir otra moneda\n" +
                    "8. Salir");
            System.out.println("\n******************************************");

            boolean opcionValida = false;
            while (!opcionValida) {
                try {
                    opcion = lectura.nextInt();
                    lectura.nextLine();
                    if (opcion >= 1 && opcion <= 8) {
                        opcionValida = true;
                    } else {
                        System.out.println("Opción no válida. Debe ser un número entre 1 y 8.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor ingrese un número entre 1 y 8.");
                    lectura.nextLine();
                }
            }
            switch (opcion){
                case 1:
                    ConvertirMoneda.convertir("USD","ARS", consulta, lectura);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", consulta, lectura);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", consulta, lectura);
                    break;
                case 7:
                    ConvertirMoneda.convertirOtraMoneda(consulta, lectura);
                    break;
                case 8:
                    System.out.println("Gracias por utilizar nuestro servicio");
                    break;

                default:
                    System.out.println("Ocion no valida");
                    break;


            }
        }
    }
}

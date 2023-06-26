import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static double saldo = 10000; // Saldo inicial
    private static List<String> historial = new ArrayList<>(); // Historial de transacciones

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al Cajero Automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Ingrese el número de opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    retirarDinero(cantidadRetiro);
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    depositarDinero(cantidadDeposito);
                    break;
                case 4:
                    System.out.println("Gracias por usar el Cajero Automático. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void consultarSaldo() {
        System.out.println("Su saldo actual es: " + saldo);
        System.out.println("Historial de transacciones:");
        for (String transaccion : historial) {
            System.out.println(transaccion);
        }
    }

    public static void retirarDinero(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente");
        } else if (saldo - cantidad < 10000) {
            System.out.println("No se puede realizar el retiro. El saldo mínimo permitido es 10,000 pesos.");
        }else {
            saldo -= cantidad;
            String transaccion = "Retiro: -" + cantidad;
            historial.add(transaccion);
            System.out.println("Ha retirado " + cantidad + " pesos. Saldo restante: " + saldo);
        }
    }

    public static void depositarDinero(double cantidad) {
        saldo += cantidad;
        String transaccion = "Depósito: +" + cantidad;
        historial.add(transaccion);
        System.out.println("Ha depositado " + cantidad + " pesos. Saldo actual: " + saldo);
    }
}
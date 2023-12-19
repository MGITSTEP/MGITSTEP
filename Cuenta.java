import java.util.ArrayList;
import java.util.Scanner;

class Cuenta {
    private String nombre;
    private double saldo;
    private String pin;

    public Cuenta(String nombre, double saldoInicial, String pin) {
        this.nombre = nombre;
        this.saldo = saldoInicial;
        this.pin = pin;
    }

    public double getSaldo(String pinIngresado) {
        if (pinIngresado.equals(this.pin)) {
            return this.saldo;
        } else {
            System.out.println("PIN incorrecto. Acceso denegado.");
            return -1;
        }
    }

    public void depositar(double monto, String pinIngresado) {
        if (pinIngresado.equals(this.pin)) {
            this.saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: " + this.saldo);
        } else {
            System.out.println("PIN incorrecto. Depósito denegado.");
        }
    }

    public void retirar(double monto, String pinIngresado) {
        if (pinIngresado.equals(this.pin)) {
            if (monto <= this.saldo) {
                this.saldo -= monto;
                System.out.println("Retiro exitoso. Nuevo saldo: " + this.saldo);
            } else {
                System.out.println("Fondos insuficientes. Retiro denegado.");
            }
        } else {
            System.out.println("PIN incorrecto. Retiro denegado.");
        }
    }
}

class Banco {
    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    public Cuenta crearCuenta(String nombre, double saldoInicial, String pin) {
        Cuenta nuevaCuenta = new Cuenta(nombre, saldoInicial, pin);
        cuentas.add(nuevaCuenta);
        return nuevaCuenta;
    }

    public Cuenta accederCuenta(String pin) {
        for (Cuenta cuenta : cuentas) {
            if (pin.equals(cuenta.getPin())) {
                return cuenta;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Crear nueva cuenta");
            System.out.println("2. Acceder a cuenta existente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Ingrese el nombre del titular: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el saldo inicial: ");
                double saldoInicial = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese un PIN: ");
                String pin = scanner.nextLine();
                Cuenta nuevaCuenta = banco.crearCuenta(nombre, saldoInicial, pin);
                System.out.println("\nCuenta creada con éxito. Nombre: " + nombre +
                        ", Saldo inicial: " + saldoInicial + ", PIN: " + pin);

            } else if (opcion.equals("2")) {
                System.out.print("Ingrese su PIN para acceder a la cuenta: ");
                String pin = scanner.nextLine();
                Cuenta cuenta = banco.accederCuenta(pin);
                if (cuenta != null) {
                    System.out.println("\n¡Acceso exitoso!");
                    while (true) {
                        System.out.println("\n1. Consultar saldo");
                        System.out.println("2. Realizar depósito");
                        System.out.println("3. Realizar retiro");
                        System.out.println("4. Salir");
                        System.out.print("Seleccione una opción: ");
                        String opcionCuenta = scanner.nextLine();

                        if (opcionCuenta.equals("1")) {
                            System.out.println("Saldo actual: " + cuenta.getSaldo(pin));

                        } else if (opcionCuenta.equals("2")) {
                            System.out.print("Ingrese el monto a depositar: ");
                            double montoDeposito = Double.parseDouble(scanner.nextLine());
                            cuenta.depositar(montoDeposito, pin);

                        } else if (opcionCuenta.equals("3")) {
                            System.out.print("Ingrese el monto a retirar: ");
                            double montoRetiro = Double.parseDouble(scanner.nextLine());
                            cuenta.retirar(montoRetiro, pin);

                        } else if (opcionCuenta.equals("4")) {
                            break;

                        } else {
                            System.out.println("Opción no válida. Intente nuevamente.");
                        }
                    }

                } else {
                    System.out.println("Acceso denegado. PIN incorrecto.");
                }

            } else if (opcion.equals("3")) {
                System.out.println("¡Gracias por utilizar nuestro servicio! Hasta luego.");
                break;

            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
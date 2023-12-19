import java.util.Scanner;

interface Cocina {
    void prepararIngredientes();
    void cocinar();
    void servir();
}

abstract class RobotCocina implements Cocina {
    public void prepararIngredientes() {
        System.out.println("Robot preparando ingredientes...");
    }

    public void cocinar() {
        System.out.println("Robot cocinando...");
    }

    public void servir() {
        System.out.println("Robot sirviendo el plato.");
    }


    public abstract void realizarAccion();
}

class RobotDesayuno extends RobotCocina {
    public void realizarAccion() {
        System.out.println("Robot de desayuno preparando café.");
    }
}

class RobotComida extends RobotCocina {
    public void realizarAccion() {
        System.out.println("Robot de comida preparando almuerzo.");
    }
}

class RobotCena extends RobotCocina {
    public void realizarAccion() {
        System.out.println("Robot de cena preparando cena.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona una opción:");
        System.out.println("1. Desayuno");
        System.out.println("2. Comida");
        System.out.println("3. Cena");

        int opcionMenu = scanner.nextInt();

        RobotCocina robot = null;

        switch (opcionMenu) {
            case 1:
                robot = new RobotDesayuno();
                break;
            case 2:
                robot = new RobotComida();
                break;
            case 3:
                robot = new RobotCena();
                break;
            default:
                System.out.println("Opción no válida");
                System.exit(1);
        }

        robot.realizarAccion();

        System.out.println("Selecciona el siguiente paso:");
        System.out.println("1. Preparar ingredientes");
        System.out.println("2. Cocinar");
        System.out.println("3. Servir");

        int Paso = scanner.nextInt();

        switch (Paso) {
            case 1:
                robot.prepararIngredientes();
                break;
            case 2:
                robot.cocinar();
                break;
            case 3:
                robot.servir();
                System.out.println("¡Hurra! El plato estaba delicioso.");
                break;
            default:
                System.out.println("Opción no válida");
                System.exit(1);
        }

        scanner.close();
    }
}

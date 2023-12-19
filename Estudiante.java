import java.util.Scanner;

public class Estudiante {
    public String nombre;
    public int numEstudiante;
    public String materia;
    public int calificacion;
    public String estado;

    public Estudiante (String nombre, int numEstudiante, String materia, int calificacion, String estado) {
        this.nombre = nombre;
        this.numEstudiante = numEstudiante;
        this.materia = materia;
        this.calificacion = calificacion;
        this.estado = estado;
    }

    public int obtenerCalificacion(){
        return calificacion;
    }

    public void CambiarCalificacion(int calificacion) {
        this.calificacion = nuevaCalificacion;
        AsignarEstado();
        System.out.println ("Calificacion cambiada para " + nombre + nuevaCalificacion);
    }

    public String obtenerEstado(){
        return estado;
    }

    public void AsignarEstado() {

        if (calificacion < 60)
        {
            estado = "Alumno reprobado";
        }
        if (calificacion >= 60)
        {
            estado =  "Alumno aprbado";
        }
    }

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estudiante[] estudiantes = new Estudiante[10];
        int opcion;

        do {
            System.out.println("1. Capturar alumnos");
            System.out.println("2. Mostrar alumnos");
            System.out.println("3. Cambiar calificación");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < 5; i++) {
                        System.out.println("\nIngrese los datos del estudiante " + (i + 1));
                        System.out.print("Nombre: ");
                        String nombre = scanner.next();
                        System.out.print("Número de control: ");
                        int numEstudiante = scanner.nextInt();
                        System.out.print("Materia: ");
                        String materia = scanner.next();
                        System.out.print("Calificación: ");
                        int calificacion = scanner.nextInt();

                        estudiantes[i] = new Estudiante(nombre, numEstudiante, materia, calificacion);
                    }
                    break;

                case 2:
                    for (int i = 0; i < 5; i++) {
                        System.out.println("\nDatos del estudiante " + (i + 1));
                        System.out.println("Nombre: " + estudiantes[i].nombre);
                        System.out.println("Número de control: " + estudiantes[i].numEstudiante);
                        System.out.println("Materia: " + estudiantes[i].materia);
                        System.out.println("Calificación: " + estudiantes[i].calificacion);
                        System.out.println("Estado: " + estudiantes[i].estado);
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el número de control del estudiante: ");
                    int numControl = scanner.nextInt();
                    boolean estudianteEncontrado = false;

                    for (Estudiante estudiante : estudiantes) {
                        if (estudiante != null && estudiante.numEstudiante == numControl) {
                            System.out.print("Ingrese la nueva calificación: ");
                            int nuevaCalificacion = scanner.nextInt();
                            estudiante.CambiarCalificacion(nuevaCalificacion);
                            estudianteEncontrado = true;
                            break;
                        }
                    }

                    if (!estudianteEncontrado) {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 4);
    }
}
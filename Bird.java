class Bird {
    private String nombre;

    public Bird(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void atacar() {
        System.out.println("El pájaro " + this.nombre + " atacó.");
    }
}

class BlueBird extends Bird {
    public BlueBird(String nombre) {
        super(nombre);
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println(this.getNombre() + " se dividió en tres.");
    }
}

class ChuckBird extends Bird {
    public ChuckBird(String nombre) {
        super(nombre);
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println(this.getNombre() + " se hizo más veloz.");
    }
}

class RedBird extends Bird {
    public RedBird(String nombre) {
        super(nombre);
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println(this.getNombre() + " atacó con furia.");
    }
}

public class Main {
    public static void main(String[] args) {

        Bird bird1 = new BlueBird("Blue");
        Bird bird2 = new ChuckBird("Chuck");
        Bird bird3 = new RedBird("Red");

        Bird[] birds = { bird1, bird2, bird3 };

        for (Bird bird : birds) {
            System.out.println(bird.getNombre() + ":");
            bird.atacar();
            System.out.println();
        }
    }
}
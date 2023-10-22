public class Carrera {
    public static void main(String[] args) {

        Animal tortuga = new Animal("Tortuga", 5);
        Animal liebre = new Animal("Liebre", 5);
        Animal perro = new Animal("Perro",5 );
        Animal caballo = new Animal("Caballo", 5);
        tortuga.setPriority(Thread.MIN_PRIORITY);
        liebre.setPriority(3);
        perro.setPriority(5);
        caballo.setPriority(Thread.MAX_PRIORITY);

    }
}

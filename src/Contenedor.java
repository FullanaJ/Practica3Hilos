public class Contenedor {
    int i;

    public synchronized void incrementar() {
        i++;
        System.out.println("i = " + i);
    }
}

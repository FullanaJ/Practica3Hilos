import java.util.concurrent.atomic.AtomicInteger;

public class Animal extends Thread{

    public static AtomicInteger posicion = new AtomicInteger();
    private static final int CANTIDAD_DE_POSICIONES = 500;
    private final String nombre;
    private final int velocidad;

    public Animal(String nombre, int velocidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        posicion.set(0);
    }

    @Override
    public void run() {
        for (int i = 0; i < CANTIDAD_DE_POSICIONES; i++) {
            if ( CANTIDAD_DE_POSICIONES / 7 == 0) {
                if (resbalarse())
                    caida();
                else
                    posicion.set(posicion.get()+velocidad);
            } else {
                i++;
            }
        }
        System.out.println(nombre + " ha terminado la carrera");
        System.out.println("posicion final: " + posicion);
        posicion.incrementAndGet();
    }

    public boolean resbalarse(){
        return Math.random() < 0.5;
    }
    public void caida(){
        posicion.set(posicion.get()-velocidad);
    }

}

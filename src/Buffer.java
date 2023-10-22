import java.sql.SQLOutput;

public class Buffer {

    private int buffer;
    private boolean disponible = false;

    public synchronized void get() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumido");
        buffer--;
        disponible = false;
        notifyAll();
    }

    public synchronized void put() {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Producido");
        buffer++;
        disponible = true;
        notifyAll();
    }

    class Consumidor extends Thread {
        private Buffer buffer;
        public Consumidor(Buffer buffer) {
            this.buffer = buffer;
        }
        public void run() {
            for (int i = 0; i < 10; i++) {
                buffer.get();
            }
        }
    }

    class Productor extends Thread {
        private Buffer buffer;
        public Productor(Buffer buffer) {
            this.buffer = buffer;
        }
        public void run() {
            for (int i = 0; i < 10; i++) {
                buffer.put();
            }
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Consumidor consumidor = buffer.new Consumidor(buffer);
        Productor productor = buffer.new Productor(buffer);
        consumidor.start();
        productor.start();
    }
}

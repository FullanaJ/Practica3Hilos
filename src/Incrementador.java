public class Incrementador extends Thread{

    Contenedor contenedor;

    public Incrementador(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    @Override
    public void run(){
        int CANTIDAD_INCREMENTOS = 500;
        for(int i = 0; i < CANTIDAD_INCREMENTOS; i++){
            contenedor.incrementar();
        }
    }
}

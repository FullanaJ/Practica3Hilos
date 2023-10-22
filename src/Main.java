public class Main {
    public static void main(String[] args) {
        /**
         * si el resultado que esperas es 500 no va ser correcto porque comparten  la misma variable
         * y si lo esperas en orden tampoco porque no hay un orden de ejecucion ya que no están sincronizados
         */
        int CANTIDAD_DE_HILOS = 4;
        Contenedor contenedor = new Contenedor();
        for (int i = 0; i < CANTIDAD_DE_HILOS; i++) {
            Incrementador incrementador = new Incrementador(contenedor);
            incrementador.start();
        }
    }


}
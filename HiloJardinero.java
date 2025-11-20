public class HiloJardinero extends Thread {
 
    private char[][] jardin;
    private int filas, columnas;
    private int velocidad;
    private boolean pausado = false;
 
    public HiloJardinero(char[][] mundo, int velocidad){
        this.jardin = mundo;
        this.filas = mundo.length;
        this.columnas = mundo[0].length;
        this.velocidad = velocidad;
    }
 
    public synchronized void pausar(){
        pausado = true;
    }
 
    public synchronized void continuarTrabajo(){
        pausado = false;
        notify();
    }
 
    private synchronized void revisarPausa() throws InterruptedException {
        while(pausado){
            wait();
        }
    }
 
    @Override
    public void run(){
        int r = 0;
 
        while(true){
            try{
                revisarPausa();
 
                synchronized(jardin){
                    for(int c=0; c<columnas; c++){
                        if(jardin[r][c] == 'W' || jardin[r][c] == 'C'){
                            jardin[r][c] = '*';
                        }
                    }
                }
 
                r = (r + 1) % filas;
 
                sleep(velocidad);
            }
            catch(InterruptedException e){}
        }
    }
}

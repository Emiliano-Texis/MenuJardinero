public class MonitorMapa extends Thread {
 
    private char[][] mapa;
 
    public MonitorMapa(char[][] mundo){
        this.mapa = mundo;
    }
 
    public void run(){
        int filas = mapa.length;
        int columnas = mapa[0].length;
 
        while(true){
            try{
                System.out.println("=====================================");
 
                for(int r=0; r<filas; r++){
                    for(int c=0; c<columnas; c++){
                        System.out.printf("|%2c|", mapa[r][c]);
                    }
                    System.out.println();
                }
 
                sleep(1500);
 
            }catch(InterruptedException e){}
        }
    }
}

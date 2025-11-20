public class HiloGusano extends Thread {
    private char[][] jardin;
    private int filas;
    private int columnas;
    private int velocidad;

    public HiloGusano(char[][] mundo, int velocidad){
        this.jardin = mundo;
        this.filas = mundo.length;
        this.columnas = mundo[0].length;
        this.velocidad = velocidad;
    }

    private void caminaColumna(int c){
        for(int x=0; x<filas; x++){
            jardin[x][c] = 'W';
        }
    }

    private void comerRenglon(int r, int traga){
        for(int x=0; x<traga && x<columnas; x++){
            jardin[r][x] = 'W';
        }
    }

    @Override
    public void run(){
        int vida = 20;
        int pos = 0;

        while(vida > 0){
            try{
                synchronized(jardin){
                    if(pos < columnas)
                        caminaColumna(pos);
                }
                pos++;
                sleep(velocidad);

                synchronized(jardin){
                    if(pos < filas)
                        comerRenglon(pos, 3);
                }
                pos++;
                sleep(velocidad);

                vida--;
            }
            catch(Exception e){}
        }
    }
}

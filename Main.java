import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//objeto sc
        Scanner sc = new Scanner(System.in);

        System.out.println("SIMULACION DEL JARDIN");

        //menu 
        
        System.out.print("¿Cuántas filas quieres? ");
        int filas = sc.nextInt();

        System.out.print("¿Cuántas columnas quieres? ");
        int columnas = sc.nextInt();

        System.out.print("Velocidad del gusano (ms): ");
        int velGusano = sc.nextInt();

        System.out.print("Velocidad del jardinero (ms): ");
        int velJardinero = sc.nextInt();

       
        char[][] mapa = new char[filas][columnas];

        for(int r = 0; r < filas; r++){
            for(int c = 0; c < columnas; c++){
                mapa[r][c] = '*';
            }
        }

        // hilos
        HiloGusano gus = new HiloGusano(mapa, velGusano);
        HiloJardinero jardinero = new HiloJardinero(mapa, velJardinero);
        MonitorMapa monitor = new MonitorMapa(mapa);

        gus.start();
        jardinero.start();
        monitor.start();

      
        int opcion = 0;
        while(opcion != 3){
            System.out.println("Control del Jardinero");
            System.out.println("1) Pausar jardinero");
            System.out.println("2) Continuar jardinero");
            System.out.println("3) Salir del programa");
            System.out.print("Elige: ");
            opcion = sc.nextInt();

// aqui las opciones de pausar,continuar y salir
            if(opcion == 1){
                jardinero.pausar();
            } else if(opcion == 2){
                jardinero.continuarTrabajo();
            }
        }

        System.exit(0);
    }
}

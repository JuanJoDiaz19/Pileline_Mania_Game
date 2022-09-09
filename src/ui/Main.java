package ui;
import model.Game;
import java.util.Scanner;
public class Main {
    public Scanner sc;
    public Game game;
    public Main() {
        sc = new Scanner(System.in);
        game = new Game();
    }
    public static void main(String[] args) {
        Main main  = new Main();
        main.execute();

    }
    public void execute(){
        System.out.println("Bienvenido al juego de PipeLine");
        int option;
        do {
            System.out.println("Elija una de las siguientes opciones:\n"+
                    "1. Nueva partida\n" +
                    "2. Ver puntaje\n" +
                    "3. Salir\n");
            option = sc.nextInt();
            sc.nextLine();
            executeOption(option);
        }while (option != 3);

    }
    public void executeOption(int option) {
            long time=0;
        switch (option) {
            case 1:
                time= System.currentTimeMillis();
                simulateGame(time);
                break;
            case 2:
                break;
            case 3:
                System.out.println("Gracias por utilizar el juego :)");
                break;
        }
    }

    public void simulateGame(long time) {
        System.out.println("Ingrese su nombre de usuario:");
        String userName = sc.nextLine();
        game.initializeBoard();
        int option;
        do {
            System.out.println("Seleccione la opcion a realizar:");
            System.out.println("1. Poner tubería\n" +
                    "2. Simular\n" +
                    "3. Salir\n");
            option = sc.nextInt();
            sc.nextLine();
            if (!executeOptionGame(option, userName, time)) {
                option = 3;
            }
        }while (option != 3);
    }

    public boolean executeOptionGame(int option, String name, long time){
        switch (option) {
            case 1:
                addPipeline();
                return true;
            case 2:
                if(game.simulateTable()) {
                    System.out.println("La solucion es correcta");
                    long knowTime= ((System.currentTimeMillis()-time)/1000);
                    game.addPlayer(name,calculateScore(knowTime));
                    return false;
                } else {
                    System.out.println("La solucion es incorrecta");
                    return true;
                }
            case 3 :

                System.out.println("Saliendo de la partida");
                return false;
        }
        return false;
    }

    public void addPipeline() {
        System.out.println("Ingrese la fila de la tuberia a ingresar:");
        int row = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la columna de la tuberia a ingresar:");
        int column = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el tipo de tuberia:\n" +
                "1. ||\n"+
                "2. =\n"+
                "3. o");
        int typePipeline = sc.nextInt();
        sc.nextLine();
        System.out.println(game.addPipeline(row, column, typePipeline));;
    }

    public int calculateScore(){
        return 0;
    }



}

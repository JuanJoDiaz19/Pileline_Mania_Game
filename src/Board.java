import java.util.Random;

public class Board {
    private Random r;
    private Pipeline[][] map;
    private Pipeline head;
    private Pipeline tail;
    public Board() {
        map = new Pipeline[8][8];
        r = new Random();
    }
    public void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = new NoPipeline();
            }
        }
        head = new Font();
        tail = new Drainage();
        map[r.nextInt(8)][r.nextInt(8)] = head;
        map[r.nextInt(8)][r.nextInt(8)] = tail;
        printTable();
    }
    public void printTable() {

        System.out.println("Forma del tablero: ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void addPipeline(int row, int column, int type) {
        if(map[row][column] != head && map[row][column] != tail) {
            switch (type) {
                case 1:
                    map[row][column] = new Vertical();
                    break;
                case 2:
                    map[row][column] = new Horizontal();
                    break;
                case 3:
                    map[row][column] = new Detour();
                    break;
            }

            printTable();
        } else {
            System.out.println("No se puede borrar la fuente o el drenaje :(");
        }



    }
}

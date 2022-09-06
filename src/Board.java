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
                map[i][j] = new NoPipeline(i, j);
            }
        }

        int coordinatesHX =  r.nextInt(8);
        int coordinatesHY =  r.nextInt(8);
        int coordinatesTX =  r.nextInt(8);
        int coordinatesTY =  r.nextInt(8);

        head = new Font(coordinatesHX, coordinatesHY);
        map[coordinatesHX][coordinatesHY] = head;

        tail = new Drainage(coordinatesTX, coordinatesTY);
        map[coordinatesTX] [coordinatesTY] = tail;

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

    public void addLast(Pipeline node) {
        if(head == null) {
            //Esto ocurre cuando el arreglo esta vacio
            head = node;
            tail = node;
            //head.setNext(head);
            //head.setPrevious(head);
        } else {
            // Esto lo hacemos para añadir un nodo al final
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }

    }

    public void addPipelineToMatrix(Pipeline pipeline) {
        map[pipeline.getRow()][pipeline.getColumn()] = pipeline;
    }

    public boolean addPipeline(int row, int column, int type) {

        if(tail instanceof Font) {
            if (type == 1 && (tail.getRow() -1 == row  || tail.getRow() + 1 == row ) && tail.getColumn() == column ) {
                //Cuando se intenta añadir una tuberia de tipo horizontal
                Horizontal newPipeline = new Horizontal(row, column);
                addLast(newPipeline);
                addPipelineToMatrix(newPipeline);
                return true;
            } else if(type == 2 && (tail.getColumn()+1 == column  || tail.getColumn()-1 == column ) && tail.getRow() == row) {
                //Cuando se intenta añadir uno vertical
                Vertical newPipeline = new Vertical(row, column);
                addLast(newPipeline);
                addPipelineToMatrix(newPipeline);
                return true;
            } else {
                return false;
            }
        } else if (tail instanceof Horizontal) {
            //Cuando se quiere añadir un horizontal
            if((tail.getRow() + 1 == row || tail.getRow() -1 == row) && tail.getColumn() == column && tail.getPrevious().getRow() != row) {
                if (type == 2){
                    Horizontal newPipeline = new Horizontal(row, column);
                    addLast(newPipeline);
                    addPipelineToMatrix(newPipeline);
                } else if(type == 3) {
                    Detour newPipeline = new Detour(row, column);
                    addLast(newPipeline);
                    addPipelineToMatrix(newPipeline);
                }
                return true;
            } else {
                return false;
            }
        } else if (tail instanceof Vertical) {

        } else if (tail instanceof Detour) {

        } else {
            //Cuando es un dreinage

        }
    }

    /*
    public boolean simulateGame() {
        return simulateGame(head);
    }
    */

    /*
    private boolean simulateGame(Pipeline current) {
        if (current instanceof Font) {
            if(map[current.getRow() + 1][current.getColumn() + 1] instanceof NoPipeline){

            }
        }
    }
    */

}
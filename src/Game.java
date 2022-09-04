public class Game {
    private Player root;
    private Board board;

    public Game() {
        board = new Board();
    }

    public void initializeBoard(){
        board.initializeBoard();
    }

    public void addPipeline(int row, int column, int type){
        board.addPipeline(row, column, type);
    }
}

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
    public void addPlayer(String name, int score){
        Player a= new Player(name, score);
        addPlayer(a, root);
        return;
    }



    private void addPlayer(Player current, Player objetive){

        if(root==null){
            root = current;
            return;
        }

        if(current.getScore()>objetive.getScore() && objetive.getRight()==null){
            objetive.setRight(current);
            return;
        }

        if(current.getScore()<objetive.getScore() && objetive.getRight()==null){
            objetive.setLeft(current);
        }

        if(current.getScore()>objetive.getScore() && objetive.getRight()!=null){
            addPlayer(current,objetive.getRight());
            return;
        }

        if(current.getScore()<objetive.getScore() && objetive.getLeft()!=null){
            addPlayer(current,objetive.getLeft());
            return;
        }

        if(current.getScore() == objetive.getScore()){
            Player tempo= objetive.getLeft();
            objetive.setLeft(current);
            current.setLeft(tempo);
            return;
        }

    }
}

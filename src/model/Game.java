package model;

public class Game {
    private Player root;
    private Board board;

    public Game() {
        board = new Board();
    }

    public void initializeBoard(){
        board.initializeBoard();
    }

    public String addPipeline(int row, int column, int type){
        if (board.addPipeline(row, column, type)) {
            board.printTable();
            return "Se añadió correctamente la tuberia";
        } else {
            board.printTable();
            return "No se pudo añadir la tuberia en esa posicion";
        }
    }
    public String changePipeline(int row, int column, int type) {
        if (board.changePipeline(row, column, type)) {
            board.printTable();
            return "Se añadió correctamente la tuberia";
        } else {
            board.printTable();
            return "No se pudo añadir la tuberia en esa posicion";
        }
    }

    public void addPlayer(String name, double score) {
        Player a= new Player(name, score);
        addPlayer(a, root);
        return;
    }

    public boolean simulateTable() {
        return board.simulateTable();
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
    public Player getMin(Player current){
        if(current.getLeft() == null){
            return current;
        }
        return getMin(current.getLeft());
    }

    public Board getBoard(){
        return board;
    }

    public void inorderR(){
         inorderR(root);
    }
    private void inorderR(Player current){

        if(current == null){
            return;
        }
        inorderR(current.getRight());
        System.out.println(current.getName()+" "+ current.getScore());
        inorderR(current.getLeft());

        return;
    }
}

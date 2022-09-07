package model;

public abstract class Pipeline {
    private Pipeline previous;
    private Pipeline next;
    private char character;
    private int row;
    private int column;

    public Pipeline(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Pipeline getPrevious() {
        return previous;
    }

    public void setPrevious(Pipeline previous) {
        this.previous = previous;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return ""+character;
    }

    public Pipeline getNext() {
        return next;
    }
    public void setNext(Pipeline next) {
        this.next = next;
    }
    public char getCharacter() {
        return character;
    }
    public void setCharacter(char character) {
        this.character = character;
    }
}
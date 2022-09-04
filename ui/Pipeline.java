public abstract class Pipeline {
    private Pipeline next;
    private char character;

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
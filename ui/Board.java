public class Board {
    private Pipeline[][] map;
    private Pipeline head;
    private Pipeline tail;
    public Board() {
        map = new Pipeline[8][8];
    }
    public void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = new NoPipeline();
            }
        }
    }
}

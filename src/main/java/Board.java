import java.util.Arrays;

public class Board {


    private final int size;
    private Object[][] gameBoard;

    public Board(int size){
        this.size = size;
        this.gameBoard   = new Object[size][size];
    }

    public int getSize() {
        return this.size;
    }

    public Object[][] getGameBoard(){
        return gameBoard;
    };

    public void initializeBoard() {
//        Create a board of size 'size' and output it

    }

    public void show() {
        for (Object[] row : gameBoard) {
            for (Object cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println("\n");
        }
    }

}

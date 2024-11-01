import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board {

    private final int size;
    private Object[][] gameBoard;
    private Player player;
    private Treasure treasure;
    private int distanceFromTreasure;
    private int numberOfMonsters = 4;
    private Monster[] monsters = new Monster[numberOfMonsters];
    private int[][] monsterPositions = new int[numberOfMonsters][2];
    int[] playerPosition;
    int[] treasurePosition;

    public Board(int size) {
        this.size = size;
        this.gameBoard = new Object[size][size];
    }

    public void initialise() {
        this.generateBoardPositions();
        this.setMonsters();
        this.addMonstersToBoard();
        this.player = new Player(playerPosition[0], playerPosition[1]);
        this.treasure = new Treasure(treasurePosition[0], treasurePosition[1]);
        this.addPlayerandTreasureToBoard();
    }


    public void addMonstersToBoard() {
//         Method to loop through monsters and set their positions on the board
        for (Monster monster : monsters) {
            int xcoord = monster.getXPos();
            int ycoord = monster.getYPos();
            gameBoard[xcoord][ycoord] = monster;
        }

    }

    public void addPlayerandTreasureToBoard() {
        int playerx = this.player.getXPos();
        int playery = this.player.getYPos();
        int treasurex = this.treasure.getXPos();
        int treasurey = this.treasure.getYPos();

        gameBoard[playerx][playery] = this.player;
        gameBoard[treasurex][treasurey] = this.treasure;
    }


    public void generateBoardPositions() {
        // Get random coordinates for n monsters and 1 treasure and 1 player
        int numPositions = this.numberOfMonsters + 2;
        int[][] positions = generateUniqueRandomPositions(numPositions);

        playerPosition = positions[0];
        treasurePosition = positions[1];

        for (int i = 2; i < numPositions; i++) {
            this.monsterPositions[i-2] = positions[i];
        }
    }

    public void setMonsters() {
        // assign type of monster to a position depending on the different coordinates
        for (int i=0; i<numberOfMonsters; i++){

            int[] position = monsterPositions[i];

            if (i % 2 == 0 ) {
                this.monsters[i] = new FriendlyMonster(position[0], position[1]);
            } else {
                this.monsters[i] = new EvilMonster(position[0], position[1]);
            }
        }
    }


    public int getSize() {
        return this.size;
    }

    public Object[][] getGameBoard(){
        return gameBoard;
    };

//    public void initializeBoard() {
////        Create a board of size 'size' and output it
//        this.gameBoard   = new Object[size][size];
//
//    }

    // Generates unique random positions in the board
    public int[][] generateUniqueRandomPositions(int noPositions) {
        Set<String> uniquePositions = new HashSet<>();
        Random random = new Random();
        int[][] positions = new int[noPositions][2];

        int count = 0;
        while (count < noPositions) {

            // generate random positions
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            String position = x + "," + y;


            // checking that position is not already used
            if (!uniquePositions.contains(position)) {
                uniquePositions.add(position);
                positions[count][0] = x;
                positions[count][1] = y;
                count++;
            }
        }

        return positions;
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

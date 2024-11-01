import java.util.*;

public class Board {

    private final int size;
    private Object[][] gameBoard;
    private Player player;
    private Treasure treasure;
    private int distanceFromTreasure;
    private int numberOfMonsters;
    private Monster[] monsters;
    private boolean gameOver;

    Deque<int[]> positionsStack = new ArrayDeque<>();

    public Board(int size) {
        this.size = size;
        this.gameBoard = new Object[size][size];
        this.numberOfMonsters = size - 2;
        this.monsters = new Monster[numberOfMonsters];
        this.gameOver = false;
    }

    public void initialise() {
        this.generateBoardPositions();
        this.setMonsters();
        this.addMonstersToBoard();
        this.player = new Player(positionsStack.pop());
        this.treasure = new Treasure(positionsStack.pop());
        this.addPlayerAndTreasureToBoard();
    }
    
    public void updateBoardAfterTurn() {
        int newPosx = player.getXPos();
        int newPosy = player.getYPos();

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (gameBoard[i][j] instanceof Player){
                    gameBoard[i][j] = null;
                }
            }
        }

        gameBoard[newPosx][newPosy] = this.player;
        //System.out.println(player.getXPos()+","+player.getYPos());
    }
    
    public boolean getGameOver() {
        return gameOver;
    }

    public void checkMoveValidity(String direction) {
        // if wall, print you've hit a wall, try again
            // if Newx or Newy is > than board size?
        // if treasure, print game won
            // if new coordinates == treasure
        // if monster, print greeting, game over
            // if new coordinates == monster
        // else move valid

        int xPos = player.getXPos();
        int yPos = player.getYPos();

//        System.out.println("YOU ARE GOING: " + direction);
//        System.out.println("YOU ARE GOING: " + xPos + " " + yPos);
        switch (direction) {
            case "up" -> yPos += 1;
            case "down" -> yPos -= 1;
            case "left" -> xPos -= 1;
            case "right" -> xPos += 1;
        }

        if (xPos > (size - 1) || yPos > (size - 1) || xPos < 0 || yPos < 0){
            System.out.println("You have hit a wall, try again.");
            return;
        }
        else if (xPos == treasure.getXPos() && yPos == treasure.getYPos()){
            System.out.println("You have found the treasure, well done!");
            gameOver = true;
            return;
        }
        for (Monster monster : monsters) {

            if (xPos == monster.getXPos() && yPos == monster.getYPos()){
            System.out.println(monster.greet());
            System.out.println("You got caught by a monster! GAME OVER!");
            gameOver = true;
            return;
            }
        }

//        System.out.println("YOU ARE GOING: " + xPos + " " + yPos);

        player.move(xPos, yPos);



        }



    public void generateBoardPositions() {
        // Get random coordinates for n monsters and 1 treasure and 1 player
        int numPositions = this.numberOfMonsters + 2;
        int[][] positions = generateUniqueRandomPositions(numPositions);

        this.positionsStack.addAll(Arrays.asList(positions));
    }

    public void setMonsters() {
        // assign type of monster to a position depending on the different coordinates
        for (int i=0; i<numberOfMonsters; i++){

            int[] position = positionsStack.pop();

            if (i % 2 == 0 ) {
                this.monsters[i] = new FriendlyMonster(position[0], position[1]);
            } else {
                this.monsters[i] = new EvilMonster(position[0], position[1]);
            }
        }
    }

    public void addMonstersToBoard() {
//         Method to loop through monsters and set their positions on the board
        for (Monster monster : monsters) {
            int xCoOrd = monster.getXPos();
            int yCoOrd = monster.getYPos();
            gameBoard[xCoOrd][yCoOrd] = monster;
        }
    }

    public void calculateDistanceFromTreasure() {
        int yDifference = Math.abs(player.getYPos() - treasure.getYPos());
        int xDifference = Math.abs(player.getXPos() - treasure.getXPos());
        distanceFromTreasure = yDifference + xDifference;
    }

    public int getDistanceFromTreasure() {
        return distanceFromTreasure;
    }

    public void addPlayerAndTreasureToBoard() {
        int playerx = this.player.getXPos();
        int playery = this.player.getYPos();
        int treasurex = this.treasure.getXPos();
        int treasurey = this.treasure.getYPos();

        gameBoard[playerx][playery] = this.player;
        gameBoard[treasurex][treasurey] = this.treasure;
    }

    public int getSize() {
        return this.size;
    }

    public Object[][] getGameBoard(){
        return gameBoard;
    };


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

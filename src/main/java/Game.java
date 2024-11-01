import java.util.Scanner;

public class Game {

    private Board board;

    public int getBoardSize() {
        // As the game player
        // I would like to specify the size of the grid that I play on
        // so that I can make the game easier or harder

        // Prompt the user for input
        System.out.println("Hello! \nHow big do you want your board to be?\nType a number from 2 to 10 ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        // Validate the input
        if (number < 2 || number > 10) {
            System.out.println("You have entered an invalid number");
            System.exit(0);
        }

//        Return board size
        return number;
    }

    public Board getBoard() {
        return this.board;
    }

}

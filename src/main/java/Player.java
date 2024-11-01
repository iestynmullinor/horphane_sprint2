public class Player {

    int xPos;
    int yPos;

    public Player(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Player(int[] position) {
        this.xPos = position[0];
        this.yPos = position[1];
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int[] getPosition() {
        return new int[]{xPos, yPos};
    }

    public void move(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public String toString() {
        return "Player";
    }

}

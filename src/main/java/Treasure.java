public class Treasure {

    int xPos;
    int yPos;

    public Treasure(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public Treasure(int[] position) {
        this.xPos = position[0];
        this.yPos = position[1];
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    @Override
    public String toString() {
        return "Treasure";
    }
}

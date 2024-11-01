public class Treasure {

    int xPos;
    int yPos;

    public Treasure(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
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

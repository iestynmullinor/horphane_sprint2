public abstract class Monster {

    int xPos;
    int yPos;

    public Monster(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public abstract String greet();

    @Override
    public String toString() {
        return "Monster";
    }
}

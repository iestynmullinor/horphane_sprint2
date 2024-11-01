public class Player {

    int xPos;
    int yPos;

    public Player(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void move(String direction){
        switch (direction) {
            case "up":
                this.yPos+=1;
                break;
            case "down":
                this.yPos-=1;
                break;
            case "left":
                this.xPos-=1;
                break;
            case "right":
                this.xPos+=1;
                break;
        }
    }

    @Override
    public String toString() {
        return "Player";
    }

}

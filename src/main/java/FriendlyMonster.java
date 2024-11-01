import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FriendlyMonster extends Monster{

    public FriendlyMonster(int xPos, int yPos) {
        super(xPos, yPos);
    }

    @Override
    public String greet() {
        List<String> greetings = new ArrayList<>();
        greetings.add("Hello, human friend!");
        greetings.add("Greetings from the monster world!");
        greetings.add("Hey there, don't be scared!");
        greetings.add("Welcome to my spooky lair!");
        greetings.add("Hiya! Ready for some fun?");
        greetings.add("Boo! Just kidding, nice to meet you!");
        greetings.add("Roar! Just a friendly hello!");
        greetings.add("Howdy, partner in fright!");
        greetings.add("Salutations from your monster buddy!");
        greetings.add("Good day, brave soul!");

        Random random = new Random();
        return greetings.get(random.nextInt(greetings.size()));
    }
    
    @Override
    public String toString() {
        return "FM";
    }

}

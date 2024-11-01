import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvilMonster extends Monster{

    public EvilMonster(int xPos, int yPos) {
        super(xPos, yPos);
    }

    public EvilMonster(int[] position) {
        super(position[0], position[1]);
    }

    @Override
    public String greet() {
        List<String> greetings = new ArrayList<>();
        greetings.add("Ah the shadows have brought you to me");
        greetings.add("Welcome to my lair; let the darkness unfold");
        greetings.add("Welcome to the abyss; it's delightful to have you");
        greetings.add("Ah, more pitiful creatures have wandered into my lair");
        greetings.add("Ah, fresh meat! You must have come to amuse me");
        greetings.add("Hello, wretched being! Your fear is my favourite flavour");
        greetings.add("Greetings, pitiful mortal! Your suffering is my delight");
        greetings.add("Welcome to your nightmare; I've been expecting you");
        greetings.add("Hello fragile being, I hope you brought your terror with you");
        greetings.add("Look who's come to offer themselves as a snack");

        Random random = new Random();
        return greetings.get(random.nextInt(greetings.size()));
    }

    @Override
    public String toString() {
        return "EvilMonster";
    }


}

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class TestGame {

    @Test
    public void TestGetBoardSize() {

        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Game game = new Game();
        int size = game.getBoardSize();

        assertEquals(5, size);
    }
}

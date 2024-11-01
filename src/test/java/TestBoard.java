import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestBoard {

    private Board b;

    @Before
    public void init() {
        b = new Board(5);
    }

    @Test
    public void TestGenerateUniqueRandomPositions() {
//        Test that no two coordinates are the same
//        Genereates noPositions coordinates

        int[][] positions = b.generateUniqueRandomPositions(5);

        HashSet<int[]> hs = new HashSet<>(Arrays.asList(positions));

        assertEquals(hs.size(), positions.length);
    }


    public void TestGenerateBoardPositions() {
        b.initialise();
    }

    @Test
    public void TestAddMonstersToBoard() {
//         Method to loop through monsters and set their positions on the board
        b.initialise();

        boolean flag = false;

        for (Object o : b.getGameBoard()) {
            if (o instanceof Monster) {
                flag = true;
                break;
            }
        }

        assertTrue(flag);
    }



}

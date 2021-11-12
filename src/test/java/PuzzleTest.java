import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PuzzleTest {

    @org.junit.jupiter.api.Test
    void possibleNextStates() {

        Puzzle s = new Puzzle();
        s.swap(0,0,0,1);
        s.swap(0,1,1,1);
        s.display();
        ArrayList<Puzzle> puzzles = s.possibleNextStates();


        assertTrue(puzzles.get(0).equals( new int[][] {
                {1, 0, 2},
                {3, 4, 5},
                {6, 7, 8},
        } ));

        assertTrue(puzzles.get(1).equals( new int[][] {
                {1, 4, 2},
                {0, 3, 5},
                {6, 7, 8},
        } ));

        assertTrue(puzzles.get(2).equals(new int[][]{
                {1, 4, 2},
                {3, 7, 5},
                {6, 0, 8},
        }));

        assertTrue(puzzles.get(3).equals(new int[][]{
                {1, 4, 2},
                {3, 5, 0},
                {6, 7, 8},
        }));

    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BFSTest {

    @Test
    void testPDFExample(){
        Puzzle init = new Puzzle(new int[][]{
                {1, 2, 5},
                {3, 4, 0},
                {6, 7, 8}
        });

        assertTrue(BFS.solve(init));

        UI.displaySteps(BFS.parentMap);

    }

    @Test
    void testNoSolution(){
        Puzzle init = new Puzzle(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {8, 7, 0}
        });

        assertFalse(BFS.solve(init));
    }

    @Test
    void testLongPuzzle(){
        Puzzle init = new Puzzle(new int[][]{
                {8, 6, 7},
                {2, 5, 4},
                {3, 0, 1}
        });

        assertTrue(BFS.solve(init));

        int steps = 0;
        Puzzle current = Puzzle.GOAL_PUZZLE, nextPuzzle = BFS.parentMap.get(current);
        while(current != nextPuzzle){
            steps++;
            current = nextPuzzle;
            nextPuzzle = BFS.parentMap.get(current);
        }

        assertEquals(27, steps);
    }
}

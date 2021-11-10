import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BFSTest {

    @Test
    void testPDFExample(){
        State init = new State(new int[][]{
                {1, 2, 5},
                {3, 4, 0},
                {6, 7, 8}
        });

        assertTrue(BFS.solve(init));

        Main.displaySteps(BFS.parentMap);

    }

    @Test
    void testNoSolution(){
        State init = new State(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {8, 7, 0}
        });

        assertFalse(BFS.solve(init));
    }

    @Test
    void testLongPuzzle(){
        State init = new State(new int[][]{
                {8, 6, 7},
                {2, 5, 4},
                {3, 0, 1}
        });

        assertTrue(BFS.solve(init));

        int steps = 0;
        State current = State.GOAL_STATE, nextState = BFS.parentMap.get(current);
        while(current != nextState){
            steps++;
            current = nextState;
            nextState = BFS.parentMap.get(current);
        }

        assertEquals(27, steps);
    }
}

import algorithms.DFS;
import algorithms.Puzzle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DFSTest {
    @Test
    void testPDFExample(){
        Puzzle init = new Puzzle(new int[][]{
                {1, 2, 5},
                {3, 4, 0},
                {6, 7, 8}
        });

        DFS dfs = new DFS();
        List<Puzzle> path = dfs.solve(init);
        assertNotNull(path);
        assertTrue(dfs.runningTime() <= 1000);
    }

    @Test
    void example2() {
        Puzzle init = new Puzzle(new int[][]{
                {4, 2, 5},
                {1, 7, 8},
                {3, 6, 0}
        });

        DFS dfs = new DFS();
        List<Puzzle> path = dfs.solve(init);
        assertNotNull(path);
        assertTrue(dfs.runningTime() <= 1000);
    }

    @Test
    void testNoSolution(){
        Puzzle init = new Puzzle(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {8, 7, 0}
        });

        DFS dfs = new DFS();
        List<Puzzle> path = dfs.solve(init);
        assertNull(path);
        assertTrue(dfs.runningTime() <= 1000);
    }

    @Test
    void testLongPuzzle(){
        Puzzle init = new Puzzle(new int[][]{
                {8, 6, 7},
                {2, 5, 4},
                {3, 0, 1}
        });

        DFS dfs = new DFS();
        List<Puzzle> path = dfs.solve(init);
        assertTrue( dfs.runningTime() <= 1000 );
        assertNotNull(path);
    }

    @Test
    void testInitialSolved(){
        Puzzle init = Puzzle.GOAL_PUZZLE;

        DFS dfs = new DFS();
        List<Puzzle> path = dfs.solve(init);
        assertNotNull(path);
        assertEquals(0, dfs.pathCost());
        assertTrue(dfs.runningTime() <= 1000);
    }
}

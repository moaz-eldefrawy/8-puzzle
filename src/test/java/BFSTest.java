import algorithms.BFS;
import algorithms.Puzzle;
import algorithms.UI;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BFSTest {

    @Test
    void testPDFExample(){
        Puzzle init = new Puzzle(new int[][]{
                {1, 2, 5},
                {3, 4, 0},
                {6, 7, 8}
        });
        BFS bfs = new BFS();
        List<Puzzle> path = bfs.solve(init);
        assertNotNull(path);
       // assertEquals(bfs.pathCost() - 1, bfs.searchDepth());
        assertTrue(bfs.runningTime() <= 1000);

    }

    @Test
    void example2() {
        Puzzle init = new Puzzle(new int[][]{
                {4, 2, 5},
                {1, 7, 8},
                {3, 6, 0}
        });

        BFS bfs = new BFS();
        List<Puzzle> path = bfs.solve(init);
        assertNotNull(path);
       // assertEquals(bfs.pathCost() - 1, bfs.searchDepth());
        assertTrue(bfs.runningTime() <= 1000);

    }

    @Test
    void testNoSolution(){
        Puzzle init = new Puzzle(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {8, 7, 0}
        });

        BFS bfs = new BFS();
        List<Puzzle> path = bfs.solve(init);
        assertNull(path);
        assertTrue(bfs.runningTime() <= 1000);
    }

    @Test
    void testLongPuzzle(){
        Puzzle init = new Puzzle(new int[][]{
                {8, 6, 7},
                {2, 5, 4},
                {3, 0, 1}
        });

        BFS bfs = new BFS();
        List<Puzzle> path = bfs.solve(init);
        assertNotNull(path);

        //assertEquals(27, bfs.pathCost()); ????
       // assertEquals(bfs.pathCost() - 1, bfs.searchDepth());
        assertTrue(bfs.runningTime() <= 1000);

    }

    @Test
    void testInitialSolved(){
        Puzzle init = Puzzle.GOAL_PUZZLE;

        BFS bfs = new BFS();
        List<Puzzle> path = bfs.solve(init);
        assertNotNull(path);
        //assertEquals(bfs.pathCost() - 1, bfs.searchDepth());
        assertTrue(bfs.runningTime() <= 1000);
    }
}

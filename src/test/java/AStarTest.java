import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AStarTest {
    @Test
    void testPDFExample(){
        Puzzle init = new Puzzle(new int[][]{
                {1, 2, 5},
                {3, 4, 0},
                {6, 7, 8}
        });

        AStar Manhatten = new AStar(AStar::ManhattanDistance);
        AStar Ecluid = new AStar(AStar::EuclideanDistance);
        List<Puzzle> path1 = Manhatten.solve(init);
        List<Puzzle> path2 = Ecluid.solve(init);
        assertNotNull(path1);
        assertNotNull(path2);
        assertArrayEquals(path1.toArray(), path2.toArray());
    }
    @Test
    void example2() {
        Puzzle init = new Puzzle(new int[][]{
                {4, 2, 5},
                {1, 7, 8},
                {3, 6, 0}
        });

        AStar soln = new AStar(AStar::ManhattanDistance);
        List<Puzzle> path = soln.solve(init);
        assertNotNull(path);
//        System.out.println(path.size()) ;
//        UI.displayPath(path);
    }

    @Test
    void example3() {
        Puzzle init = new Puzzle(new int[][]{
                {3, 1, 2},
                {6, 5, 0},
                {7, 4, 8}
        });

        AStar soln = new AStar(AStar::ManhattanDistance);
        List<Puzzle> path = soln.solve(init);
        assertNotNull(path);
        assertEquals(path.size(), 6);
//        System.out.println(path.size()) ;
//        UI.displayPath(path);
    }

    @Test
    void testNoSolution(){
        Puzzle init = new Puzzle(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {8, 7, 0}
        });

        AStar soln = new AStar(AStar::ManhattanDistance);
        List<Puzzle> path = soln.solve(init);
        assertNull(path);
//        UI.displayPath(path);
    }

    @Test
    void testLongPuzzle(){
        Puzzle init = new Puzzle(new int[][]{
                {8, 6, 7},
                {2, 5, 4},
                {3, 0, 1}
        });

        AStar soln = new AStar(AStar::ManhattanDistance);
        List<Puzzle> path = soln.solve(init);
        assertTrue( soln.runningTime() < 1000 ); // less than 1 ms.
        assertNotNull(path);
    }
}

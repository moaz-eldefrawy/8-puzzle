import algorithms.AStar;
import algorithms.Puzzle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AStarTest {
    private static final int maxMilliSeconds = 1500;

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

        assertTrue(Manhatten.runningTime() <= maxMilliSeconds);
        assertTrue(Ecluid.runningTime() <= maxMilliSeconds);

        assertArrayEquals(path1.toArray(), path2.toArray());
    }

    @Test
    void example2() {
        Puzzle init = new Puzzle(new int[][]{
                {4, 2, 5},
                {1, 7, 8},
                {3, 6, 0}
        });

        AStar manhattan = new AStar(AStar::ManhattanDistance);
        AStar euclid = new AStar(AStar::EuclideanDistance);

        List<Puzzle> path_manhattan = manhattan.solve(init);
        assertNotNull(path_manhattan);
        List<Puzzle> path_euclid = euclid.solve(init);
        assertNotNull(path_euclid);
        assertArrayEquals(path_manhattan.toArray(), path_euclid.toArray());

        assertTrue(manhattan.runningTime() <= maxMilliSeconds);
        assertTrue(euclid.runningTime() <= maxMilliSeconds);
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

        AStar manhattan = new AStar(AStar::ManhattanDistance);
        AStar euclid = new AStar(AStar::EuclideanDistance);

        List<Puzzle> path_manhattan = manhattan.solve(init);
        assertNotNull(path_manhattan);
        assertEquals(6, path_manhattan.size());
        List<Puzzle> path_euclid = euclid.solve(init);
        assertNotNull(path_euclid);
        assertArrayEquals(path_manhattan.toArray(), path_euclid.toArray());

        assertTrue(manhattan.runningTime() <= maxMilliSeconds);
        assertTrue(euclid.runningTime() <= maxMilliSeconds);

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

        AStar manhattan = new AStar(AStar::ManhattanDistance);
        AStar euclid = new AStar(AStar::EuclideanDistance);

        List<Puzzle> path = manhattan.solve(init);
        assertNull(path);
        path = euclid.solve(init);
        assertNull(path);

        assertTrue(euclid.runningTime() <= maxMilliSeconds, "Euclidean takes too long " + euclid.runningTime());
        assertTrue(manhattan.runningTime() <= maxMilliSeconds, "Manhattan takes too long " + manhattan.runningTime());
//        UI.displayPath(path);
    }

    @Test
    void testLongPuzzle(){
        Puzzle init = new Puzzle(new int[][]{
                {8, 6, 7},
                {2, 5, 4},
                {3, 0, 1}
        });

        AStar manhattan = new AStar(AStar::ManhattanDistance);
        AStar euclid = new AStar(AStar::EuclideanDistance);

        List<Puzzle> path_manhattan = manhattan.solve(init);
        assertNotNull(path_manhattan);
        assertTrue(manhattan.runningTime() <= maxMilliSeconds);

        List<Puzzle> path_euclid = euclid.solve(init);
        assertNotNull(path_euclid);
        assertTrue(euclid.runningTime() <= maxMilliSeconds);

        assertArrayEquals(path_manhattan.toArray(), path_euclid.toArray());
    }

    @Test
    void testInitialSolved(){
        Puzzle init = Puzzle.GOAL_PUZZLE;

        AStar manhattan = new AStar(AStar::ManhattanDistance);
        AStar euclid = new AStar(AStar::EuclideanDistance);

        List<Puzzle> path_manhattan = manhattan.solve(init);
        assertNotNull(path_manhattan);
        assertTrue(manhattan.runningTime() <= maxMilliSeconds);

        List<Puzzle> path_euclid = euclid.solve(init);
        assertNotNull(path_euclid);
        assertTrue(euclid.runningTime() <= maxMilliSeconds);

        assertArrayEquals(path_manhattan.toArray(), path_euclid.toArray());
    }
}

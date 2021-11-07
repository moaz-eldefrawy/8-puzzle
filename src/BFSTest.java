import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
}

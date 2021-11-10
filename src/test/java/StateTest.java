import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {

    @org.junit.jupiter.api.Test
    void possibleNextStates() {

        State s = new State();
        s.swap(0,0,0,1);
        s.swap(0,1,1,1);
        s.display();
        ArrayList<State> states = s.possibleNextStates();


        assertTrue(states.get(0).equals( new int[][] {
                {1, 0, 2},
                {3, 4, 5},
                {6, 7, 8},
        } ));

        assertTrue(states.get(1).equals( new int[][] {
                {1, 4, 2},
                {0, 3, 5},
                {6, 7, 8},
        } ));

        assertTrue(states.get(2).equals(new int[][]{
                {1, 4, 2},
                {3, 7, 5},
                {6, 0, 8},
        }));

        assertTrue(states.get(3).equals(new int[][]{
                {1, 4, 2},
                {3, 5, 0},
                {6, 7, 8},
        }));

    }
}
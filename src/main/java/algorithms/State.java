package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class State implements Cloneable{
    public static final int PUZZLE_SIZE = 3;
    public static final State GOAL_STATE = new State();
    int[][] grid = new int[PUZZLE_SIZE][PUZZLE_SIZE];

    /** Creates a goal state */
    public State(){
        for(int i=0; i<PUZZLE_SIZE*PUZZLE_SIZE; i++){
            grid[i/3][i%3] = i;
        }
    }

    public State(int[][] grid){
        for(int i=0; i<PUZZLE_SIZE; i++){
            this.grid[i] = Arrays.copyOf(grid[i],3);
        }
    }

    /*

            UTIL

     */

    public ArrayList<State> possibleNextStates() {
        ArrayList<State> result = new ArrayList<>();
        ArrayList<Integer> zero = getZero();
        int x = zero.get(0);
        int y = zero.get(1);


        // up
        if(x>0) {
            State newState = new State(grid);
            newState.swap(x,y,x-1,y);
            result.add(newState);
        }

        // left
        if(y>0) {
            State newState = new State(grid);
            newState.swap(x,y,x,y-1);
            result.add(newState);
        }

        // down
        if(x<PUZZLE_SIZE-1) {
            State newState = new State(grid);
            newState.swap(x,y,x+1,y);
            result.add(newState);
        }

        // right
        if(y<PUZZLE_SIZE-1) {
            State newState = new State(grid);
            newState.swap(x,y,x,y+1);
            result.add(newState);
        }

        return result;
    }

    /**
     * @return is the puzzle finished
     */
    boolean isWin() {
        /* Commented out.. how does it work?
        for(int i=1; i<9; i++){
            int pre = i-1;
            if(grid[i/3][i%3] != grid[pre/3][pre%3])
                return false;
        }

        return true;*/
        return this.equals(GOAL_STATE);
    }

    /**
     *
     * @param i1 first square i
     * @param j1 first square j
     * @param i2 second sqaure i
     * @param j2 second square j
     *           swaps(arr[i1][j1], arr[i2][j2]
     */
    public void swap(int i1, int j1, int i2, int j2) {
        int tmp = grid[i2][j2];
        grid[i2][j2] = grid[i1][j1];
        grid[i1][j1] = tmp;
    }


    /**
        @return i,j of zero
     */
    public ArrayList<Integer> getZero(){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<PUZZLE_SIZE; i++) {
            for (int j = 0; j < PUZZLE_SIZE; j++) {
                if (grid[i][j] == 0) {
                    arr.add(i);
                    arr.add(j);
                    return arr;
                }
            }
        }
        // unreachable
        assert(false);
        return arr;
    }

    public void display(){
        int rows = grid.length;
        int columns = grid[0].length;
        String str = "|\t";

        System.out.println("-----------------");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str += grid[i][j] + "\t";
            }
            System.out.println(str + "|");
            str = "|\t";
        }
        System.out.println("-----------------");
    }


    @Override
    public boolean equals(Object other) {
        if (other.getClass() != this.getClass())
            return false;
        State state = (State) other;
        return this.equals(state.grid);
    }

    @Override
    public int hashCode(){
        return java.util.Arrays.deepHashCode(grid);
    }

    public boolean equals(int[][] grid) {
        return Arrays.deepEquals(this.grid,grid);
    }

    @Override
    protected Object clone()  {
        return new State(grid);
    }
}

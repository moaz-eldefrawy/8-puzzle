import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFS implements Traversal{

    Set<Puzzle> visited = new HashSet<>();
    Map<Puzzle, Puzzle> parent = new Hashtable<>();
    List<Puzzle> path = new ArrayList<>();
    long startTime;
    long endTime;
    int nodesExpanded = 0;
    DFS(){}

    public List<Puzzle> solve(Puzzle initialPuzzle){

        startTime = System.nanoTime();

        Stack<Puzzle> stack = new Stack<>();
        Puzzle puzzle = initialPuzzle;

        stack.push(initialPuzzle);

        while(!stack.isEmpty()) {
            nodesExpanded++;
            puzzle = stack.pop();

            if (puzzle.isWin()) {
                path = Helpers.getPathFromTraversalMap(parent, initialPuzzle, puzzle);
                endTime = System.nanoTime();
                return path;
            }

            for (Puzzle nextPuzzle : puzzle.possibleNextStates()) {
                if(!visited.contains(nextPuzzle)) {
                    stack.add(nextPuzzle);
                    visited.add(puzzle);
                    parent.put(nextPuzzle,puzzle);
                }
            }
        }

        endTime = System.nanoTime();
        return null;
    }

    public Integer pathCost(){
        return path.size();
    }

    public Integer nodesExpanded(){
        return nodesExpanded;
    }

    public Integer searchDepth(){
        return path.size();
    }

    /**
     * @return execution time in ms.
     */
    public Long runningTime(){
        return (endTime - startTime)/1000/1000;
    }

}

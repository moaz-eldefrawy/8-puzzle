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
    int maxDepth = 0;
    DFS(){}

    public List<Puzzle> solve(Puzzle initialPuzzle){

        startTime = System.nanoTime();

        Stack<Node> stack = new Stack<>();
        Node curr = new Node(initialPuzzle,1);

        stack.push(curr);

        while(!stack.isEmpty()) {
            maxDepth = Math.max(maxDepth, curr.depth);
            nodesExpanded++;
            curr = stack.pop();

            if (curr.puzzle.isWin()) {
                path = Helpers.getPathFromTraversalMap(parent, initialPuzzle, curr.puzzle);
                endTime = System.nanoTime();
                return path;
            }

            for (Puzzle nextPuzzle : curr.puzzle.possibleNextStates()) {
                if(!visited.contains(nextPuzzle)) {
                    stack.add(new Node(nextPuzzle,curr.depth+1));
                    visited.add(curr.puzzle);
                    parent.put(nextPuzzle,curr.puzzle);
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

    class Node {
        Puzzle puzzle;
        int depth;

        public Node(Puzzle puzzle, int depth) {
            this.puzzle = puzzle;
            this.depth = depth;
        }
    }
}

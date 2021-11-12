package algorithms;

import algorithms.Puzzle;
import algorithms.Traversal;

import java.util.*;

public class BFS implements Traversal {

    Map<Puzzle, Puzzle> parentMap = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    List<Puzzle> path;
    boolean solved = false;
    long startTime;
    long endTime;
    int maxDepth = 0;

    public List<Puzzle> solve(Puzzle initialPuzzle){
        startTime = System.nanoTime();

        if (initialPuzzle.isWin())
            solved = true;
        else {
            queue.add(new Node(initialPuzzle, 1));
            parentMap.put(initialPuzzle, initialPuzzle);

            Puzzle current;
            int current_depth;
            while (!queue.isEmpty()) {
                current = queue.peek().puzzle;
                current_depth = queue.remove().depth;
                maxDepth = Math.max(current_depth, maxDepth);
                for (Puzzle nextPuzzle : current.possibleNextStates()) {
                    if (parentMap.containsKey(nextPuzzle))
                        continue;
                    queue.add(new Node(nextPuzzle, current_depth + 1));
                    parentMap.put(nextPuzzle, current);
                    /* Early goal test, the TA doesn't mind*/
                    if (nextPuzzle.isWin()) {
                        solved = true;
                        break;
                    }
                }
                if (solved)
                    break;
            }
        }

        if (solved){
            endTime = System.nanoTime();
            parentMap.remove(initialPuzzle); //to comply with the interface..
            return path = Helpers.getPathFromTraversalMap(parentMap, initialPuzzle, Puzzle.GOAL_PUZZLE);
        }
        return path = null;
    }

    @Override
    public Integer pathCost() {
        return (solved? path.size() - 1 : Integer.MAX_VALUE);
    }

    @Override
    public Integer nodesExpanded() {
        return parentMap.size() + 1 /*Because with this new interface, we do not add the initial state to the map*/
                - queue.size();
    }

    @Override
    public Integer searchDepth() {
        return maxDepth;
    }

    @Override
    public Long runningTime() {
        return (endTime - startTime)/1000000;
    }

    static class Node {
        Puzzle puzzle;
        int depth;

        public Node(Puzzle puzzle, int depth) {
            this.puzzle = puzzle;
            this.depth = depth;
        }
    }

}

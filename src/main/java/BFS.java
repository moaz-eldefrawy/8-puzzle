import java.util.*;

class BFS implements Traversal{

    Map<Puzzle, Puzzle> parentMap = new HashMap<>();
    Queue<Puzzle> queue = new LinkedList<>();
    List<Puzzle> path;
    boolean solved = false;
    long startTime;
    long endTime;

    public List<Puzzle> solve(Puzzle initialPuzzle){
        startTime = System.nanoTime();

        if (initialPuzzle.isWin())
            solved = true;
        else {
            queue.add(initialPuzzle);
            parentMap.put(initialPuzzle, initialPuzzle);

            Puzzle current;
            while (!queue.isEmpty()) {
                current = queue.remove();
                for (Puzzle nextPuzzle : current.possibleNextStates()) {
                    if (parentMap.containsKey(nextPuzzle))
                        continue;
                    queue.add(nextPuzzle);
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
        return (solved? path.size() : Integer.MAX_VALUE);
    }

    @Override
    public Integer nodesExpanded() {
        return parentMap.size() + 1 /*Because with this new interface, we do not add the initial state to the map*/
                - queue.size();
    }

    @Override
    public Integer searchDepth() {
        return (solved? path.size() : Integer.MAX_VALUE /* TODO */);
    }

    @Override
    public Long runningTime() {
        return (endTime - startTime)/1000000;
    }

}

package algorithms;

import java.util.List;

public interface Traversal {
    public List<Puzzle> solve(Puzzle initialPuzzle);

    public Integer pathCost();

    public Integer nodesExpanded();

    public Integer searchDepth();

    /**
     * @return execution time in ms.
     */
    public Long runningTime();

}

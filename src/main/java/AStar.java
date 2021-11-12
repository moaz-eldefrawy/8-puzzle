import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

public class AStar implements Traversal{

    Map<Puzzle, Integer> FCost = new HashMap<>();
    Map<Puzzle, Puzzle> parent = new Hashtable<>();
    List<Puzzle> path = new ArrayList<>();
    long startTime;
    long endTime;
    int nodesExpaneded = 0;
    int maxDepth = 0;
    Function<Puzzle,Integer> heuristic;

    AStar(Function<Puzzle,Integer> heuristic){
        this.heuristic = heuristic;
    }

    public List<Puzzle> solve(Puzzle initialPuzzle){
        startTime = System.nanoTime();
        PriorityQueue<Node> queue = new PriorityQueue<>();

        Node curr = new Node(initialPuzzle,0,heuristic.apply(initialPuzzle),1);
        queue.add(curr);
        FCost.put(curr.puzzle,  curr.totalCost());

        while(!queue.isEmpty()) {
            maxDepth = Math.max(maxDepth, curr.depth);
            nodesExpaneded++;
            curr = queue.poll();

            if(curr.totalCost() > FCost.get(curr.puzzle)){
                continue;
            }

            if (curr.puzzle.isWin()) {
                path = Helpers.getPathFromTraversalMap(parent, initialPuzzle, curr.puzzle);
                endTime = System.nanoTime();
                return path;
            }

            for (Puzzle nextPuzzle : curr.puzzle.possibleNextStates()) {
                Node node = new Node(nextPuzzle, curr.pathCost+1, heuristic.apply(nextPuzzle),curr.depth+1);
                if(!FCost.containsKey(nextPuzzle) || (node.totalCost() < FCost.get(nextPuzzle))) {
                    queue.add(node);
                    FCost.put(nextPuzzle, node.totalCost());
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
        return nodesExpaneded;
    }

    public Integer searchDepth(){
        return maxDepth;
    }
    /**
     * @return execution time in ms.
     */
    public Long runningTime(){
        return (endTime - startTime)/1000/1000;
    }

    public static int ManhattanDistance(Puzzle puzzle){
        int sum = 0;
        for(int i=0; i<Puzzle.PUZZLE_SIZE; i++) {
            for(int j=0; j<Puzzle.PUZZLE_SIZE; j++) {
                int x = puzzle.grid[i][j]/3;
                int y = puzzle.grid[i][j]%3;
                sum += Math.abs(i - x) + Math.abs(j - y);
            }
        }
        return sum;
    }
    public static int EuclideanDistance(Puzzle puzzle){
        int sum = 0;
        for(int i=0; i<Puzzle.PUZZLE_SIZE; i++) {
            for(int j=0; j<Puzzle.PUZZLE_SIZE; j++) {
                int x = puzzle.grid[i][j]/3;
                int y = puzzle.grid[i][j]%3;
                sum += Math.hypot(
                        i - x,
                        j - y);
            }
        }
        return sum;
    }

    class Node implements Comparable<Node> {
        final public Puzzle puzzle;
        final public Integer pathCost;
        final public Integer heuristicCost;
        final public Integer depth;

        public Node(Puzzle puzzle, Integer pathCost, Integer heuristicCost, Integer depth) {
            this.puzzle = puzzle;
            this.pathCost = pathCost;
            this.heuristicCost = heuristicCost;
            this.depth = depth;
        }

        public int totalCost(){
            return this.heuristicCost + this.pathCost;
        }

        @Override
        public int compareTo(Node o) {
            int F1 = totalCost();
            int F2 = o.totalCost();
            return F1-F2;
        }
    }
}

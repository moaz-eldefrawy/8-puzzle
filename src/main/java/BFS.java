import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class BFS {

    static Map<Puzzle, Puzzle> parentMap = null;

    static boolean solve(Puzzle initialPuzzle){
        Queue<Puzzle> queue = new LinkedList<>();
        queue.add(initialPuzzle);
        parentMap = new HashMap<>();
        parentMap.put(initialPuzzle, initialPuzzle);

        Puzzle current;
        while (!queue.isEmpty()){
            current = queue.remove();
            for (Puzzle nextPuzzle : current.possibleNextStates()){
                if (parentMap.containsKey(nextPuzzle))
                    continue;
                queue.add(nextPuzzle);
                parentMap.put(nextPuzzle, current);
                /* Early goal test, the TA doesn't mind*/
                if (nextPuzzle.isWin())
                    return true;
            }
        }

        return false;
    }

}

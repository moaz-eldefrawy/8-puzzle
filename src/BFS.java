import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class BFS {

    static Map<State, State> parentMap = null;

    static boolean solve(State initialState){
        Queue<State> queue = new LinkedList<>();
        queue.add(initialState);
        parentMap = new HashMap<>();
        parentMap.put(initialState, initialState);

        State current;
        while (!queue.isEmpty()){
            current = queue.remove();
            for (State nextState : current.possibleNextStates()){
                if (parentMap.containsKey(nextState))
                    continue;
                queue.add(nextState);
                parentMap.put(nextState, current);
                /* Early goal test, the TA doesn't mind*/
                if (nextState.isWin())
                    return true;
            }
        }

        return false;
    }

}

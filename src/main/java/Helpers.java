import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Helpers {
    public static List<Puzzle> getPathFromTraversalMap(Map<Puzzle, Puzzle> parent, Puzzle initialPuzzle, Puzzle finalPuzzle) {
        List<Puzzle> path = new ArrayList<>();
        Puzzle puzzle = finalPuzzle;
        while(parent.containsKey(puzzle)) {
            path.add(puzzle);
            puzzle = parent.get(puzzle);
        }
        path.add(initialPuzzle);
        Collections.reverse(path);

        return path;
    }
}

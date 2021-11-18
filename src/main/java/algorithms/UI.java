package algorithms;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class UI {
    public static void main(String[] args) {
        Puzzle a = new Puzzle();
        Puzzle b = new Puzzle();
        Set<Puzzle> k = new HashSet<>();
        k.add(a);
        System.out.println(k.contains(a));
        System.out.println(k.contains(b));
    }

    public static void displaySteps(Map<Puzzle, Puzzle> parentMap){
        Puzzle goal = Puzzle.GOAL_PUZZLE;
        if (parentMap.containsKey(goal)){
            Stack<Puzzle> stack = new Stack<>();
            stack.push(goal);
            Puzzle current = goal, next = parentMap.get(current);
            while (next != null){
                stack.push(next);
                current = next;
                next = parentMap.get(current);
            }
            while(!stack.empty()){
                stack.pop().display();
            }
        }else{
            System.out.println("No way to solve");
        }
    }

    static void displayPath(List<Puzzle> path){
        for(Puzzle puzzle: path){
            puzzle.display();
        }
        return;
    }
}

package algorithms;

import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("asd");
    }

    public static void displaySteps(Map<State, State> parentMap){
        State goal = State.GOAL_STATE;
        if (parentMap.containsKey(goal)){
            Stack<State> stack = new Stack<>();
            stack.push(goal);
            State current = goal, next = parentMap.get(current);
            while (next != current){
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
}

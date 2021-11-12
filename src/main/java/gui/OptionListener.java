package gui;

public interface OptionListener {
    enum Option {DFS, BFS, ASTAR}

    void onOptionSelected(Option option);
}

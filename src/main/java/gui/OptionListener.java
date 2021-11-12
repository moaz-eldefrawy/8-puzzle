package gui;

public interface OptionListener {
    enum Option {DFS, BFS, ASTAR_EUC, ASTAR_MAN}

    void onOptionSelected(Option option);
}

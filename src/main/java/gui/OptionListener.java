package gui;

public interface OptionListener {
    enum Option {DFS, BFS}

    void onOptionSelected(Option option);
}

package gui;

import algorithms.Puzzle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.List;

public class OutputGrid extends BorderPane {
    List<Puzzle> moves;
    int currentMoveIndex = 0;
    InputGrid inputGrid = new InputGrid();
    HBox buttonBar = new HBox();
    ExitListener el;

    public OutputGrid(List<Puzzle> moves){
        super();
        this.moves = moves;

        for (int i = 0;i < 3;i++)
            for (int j = 0;j < 3;j++) {
                inputGrid.tfGrid[i][j].setDisable(true);
                inputGrid.tfGrid[i][j].setOpacity(0.8);
            }

        setCenter(inputGrid);


        Button prev = createButton("Prev");
        
        Label label;

        if(moves != null)
            label = new Label("Number of moves: " + (moves.size()-1));
        else
            label = new Label("No Solution Exists!");

        buttonBar.getChildren().add(label);

        Button exit = createButton("Exit");
        Button next = createButton("Next");


        setBottom(buttonBar);
        buttonBar.setAlignment(Pos.CENTER);


        prev.setOnAction((e) -> {
            if (moves == null || currentMoveIndex == 0)
                return;
            setCurrentState(moves.get(--currentMoveIndex));
        });

        next.setOnAction((e) -> {
            if (moves== null || currentMoveIndex == moves.size()-1)
                return;
            setCurrentState(moves.get(++currentMoveIndex));
        });

        exit.setOnAction((e) -> el.onExit());
        if(moves != null)
            setCurrentState(moves.get(0));
    }

    private Button createButton(String name){
        Button b = new Button(name);
        HBox.setMargin(b, new Insets(10));
        buttonBar.getChildren().add(b);

        return b;
    }

    private void setCurrentState(Puzzle puzzle){
        for (int i = 0;i < 3;i++){
            for (int j = 0;j < 3;j++){
                inputGrid.tfGrid[i][j].setText(String.valueOf(puzzle.grid[i][j] == 0 ? "" : puzzle.grid[i][j]));
            }
        }
    }

    public void setExitListener(ExitListener el){
        this.el = el;
    }

}

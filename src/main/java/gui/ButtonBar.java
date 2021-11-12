package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonBar extends HBox {
    OptionListener optionListener;

    public ButtonBar(){
        super();

        Button dfsButton = new Button("DFS");
        Button bfsButton = new Button("BFS");
        Button aStartButton = new Button("A*");

        dfsButton.setOnAction((e) -> optionListener.onOptionSelected(OptionListener.Option.DFS));
        bfsButton.setOnAction((e) -> optionListener.onOptionSelected(OptionListener.Option.BFS));
        aStartButton.setOnAction((e) -> optionListener.onOptionSelected(OptionListener.Option.ASTAR));

        getChildren().addAll(dfsButton, bfsButton, aStartButton);
    }

    public void setOptionListener(OptionListener ol){
        optionListener = ol;
    }
}

package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonBar extends HBox {
    OptionListener optionListener;

    public ButtonBar(){
        super();

        Button dfsButton = new Button("algorithms.DFS");
        Button bfsButton = new Button("BFS");


        dfsButton.setOnAction((e) -> optionListener.onOptionSelected(OptionListener.Option.DFS));
        bfsButton.setOnAction((e) -> optionListener.onOptionSelected(OptionListener.Option.BFS));


        getChildren().addAll(dfsButton, bfsButton);
    }

    public void setOptionListener(OptionListener ol){
        optionListener = ol;
    }
}

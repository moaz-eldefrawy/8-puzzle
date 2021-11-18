package gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class OptionsBar extends HBox {
    OptionListener optionListener;

    public OptionsBar(){
        super();

        createButton("DFS", OptionListener.Option.DFS);
        createButton("BFS", OptionListener.Option.BFS);
        createButton("A* Euclidean", OptionListener.Option.ASTAR_EUC);
        createButton("A* Manhattan", OptionListener.Option.ASTAR_MAN);

        setAlignment(Pos.CENTER);

    }

    public void setOptionListener(OptionListener ol){
        optionListener = ol;
    }

    private void createButton(String name, OptionListener.Option op){
        Button b = new Button(name);
        setMargin(b, new Insets(0, 10, 0, 10));
        b.setOnAction((e) -> optionListener.onOptionSelected(op));
        getChildren().add(b);
    }
}

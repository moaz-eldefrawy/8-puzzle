package gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DigitTextField extends TextField {

    final String baseStyle =
            "-fx-alignment: center;" +
            "-fx-background-color: #3943B7;" +
            "-fx-text-fill: #0E0E52;" +
            "-fx-border-color: BLACK;"+
            "-fx-border-width: 5px;" +
            "-fx-border-radius: 10px;" +
            "-fx-background-radius: 10px;";

    final String outOfFocusStyle = baseStyle +"-fx-background-color: #3943B7;";
    final String inFocusStyle = baseStyle +"-fx-background-color: #449DD1;";

    public DigitTextField(String defaultText){

        super(defaultText);
        setPrefHeight(100);

        setStyle(outOfFocusStyle);
        setFont(Font.font("Verdana", FontWeight.BOLD, 35));

        setOnKeyTyped(keyEvent -> {
            char c = keyEvent.getCharacter().charAt(0);

            if (c >= '1' && c <= '8')
                setText(String.valueOf(c));
            else setText("");
        });

        focusedProperty().addListener( (arg, oldVal, newVal) -> {
            if (newVal){
               setStyle(inFocusStyle);
            }else setStyle(outOfFocusStyle);
        });

    }
}

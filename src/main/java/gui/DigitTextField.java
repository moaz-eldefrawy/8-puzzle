package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DigitTextField extends TextField {

    public DigitTextField(String defaultText){

        super(defaultText);
        setPrefHeight(100);

        setStyle(
                "-fx-alignment: center;" +
                        "-fx-background-color: #660000;" +
                        "-fx-text-fill: #665555;");
        setFont(Font.font("Verdana", FontWeight.BOLD, 35));

        setOnKeyTyped(keyEvent -> {
            char c = keyEvent.getCharacter().charAt(0);

            if (c >= '1' && c <= '8')
                setText(String.valueOf(c));
            else setText("");
        });


    }
}

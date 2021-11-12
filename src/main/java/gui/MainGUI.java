package gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainGUI extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Image icon = new Image("icon.png");
        Scene scene = new Scene(root, Color.BISQUE);

        InputGrid inputGrid = new InputGrid();

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.setOptionListener((option) -> {
            System.out.println(option.toString());

            if (inputGrid.getGameState() != null)
                inputGrid.getGameState().display();

        });

        root.setCenter(inputGrid);
        root.setBottom(buttonBar);


        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("8-puzzle Solver");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
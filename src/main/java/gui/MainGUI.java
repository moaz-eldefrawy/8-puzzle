package gui;

import algorithms.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class MainGUI extends Application {
    BorderPane root = new BorderPane();

    @Override
    public void start(Stage stage) {
        root.setStyle("-fx-background-color: #78C0E0;");
        Image icon = new Image("icon.png");





        Scene scene = new Scene(root);

        InputGrid inputGrid = new InputGrid();

        OptionsBar buttonBar = new OptionsBar();
        buttonBar.setOptionListener((option) -> {
            if (inputGrid.getGameState() != null) {

                Puzzle initalState = inputGrid.getGameState();

                System.out.println("Initial state: ");
                initalState.display();

                Traversal t;
                switch (option){
//                    case DFS -> t = new DFS();
                    case ASTAR_EUC -> t = new AStar(AStar::EuclideanDistance);
                    case ASTAR_MAN -> t = new AStar(AStar::ManhattanDistance);
                    default -> t = new DFS();
//                    case BFS -> t = new BFS();
                }
                solve(initalState, t);
            }

        });


        root.setTop(buttonBar);
        root.setCenter(inputGrid);

        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("8-puzzle Solver");
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }

    void solve(Puzzle state, Traversal traversal){
        List<Puzzle> moves = traversal.solve(state);


        System.out.println("MOVES : ");
        for (Puzzle p : moves)
            p.display();

        OutputGrid outputGrid = new OutputGrid(moves);
        outputGrid.setExitListener(() -> {
            root.setCenter(new InputGrid());
        });

        root.setCenter(outputGrid);

    }

}
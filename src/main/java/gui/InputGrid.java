package gui;

import algorithms.Puzzle;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;



public class InputGrid extends GridPane {
    DigitTextField[][] tfGrid = new DigitTextField[3][3];
    Label errorMsg = new Label("");

    public InputGrid () {
        super();

        setPrefSize(400, 350);

        GridPane.setConstraints(errorMsg, 0, 3,3,3);
        getChildren().add(errorMsg);

        for (int i = 0;i < 3;i++){
            for (int j = 0;j < 3;j++){
                int v = i*3+j;
                tfGrid[i][j] = new DigitTextField( v == 0 ? "" : Integer.toString(v));

                GridPane.setConstraints(tfGrid[i][j], j, i);
                GridPane.setMargin(tfGrid[i][j], new Insets(5, 5, 5, 5));
                getChildren().add(tfGrid[i][j]);
            }
        }



    }


    /**
     *
     * @return State if the board is valid. Null if the board is invalid and shows an error message.
     */
    public Puzzle getGameState(){
        boolean[] found = new boolean[9];
        int[][] grid = new int[3][3];

        for (int i = 0;i < 3;i++){
            for (int j = 0;j < 3;j++){
                String content = tfGrid[i][j].getText();


                try{
                    int v = content.equals("") ? 0 : Integer.parseInt(content);
                    found[v] = true;
                    grid[i][j] = v;
                }
                catch (NumberFormatException e){
                    errorMsg.setText("Invalid Character at position " + j + ", " + i);
                    return null;
                }

            }
        }

        for (boolean b : found)
            if (!b){
                errorMsg.setText("Make sure all digits are on the board");
                return null;
            }

        errorMsg.setText("");

        return new Puzzle(grid);
    }


}

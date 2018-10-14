package tictactoe;

import java.awt.*;
import javax.swing.*;

public class Control extends JFrame {
    /*
     this is the main controler that controls
     and combines different components of the game.
    */ 

    private Board GameBoard; //Board and Button
    private Tools TButtons; // Exit and Reset

    Control() {
        setLayout(new BorderLayout());

        GameBoard = new Board();
        TButtons = new Tools();

        TButtons.SetObject(GameBoard);

        add(GameBoard, BorderLayout.CENTER);
        add(TButtons, BorderLayout.SOUTH);

        setVisible(true);
        setSize(400, 300); // altered dimensions to add in score for both players
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

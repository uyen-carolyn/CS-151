package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Tools extends JPanel {
	private JButton Exit, Reset;
	private Board Brd;
	private JLabel Player1Wins, Player2Wins;
	
	Tools() {
		setLayout(new GridLayout(1,2));
    		Player1Wins = new JLabel("Player 1 Wins:  0");
	
    		Player2Wins = new JLabel("Player 2 Wins:  0");
	
    		setLayout(new FlowLayout());

    		Exit = new JButton("Exit");
    		Reset = new JButton("Reset");
    
    		Exit.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent ae) {
            		System.exit(0);
        	}
    	});
    		Reset.addActionListener(new ActionListener() {
        	
		public void actionPerformed(ActionEvent ae) {
            		Brd.Reset();
            		Player1Wins.setText("Player 1 Wins: "+ Brd.getPlayer1Score());
            		Player2Wins.setText("Player 2 Wins: "+ Brd.getPlayer2Score());
        	}
    	});

    	add(Player1Wins);
    	add(Player2Wins);
    
    	add(Exit);
    	add(Reset);
	}

	public void SetObject(Board B) {
    		Brd = B;
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;

import model.ChessField;
import model.Game;
import client.viewmodel.ChessBoardViewModel;

/**
 * Kontrolliert den Ablauf des Schachspiels
 * @author florian
 */
public class GameController {
    private Game game;
    private ChessBoardViewModel viewModel;
    
    public GameController(ChessBoardViewModel viewModel){
        this.game = new Game();
        this.viewModel = viewModel;
    }
    
    public ArrayList<ChessField> getPossibleFields(ChessField field){
    
        if(field.getPiece() != null){
        	return field.getPiece().getPossibleFields();
        } else {
        	return new ArrayList<ChessField>();
        }
    }
    
    public void doTurn(ChessField fromField, ChessField toField){        
    	if(fromField.getPiece().getPossibleFields().contains(toField)){
    		game.getChessBoard().movePiece(fromField, toField);
    		game.changeActivePlayer();
    		viewModel.reset();
    	}
    	// Prüfe auf Schach, Schachmatt, etc. 
              
    }

    public void startNewGame(){
    	game.getChessBoard().initChessboard();
    	game.initialize();
        viewModel.reset();
    }
    
    /**
     * Gibt die Model-Informationen zurück.
     * @return Game-Model.
     */
	public Game getGame() {
		return game;
	}
}

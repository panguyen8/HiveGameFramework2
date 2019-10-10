/*
*
*
*
*
 */

package com.example.hivegamestate;
/*
Remove static variables

 */

import android.net.wifi.p2p.WifiP2pGroup;

import java.util.ArrayList;

public class HiveGameState {
    final int BLACK_TURN = 0;

    //Stephen added this instance vars, delete if needed
    final int WHITE_TURN = 1;

    //holds a 2d array of strings for what the board would look like
    //using a 2d array for now, idk if we will used a linked list later on
    //once we get the class for the pieces set up, we can change string to that new class
    private Piece[][] board = new Piece[100][100];


    //int variable to tell whose turn it is
    //If 1, white moves, if 2, black moves
    //Removed static for now, not sure if it's needed
    //Let me (Stephen) know if it is
    private int turn = 1;  // Edit by Samuel Nguyen

    //Represents how many total pieces each player has
    private int player1Pieces;
    private int player2Pieces;

    // This is so MainActivity compiles, delete when necessary
    Piece ant = new Piece("Ant");

    public ArrayList<piece> bugList = new ArrayList<>();

    enum piece {
        BBEE, BSPIDER, BANT, BGHOPPER, BBEETLE, WBEE, WSPIDER, WANT, WGHOPPER, WBEETLE;
    }

    //Basic constructor
    public HiveGameState() {

        bugList.add(piece.BBEE);
        bugList.add(piece.BSPIDER);
        bugList.add(piece.BANT);
        bugList.add(piece.BGHOPPER);
        bugList.add(piece.BBEETLE);
        bugList.add(piece.WBEE);
        bugList.add(piece.WSPIDER);
        bugList.add(piece.WANT);
        bugList.add(piece.WGHOPPER);
        bugList.add(piece.WBEETLE);

        this.turn = WHITE_TURN; // White goes first?
        this.player1Pieces = 11;
        this.player2Pieces = 11;

    }

    //Copy constructor (Stephen)
    public HiveGameState(HiveGameState hgs) {
        hgs.turn = this.turn;


        //Copies each board index/cell
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                this.board[i][j] = hgs.board[i][j];
            }
        }
    }

    //Returns a formatted string that describes the game's state
    @Override
    public String toString() {
        return "Turn: " + turn + "/n" +
                "BLACK_TURN: " + BLACK_TURN + "/n" +
                "WHITE_TURN: " + WHITE_TURN + "/n" +
                "White Bee: " + piece.WBEE + "/n" +
                "White Spider: " + piece.WSPIDER + "/n" +
                "White Ant: " + piece.WANT + "/n" +
                "White Beetle: " + piece.WBEETLE + "/n" +
                "White Grasshopper: " + piece.WGHOPPER + "/n" +
                "Black Bee: " + piece.BBEE + "/n" +
                "Black Spider: " + piece.BSPIDER + "/n" +
                "Black Ant: " + piece.BANT + "/n" +
                "Black Beetle: " + piece.BBEETLE + "/n" +
                "Black Grasshopper: " + piece.BGHOPPER + "/n" +
                board;
    }

    // Following methods started by Samuel Nguyen
    // Feel free to edit these (if so, delete this comment)

    /**
     * Places a piece on the board, subtracts one from total piece count and appropriate piece count,
     * and sets the turn to that of the other player.
     *
     * @param id: the id of whose turn it is
     * @param piece: the piece being moved
     * @param boardX: row index of where the piece is being placed on board
     * @param boardY: col index
     *
     * @return true if successful, false otherwise
     *
     *
     */
    boolean placePiece(int id, Piece piece, int boardX, int boardY) {
        if (id == WHITE_TURN) {
            // Checks piece being placed
            if(piece.getType().equals("QueenBee")) {
                bugList.remove(HiveGameState.piece.WBEE);
            }
            else if(piece.getType().equals("Spider")) {
                bugList.remove(HiveGameState.piece.WSPIDER);
            }
            else if(piece.getType().equals("Ant")) {
                bugList.remove(HiveGameState.piece.WANT);
            }
            else if(piece.getType().equals("Beetle")) {
                bugList.remove(HiveGameState.piece.WBEETLE);
            }
            else if(piece.getType().equals("Grasshopper")) {
                bugList.remove(HiveGameState.piece.WGHOPPER);
            }
            this.player1Pieces--;
            board[boardX][boardY] = piece;
            this.setTurn(BLACK_TURN);
            return true;
        }
        else if (id == BLACK_TURN) {
            // Checks piece being placed
            if(piece.getType().equals("QueenBee")) {
                bugList.remove(HiveGameState.piece.BBEE);
            }
            else if(piece.getType().equals("Spider")) {
                bugList.remove(HiveGameState.piece.BSPIDER);
            }
            else if(piece.getType().equals("Ant")) {
                bugList.remove(HiveGameState.piece.BANT);
            }
            else if(piece.getType().equals("Beetle")) {
                bugList.remove(HiveGameState.piece.BBEETLE);
            }
            else if(piece.getType().equals("Grasshopper")) {
                bugList.remove(HiveGameState.piece.BGHOPPER);
            }
            this.player2Pieces--;
            board[boardX][boardY] = piece;
            this.setTurn(WHITE_TURN);
            return true;
        }
        return false;
    }

    /**
     * Moves a piece on the board and sets the turn to that of the other player.
     *
     * @param id: the id of whose turn it is
     * @return true if successful, false otherwise
     */
    boolean movePiece(int id, Piece piece, int startX, int startY, int newX, int newY) {
        if(id == WHITE_TURN) {
            if(piece.getType().equals("QueenBee")) {

            }
            else if(piece.getType().equals("Spider")) {

            }
            else if(piece.getType().equals("Ant")) {

            }
            else if(piece.getType().equals("Beetle")) {

            }
            else if(piece.getType().equals("Grasshopper")) {

            }
            this.setTurn(BLACK_TURN);
            return true;
        }
        else if(id == BLACK_TURN) {
            if(piece.getType().equals("QueenBee")) {

            }
            else if(piece.getType().equals("Spider")) {

            }
            else if(piece.getType().equals("Ant")) {

            }
            else if(piece.getType().equals("Beetle")) {

            }
            else if(piece.getType().equals("Grasshopper")) {

            }
            this.setTurn(WHITE_TURN);
            return true;
        }
        return false;
    }

    // Not sure if we're implementing this, go ahead and delete if so
    boolean undo(int id) {
        if (id == WHITE_TURN || id == BLACK_TURN) {
            return true;
        }
        return false;
    }

    /**
     * Quits the game.
     *
     * @param id: the id of whose turn it is
     * @return true if successful, false otherwise
     */
    boolean quit(int id) {
        if(id == WHITE_TURN || id == BLACK_TURN) {
            // Quit method here
            return true;
        }
        return false;
    }

    /**
     * Zooms in or out on the screen.
     *
     * @param id: the id of whose turn it is
     * @return true if successful, false otherwise
     */
    boolean zoom(int id) {
        if (id == WHITE_TURN || id == BLACK_TURN) {
            // Zoom method here
            return true;
        }
        return false;
    }

    int getTurn() {
        return this.turn;
    }

    void setTurn(int id) {
        this.turn = id;
    }
}

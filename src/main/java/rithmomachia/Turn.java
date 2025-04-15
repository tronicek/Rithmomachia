package rithmomachia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This class holds data for the minimax nodes. It is constructed with a Piece to move, and where to move it to
// It should then figure out all the captures that can be made for that one piece at that one position and add that to
// The previous value.
public class Turn {
    private Board board;
    private Piece piece;
    private Pos newPosition;
    private int value;

    public Turn(Board board, Piece piece, Pos newPosition) {
        this.board = board;
        this.piece = piece;
        this.newPosition = newPosition;
        this.value = this.determineValue();
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Pos getNewPosition() {
        return this.newPosition;
    }

    public int getValue() {
        return this.value;
    }

    private int determineValue() {
        int sum = 0;
        Board boardToCheck = this.board.makeVirtualBoard(this);
        Set<Piece> captures = this.piece.getAllCaptures(boardToCheck);
        for (Piece capture : captures) {
            sum += capture.getValue();
        }
        return sum;
    }
}

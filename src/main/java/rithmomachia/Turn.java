package rithmomachia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// This class holds data for the minimax nodes. It is constructed with a Piece to move, and where to move it to
// It should then figure out all the captures that can be made for that one piece at that one position and add that to
// The previous value.
public class Turn {
    private Piece piece;
    private Pos newPosition;

    public Turn(Piece piece, Pos newPosition) {
        this.piece = piece;
        this.newPosition = newPosition;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Pos getNewPosition() {
        return this.newPosition;
    }
}

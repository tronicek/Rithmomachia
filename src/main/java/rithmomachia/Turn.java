package rithmomachia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// WE ARE NOT USING THIS CLASS PLEASE DO NOT MAKE EYE CONTACT. We are doing all this in minimax node and just keeping this so choas doesnt ensue
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

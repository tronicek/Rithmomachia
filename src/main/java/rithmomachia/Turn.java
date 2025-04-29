package rithmomachia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// You can make eye contact now he is chill we talked it out.
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

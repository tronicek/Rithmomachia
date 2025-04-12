package rithmomachia;

import java.util.ArrayList;
import java.util.List;

public class Turn {
    private Piece piece;
    private Pos newPosition;
    private List<Integer> captureValues;

    public Turn(Piece piece, Pos newPosition){
        this.piece = piece;
        this.newPosition = newPosition;
        this.captureValues = new ArrayList<>();
    }

    public Piece getPiece() {
        return piece;
    }

    public Pos getNewPosition() {
        return newPosition;
    }

    public List<Integer> getCaptureValues() {
        return captureValues;
    }


}

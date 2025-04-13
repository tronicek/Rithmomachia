package rithmomachia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Turn {
    private Board board;
    private Piece piece;
    private Pos newPosition;
    private int value;
    private List<Piece> captures;

    public Turn(Board board, Piece piece, Pos newPosition, int previousValue) {
        this.board = board;
        this.piece = piece;
        this.newPosition = newPosition;
        this.captures = new ArrayList<>();
        this.value = this.getValue() + previousValue;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Pos getNewPosition() {
        return this.newPosition;
    }

    public List<Piece> getCaptures() {
        return this.captures;
    }

    public int getValue() {
        int sum = 0;
        for (Piece capture : captures) {
            sum += capture.getValue();
        }
        return sum;
    }

    private List<Piece> getAllCaptures(){
        Set<Piece> possibleCaptures = new HashSet<>();
        for (Move nextMove: piece.findMoves(this.board)){
            Board virtualBoard = this.board.makeVirtualBoard(this.piece, nextMove);
            possibleCaptures.addAll(virtualBoard.getAllCapturesForPiece(this.piece));
        }
        for (Piece piece : allPieces) {
            Set<Move> allMoves = piece.findMoves(this.board);
            for (Move move : allMoves) {
                Board virtualBoard = board.makeVirtualBoard(this.piece, move);
                possibleCaptures.addAll(piece.)
            }
        }
        return possibleCaptures;
    }
}

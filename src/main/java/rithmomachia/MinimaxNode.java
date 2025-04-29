package rithmomachia;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

// This is a node for minimax. It is constructed with the Turn that has been made.
// Move goal declaration here?
public class MinimaxNode {
    private List<MinimaxNode> children;
    private final Turn turn;
    private final int depth;
    final int nodeValue;
    private Board virtualBoard;
    private final int bodiesRemaining;
    private final int valueRemaining;
    private final int digitsRemaining;


    public MinimaxNode(Turn turn, int depth, int previousValue, Board board, int bodiesRemaining, int valueRemaining, int digitsRemaining) {
        this.turn = turn;
        this.virtualBoard = board;
        this.bodiesRemaining = bodiesRemaining;
        this.valueRemaining = valueRemaining;
        this.digitsRemaining = digitsRemaining;
        this.nodeValue = this.determineNodeValue(previousValue);
        this.depth = depth;
        this.children = this.createChildren();
    }

    public List<MinimaxNode> getChildren() {
        return children;
    }

    public int getValue(){
        return this.nodeValue;
    }

    // This should create new nodes containing the NEXT turns (mainly new position for all pieces for the color that is
    // moving.
    // TODO: Think about possibility that captures can be made without making a move first. This is a new turn where the piece is given it's current position.
    // Need to make a set of all pieces for that color, iterate, find all movement positions for each piece, and create a bunch of
    // new nodes with those positions as well as one for if no pieces have moved (pick one piece and create Turn with that piece's current position
    // Each node on creation makes a bunch of new nodes, each of those nodes makes more nodes, etc.
    // TODO: Account for color. I feel like the turn data holds the color because it has a piece???
    // Feed the new nodes depth-1;
    // Create new nodes based off opposite color of the piece in this node. Ternary statement.

    private List<MinimaxNode> createChildren() {
        List<MinimaxNode> nextMoves = new ArrayList<>();
        if (this.depth == 0)
            return nextMoves;
        //else, fill nextmoves with new nodes with depth-1

        List<Turn> possibleMoves = this.virtualBoard.getAllMovesForColor(this.turn.getPiece().getColor() == Color.W ? Color.B : Color.W);
        for (Turn possibleMove : possibleMoves) {
            Board newVirtualBoard = this.virtualBoard.makeVirtualBoard(possibleMove);
            MinimaxNode newChild = new MinimaxNode(possibleMove, this.depth -1, this.nodeValue, newVirtualBoard, this.bodiesRemaining, this.valueRemaining, this.digitsRemaining);
        }
        return nextMoves;
    }

    private int determineNodeValue(int previousValue) {
        int sum = 0;
        Set<Piece> captures = this.virtualBoard.getAllCapturesForPiece(this.turn.getPiece());
        for (Piece capture : captures) {
            sum += capture.getValue();
        }
        // sum is values
        // captures.length is bodies
        // loop through captures and determine digits and then compare to remaining goals
        return sum;
    }

}

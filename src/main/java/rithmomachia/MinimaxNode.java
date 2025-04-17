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


    public MinimaxNode(Turn turn, int depth, int previousValue) {
        this.turn = turn;
        this.nodeValue =  previousValue;
        this.depth = depth;
        this.children = this.createChildren(this.depth);
    }

    public List<MinimaxNode> getChildren() {
        return children;
    }

//    public int getValue(){
//        return this.nodeValue();
//    }

    // This should create new nodes containing the NEXT turns (mainly new position for all pieces for the color that is
    // moving.
    // TODO: Think about possibility that captures can be made without making a move first. This is a new turn where the piece is given it's current position.
    // Need to make a set of all pieces for that color, iterate, find all movement positions for each piece, and create a bunch of
    // new nodes with those positions as well as one for if no pieces have moved (pick one piece and create Turn with that piece's current position
    // Each node on creation makes a bunch of new nodes, each of those nodes makes more nodes, etc.
    // TODO: Account for color. I feel like the turn data holds the color because it has a piece???
    // Feed the new nodes depth-1;
    // Create new nodes based off opposite color of the piece in this node. Ternary statement.

    private List<MinimaxNode> createChildren(int currentDepth) {
        List<MinimaxNode> nextMoves = new ArrayList<>();
        if (currentDepth == 0)
            return nextMoves;
        //else, fill nextmoves with new nodes with depth-1
        return nextMoves;
    }

//    private int determineValue() {
//        int sum = 0;
//        Board boardToCheck = this.board.makeVirtualBoard(this);
//        Set<Piece> captures = this.piece.getAllCaptures(boardToCheck);
//        for (Piece capture : captures) {
//            sum += capture.getValue();
//        }
//        return sum;
//    }
}

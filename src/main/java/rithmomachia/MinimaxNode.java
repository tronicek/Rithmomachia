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
    private final boolean isMaximizingPlayer;
    private final GoalHolder maximizerGoals;
    private final GoalHolder minimizerGoals;


    public MinimaxNode(Turn turn, int depth, int previousValue, Board virtualBoard, GoalHolder maximizerGoals, GoalHolder minimizerGoals, boolean isMaximizingPlayer) {
        this.turn = turn;
        this.virtualBoard = virtualBoard;
        this.isMaximizingPlayer = isMaximizingPlayer;
        this.maximizerGoals = maximizerGoals;
        this.minimizerGoals = minimizerGoals;
        this.children = new ArrayList<MinimaxNode>();
        this.depth = depth;
        if (maximizerGoals.hasWon()) {
            this.nodeValue = Integer.MAX_VALUE;
        } else if (minimizerGoals.hasWon()) {
            this.nodeValue = Integer.MIN_VALUE;
        } else {
            this.nodeValue = this.determineNodeValue(previousValue);
            this.createChildren();
        }
    }

    public List<MinimaxNode> getChildren() {
        return children;
    }

    public int getValue(){
        return this.nodeValue;
    }

    private int determineNodeValue(int previousValue) {

        int newValueTotal = 0;
        int newDigitsTotal = 0;
        // Need check for glorious victories
        // If glorious, return Integer.MAX_VALUE
        Set<Piece> captures = this.virtualBoard.getAllCapturesForPiece(this.turn.getPiece());
        for (Piece capture : captures) {
            int captureValue = capture.getValue();
            newValueTotal += captureValue;
            if (captureValue < 10) {
                newDigitsTotal += 1;
            }
            else if (captureValue < 100) {
                newDigitsTotal += 2;
            }
            else
            {
                newDigitsTotal += 3;
            }
        }

        GoalHolder holderToCheck = this.isMaximizingPlayer ? this.maximizerGoals : this.minimizerGoals;
        int valueRemaining = holderToCheck.getValueRemaining();
        int bodiesRemaining = holderToCheck.getBodiesRemaining();
        int digitsRemaining = holderToCheck.getDigitsRemaining();
        if (newValueTotal > valueRemaining) {
            newValueTotal = valueRemaining;
            holderToCheck.setValueRemaining(0);
        }

        int newBodiesTotal = captures.size();
        if (newBodiesTotal > bodiesRemaining) {
            newBodiesTotal = bodiesRemaining;
            holderToCheck.setBodiesRemaining(0);
        }

        if (newDigitsTotal > digitsRemaining) {
            newDigitsTotal = digitsRemaining;
            holderToCheck.setDigitsRemaining(0);
        }
        holderToCheck.setValueRemaining(valueRemaining-newValueTotal);
        holderToCheck.setBodiesRemaining(bodiesRemaining-newBodiesTotal);
        holderToCheck.setDigitsRemaining(digitsRemaining-newDigitsTotal);
        int totalScore = newValueTotal + newDigitsTotal + newBodiesTotal;
        return previousValue + (isMaximizingPlayer ? totalScore : -totalScore);
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

    private void createChildren() {
        //else, fill nextmoves with new nodes with depth-1

        List<Turn> possibleMoves = this.virtualBoard.getAllMovesForColor(this.turn.getPiece().getColor() == Color.W ? Color.B : Color.W);
        for (Turn possibleMove : possibleMoves) {
            Board newVirtualBoard = this.virtualBoard.makeVirtualBoard(possibleMove);
            MinimaxNode newChild = new MinimaxNode(possibleMove, this.depth -1, this.nodeValue, newVirtualBoard, this.maximizerGoals, this.minimizerGoals, !this.isMaximizingPlayer);
            this.children.add(newChild);
        }
    }
}

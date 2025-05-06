package rithmomachia;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class MinimaxNode {
    private List<MinimaxNode> children;
    private final Turn turn;
    private final int depth;
    final int nodeValue;
    private Board virtualBoard;
    private final boolean isMaximizingPlayer;
    private final GoalHolder maximizerGoals;
    private final GoalHolder minimizerGoals;
    private final VictoryManager victoryManager;
    private final Color nodeColor;

    public MinimaxNode(Turn turn, int depth, int previousValue, Board virtualBoard, GoalHolder maximizerGoals, GoalHolder minimizerGoals, boolean isMaximizingPlayer, VictoryManager victoryManager) {
        this.turn = turn;
        this.nodeColor = this.turn.getPiece().getColor() == Color.W ? Color.B : Color.W;
        this.victoryManager = victoryManager;
        this.virtualBoard = virtualBoard;
        this.isMaximizingPlayer = isMaximizingPlayer;
        this.maximizerGoals = maximizerGoals;
        this.minimizerGoals = minimizerGoals;
        this.children = new ArrayList<MinimaxNode>();
        this.depth = depth;
        Victory victory = victoryManager.checkForVictory(turn.getPiece().getColor());
        if (victory != Victory.NONE) {
            this.nodeValue = isMaximizingPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE;
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

    private void createChildren() {
        List<Turn> possibleMoves = this.virtualBoard.getAllMovesForColor(this.nodeColor);
        Piece randomPiece = (Piece) virtualBoard.getPiecesOfColor(nodeColor).toArray()[0];
        possibleMoves.add(new Turn(randomPiece, new Pos(randomPiece.getRow(), randomPiece.getCol())));
        for (Turn possibleMove : possibleMoves) {
            Board newVirtualBoard = this.virtualBoard.makeVirtualBoard(possibleMove);
            MinimaxNode newChild = new MinimaxNode(possibleMove, this.depth -1, this.nodeValue, newVirtualBoard, this.maximizerGoals, this.minimizerGoals, !this.isMaximizingPlayer, victoryManager);
            this.children.add(newChild);
        }
    }
}

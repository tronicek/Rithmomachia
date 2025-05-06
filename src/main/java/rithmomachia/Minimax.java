package rithmomachia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Minimax {
    final Victory victory;
    final Board board;
    final Color computerColor;
    private VictoryManager victoryManager;
//    private final int bodiesRemaining;
//    private final int valueRemaining;
//    private final int digitsRemaining;

    public Minimax(Board board, Victory victory, VictoryManager victoryManager, Color color) {
        this.computerColor = color;
        this.board = board;
        this.victory = victory;
        this.victoryManager = victoryManager;
    }

    public Turn findBestMove(int depth) {
        // Must be able to create nodes or turns that know which color move
        // Computer is creating a dummy best value and a null Turn.
        // For each piece it can move, it must run minimax on the child node
        // If that child node beats the current max, that becomes the new node that is returned
        List<Turn> moves = board.getAllMovesForColor(computerColor);
        Turn bestMove = moves.getFirst();
        int bestScore = Integer.MIN_VALUE;
        for (int i = 1; i < moves.size(); i++) {
            Turn move = moves.get(i);
            Board virtualBoard = board.makeVirtualBoard(move);
            Color playerColor = computerColor == Color.B ? Color.W : Color.B;
            int maximizerBodiesRemaining = victoryManager.getBodiesRemainingForColor(computerColor);
            int maximizerValueRemaining = victoryManager.getValueRemainingForColor(computerColor);
            int maximizerDigitsRemaining = victoryManager.getDigitsRemainingForColor(computerColor);
            int minimizerBodiesRemaining = victoryManager.getBodiesRemainingForColor(playerColor);
            int minimizerValueRemaining = victoryManager.getValueRemainingForColor(playerColor);
            int minimizerDigitsRemaining = victoryManager.getDigitsRemainingForColor(playerColor);
            GoalHolder maximizerGoals = new GoalHolder(maximizerBodiesRemaining, maximizerValueRemaining, maximizerDigitsRemaining, true);
            GoalHolder minimizerGoals = new GoalHolder(minimizerBodiesRemaining, minimizerValueRemaining, minimizerDigitsRemaining, false);
            MinimaxNode branch = new MinimaxNode(move, depth - 1, 0, virtualBoard, maximizerGoals, minimizerGoals, false);
            int branchValue = minimax(branch, depth - 1, false);
            if (branchValue > bestScore) {
                bestScore = branchValue;
                bestMove = move;
            }
        }

        return bestMove;
    }

    private int minimax(MinimaxNode currentNode, int depth, boolean isMaximizingPlayer) {
        if (depth == 0) { // OR someone has won
            // Integer.MAX_VALUE if computer's win
            // Integer.MIN_VALUE if player's win
            return currentNode.getValue();
        }
        if (isMaximizingPlayer) {
            int value = currentNode.getChildren().getFirst().getValue();
            for (MinimaxNode nextNode : currentNode.getChildren()) {
                value = Math.max(value, minimax(nextNode, depth - 1, false));
            }
            return value;
        } else {
            int value = currentNode.getChildren().getFirst().getValue();
            for (MinimaxNode nextNode : currentNode.getChildren()) {
                value = Math.min(value, minimax(nextNode, depth - 1, true));
            }
            return value;
        }
    }
}
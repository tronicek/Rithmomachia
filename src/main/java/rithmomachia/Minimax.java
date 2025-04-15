package rithmomachia;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Minimax {
    final Victory victory;
    final int bodyGoal;
    final int valueGoal;
    final int digitsGoal;
    final Board board;
    final Color computerColor;
    private final int bodiesRemaining;
    private final int valueRemaining;
    private final int digitsRemaining;

    public Minimax(Board board, Victory victory, Color color,  int bodyGoal, int valueGoal, int digitsGoal) {
        this.computerColor = color;
        this.board = board;
        this.victory = victory;
        this.bodyGoal = bodyGoal;
        this.valueGoal = valueGoal;
        this.digitsGoal = digitsGoal;
        this.bodiesRemaining = bodyGoal;
        this.valueRemaining = valueGoal;
        this.digitsRemaining = digitsGoal;
    }

    public Turn findBestMove(int depth){
        // Must be able to create nodes or turns that know which color move
        // Computer is creating a dummy best value and a null Turn.
        // For each piece it can move, it must run minimax on the child node
        // If that child node beats the current max, that becomes the new node that is returned
        List<Turn> moves = board.getAllMovesForColor(computerColor);
        Turn bestMove = moves.get(0);
        int bestScore = bestMove.getValue();
        for(int i = 1; i < moves.size(); i++){
            Turn move = moves.get(i);
            MinimaxNode branch = new MinimaxNode(move, depth - 1, move.getValue());
            int branchValue = minimax(branch, depth - 1, false);
            if(branchValue > bestScore){
                bestScore = branchValue;
                bestMove = move;
            }
        }

        return bestMove;
    }

    private int minimax(MinimaxNode currentNode, int depth, boolean maximizingPlayer) {
        if (depth == 0) {
            return currentNode.getValue();
        }
        if (maximizingPlayer) {
            int value = currentNode.getChildren().getFirst().getValue();
            for (MinimaxNode nextNode : currentNode.getChildren()) {
                value = Math.max(value, minimax(nextNode, depth-1, false));
            }
            return value;
        }
        else {
            int value = currentNode.getChildren().getFirst().getValue();
            for (MinimaxNode nextNode : currentNode.getChildren()) {
                value = Math.min(value, minimax(nextNode, depth-1, true));
            }
            return value;
        }
    }


//    function minimax(node, depth, maximizingPlayer) is
//    if depth = 0 or node is a terminal node then
//        return the heuristic value of node
//    if maximizingPlayer then
//    value := −∞
//            for each child of node do
//    value := max(value, minimax(child, depth − 1, FALSE))
//            return value
//    else (* minimizing player *)
//    value := +∞
//            for each child of node do
//    value := min(value, minimax(child, depth − 1, TRUE))
//            return value
}

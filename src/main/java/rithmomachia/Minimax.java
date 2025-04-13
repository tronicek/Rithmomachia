package rithmomachia;

public class Minimax {
    final Victory victory;
    final int bodyGoal;
    final int valueGoal;
    final int digitsGoal;
    private final int bodiesRemaining;
    private final int valueRemaining;
    private final int digitsRemaining;

    public Minimax(Victory victory, int bodyGoal, int valueGoal, int digitsGoal) {
        this.victory = victory;
        this.bodyGoal = bodyGoal;
        this.valueGoal = valueGoal;
        this.digitsGoal = digitsGoal;
        this.bodiesRemaining = bodyGoal;
        this.valueRemaining = valueGoal;
        this.digitsRemaining = digitsGoal;
    }

    public Turn findBestMove(int depth){

        return null;
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

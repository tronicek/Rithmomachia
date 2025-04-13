package rithmomachia;

import java.util.List;
import java.util.ArrayList;

public class MinimaxNode {
    private List<MinimaxNode> children;
    private final Turn turn;

    public MinimaxNode(Turn turn) {
        this.turn = turn;
        this.children = this.createChildren();
    }

    public List<MinimaxNode> getChildren() {
        return children;
    }

    public int getValue(){
        return turn.getValue();
    }

    private List<MinimaxNode> createChildren() {
        List<MinimaxNode> nextMoves = new ArrayList<>();
        return nextMoves;
    }
}

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class EruptionTest {

    private String toString(Set<Pos> pp) {
        StringBuilder sb = new StringBuilder();
        for (Pos p : pp) {
            sb.append(p);
        }
        return sb.toString();
    }

    @Test
    public void testSameShape1() {
        String[] s = {
                "--- BT5 --- WT15"
        };
        Board board = new Board(1,4,s);
        Piece piece = board.getPiece(0,1);
        Set<Pos> possible = piece.eruptionCapture(board);
        String capture = toString(possible);
        Assert.assertEquals("[0,3]", capture);
    }

    @Test
    public void testSameShape2() {
        String[] s = {
                "--- BT5 --- --- WT20"
        };
        Board board = new Board(1,5,s);
        Piece piece = board.getPiece(0,1);
        Set<Pos> possible = piece.eruptionCapture(board);
        String capture = toString(possible);
        Assert.assertEquals("[0,4]", capture);
    }

}

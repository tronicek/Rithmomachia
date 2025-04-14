package rithmomachia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CommonVictoryTest {

    //Convert Victory text to string
    private String toString(Victory pp) {
        return pp.toString();
    }

    @Test
    public void test1() {
        String[] s = {
                "--- --- ---",
                "WT5 --- BC5",
                "--- --- ---",
        };
        Board board = new Board(3, 3, s); //Initialize Board
        VictoryManager vm = new VictoryManager(board, Victory.BODIES, 1, 0, 0); //Create Victory conditions
        Piece capturedPiece = board.getPiece(1,2); //Set Piece being captured to "capturedPiece"
        Victory v = vm.capture(capturedPiece); //Put capturedPiece into Victory Manager's "capture" and set the victory it produced to "v"
        String Victory = toString(v); //Convert the "v" or victory name to string
        assertEquals("BODIES",Victory); //Make sure victory aligns with expected victory

        //numBodies is set to 1 and only 1 vm.capture occurs thus whichever piece made the capture wins
    }

    @Test
    public void test2() {
        String[] s = {
                "--- --- ---",
                "WT5 --- BC5",
                "--- --- ---",
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.GOODS, 0, 0, 5);
        Piece capturedPiece = board.getPiece(1,2);
        Victory v = vm.capture(capturedPiece);
        String Victory = toString(v);
        assertEquals("GOODS",Victory);

        //value is equal to 5 and the piece that is being captured is equal to (or greater than) 5
    }


}

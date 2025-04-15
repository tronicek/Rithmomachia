package rithmomachia;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

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
    public void test2Bodies() {
        String[] s = {
                "--- --- ---",
                "BT5 --- P,W,C10,T15,S5",
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
    public void testBodiesVictoryWithEruptionCapture() {
        String[] s = {
                "--- --- --- BT5",
                "--- --- --- ---",
                "--- --- --- ---",
                "P,W,C1,T5,S20 --- --- ---",
        };

        Board board = new Board(4, 4, s);
        Piece attacker = board.getPiece(0, 3); // BT5

        // Get all valid eruption captures
        Set<Piece> possibleCaptures = attacker.captureByEruption(board);

        // Check that the correct piece is capturable
        // Expected to capture WS20 (White Square value 20)
        Piece expected = new Piece(Color.W, 20, 3, 4, 3, "S"); // row 3, col 4 = S20
        assertTrue(possibleCaptures.stream().anyMatch(p -> p.toString().equals(expected.toString())));

        // Set VM with BODIES = 1
        VictoryManager vm = new VictoryManager(board, Victory.BODIES, 1 , 0, 0);

        // Feed in the captured piece to simulate that it was taken
        Piece capturedPiece = possibleCaptures.stream().filter(p -> p.toString().equals(expected.toString())).findFirst().orElseThrow();

        Victory result = vm.capture(capturedPiece);
        String Victory = toString(result);

        assertEquals("BODIES", Victory);
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
    @Test
    public void testQuarrelVictory() {
        String[] s = {
                "--- --- ---",
                "BT15 --- WC15",
                "--- --- ---",
        };
        Board board = new Board(3, 3, s);
        // Capturing WC10
        // Assume BT10 captures it -> value 10, digits 2
        VictoryManager vm = new VictoryManager(board, Victory.QUARREL, 0, 2, 10);//Value here >10
        Piece capturedPiece = board.getPiece(1,2); // WC10
        Victory v = vm.capture(capturedPiece);     // Black captured white
        String Victory = toString(v);
        assertEquals("QUARREL", Victory);
    }
    @Test
    public void testQuarrelVictory2() {
        String[] s = {
                "--- --- ---",
                "BT15 --- P,W,C15,T10,S20",
                "--- --- ---",
        };
        Board board = new Board(3, 3, s);
        // Capturing WC10
        // Assume BT10 captures it -> value 10, digits 2
        VictoryManager vm = new VictoryManager(board, Victory.QUARREL, 0, 2, 10);//Value here >10
        Piece capturedPiece = board.getPiece(1,2); // WC10
        Victory v = vm.capture(capturedPiece);     // Black captured white
        String Victory = toString(v);
        assertEquals("QUARREL", Victory);
    }
    @Test
    public void testQuarrelVictory3() {
        String[] s = {
                "--- --- ---",
                "BT15 --- WC15",
                "--- --- ---",
        };
        Board board = new Board(3, 3, s);
        // Capturing WC10
        // Assume BT10 captures it -> value 10, digits 2
        VictoryManager vm = new VictoryManager(board, Victory.QUARREL, 0, 2, 10);//Value here >10
        Piece capturedPiece = board.getPiece(1,2); // WC10
        Victory v = vm.capture(capturedPiece);     // Black captured white
        String Victory = toString(v);
        assertEquals("QUARREL", Victory);
    }
    @Test
    public void testHonorVictory() {
        String[] s = {
                "--- --- ---",
                "BT15 --- WC15",
                "--- --- ---",
        };
        Board board = new Board(3, 3, s);
        // WC15 = 1 piece captured, value = 15
        VictoryManager vm = new VictoryManager(board, Victory.HONOR, 1, 0, 15);
        Piece capturedPiece = board.getPiece(1,2); // WC15
        Victory v = vm.capture(capturedPiece);
        String Victory = toString(v);
        assertEquals("HONOR", Victory);
    }
    @Test
    public void testHonorAndQuarrelVictory() {
        String[] s = {
                "--- --- ---",
                "BT12 --- WC12",
                "--- --- ---",
        };
        Board board = new Board(3, 3, s);

        // Must meet ALL: bodies (1), digits (2), value (12)
        VictoryManager vm = new VictoryManager(board, Victory.HONOR_AND_QUARREL, 1, 2, 12);

        Piece capturedPiece = board.getPiece(1, 2); // WC12
        Victory v = vm.capture(capturedPiece);
        String Victory = toString(v);

        assertEquals("HONOR_AND_QUARREL", Victory);
    }


}

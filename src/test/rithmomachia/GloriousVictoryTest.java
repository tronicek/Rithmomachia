package rithmomachia;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class GloriousVictoryTest {

    @Test
    public void testVictoriaMagna() {
        String[] s = {
                "--- --- --- ---",
                "--- WC3 WC5 WC7" // Arithmetic: 3,5,7
        };
        Board board = new Board(2, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor() {
        String[] s = {
                "WC2 WC4 WC6 WC8" // Arithmetic: 2,4,6 and Geometric: 2,4,8
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.W);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma() {
        String[] s = {
                "--- --- --- --- WC4 WC6 WC8 WC12"
        };
        Board board = new Board(1, 8, s); // 1 row, 8 columns
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.W);
        assertTrue("Victoria Excellentissima should be triggered", triggered);
    }

    @Test
    public void testNoGloriousVictory() {
        String[] s = {
                "--- --- --- ---",
                "--- WC2 WC5 WC9"
        };
        Board board = new Board(2, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);

        boolean magna = vm.checkVictoriaMagna(Color.W);
        boolean mayor = vm.checkVictoriaMayor(Color.W);
        boolean excellentisma = vm.checkVictoriaExcelentisma(Color.W);

        assertFalse("No Victoria Magna should be triggered", magna);
        assertFalse("No Victoria Mayor should be triggered", mayor);
        assertFalse("No Victoria Excellentísima should be triggered", excellentisma);
    }
}
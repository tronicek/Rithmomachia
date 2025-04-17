package rithmomachia;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class GloriousVictoryTest {


    @Test
    public void testVictoriaMagna() {
        String[] s = {
                "--- --- ---",
                "WC3 WC5 WC7",
                "--- --- ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna0() {
        String[] s = {
                "--- --- ---",
                "WC7 WC5 WC3",
                "--- --- ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna1() {
        String[] s = {
                "--- WC7 ---",
                "--- WC5 ---",
                "--- WC3 ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna1A() {
        String[] s = {
                "--- WC3 ---",
                "--- WC5 ---",
                "--- WC7 ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }



    @Test
    public void testVictoriaMagna2() {
        String[] s = {
                "--- --- WC7",
                "--- WC5 ---",
                "WC3 --- ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna2A() {
        String[] s = {
                "--- --- WC3",
                "--- WC5 ---",
                "WC7 --- ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }



    @Test
    public void testVictoriaMagna3() {
        String[] s = {
                "--- --- ---",
                "--- WC5 WC7",
                "--- WC3 ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna3A() {
        String[] s = {
                "--- --- ---",
                "--- WC5 WC3",
                "--- WC7 ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna4() {
        String[] s = {
                "--- --- ---",
                "WC3 WC5 ---",
                "--- WC7 ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna4A() {
        String[] s = {
                "--- --- ---",
                "WC7 WC5 ---",
                "--- WC3 ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna5() {
        String[] s = {
                "--- --- WC7",
                "--- WC5 ---",
                "--- WC3 ---", // Arithmetic: 3,5,7
        };
        Board board = new Board(3, 3, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna6() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "WC3 --- WC5 --- WC7",
                "--- --- --- --- ---",
                "--- --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna6A() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "WC7 --- WC5 --- WC3",
                "--- --- --- --- ---",
                "--- --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna7() {
        String[] s = {
                "--- --- WC3 --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- WC7 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna7A() {
        String[] s = {
                "--- --- WC7 --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- WC3 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna8() {
        String[] s = {
                "--- --- --- --- WC7",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "WC3 --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna8A() {
        String[] s = {
                "--- --- --- --- WC3",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "WC7 --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna9() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- WC7",
                "--- --- --- --- ---",
                "--- --- WC3 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);

        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna9A() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- WC3",
                "--- --- --- --- ---",
                "--- --- WC7 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna10() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "WC3 --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- WC7 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna10A() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "WC7 --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- WC3 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertTrue("Victoria Magna should be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna11() {
        String[] s = {
                "--- --- --- --- WC7",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- WC3 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna11A() {
        String[] s = {
                "--- --- --- --- WC3",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- WC7 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna12() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- WC7 --- WC3",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna12A() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- WC3 --- WC7",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna13() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "WC7 --- WC3 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna13A() {
        String[] s = {
                "--- --- --- --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "WC3 --- WC7 --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna14() {
        String[] s = {
                "WC3 --- WC7 --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna14A() {
        String[] s = {
                "WC7 --- WC3 --- ---",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna15() {
        String[] s = {
                "--- --- WC3 --- WC7",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna15A() {
        String[] s = {
                "--- --- WC7 --- WC3",
                "--- --- --- --- ---",
                "--- --- WC5 --- ---",
                "--- --- --- --- ---",
                "--- --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMagna(Color.W);
        assertFalse("Victoria Magna should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMagna16() {
        String[] s = {
                "--- --- WC8 --- WC12",
                "--- --- --- --- ---",
                "--- --- WC6 --- ---",
                "--- --- --- --- ---",
                "--- --- --- --- ---",// Arithmetic: 3,5,7
        };
        Board board = new Board(5, 5, s);
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
    public void testVictoriaMayor1() {
        String[] s = {
                "WC8 WC6 WC4 WC2" // Arithmetic: 2,4,6 and Geometric: 2,4,8
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.W);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor2() {
        String[] s = {
                "BC8 --- --- ---",
                "BC6 --- --- ---",
                "BC4 --- --- ---",
                "BC2 --- --- ---",// Arithmetic: 2,4,6 and Geometric: 2,4,8
        };
        Board board = new Board(4, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor3() {
        String[] s = {
                "BC2 --- --- ---",
                "BC4 --- --- ---",
                "BC6 --- --- ---",
                "BC8 --- --- ---",// Arithmetic: 2,4,6 and Geometric: 2,4,8
        };
        Board board = new Board(4, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor4() {
        String[] s = {
                "--- --- --- BC2",
                "--- --- BC4 ---",
                "--- BC6 --- ---",
                "BC8 --- --- ---",// Arithmetic: 2,4,6 and Geometric: 2,4,8
        };
        Board board = new Board(4, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor5() {
        String[] s = {
                "--- --- --- BC8",
                "--- --- BC4 ---",
                "--- BC3 --- ---",
                "BC2 --- --- ---",
        };
        Board board = new Board(4, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor6() {
        String[] s = {
                "--- --- --- ---",
                "--- BC4 BC8 ---",
                "--- BC3 BC2 ---",
                "--- --- --- ---",
        };
        Board board = new Board(4, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor7() {
        String[] s = {
                "--- --- --- ---",
                "--- BC8 BC4 ---",
                "--- BC3 BC2 ---",
                "--- --- --- ---",
        };
        Board board = new Board(4, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertFalse("Victoria Mayor should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor8() {
        String[] s = {
                "--- --- --- ---",
                "BC3 --- BC8 ---",
                "--- --- --- ---",
                "BC2 --- BC4 ---",
        };
        Board board = new Board(4, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertFalse("Victoria Mayor should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor9() {
        String[] s = {
                "--- --- --- ---",
                "BC3 --- BC4 ---",
                "--- --- --- ---",
                "BC2 --- BC8 ---",
        };
        Board board = new Board(4, 4, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor10() {
        String[] s = {
                "--- --- --- --- --- --- BC8",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- BC4 --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- BC3 --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC2 --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor11() {
        String[] s = {
                "--- --- --- --- --- --- BC2",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- BC3 --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- BC4 --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC8 --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor12() {
        String[] s = {
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- BC2 ---",
                "--- --- --- --- BC3 --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- BC4 --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC8 --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertFalse("Victoria Mayor should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor13() {
        String[] s = {
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC3 --- BC6 --- BC9 --- BC12",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor14() {
        String[] s = {
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC12 --- BC9 --- BC6 --- BC3",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor15() {
        String[] s = {
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC12 --- BC9 --- BC6 --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- BC3 --- ---",
                "--- --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertFalse("Victoria Mayor should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor16() {
        String[] s = {
                "--- --- --- --- --- --- ---",
                "--- --- BC12 --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- BC9 --- BC6 --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- BC3 --- ---",
                "--- --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertFalse("Victoria Mayor should not be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor17() {
        String[] s = {
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC45 --- BC25 --- BC15 --- BC5",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor18() {
        String[] s = {
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC45 --- BC25 --- BC15 --- BC5",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaMayor19() {
        String[] s = {
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "BC16 --- BC15 --- BC12 --- BC9",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, null, 0, 0, 0);
        boolean triggered = vm.checkVictoriaMayor(Color.B);
        assertTrue("Victoria Mayor should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma() {
        String[] s = {
                "--- --- --- --- WC4 WC6 WC8 WC12"
        };
        Board board = new Board(1, 8, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.W);
        assertFalse("Victoria Excellentisima should not be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma1() {
        String[] s = {
                "BC2 BC3 BC4 BC6"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertFalse("Victoria Excellentisima should not be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma2() {
        String[] s = {
                "BC2 BC3 BC6 BC9"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertFalse("Victoria Excellentisima should not be triggered", triggered);
    }


    @Test
    public void testVictoriaExcellentisma4() {
        String[] s = {
                "BC45 BC30 BC20 BC15"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertTrue("Victoria Excellentisima should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma5() {
        String[] s = {
                "BC4 BC6 BC9 BC12"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertTrue("Victoria Excellentisima should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma6() {
        String[] s = {
                "BC3 BC4 BC6 BC9"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertTrue("Victoria Excellentisima should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma7() {
        String[] s = {
                "BC3 BC4 BC6 BC8"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertFalse("Victoria Excellentisima should NOT be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma8() {
        String[] s = {
                "BC2 BC9 BC16 BC72"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertFalse("Victoria Excellentisima should NOT be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma9() {
        String[] s = {
                "BC2 BC7 BC12 BC42"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertFalse("Victoria Excellentisima should NOT be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma10() {
        String[] s = {
                "BC2 BC4 BC6 BC12"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertFalse("Victoria Excellentisima should NOT be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma11() {
        String[] s = {
                "BC2 BC5 BC8 BC20"
        };
        Board board = new Board(1, 4, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertFalse("Victoria Excellentisima should NOT be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma12() {
        String[] s = {
                "BC3 --- BC4  --- BC6 --- BC9"
        };
        Board board = new Board(1, 7, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertTrue("Victoria Excellentisima should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma13() {
        String[] s = {
                "BC3 --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- BC4 --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- BC6 --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- BC9",

        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertTrue("Victoria Excellentisima should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma14() {
        String[] s = {
                "--- --- --- BC4 --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- BC6 --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- BC9 --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- BC12 --- --- ---",

        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertTrue("Victoria Excellentisima should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma15() {
        String[] s = {
                "--- BC20 --- BC30 --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- BC15 --- WC45 --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",

        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertTrue("Victoria Excellentisima should be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma16() {
        String[] s = {
                "--- BC30 --- BC45 --- BC20 ---",
                "--- --- --- --- --- --- ---",
                "--- BC15 --- BC90 --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",

        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        assertFalse("Victoria Excellentisima should not be triggered", triggered);
    }

    @Test
    public void testVictoriaExcellentisma17() {
        String[] s = {
                "--- BC20 --- WC30 --- BC45 ---",
                "--- --- --- --- --- --- ---",
                "--- BC15 --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- WC10 --- --- --- --- ---",
                "--- --- --- --- --- --- ---",
                "--- --- --- --- --- --- ---",

        };
        Board board = new Board(7, 7, s);
        VictoryManager vm = new VictoryManager(board, Victory.NONE, 0, 0, 0);
        boolean triggered = vm.checkVictoriaExcelentisma(Color.B);
        boolean triggered2 = vm.checkVictoriaMayor(Color.B);
        assertFalse("Victoria Excellentisima should NOT be triggered", triggered);
        assertFalse("Victoria Mayor should be triggered", triggered2);
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
package rithmomachia;

import org.junit.Test;
import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DeceitCaptureTest {

    private String toString(Set<Piece> pp) {
        StringBuilder sb = new StringBuilder();
        for (Piece p : pp) {
            sb.append(p);
        }
        return sb.toString();
    }


    //Demo Tests
    @Test
    public void test1() {
        String[] s = {
                "--- --- ---",
                "BC2 WC5 BC3",
                "--- --- ---"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(1, 0);
        Set<Piece> pp = p.capturebyDeceit(b);
        String t = toString(pp);
        assertEquals("WC5", t);
    }
    @Test
    public void test2() {
        String[] s = {
                "--- --- ---",
                "BC2 WC5 BC3",
                "--- --- ---"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(1, 2);
        Set<Piece> pp = p.capturebyDeceit(b);
        String t = toString(pp);
        assertEquals("WC5", t);
    }
    @Test
    public void test3() {
        String[] s = {
                "--- BS3 ---",
                "--- WC5 ---",
                "--- BT2 ---"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(0, 1);
        Set<Piece> pp = p.capturebyDeceit(b);
        String t = toString(pp);
        assertEquals("WC5", t);
    }
    @Test
    public void test4() {
        String[] s = {
                "--- BS3 ---",
                "--- WC5 ---",
                "--- BT2 ---"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(2, 1);
        Set<Piece> pp = p.capturebyDeceit(b);
        String t = toString(pp);
        assertEquals("WC5", t);
    }
    @Test
    public void test5() {
        String[] s = {
                "--- --- BS3",
                "--- WC5 ---",
                "BS2 --- ---"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(2, 0);
        Set<Piece> pp = p.capturebyDeceit(b);
        String t = toString(pp);
        assertEquals("WC5", t);
    }
    @Test
    public void test6() {
        String[] s = {
                "--- --- BS3",
                "--- WC5 ---",
                "BS2 --- ---"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(0, 2);
        Set<Piece> pp = p.capturebyDeceit(b);
        String t = toString(pp);
        assertEquals("WC5", t);
    }
    @Test
    public void test7() {
        String[] s = {
                "BT2 --- ---",
                "--- WC5 ---",
                "--- --- BS3"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(0, 0);
        Set<Piece> pp = p.capturebyDeceit(b);
        String t = toString(pp);
        assertEquals("WC5", t);
    }
    @Test
    public void test8() {
        String[] s = {
                "BT2 --- ---",
                "--- WC5 ---",
                "--- --- BS3"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(2, 2);
        Set<Piece> pp = p.capturebyDeceit(b);
        String t = toString(pp);
        assertEquals("WC5", t);
    }
    @Test
    public void test9() {
        String[] s = {
                "BT2 --- ---",
                "--- WC6 ---",
                "--- --- BS3"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(2, 2);
        Set<Piece> pp = p.capturebyDeceit(b);
        assertEquals(0, pp.size());
    }
    @Test
    public void test10() {
        String[] s = {
                "BT2 --- ---",
                "--- --- ---",
                "--- --- BS3"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(2, 2);
        Set<Piece> pp = p.capturebyDeceit(b);
        assertEquals(0, pp.size());
    }
    @Test
    public void test11() {
        String[] s = {
                "BT2 --- ---",
                "--- WT6 ---",
                "--- --- ---"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(0, 0);
        Set<Piece> pp = p.capturebyDeceit(b);
        assertEquals(0, pp.size());
    }
    @Test
    public void test12() {
        String[] s = {
                "BT2 BT6 BS5",
                "BT4 WC6 BC5",
                "BS7 BC4 BS3"
        };
        Board b = new Board(3, 3, s);
        b.printBoard();
        Piece p = b.getPiece(1, 1);
        Set<Piece> pp = p.capturebyDeceit(b);
        assertEquals(0, pp.size());
    }
    @Test
    public void test13() {
        String[] s = {
                "BT1 --- BT1 --- BT1",
                "--- WT2 WT2 WT2 ---",
                "BT1 WT2 BC1 WT2 BT1",
                "--- WT2 WT2 WT2 ---",
                "BT1 --- BT1 --- BT1"

        };
        Board b = new Board(5, 5, s);
        b.printBoard();
        Piece p = b.getPiece(2, 2);
        Set<Piece> pp = p.capturebyDeceit(b);
        assertEquals(8, pp.size());
    }

}

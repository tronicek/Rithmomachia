import static org.junit.Assert.assertEquals;

//import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class TriangleTest {

    private String toString(Set<Pos> pp) {
        StringBuilder sb = new StringBuilder();
        for (Pos p : pp) {
            sb.append(p);
        }
        return sb.toString();
    }

    @Test
    public void testC1() {
        String[] s = {
            "--- WT5 --- BT5"
        };
        Board b = new Board(1, 4, s);
        Board.printBoard();
        Piece p = Board.getPiece(0, 1);
        Set<Pos> pp = p.capture(0, 1, b);
        String t = toString(pp);
        assertEquals("[0,3]", t);
        
        
    }

    @Test
    public void testC2() {
        String[] s = {
            "--- BT5 --- WT5"
        };
        Board b = new Board(1, 4, s);
        Board.printBoard();
        Piece p = Board.getPiece(0, 3);
        Set<Pos> pp = p.capture(0, 3, b);
        String t = toString(pp);
        assertEquals("[0,1]", t);
    }

    @Test
    public void testC3() {
        String[] s = {
            "---",
            "WT5",
            "---",
            "BT5"
        };
        Board b = new Board(4, 1, s);
        Board.printBoard();
        Piece p = Board.getPiece(1, 0);
        Set<Pos> pp = p.capture(1, 0, b);
        String t = toString(pp);
        assertEquals("[3,0]", t);
    }

    @Test
    public void testC4() {
        String[] s = {
            "---",
            "BT5",
            "---",
            "WT5"
        };
        Board b = new Board(4, 1, s);
        Board.printBoard();
        Piece p = Board.getPiece(3, 0);
        Set<Pos> pp = p.capture(3, 0, b);
        String t = toString(pp);
        assertEquals("[1,0]", t);
    }

    @Test
    public void testNC1() {
        String[] s = {
            "--- WT5 WC2 BT5"
        };
        Board b = new Board(1, 4, s);
        Board.printBoard();
        Piece p = Board.getPiece(0, 1);
        Set<Pos> pp = p.capture(0, 1, b);
        assertEquals(0, pp.size());
    }

    @Test
    public void testNC2() {
        String[] s = {
            "--- BT5 BC2 WT5"
        };
        Board b = new Board(1, 4, s);
        Board.printBoard();
        Piece p = Board.getPiece(0, 3);
        Set<Pos> pp = p.capture(0, 3, b);
        assertEquals(0, pp.size());
    }

    @Test
    public void testNC3() {
        String[] s = {
            "---",
            "WT5",
            "BC2",
            "BT5"
        };
        Board b = new Board(4, 1, s);
        Board.printBoard();
        Piece p = Board.getPiece(1, 0);
        Set<Pos> pp = p.capture(1, 0, b);
        assertEquals(0, pp.size());
    }

    @Test
    public void testNC4() {
        String[] s = {
            "---",
            "BT5",
            "BC2",
            "WT5"
        };
        Board b = new Board(4, 1, s);
        Board.printBoard();
        Piece p = Board.getPiece(3, 0);
        Set<Pos> pp = p.capture(3, 0, b);
        assertEquals(0, pp.size());
    }

    public static void main(String[] args) {
        // Uncomment if you want to allow user-defined board initialization
        /*
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter number of rows: ");
            int numRows = scanner.nextInt();
            System.out.print("Enter number of columns: ");
            int numCols = scanner.nextInt();
            Board.initBoard(numRows, numCols);
        }
        */
    }
}

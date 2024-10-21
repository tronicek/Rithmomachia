import java.util.Scanner;
import java.util.Set;

public class TriangleTest {
    public static void main(String[] args) {
        // Create a board and initialize it
    	
try (Scanner scanner = new Scanner(System.in)) {
	System.out.print("Enter number of rows: ");
	int numRows = scanner.nextInt();
	System.out.print("Enter number of columns: ");
	int numCols = scanner.nextInt();
	Board.initBoard(numRows, numCols);
}
		
		// Create a triangle piece
        Square square = new Square(Color.B, 1, 4, 4);
        
        
        
        
        Board.printBoard();

        // Call findMoves method
        Set<Move> moves = square.findMoves(square.getX(), square.getY(), new Board();

        // Print the moves
        System.out.println("Possible Moves for Square at (4, 4):");
        for (Move move : moves) {
            System.out.println(move);
        }
        
        	}
    
    

        

        // You could add assertions or expected results here
    }


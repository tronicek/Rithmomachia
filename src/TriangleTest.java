import java.util.Set;

public class TriangleTest {
    public static void main(String[] args) {
        // Create a board and initialize it
        

        // Create a triangle piece
        Square square = new Square(Color.B, "square1", 10, 4, 4); // Place it in the center of the board
        

        // Call findMoves method
        Set<Move> moves = square.findMoves(square.getX(), square.getY(), new Board());

        // Print the moves
        System.out.println("Possible Moves for Square at (4, 4):");
        for (Move move : moves) {
            System.out.println(move);
        }
        
        
        
        

        // You could add assertions or expected results here
    }
}

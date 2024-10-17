import java.util.Set;

public class Game {

	public static void main(String[] args) {
		Board.startGame();
		Board.printBoard();
		
		Triangle triangle = new Triangle(Color.B, "triangle1", 10, 4, 4); // Place it in the center of the board

        
        Set<Move> moves = triangle.findMoves(triangle.getX(), triangle.getY(), new Board());

        
        System.out.println("Possible Moves for Triangle at (4, 4):");
        for (Move move : moves) {
            System.out.println(move);
        }
		
		
		
		
		
		

	}

}

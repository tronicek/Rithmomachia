import java.util.HashSet;
import java.util.Set;

public class Square extends Piece{
	public Square(Color color, String ID, int value, int startX, int startY) {
		super(color, ID, value, startX, startY);
	}
	
	 @Override
	    public String toString() {
	        return String.format("%S%d", color, value);
	    }
	 
	 @Override
	 public Set<Move> findMoves(int x, int y, Board board) {
	     Set<Move> mm = new HashSet<>();

	     // Horizontal and vertical moves (3 squares)
	     if (Board.isValidPos(x + 3, y) && Board.isEmpty(x + 1, y) && Board.isEmpty(x + 2, y) && Board.isEmpty(x + 3, y)) {
	         mm.add(new Move(x, y, x + 3, y));
	     }
	     if (Board.isValidPos(x - 3, y) && Board.isEmpty(x - 1, y) && Board.isEmpty(x - 2, y) && Board.isEmpty(x - 3, y)) {
	         mm.add(new Move(x, y, x - 3, y));
	     }
	     if (Board.isValidPos(x, y + 3) && Board.isEmpty(x, y + 1) && Board.isEmpty(x, y + 2) && Board.isEmpty(x, y + 3)) {
	         mm.add(new Move(x, y, x, y + 3));
	     }
	     if (Board.isValidPos(x, y - 3) && Board.isEmpty(x, y - 1) && Board.isEmpty(x, y - 2) && Board.isEmpty(x, y - 3)) {
	         mm.add(new Move(x, y, x, y - 3));
	     }

	     // Diagonal moves (3 squares)
	     if (Board.isValidPos(x + 3, y + 3) && Board.isEmpty(x + 1, y + 1) && Board.isEmpty(x + 2, y + 2) && Board.isEmpty(x + 3, y + 3)) {
	         mm.add(new Move(x, y, x + 3, y + 3));
	     }
	     if (Board.isValidPos(x + 3, y - 3) && Board.isEmpty(x + 1, y - 1) && Board.isEmpty(x + 2, y - 2) && Board.isEmpty(x + 3, y - 3)) {
	         mm.add(new Move(x, y, x + 3, y - 3));
	     }
	     if (Board.isValidPos(x - 3, y + 3) && Board.isEmpty(x - 1, y + 1) && Board.isEmpty(x - 2, y + 2) && Board.isEmpty(x - 3, y + 3)) {
	         mm.add(new Move(x, y, x - 3, y + 3));
	     }
	     if (Board.isValidPos(x - 3, y - 3) && Board.isEmpty(x - 1, y - 1) && Board.isEmpty(x - 2, y - 2) && Board.isEmpty(x - 3, y - 3)) {
	         mm.add(new Move(x, y, x - 3, y - 3));
	     }

	     // Up/Down/Left/Right moves (1 square) to keep movement flexible
	     // This is optional, remove if only 3 squares movement is needed.
	     if (Board.isValidPos(x + 1, y) && Board.isEmpty(x + 1, y)) {
	         mm.add(new Move(x, y, x + 1, y));
	     }
	     if (Board.isValidPos(x - 1, y) && Board.isEmpty(x - 1, y)) {
	         mm.add(new Move(x, y, x - 1, y));
	     }
	     if (Board.isValidPos(x, y + 1) && Board.isEmpty(x, y + 1)) {
	         mm.add(new Move(x, y, x, y + 1));
	     }
	     if (Board.isValidPos(x, y - 1) && Board.isEmpty(x, y - 1)) {
	         mm.add(new Move(x, y, x, y - 1));
	     }

	     return mm;
	 }


}
 
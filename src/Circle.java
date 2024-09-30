import java.util.HashSet;
import java.util.Set;

public class Circle extends Piece {
	public Circle(Color color, String ID, int value, int startX, int startY) {
			super(color, ID, value, startX, startY);
	}
	
	 @Override
	    public String toString() {
	        return String.format("%sC%d", color, value);
	    }
	 
	 @Override
	 public Set<Move> findMoves(int x, int y, Board board) {
	     Set<Move> mm = new HashSet<>();

	     // Move one square to the right
	     if (Board.isValidPos(x + 1, y) && Board.isEmpty(x + 1, y)) {
	         mm.add(new Move(x, y, x + 1, y));
	     }
	     // Move one square to the left
	     if (Board.isValidPos(x - 1, y) && Board.isEmpty(x - 1, y)) {
	         mm.add(new Move(x, y, x - 1, y));
	     }
	     // Move one square up
	     if (Board.isValidPos(x, y - 1) && Board.isEmpty(x, y - 1)) {
	         mm.add(new Move(x, y, x, y - 1));
	     }
	     // Move one square down
	     if (Board.isValidPos(x, y + 1) && Board.isEmpty(x, y + 1)) {
	         mm.add(new Move(x, y, x, y + 1));
	     }
	     // Move one square diagonally up-right
	     if (Board.isValidPos(x + 1, y - 1) && Board.isEmpty(x + 1, y - 1)) {
	         mm.add(new Move(x, y, x + 1, y - 1));
	     }
	     // Move one square diagonally up-left
	     if (Board.isValidPos(x - 1, y - 1) && Board.isEmpty(x - 1, y - 1)) {
	         mm.add(new Move(x, y, x - 1, y - 1));
	     }
	     // Move one square diagonally down-right
	     if (Board.isValidPos(x + 1, y + 1) && Board.isEmpty(x + 1, y + 1)) {
	         mm.add(new Move(x, y, x + 1, y + 1));
	     }
	     // Move one square diagonally down-left
	     if (Board.isValidPos(x - 1, y + 1) && Board.isEmpty(x - 1, y + 1)) {
	         mm.add(new Move(x, y, x - 1, y + 1));
	     }

	     return mm;
	 }


}

import java.util.HashSet;
import java.util.Set;

public class Triangle extends Piece {
	public Triangle(Color color, String ID, int value, int startX, int startY) {
			super(color, ID, value, startX, startY);
	}
	
	@Override
    public String toString() {
        return String.format("%sT%d", color, value);
    }
	
	@Override
	public Set<Move> findMoves(int x, int y, Board board) {
	    Set<Move> mm = new HashSet<>();

	    // Move two squares horizontally to the right
	    if (Board.isValidPos(x + 2, y) && Board.isEmpty(x + 1, y) && Board.isEmpty(x + 2, y)) {
	        mm.add(new Move(x, y, x + 2, y));
	    }
	    // Move two squares horizontally to the left
	    if (Board.isValidPos(x - 2, y) && Board.isEmpty(x - 1, y) && Board.isEmpty(x - 2, y)) {
	        mm.add(new Move(x, y, x - 2, y));
	    }
	    // Move two squares vertically down
	    if (Board.isValidPos(x, y + 2) && Board.isEmpty(x, y + 1) && Board.isEmpty(x, y + 2)) {
	        mm.add(new Move(x, y, x, y + 2));
	    }
	    // Move two squares vertically up
	    if (Board.isValidPos(x, y - 2) && Board.isEmpty(x, y - 1) && Board.isEmpty(x, y - 2)) {
	        mm.add(new Move(x, y, x, y - 2));
	    }
	    // Move diagonally down-right
	    if (Board.isValidPos(x + 2, y + 1) && Board.isEmpty(x + 2, y + 1)) {
	        mm.add(new Move(x, y, x + 2, y + 1));
	    }
	    // Move diagonally down-left
	    if (Board.isValidPos(x - 2, y + 1) && Board.isEmpty(x - 2, y + 1)) {
	        mm.add(new Move(x, y, x - 2, y + 1));
	    }
	    // Move diagonally up-right
	    if (Board.isValidPos(x + 2, y - 1) && Board.isEmpty(x + 2, y - 1)) {
	        mm.add(new Move(x, y, x + 2, y - 1));
	    }
	    // Move diagonally up-left
	    if (Board.isValidPos(x - 2, y - 1) && Board.isEmpty(x - 2, y - 1)) {
	        mm.add(new Move(x, y, x - 2, y - 1));
	    }
	    // Move one square to the right and two squares up
	    if (Board.isValidPos(x + 1, y - 2) && Board.isEmpty(x + 1, y - 2)) {
	        mm.add(new Move(x, y, x + 1, y - 2));
	    }
	    // Move one square to the left and two squares up
	    if (Board.isValidPos(x - 1, y - 2) && Board.isEmpty(x - 1, y - 2)) {
	        mm.add(new Move(x, y, x - 1, y - 2));
	    }
	    // Move one square to the right and two squares down
	    if (Board.isValidPos(x + 1, y + 2) && Board.isEmpty(x + 1, y + 2)) {
	        mm.add(new Move(x, y, x + 1, y + 2));
	    }
	    // Move one square to the left and two squares down
	    if (Board.isValidPos(x - 1, y + 2) && Board.isEmpty(x - 1, y + 2)) {
	        mm.add(new Move(x, y, x - 1, y + 2));
	    }

	    return mm;
	}

	
	
	

}

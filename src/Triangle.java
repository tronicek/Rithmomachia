import java.util.HashSet;
import java.util.Set;

public class Triangle extends Piece {
	public Triangle(Color color, int value, int row, int col, int moveSpaces) {
			super(color, value, row, col, 2);
	}
	
	@Override
    public String toString() {
        return String.format("%sT%d", color, value);
    }
	
	@Override
	public Set<Move> findMoves(int row, int col, Board board) {
	    Set<Move> mm = new HashSet<>();
	    int distance = 2; // Move 2 squares

	    // Horizontal and vertical moves (distance squares)
	    if (board.isValidPos(row + distance, col)
	            && board.pathIsClear(row, col, row + distance, col, board)) {
	        mm.add(new Move(row, col, row + distance, col));
	    }
	    if (board.isValidPos(row - distance, col)
	            && board.pathIsClear(row, col, row - distance, col, board)) {
	        mm.add(new Move(row, col, row - distance, col));
	    }
	    if (board.isValidPos(row, col + distance)
	            && board.pathIsClear(row, col, row, col + distance, board)) {
	        mm.add(new Move(row, col, row, col + distance));
	    }
	    if (board.isValidPos(row, col - distance)
	            && board.pathIsClear(row, col, row, col - distance, board)) {
	        mm.add(new Move(row, col, row, col - distance));
	    }

	    // Diagonal moves (distance squares)
	    if (board.isValidPos(row + distance, col + distance)
	            && board.pathIsClear(row, col, row + distance, col + distance, board)) {
	        mm.add(new Move(row, col, row + distance, col + distance));
	    }
	    if (board.isValidPos(row + distance, col - distance)
	            && board.pathIsClear(row, col, row + distance, col - distance, board)) {
	        mm.add(new Move(row, col, row + distance, col - distance));
	    }
	    if (board.isValidPos(row - distance, col + distance)
	            && board.pathIsClear(row, col, row - distance, col + distance, board)) {
	        mm.add(new Move(row, col, row - distance, col + distance));
	    }
	    if (board.isValidPos(row - distance, col - distance)
	            && board.pathIsClear(row, col, row - distance, col - distance, board)) {
	        mm.add(new Move(row, col, row - distance, col - distance));
	    }

	    // Knight-like moves
	    if (board.isValidPos(row + 2, col + 1) && board.isEmpty(row + 2, col + 1)) {
	        mm.add(new Move(row, col, row + 2, col + 1));
	    }
	    if (board.isValidPos(row + 2, col - 1) && board.isEmpty(row + 2, col - 1)) {
	        mm.add(new Move(row, col, row + 2, col - 1));
	    }
	    if (board.isValidPos(row - 2, col + 1) && board.isEmpty(row - 2, col + 1)) {
	        mm.add(new Move(row, col, row - 2, col + 1));
	    }
	    if (board.isValidPos(row - 2, col - 1) && board.isEmpty(row - 2, col - 1)) {
	        mm.add(new Move(row, col, row - 2, col - 1));
	    }

	    return mm;
	}


	 
}

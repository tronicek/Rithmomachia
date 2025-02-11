import java.util.HashSet;
import java.util.Set;

public class Square extends Piece {
	public Square(Color color, int value, int row, int col, int moveSpaces) {
		super(color, value, row, col, 3);
	}

	@Override
	public String toString() {
		return String.format("%S%d", color, value);
	}

	@Override
	public Set<Move> findMoves(int row, int col, Board board) {
		Set<Move> mm = new HashSet<>();
		int distance = 3;  // Move 3 squares

		// Horizontal and vertical moves (distance squares)
		if (board.isValidPos(row + distance, col) && board.pathIsClear(row, col, row + distance, col, board)) {
			mm.add(new Move(row, col, row + distance, col));
		}
		if (board.isValidPos(row - distance, col) && board.pathIsClear(row, col, row - distance, col, board)) {
			mm.add(new Move(row, col, row - distance, col));
		}
		if (board.isValidPos(row, col + distance) && board.pathIsClear(row, col, row, col + distance, board)) {
			mm.add(new Move(row, col, row, col + distance));
		}
		if (board.isValidPos(row, col - distance) && board.pathIsClear(row, col, row, col - distance, board)) {
			mm.add(new Move(row, col, row, col - distance));
		}

		// Diagonal moves (distance squares)
		if (board.isValidPos(row + distance, col + distance) && board.pathIsClear(row, col, row + distance, col + distance, board)) {
			mm.add(new Move(row, col, row + distance, col + distance));
		}
		if (board.isValidPos(row + distance, col - distance) && board.pathIsClear(row, col, row + distance, col - distance, board)) {
			mm.add(new Move(row, col, row + distance, col - distance));
		}
		if (board.isValidPos(row - distance, col + distance) && board.pathIsClear(row, col, row - distance, col + distance, board)) {
			mm.add(new Move(row, col, row - distance, col + distance));
		}
		if (board.isValidPos(row - distance, col - distance) && board.pathIsClear(row, col, row - distance, col - distance, board)) {
			mm.add(new Move(row, col, row - distance, col - distance));
		}

		return mm;
	}

	
}
 
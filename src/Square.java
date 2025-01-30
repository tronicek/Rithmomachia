import java.util.HashSet;
import java.util.Set;

public class Square extends Piece{
	public Square(Color color, int value) {
		super(color, value);
	}
	
	 @Override
	    public String toString() {
	        return String.format("%S%d", color, value);
	    }
	 
	 @Override
	 public Set<Move> findMoves(int x, int y, Board board) {
	     Set<Move> mm = new HashSet<>();
	     int distance = 3;  // Move 3 squares

	     // Horizontal and vertical moves (distance squares)
	     if (board.isValidPos(x + distance, y) && board.pathIsClear(x, y, x + distance, y, board)) {
	         mm.add(new Move(x, y, x + distance, y));
	     }
	     if (board.isValidPos(x - distance, y) && board.pathIsClear(x, y, x - distance, y, board)) {
	         mm.add(new Move(x, y, x - distance, y));
	     }
	     if (board.isValidPos(x, y + distance) && board.pathIsClear(x, y, x, y + distance, board)) {
	         mm.add(new Move(x, y, x, y + distance));
	     }
	     if (board.isValidPos(x, y - distance) && board.pathIsClear(x, y, x, y - distance, board)) {
	         mm.add(new Move(x, y, x, y - distance));
	     }

	     // Diagonal moves (distance squares)
	     if (board.isValidPos(x + distance, y + distance) && board.pathIsClear(x, y, x + distance, y + distance, board)) {
	         mm.add(new Move(x, y, x + distance, y + distance));
	     }
	     if (board.isValidPos(x + distance, y - distance) && board.pathIsClear(x, y, x + distance, y - distance, board)) {
	         mm.add(new Move(x, y, x + distance, y - distance));
	     }
	     if (board.isValidPos(x - distance, y + distance) && board.pathIsClear(x, y, x - distance, y + distance, board)) {
	         mm.add(new Move(x, y, x - distance, y + distance));
	     }
	     if (board.isValidPos(x - distance, y - distance) && board.pathIsClear(x, y, x - distance, y - distance, board)) {
	         mm.add(new Move(x, y, x - distance, y - distance));
	     }

	     return mm;
	 }
	 
	 @Override
	 public Set<Pos> capture(int x, int y, Board board) {
	        Set<Pos> pp = new HashSet<>();
	        int distance = 3;
	        if (board.isValidPos(x + distance, y)
	                && board.contains(x + distance, y, value) && board.capturepathIsClear(x, y, x + distance, y, board)) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x + distance, y));
	            
	        }
	        if (board.isValidPos(x - distance, y)
	                && board.contains(x - distance, y, value) && board.capturepathIsClear(x, y, x - distance, y, board)) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x - distance, y));
	        }
	        if (board.isValidPos(x, y + distance)
	                && board.contains(x, y + distance, value) && board.capturepathIsClear(x, y, x, y + distance, board) ) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x, y + distance));
	        }
	        if (board.isValidPos(x, y - distance)
	                && board.contains(x, y - distance, value) && board.capturepathIsClear(x, y, x, y - distance, board)) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x, y - distance));
	            
	        }
	        return pp;
	    }

	 



}
 
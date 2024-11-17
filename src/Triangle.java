import java.util.HashSet;
import java.util.Set;

public class Triangle extends Piece {
	public Triangle(Color color, int value) {
			super(color, value);
	}
	
	@Override
    public String toString() {
        return String.format("%sT%d", color, value);
    }
	
	@Override
	public Set<Move> findMoves(int x, int y, Board board) {
	    Set<Move> mm = new HashSet<>();
	    int distance = 2; // Move 2 squares

	    // Horizontal and vertical moves (distance squares)
	    if (Board.isValidPos(x + distance, y) 
	            && Board.pathIsClear(x, y, x + distance, y, board)) {
	        mm.add(new Move(x, y, x + distance, y));
	    }
	    if (Board.isValidPos(x - distance, y) 
	            && Board.pathIsClear(x, y, x - distance, y, board)) {
	        mm.add(new Move(x, y, x - distance, y));
	    }
	    if (Board.isValidPos(x, y + distance) 
	            && Board.pathIsClear(x, y, x, y + distance, board)) {
	        mm.add(new Move(x, y, x, y + distance));
	    }
	    if (Board.isValidPos(x, y - distance) 
	            && Board.pathIsClear(x, y, x, y - distance, board)) {
	        mm.add(new Move(x, y, x, y - distance));
	    }

	    // Diagonal moves (distance squares)
	    if (Board.isValidPos(x + distance, y + distance) 
	            && Board.pathIsClear(x, y, x + distance, y + distance, board)) {
	        mm.add(new Move(x, y, x + distance, y + distance));
	    }
	    if (Board.isValidPos(x + distance, y - distance) 
	            && Board.pathIsClear(x, y, x + distance, y - distance, board)) {
	        mm.add(new Move(x, y, x + distance, y - distance));
	    }
	    if (Board.isValidPos(x - distance, y + distance) 
	            && Board.pathIsClear(x, y, x - distance, y + distance, board)) {
	        mm.add(new Move(x, y, x - distance, y + distance));
	    }
	    if (Board.isValidPos(x - distance, y - distance) 
	            && Board.pathIsClear(x, y, x - distance, y - distance, board)) {
	        mm.add(new Move(x, y, x - distance, y - distance));
	    }

	    // Knight-like moves
	    if (Board.isValidPos(x + 2, y + 1) && Board.isEmpty(x + 2, y + 1)) {
	        mm.add(new Move(x, y, x + 2, y + 1));
	    }
	    if (Board.isValidPos(x + 2, y - 1) && Board.isEmpty(x + 2, y - 1)) {
	        mm.add(new Move(x, y, x + 2, y - 1));
	    }
	    if (Board.isValidPos(x - 2, y + 1) && Board.isEmpty(x - 2, y + 1)) {
	        mm.add(new Move(x, y, x - 2, y + 1));
	    }
	    if (Board.isValidPos(x - 2, y - 1) && Board.isEmpty(x - 2, y - 1)) {
	        mm.add(new Move(x, y, x - 2, y - 1));
	    }

	    return mm;
	}


	 @Override
	    public Set<Pos> capture(int x, int y, Board board) {
	        Set<Pos> pp = new HashSet<>();
	        int distance = 2;
	        if (Board.isValidPos(x + distance, y)
	                && Board.contains(x + distance, y, value) && Board.capturepathIsClear(x, y, x + distance, y, board)) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x + distance, y));
	            
	        }
	        if (Board.isValidPos(x - distance, y)
	                && Board.contains(x - distance, y, value) && Board.capturepathIsClear(x, y, x - distance, y, board)) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x - distance, y));
	        }
	        if (Board.isValidPos(x, y + distance)
	                && Board.contains(x, y + distance, value) && Board.capturepathIsClear(x, y, x, y + distance, board) ) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x, y + distance));
	        }
	        if (Board.isValidPos(x, y - distance)
	                && Board.contains(x, y - distance, value) && Board.capturepathIsClear(x, y, x, y - distance, board)) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x, y - distance));
	            
	        }
	        return pp;
	    }
	
	
	

}

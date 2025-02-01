import java.util.HashSet;
import java.util.Set;

public class Circle extends Piece {
	public Circle(Color color, int value, int x, int y) {
			super(color, value, x, y);
	}
	
	 @Override
	    public String toString() {
	        return String.format("%sC%d", color, value);
	    }
	 
	 @Override
	 public Set<Move> findMoves(int x, int y, Board board) {
	     Set<Move> mm = new HashSet<>();
	     int distance = 1;  // Move 3 squares

	     // Horizontal and vertical moves (distance squares)
	     if (board.isValidPos(x + distance, y) && board.pathIsClear(x, y, x + distance, y, board)) {
	         mm.add(new Move(x, y, x + distance, y) );
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
	        int distance = 1;
	        

	        if (board.isValidPos(x + distance, y)
	                && board.contains(x + distance, y, value) && board.capturepathIsClear(x, y, x + distance, y, board)  && (board.checkColor( x + distance, y, color))) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x + distance, y));
	            
	        }
	        if (board.isValidPos(x - distance, y)
	                && board.contains(x - distance, y, value) && board.capturepathIsClear(x, y, x - distance, y, board) && (board.checkColor( x - distance, y, color))) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x - distance, y));
	        }
	        if (board.isValidPos(x, y + distance)
	                && board.contains(x, y + distance, value) && board.capturepathIsClear(x, y, x, y + distance, board) && (board.checkColor( x, y + distance, color))) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x, y + distance));
	        }
	        if (board.isValidPos(x, y - distance)
	                && board.contains(x, y - distance, value) && board.capturepathIsClear(x, y, x, y - distance, board) && (board.checkColor( x, y - distance, color)))  {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x, y - distance));
	            
	        }
	        
	        //Diagonal Captures
	        
	        if(board.isValidPos(x + distance, y + distance)
	        		&& board.contains(x + distance, y + distance, value) && board.capturepathIsClear(x, y, x + distance, y + distance, board) && (board.checkColor( x + distance, y + distance, color)) ) {
	        	//System.out.print("Position Conditions met");
	        	pp.add(new Pos(x + distance, y + distance));
	        }
	        if(board.isValidPos(x + distance, y - distance)
	        		&& board.contains(x + distance, y - distance, value) && board.capturepathIsClear(x, y, x + distance, y - distance, board) && (board.checkColor( x + distance, y - distance, color))) {
	        	//System.out.print("Position Conditions met");
	        	pp.add(new Pos(x + distance, y - distance));
	        }
	        if(board.isValidPos(x - distance, y + distance)
	        		&& board.contains(x - distance, y + distance, value) && board.capturepathIsClear(x, y, x - distance, y + distance, board) && (board.checkColor( x - distance, y + distance, color))) {
	        	//System.out.print("Position Conditions met");
	        	pp.add(new Pos(x - distance, y + distance));
	        }
	        if(board.isValidPos(x - distance, y - distance)
	        		&& board.contains(x - distance, y - distance, value) && board.capturepathIsClear(x, y, x - distance, y - distance, board) && (board.checkColor( x - distance, y - distance, color))) {
	        	//System.out.print("Position Conditions met");
	        	pp.add(new Pos(x - distance, y - distance));
	        }
	        return pp;
	    }


}

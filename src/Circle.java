import java.util.HashSet;
import java.util.Set;

public class Circle extends Piece {
	public Circle(Color color, int value) {
			super(color, value);
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
	     if (Board.isValidPos(x + distance, y) && Board.pathIsClear(x, y, x + distance, y, board)) {
	         mm.add(new Move(x, y, x + distance, y) );
	     }
	     if (Board.isValidPos(x - distance, y) && Board.pathIsClear(x, y, x - distance, y, board)) {
	         mm.add(new Move(x, y, x - distance, y));
	     }
	     if (Board.isValidPos(x, y + distance) && Board.pathIsClear(x, y, x, y + distance, board)) {
	         mm.add(new Move(x, y, x, y + distance));
	     }
	     if (Board.isValidPos(x, y - distance) && Board.pathIsClear(x, y, x, y - distance, board)) {
	         mm.add(new Move(x, y, x, y - distance));
	     }

	     // Diagonal moves (distance squares)
	     if (Board.isValidPos(x + distance, y + distance) && Board.pathIsClear(x, y, x + distance, y + distance, board)) {
	         mm.add(new Move(x, y, x + distance, y + distance));
	     }
	     if (Board.isValidPos(x + distance, y - distance) && Board.pathIsClear(x, y, x + distance, y - distance, board)) {
	         mm.add(new Move(x, y, x + distance, y - distance));
	     }
	     if (Board.isValidPos(x - distance, y + distance) && Board.pathIsClear(x, y, x - distance, y + distance, board)) {
	         mm.add(new Move(x, y, x - distance, y + distance));
	     }
	     if (Board.isValidPos(x - distance, y - distance) && Board.pathIsClear(x, y, x - distance, y - distance, board)) {
	         mm.add(new Move(x, y, x - distance, y - distance));
	     }

	     return mm;
	 }
	 
	 @Override
	 public Set<Pos> capture(int x, int y, Board board) {
	        Set<Pos> pp = new HashSet<>();
	        int distance = 1;
	        
	        
	        //Capture by Encounter
	        
	        //Orthogonal Captures
	        if (Board.isValidPos(x + distance, y)
	                && Board.containsSame(x + distance, y, value) && Board.capturepathIsClear(x, y, x + distance, y, board)  && (board.checkColor( x + distance, y, color))) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x + distance, y));
	            
	        }
	        if (Board.isValidPos(x - distance, y)
	                && Board.containsSame(x - distance, y, value) && Board.capturepathIsClear(x, y, x - distance, y, board) && (board.checkColor( x - distance, y, color))) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x - distance, y));
	        }
	        if (Board.isValidPos(x, y + distance)
	                && Board.containsSame(x, y + distance, value) && Board.capturepathIsClear(x, y, x, y + distance, board) && (board.checkColor( x, y + distance, color))) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x, y + distance));
	        }
	        if (Board.isValidPos(x, y - distance)
	                && Board.containsSame(x, y - distance, value) && Board.capturepathIsClear(x, y, x, y - distance, board) && (board.checkColor( x, y - distance, color)))  {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x, y - distance));
	            
	        }
	        
	        //Diagonal Captures
	        
	        if(Board.isValidPos(x + distance, y + distance)
	        		&& Board.containsSame(x + distance, y + distance, value) && Board.capturepathIsClear(x, y, x + distance, y + distance, board) && (board.checkColor( x + distance, y + distance, color)) ) {
	        	//System.out.print("Position Conditions met");
	        	pp.add(new Pos(x + distance, y + distance));
	        }
	        if(Board.isValidPos(x + distance, y - distance)
	        		&& Board.containsSame(x + distance, y - distance, value) && Board.capturepathIsClear(x, y, x + distance, y - distance, board) && (board.checkColor( x + distance, y - distance, color))) {
	        	//System.out.print("Position Conditions met");
	        	pp.add(new Pos(x + distance, y - distance));
	        }
	        if(Board.isValidPos(x - distance, y + distance)
	        		&& Board.containsSame(x - distance, y + distance, value) && Board.capturepathIsClear(x, y, x - distance, y + distance, board) && (board.checkColor( x - distance, y + distance, color))) {
	        	//System.out.print("Position Conditions met");
	        	pp.add(new Pos(x - distance, y + distance));
	        }
	        if(Board.isValidPos(x - distance, y - distance)
	        		&& Board.containsSame(x - distance, y - distance, value) && Board.capturepathIsClear(x, y, x - distance, y - distance, board) && (board.checkColor( x - distance, y - distance, color))) {
	        	//System.out.print("Position Conditions met");
	        	pp.add(new Pos(x - distance, y - distance));
	        }
	        
	        //Eruption Captures
	        
	        if (Board.isValidPos(x + distance, y)
	                && Board.containsSame(x + distance, y, value) && Board.capturepathIsClear(x, y, x + distance, y, board)  && (board.checkColor( x + distance, y, color))) {
	        	//System.out.print("Position Conditions met");
	            pp.add(new Pos(x + distance, y));
	        }
	        
	        int[][] directions = {
	     	        {1, 0},  // Right
	     	        {-1, 0}, // Left
	     	        {0, 1},  // Up
	     	        {0, -1}, // Down
	     	        {1, 1},  // Diagonal up-right
	     	        {-1, -1},// Diagonal down-left
	     	        {1, -1}, // Diagonal down-right
	     	        {-1, 1}  // Diagonal up-left
	     	    };

	     	    for (int[] dir : directions) {
	     	        int dx = dir[0];
	     	        int dy = dir[1];
	     	        int Edistance = 0;

	     	        int currX = x;
	     	        int currY = y;

	     	        while (true) {
	     	            currX += dx;
	     	            currY += dy;
	     	            
	     	            Edistance++;

	     	            // Check if out of bounds
	     	            if (currX < 0 || currX >= board.rows || currY < 0 || currY >= board.cols) {
	     	                System.out.println("Direction (" + dx + "," + dy + "): Edge reached at distance " + Edistance);
	     	                break;
	     	            }

	     	            // Check if square is occupied
	     	            if (!Board.isEmpty(currX, currY)) {
	     	                Piece targetPiece = Board.getPiece(currX, currY);
	     	                int capturingValue = currentPiece.getValue();
	     	                int targetValue = targetPiece.getValue();

	     	                // Check capture conditions
	     	                boolean canCapture = 
	     	                    (capturingValue * Edistance == targetValue) || 
	     	                    (capturingValue / Edistance == targetValue);

	     	                if (canCapture) {
	     	                    System.out.println("Direction (" + dx + "," + dy + "): Piece at distance " + Edistance + " can be captured!");
	     	                } else {
	     	                    System.out.println("Direction (" + dx + "," + dy + "): Piece at distance " + Edistance + " cannot be captured.");
	     	                }

	     	                break; // Stop checking further in this direction
	     	            }
	     	        }
	     	    }

	        
	       
	        return pp;
	    }


}

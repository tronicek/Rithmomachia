
import java.util.HashSet;
import java.util.Set;


public abstract class Piece {
	protected final Color color;
	protected final int value; 
	private int row, col;
	private int moveSpaces;
	
	public Piece( Color color, int value, int row, int col, int moveSpaces) {
		this.color = color;
		this.value = value;
		this.row = row;
		this.col = col;
		this.moveSpaces = moveSpaces;
		
		//Board.setPiece(row, col, this);
	}
	
	public abstract Set<Move> findMoves(int row, int col,Board board);
	
	public abstract Set<Pos> encounterCapture(int row, int col, Board board);
	   
    
	
	// This checks for all possible eruption captures and returns as a Set of Pos.
	// If there are no captures, it will return an empty set.
	public Set<Pos> eruptionCapture(Board board){
		Set<Pos> posECaps = new HashSet<>();
		Set<Piece> neighbors = board.findClosestNeighbors(this.row, this.col);
		if (!neighbors.isEmpty()) {
			for (Piece piece : neighbors) {
				if (piece.color != this.color) {
					int totalSquares = 2;
					int numRows = Math.abs(piece.row - this.row);
					int numCols = Math.abs(piece.col - this.col);
					if (numRows == 0)
						totalSquares = numCols + 1;
					else
						totalSquares = numRows + 1;
					int divValue = 0;
					if (this.value % totalSquares == 0) {
						divValue = this.value / totalSquares;
					}
					int multValue = this.value * totalSquares;
					if (multValue == piece.value || divValue == piece.value) {
						posECaps.add(new Pos(piece.row, piece.col));
					}
				}
			}
		}
		return posECaps;
	}
	/*public Set<Pos> deceitCapture(Board board) {
		Set<Pos> posDCaps = new HashSet<>();
  		Set<Piece> neighbors = board.findClosestNeighbors(this.x, this.y);
    		if (!neighbors.isEmpty()){
      			for(Piece piece1 : neighbors) { // Here making sure two diff pieces
	 			for(Piece piece2 : neighbors){
     					if (piece1 != piece2){ //check if pieces are on opposite sides of piece
	  					boolean isOpposite = (piece1.x == piece2.x || piece1.y == piece2.y);
	
						if (isOpposite) { //check if sum of the values = current piece value
      							if (piece1.value + piece2.value == this.value) { //add both pieces' positions as working deceit captures
	     							posDCaps.add(new Pos(piece1.x, piece1.y));
	     							posDCaps.add(new Pos(piece2.x, piece2.y));
	     						}
	    					}
	  				}
       				}
	   		}
      		}
	}
<<<<<<< HEAD
	
=======
>>>>>>> 222caa7957a3b91c66b162f271a8a91a3909d4b6
	*/
	public Color getColor() {
		return this.color;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getRow() {
		return this.row;
	}
	
	void setRow(int newX) {
		this.row = newX;
	}
	
	public int getCol()
	{
		return this.col;
	}
	
	void setCol(int newY) {
		this.col = newY;
	}
	
	public String nullToString() {
		return "   ";
	}
	public abstract String toString();

}

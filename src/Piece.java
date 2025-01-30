
import java.util.HashSet;
import java.util.Set;


public abstract class Piece {
	protected final Color color;
	protected final int value; 
	private int x, y;
	
	public Piece( Color color, int value) {
		this.color = color;
		this.value = value;
		
		//Board.setPiece(x, y, this);
	}
	
	public abstract Set<Move> findMoves(int x, int y, Board board);
	
	public abstract Set<Pos> capture(int x, int y, Board board);
	   
    
	
	
	public Set<Pos> eruptionCapture(Board board){
		Set<Pos> posECaps = new HashSet<>();
		Set<Piece> neighbors = board.findClosestNeighbors(this.x, this.y);
		if (!neighbors.isEmpty()) {
			for (Piece piece : neighbors) {
				int totalSquares = 2;
				int numSquaresX = Math.abs(piece.x - this.x);
				int numSquaresY = Math.abs(piece.y - this.y);
				if (numSquaresX == 0)
					totalSquares = numSquaresY+1;
				else
					totalSquares = numSquaresX+1;
				int divValue = 0;
				if (this.value % totalSquares==0){
					divValue = this.value / totalSquares;
				}
				int multValue = this.value*totalSquares;
				if (piece.color != this.color) {
					if (multValue == piece.value || divValue == piece.value) {
						posECaps.add(new Pos(piece.x, piece.y));
					}
				}
			}
		}
		return posECaps;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getX() {
		return this.x;
	}
	
	void setX(int newX) {
		this.x = newX;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	void setY(int newY) {
		this.y = newY;
	}
	
	public String nullToString() {
		return "   ";
	}
	public abstract String toString();

}

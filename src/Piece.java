
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

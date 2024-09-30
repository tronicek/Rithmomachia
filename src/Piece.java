
import java.util.Set;

public abstract class Piece {
	protected final Color color;
	protected final int value; 
	private String ID;
	private int x, y;
	
	public Piece( Color color, String ID, int value, int startX, int startY) {
		this.color = color;
		this.ID = ID;
		this.x = startX;
		this.y = startY;
		this.value = value;
		
		Board.setPiece(x, y, this);
	}
	
	public abstract Set<Move> findMoves(int x, int y, Board board);
	   
    
	
	
	public String getID() {
		return this.ID;
	}
	
	public Color getColor() {
		return this.color;
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

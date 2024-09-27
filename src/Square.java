
public class Square extends Piece{
	public Square(Color color, String ID, int startX, int startY) {
		super(color, ID, startX, startY);
	}
	
	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE ) {
			return "WS";
		}
		return "BS";
	}

}
 
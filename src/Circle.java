
public class Circle extends Piece {
	public Circle(Color color, String ID, int startX, int startY) {
			super(color, ID, startX, startY);
	}
	
	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE ) {
			return "WC";
		}
		return "BC";
	}

}

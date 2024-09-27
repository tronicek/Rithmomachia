
public class Triangle extends Piece {
	public Triangle(Color color, String ID, int startX, int startY) {
			super(color, ID, startX, startY);
	}
	
	@Override
	public String toString() {
		if (this.getColor() == Color.WHITE ) {
			return "WT";
		}
		return "BT";
	}

}

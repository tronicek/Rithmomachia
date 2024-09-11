public class Triangle extends Piece {
    public Triangle(int value, String color) {
        super("Triangle", value, 3, color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {// Calculate the difference in X and Y coordinates
    int deltaX = Math.abs(endX - startX);
    int deltaY = Math.abs(endY - startY);

    // A valid move is when deltaX and/or deltaY are either 0, 2, or both
    if ((deltaX == 0 || deltaX == 2) && (deltaY == 0 || deltaY == 2)) {
        return true;
    }

    return false;
}

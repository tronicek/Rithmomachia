public class Square extends Piece {
    public Square(int value, String color) {
        super("Square", value, 4, color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
      // Calculate the difference in X and Y coordinates
    int deltaX = Math.abs(endX - startX);
    int deltaY = Math.abs(endY - startY);

    // A valid move is when deltaX and/or deltaY are either 0, 2, or both
    if ((deltaX == 0 || deltaX == 3) && (deltaY == 0 || deltaY == 3)) {
        // You can add additional checks here if needed (e.g., ensuring the end position is valid)
        return true;
    }

    return false;
}

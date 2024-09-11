public class Circle extends Piece {
    public Circle(int value, String color) {
        super("Circle", value, 1, color);
    }

    @Override
    public boolean isValidMove(int startX, int startY, int endX, int endY, Board board) {
        // Calculate the difference in X and Y coordinates
    int deltaX = Math.abs(endX - startX);
    int deltaY = Math.abs(endY - startY);

    // A valid king move is either one square in any direction
    // deltaX and deltaY should both be 0, 1, or both
    if (deltaX <= 1 && deltaY <= 1) {
        return true;
    }

    return false;
}
}

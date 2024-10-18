public class Board {
    private Piece[][] grid = new Piece[8][16];

    public Board() {
        initializePieces();
    }

    private void initializePieces() {
        // Initialize Black Pieces
        
        // Initialize White Pieces

    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = grid[startX][startY];
        if (piece != null && piece.isValidMove(startX, startY, endX, endY, this)) {
            grid[endX][endY] = piece;
            grid[startX][startY] = null;
            return true;
        }
        return false;
    }

    public Piece getPieceAt(int x, int y) {
        return grid[x][y];
    }
}

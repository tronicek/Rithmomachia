package rithmomachia;

import java.util.HashSet;
import java.util.Set;


public abstract class Piece {
    protected final Color color;
    private int value;
    private int row, col;
    private int moveSpaces;
    private String shape;

    public Piece(Color color, int value, int row, int col, int moveSpaces, String shape) {
        this.color = color;
        this.value = value;
        this.row = row;
        this.col = col;
        this.moveSpaces = moveSpaces;
        this.shape = shape.toUpperCase();

        //Board.setPiece(row, col, this);
    }

    // What is row col? The piece's current row and col??? Do we need this??
    public Set<Move> findMoves(int row, int col, Board board) {
        Set<Move> mm = new HashSet<>();
        int distance = getMoveSpaces();

        // Horizontal and vertical moves (distance squares)
        if (board.isValidPos(row + distance, col) && board.pathIsClear(row, col, row + distance, col, board)) {
            mm.add(new Move(row, col, row + distance, col));
        }
        if (board.isValidPos(row - distance, col) && board.pathIsClear(row, col, row - distance, col, board)) {
            mm.add(new Move(row, col, row - distance, col));
        }
        if (board.isValidPos(row, col + distance) && board.pathIsClear(row, col, row, col + distance, board)) {
            mm.add(new Move(row, col, row, col + distance));
        }
        if (board.isValidPos(row, col - distance) && board.pathIsClear(row, col, row, col - distance, board)) {
            mm.add(new Move(row, col, row, col - distance));
        }

        // Diagonal moves (distance squares)
        if (board.isValidPos(row + distance, col + distance) && board.pathIsClear(row, col, row + distance, col + distance, board)) {
            mm.add(new Move(row, col, row + distance, col + distance));
        }
        if (board.isValidPos(row + distance, col - distance) && board.pathIsClear(row, col, row + distance, col - distance, board)) {
            mm.add(new Move(row, col, row + distance, col - distance));
        }
        if (board.isValidPos(row - distance, col + distance) && board.pathIsClear(row, col, row - distance, col + distance, board)) {
            mm.add(new Move(row, col, row - distance, col + distance));
        }
        if (board.isValidPos(row - distance, col - distance) && board.pathIsClear(row, col, row - distance, col - distance, board)) {
            mm.add(new Move(row, col, row - distance, col - distance));
        }

        // Knight-like moves

        if (getMoveSpaces() == 2) {

            if (board.isValidPos(row + 2, col + 1) && board.isEmpty(row + 2, col + 1)) {
                mm.add(new Move(row, col, row + 2, col + 1));
            }
            if (board.isValidPos(row + 2, col - 1) && board.isEmpty(row + 2, col - 1)) {
                mm.add(new Move(row, col, row + 2, col - 1));
            }
            if (board.isValidPos(row - 2, col + 1) && board.isEmpty(row - 2, col + 1)) {
                mm.add(new Move(row, col, row - 2, col + 1));
            }
            if (board.isValidPos(row - 2, col - 1) && board.isEmpty(row - 2, col - 1)) {
                mm.add(new Move(row, col, row - 2, col - 1));
            }

        }

        return mm;
    }

    public Set<Pos> captureBySiege(Board board) {
        Set<Pos> capturedPositions = new HashSet<>();
        boolean orthogonalBlocked = true;
        boolean diagonalBlocked = true;
        // Check all four orthogonal directions
        int[][] orthogonalMoves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] move : orthogonalMoves) {
            int newRow = this.row + move[0];
            int newCol = this.col + move[1];
            // Check if the position is valid
            if (!board.isValidPos(newRow, newCol)) {
                orthogonalBlocked = false;  // If out of bounds, not blocked
                continue;
            }
            Piece neighbor = board.getPiece(newRow, newCol);
            if (neighbor == null || neighbor.getColor() == this.color) {
                orthogonalBlocked = false;  // If empty or friendly piece, not blocked
            }
        }
        // Check all four diagonal directions
        int[][] diagonalMoves = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int[] move : diagonalMoves) {
            int newRow = this.row + move[0];
            int newCol = this.col + move[1];
            if (!board.isValidPos(newRow, newCol)) {
                diagonalBlocked = false;
                continue;
            }
            Piece neighbor = board.getPiece(newRow, newCol);
            if (neighbor == null || neighbor.getColor() == this.color) {
                diagonalBlocked = false;
            }
        }
        // Capture if surrounded in any one pattern (either all orthogonal or all diagonal)
        if (orthogonalBlocked || diagonalBlocked) {
            capturedPositions.add(new Pos(this.row, this.col));
        }
        return capturedPositions;
    }


    // What is row col? The piece's current row and col??? Do we need this??
    public Set<Pos> captureByEncounter(Board board) {
        Set<Pos> pp = new HashSet<>();

        if (board.isValidPos(row + moveSpaces, col)
                && board.contains(row + moveSpaces, col, value) && board.capturepathIsClear(row, col, row + moveSpaces, col, board) && (board.checkColor(row + moveSpaces, col, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row + moveSpaces, col));

        }
        if (board.isValidPos(row - moveSpaces, col)
                && board.contains(row - moveSpaces, col, value) && board.capturepathIsClear(row, col, row - moveSpaces, col, board) && (board.checkColor(row - moveSpaces, col, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row - moveSpaces, col));
        }
        if (board.isValidPos(row, col + moveSpaces)
                && board.contains(row, col + moveSpaces, value) && board.capturepathIsClear(row, col, row, col + moveSpaces, board) && (board.checkColor(row, col + moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row, col + moveSpaces));
        }
        if (board.isValidPos(row, col - moveSpaces)
                && board.contains(row, col - moveSpaces, value) && board.capturepathIsClear(row, col, row, col - moveSpaces, board) && (board.checkColor(row, col - moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row, col - moveSpaces));

        }

        //Diagonal Captures

        if (board.isValidPos(row + moveSpaces, col + moveSpaces)
                && board.contains(row + moveSpaces, col + moveSpaces, value) && board.capturepathIsClear(row, col, row + moveSpaces, col + moveSpaces, board) && (board.checkColor(row + moveSpaces, col + moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row + moveSpaces, col + moveSpaces));
        }
        if (board.isValidPos(row + moveSpaces, col - moveSpaces)
                && board.contains(row + moveSpaces, col - moveSpaces, value) && board.capturepathIsClear(row, col, row + moveSpaces, col - moveSpaces, board) && (board.checkColor(row + moveSpaces, col - moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row + moveSpaces, col - moveSpaces));
        }
        if (board.isValidPos(row - moveSpaces, col + moveSpaces)
                && board.contains(row - moveSpaces, col + moveSpaces, value) && board.capturepathIsClear(row, col, row - moveSpaces, col + moveSpaces, board) && (board.checkColor(row - moveSpaces, col + moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row - moveSpaces, col + moveSpaces));
        }
        if (board.isValidPos(row - moveSpaces, col - moveSpaces)
                && board.contains(row - moveSpaces, col - moveSpaces, value) && board.capturepathIsClear(row, col, row - moveSpaces, col - moveSpaces, board) && (board.checkColor(row - moveSpaces, col - moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row - moveSpaces, col - moveSpaces));
        }
        return pp;
    }


    // This checks for all possible eruption captures and returns as a Set of Pos.
    // If there are no captures, it will return an empty set.
    public Set<Pos> captureByEruption(Board board) {
        Set<Pos> posECaps = new HashSet<>();
        Set<Piece> neighbors = board.findClosestNeighbors(this.row, this.col);
        if (!neighbors.isEmpty()) {
            for (Piece piece : neighbors) {
                if (piece.color != this.color) {
                    int totalSquares = 2;
                    int numRows = Math.abs(piece.row - this.row);
                    int numCols = Math.abs(piece.col - this.col);
                    if (numRows == 0)
                        totalSquares = numCols + 1;
                    else
                        totalSquares = numRows + 1;
                    int divValue = 0;
                    if (this.value % totalSquares == 0) {
                        divValue = this.value / totalSquares;
                    }
                    int multValue = this.value * totalSquares;
                    if (multValue == piece.value || divValue == piece.value) {
                        posECaps.add(new Pos(piece.row, piece.col));
                    }
                }
            }
        }
        return posECaps;
    }

    /*public Set<Pos> deceitCapture(Board board) {
        Set<Pos> posDCaps = new HashSet<>();
          Set<Piece> neighbors = board.findClosestNeighbors(this.x, this.y);
            if (!neighbors.isEmpty()){
                  for(Piece piece1 : neighbors) { // Here making sure two diff pieces
                 for(Piece piece2 : neighbors){
                         if (piece1 != piece2){ //check if pieces are on opposite sides of piece
                          boolean isOpposite = (piece1.x == piece2.x || piece1.y == piece2.y);

                        if (isOpposite) { //check if sum of the values = current piece value
                                  if (piece1.value + piece2.value == this.value) { //add both pieces' positions as working deceit captures
                                     posDCaps.add(new Pos(piece1.x, piece1.y));
                                     posDCaps.add(new Pos(piece2.x, piece2.y));
                                 }
                            }
                      }
                       }
               }
              }
    }

    */
    public Color getColor() {
        return this.color;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRow() {
        return this.row;
    }

    public int getMoveSpaces() {
        return this.moveSpaces;
    }

    private void setMoveSpaces(int moveSpaces) {
        this.moveSpaces = moveSpaces;
    }

    public String getShape() {
        return this.shape;
    }

    protected void setShape(String shape) {
        if (shape.equalsIgnoreCase(this.getShape())) {
            return;
        }
        switch (shape.toLowerCase()) {
            case "c":
                this.setMoveSpaces(1);
                break;
            case "t":
                this.setMoveSpaces(2);
                break;
            case "s":
                this.setMoveSpaces(3);
                break;
            default:
                return;
        }
        this.shape = shape.toUpperCase();
    }

    void setRow(int newRow) {
        this.row = newRow;
    }

    public int getCol() {
        return this.col;
    }

    void setCol(int newCol) {
        this.col = newCol;
    }

    public String nullToString() {
        return "   ";
    }

    public String toString() {
        return String.format("%s%s%d", color, shape, value);
    }

}
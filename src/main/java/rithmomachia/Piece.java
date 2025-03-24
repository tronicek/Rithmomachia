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
    public Set<Move> findMoves(Board board) {
        Set<Move> mm = new HashSet<>();
        int distance = getMoveSpaces();

        // Horizontal and vertical moves (distance squares)
        if (board.isValidPos(this.row + distance, this.col) && board.pathIsClear(this.row, this.col, this.row + distance, this.col, board)) {
            mm.add(new Move(this.row, this.col, this.row + distance, this.col));
        }
        if (board.isValidPos(this.row - distance, this.col) && board.pathIsClear(this.row, this.col, this.row - distance, this.col, board)) {
            mm.add(new Move(this.row, this.col, this.row - distance, this.col));
        }
        if (board.isValidPos(this.row, this.col + distance) && board.pathIsClear(this.row, this.col, this.row, this.col + distance, board)) {
            mm.add(new Move(this.row, this.col, this.row, this.col + distance));
        }
        if (board.isValidPos(this.row, this.col - distance) && board.pathIsClear(this.row, this.col, this.row, this.col - distance, board)) {
            mm.add(new Move(this.row, this.col, this.row, this.col - distance));
        }

        // Diagonal moves (distance squares)
        if (board.isValidPos(this.row + distance, this.col + distance) && board.pathIsClear(this.row, this.col, this.row + distance, this.col + distance, board)) {
            mm.add(new Move(this.row, this.col, this.row + distance, this.col + distance));
        }
        if (board.isValidPos(this.row + distance, this.col - distance) && board.pathIsClear(this.row, this.col, this.row + distance, this.col - distance, board)) {
            mm.add(new Move(this.row, this.col, this.row + distance, this.col - distance));
        }
        if (board.isValidPos(this.row - distance, this.col + distance) && board.pathIsClear(this.row, this.col, this.row - distance, this.col + distance, board)) {
            mm.add(new Move(this.row, this.col, this.row - distance, this.col + distance));
        }
        if (board.isValidPos(this.row - distance, this.col - distance) && board.pathIsClear(this.row, this.col, this.row - distance, this.col - distance, board)) {
            mm.add(new Move(this.row, this.col, this.row - distance, this.col - distance));
        }

        // Knight-like moves

        if (getMoveSpaces() == 2) {

            if (board.isValidPos(this.row + 2, this.col + 1) && board.isEmpty(this.row + 2, this.col + 1)) {
                mm.add(new Move(this.row, this.col, this.row + 2, this.col + 1));
            }
            if (board.isValidPos(this.row + 2, this.col - 1) && board.isEmpty(this.row + 2, this.col - 1)) {
                mm.add(new Move(this.row, this.col, this.row + 2, this.col - 1));
            }
            if (board.isValidPos(this.row - 2, this.col + 1) && board.isEmpty(this.row - 2, this.col + 1)) {
                mm.add(new Move(this.row, this.col, this.row - 2, this.col + 1));
            }
            if (board.isValidPos(this.row - 2, this.col - 1) && board.isEmpty(this.row - 2, this.col - 1)) {
                mm.add(new Move(this.row, this.col, this.row - 2, this.col - 1));
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
    // Have to rework this so it can capture pyramids as either a whole or a part.
    // Thought:
    //  Set<Pos> pp = new HashSet<>();
    //  board.findClosestNeighbors(this.row, this.col);
    //      for (Piece neighbor : board.findClosestNeighbors(this.row, this.col)){
    //          for(Piece pieceInSet : neighbor.getPieceAsSet){
    //              int neighborRow = pieceInSet.getRow();
    //              int neighborCol = pieceInSet.getCol();
    //              if (board.distanceBetween(this, pieceInSet) == this.moveSpaces + 1
    //                  && this.color != pieceInSet.getColor()
    //                  && this.value == pieceInSet.getValue()){
    //                      pp.add(new Pos(pieceInSet.getRow(), pieceInSet.getCol()));
    //              }
    //          }
    //      }
    //  return pp;
    // That's it. That's the function.
    public Set<Pos> captureByEncounter(Board board) {
        Set<Pos> pp = new HashSet<>();

        if (board.isValidPos(row + moveSpaces, col)
                && board.contains(row + moveSpaces, col, value) && board.capturePathIsClear(row, col, row + moveSpaces, col, board) && (board.checkColor(row + moveSpaces, col, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row + moveSpaces, col));

        }
        if (board.isValidPos(row - moveSpaces, col)
                && board.contains(row - moveSpaces, col, value) && board.capturePathIsClear(row, col, row - moveSpaces, col, board) && (board.checkColor(row - moveSpaces, col, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row - moveSpaces, col));
        }
        if (board.isValidPos(row, col + moveSpaces)
                && board.contains(row, col + moveSpaces, value) && board.capturePathIsClear(row, col, row, col + moveSpaces, board) && (board.checkColor(row, col + moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row, col + moveSpaces));
        }
        if (board.isValidPos(row, col - moveSpaces)
                && board.contains(row, col - moveSpaces, value) && board.capturePathIsClear(row, col, row, col - moveSpaces, board) && (board.checkColor(row, col - moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row, col - moveSpaces));

        }

        //Diagonal Captures

        if (board.isValidPos(row + moveSpaces, col + moveSpaces)
                && board.contains(row + moveSpaces, col + moveSpaces, value) && board.capturePathIsClear(row, col, row + moveSpaces, col + moveSpaces, board) && (board.checkColor(row + moveSpaces, col + moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row + moveSpaces, col + moveSpaces));
        }
        if (board.isValidPos(row + moveSpaces, col - moveSpaces)
                && board.contains(row + moveSpaces, col - moveSpaces, value) && board.capturePathIsClear(row, col, row + moveSpaces, col - moveSpaces, board) && (board.checkColor(row + moveSpaces, col - moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row + moveSpaces, col - moveSpaces));
        }
        if (board.isValidPos(row - moveSpaces, col + moveSpaces)
                && board.contains(row - moveSpaces, col + moveSpaces, value) && board.capturePathIsClear(row, col, row - moveSpaces, col + moveSpaces, board) && (board.checkColor(row - moveSpaces, col + moveSpaces, color))) {
            //Scolstem.out.print("Position Conditions met");
            pp.add(new Pos(row - moveSpaces, col + moveSpaces));
        }
        if (board.isValidPos(row - moveSpaces, col - moveSpaces)
                && board.contains(row - moveSpaces, col - moveSpaces, value) && board.capturePathIsClear(row, col, row - moveSpaces, col - moveSpaces, board) && (board.checkColor(row - moveSpaces, col - moveSpaces, color))) {
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
                    Set<Piece> pieceAsSet = piece.getPieceAsSet();
                    for (Piece setPiece : pieceAsSet) {
                        int totalSquares = 2;
                        int numRows = Math.abs(setPiece.row - this.row);
                        int numCols = Math.abs(setPiece.col - this.col);
                        if (numRows == 0)
                            totalSquares = numCols + 1;
                        else
                            totalSquares = numRows + 1;
                        int divValue = 0;
                        if (this.value % totalSquares == 0) {
                            divValue = this.value / totalSquares;
                        }
                        int multValue = this.value * totalSquares;
                        if (multValue == setPiece.value || divValue == setPiece.value) {
                            posECaps.add(new Pos(setPiece.row, setPiece.col));
                        }
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

    public Set<Piece> getPieceAsSet(){
        Set<Piece> pieceAsSet = new HashSet<>();
        pieceAsSet.add(this);
        return pieceAsSet;
    }

    public String nullToString() {
        return "   ";
    }

    public String toString() {
        return String.format("%s%s%d", color, shape, value);
    }
}
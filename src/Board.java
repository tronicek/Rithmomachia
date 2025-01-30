import java.util.HashSet;
import java.util.Set;

public class Board {
    private int rows; //Number of Rows
    private int cols; //Number of Columns
    private Piece[][] pieces;

        Board(int numRows, int numCols, String[] str) {
        	initBoard(numRows,numCols);
        	//System.out.println("Start [0, 0]: " + pieces[0][0]);
        	//System.out.println("After 'pieces' are added [0, 0]: " + pieces[0][0]);
        	for (int i = 0; i < str.length; i++) {
        	    String[] t = str[i].split(" +");
        	    for (int j = 0; j < t.length; j++) {
        	        //System.out.println("Placing piece at [" + i + "][" + j + "]: " + t[j]);
        	        pieces[i][j] = fromString(t[j], i, j);
        	        //System.out.println("Piece at [0, 0]: " + pieces[0][0]);
        	        
        	    }
        	}
        }

        private static Piece fromString(String s, int row, int col) {
            if (s.charAt(0) == '-') {
                return null;
            }
            Color c = switch (s.charAt(0)) {
                case 'B' -> Color.B;
                case 'W' -> Color.W;
                default -> {
                    throw new AssertionError();
                }
            };
            int value = Integer.valueOf(s.substring(2));
            switch (s.charAt(1)) {
                case 'C':
                    return new Circle(c, value, row, col);
                case 'S':
                    return new Square(c, value, row, col);
                case 'T':
                    return new Triangle(c, value, row, col);
                default:
                    throw new AssertionError();
            }
        }
   
	
	
	private void initBoard(int numRows, int numCols) {
		rows = numRows;
		cols = numCols;
		pieces = new Piece[rows][cols];
	}

    public void printBoard() {
        // Print the numbers at the top for the columns
        System.out.print("    ");
        for (int i = 1; i <= cols; i++) {
            System.out.printf("%9d", i);
        }
        System.out.println();

        // Horizontal separator line for dynamic column size
        System.out.print("    ");
        for (int i = 0; i < cols; i++) {
            System.out.print("----------");
        }
        System.out.println();

        // Letters on the sides for the rows
        char letter = 'a';
        for (int i = 0; i < rows; i++) {
            System.out.printf(" %c |", letter);  // Print the letter for the row
            for (int j = 0; j < cols; j++) {
                if (pieces[i][j] == null) {
                    System.out.print("         |");  // Empty space if no piece
                } else {
                    System.out.printf("%-8s|", pieces[i][j]);  // Piece name
                }
            }
            System.out.printf(" %c", letter);  // Print the letter at the end of the row
            letter++;
            System.out.println();

            // Horizontal separator line for dynamic column size
            System.out.print("    ");
            for (int k = 0; k < cols; k++) {
                System.out.print("----------");
            }
            System.out.println();
        }

        // Print the column numbers again at the bottom
        System.out.print("    ");
        for (int i = 1; i <= cols; i++) {
            System.out.printf("%9d", i);
        }
        System.out.println();
    }


   /* static void startGame() {
        // Initializes black pieces
        new Circle(Color.B, 3, 5, 2);
        new Circle(Color.B, 5, 5, 3);
        new Circle(Color.B, 7, 5, 4);
        new Circle(Color.B, 9, 5, 5);
        new Circle(Color.B, 9, 4, 2);
        new Circle(Color.B, 25, 4, 3);
        new Circle(Color.B, 49, 4, 4);
        new Circle(Color.B, 81, 4, 5);

        new Triangle(Color.B, 16, 4, 0);
        new Triangle(Color.B, 12, 4, 1);
        new Triangle(Color.B, 90, 4, 6);
        new Triangle(Color.B, 100, 4, 7);
        new Triangle(Color.B, 36, 3, 2);
        new Triangle(Color.B, 30, 3, 3);
        new Triangle(Color.B, 56, 3, 4);
        new Triangle(Color.B, 64, 3, 5);

        new Square(Color.B, 49, 2, 0);
        new Square(Color.B, 28, 3, 0);
        new Square(Color.B, 121, 2, 1);
        new Square(Color.B, 66, 3, 1);
        new Square(Color.B, 225, 2, 6);
        new Square(Color.B, 120, 3, 6);
        new Square(Color.B, 361, 2, 7);

        // Initializes white pieces
        new Circle(Color.W, 8, 10, 2);
        new Circle(Color.W, 6, 10, 3);
        new Circle(Color.W, 4, 10, 4);
        new Circle(Color.W, 2, 10, 5);
        new Circle(Color.W, 64, 11, 2);
        new Circle(Color.W, 36, 11, 3);
        new Circle(Color.W, 16, 11, 4);
        new Circle(Color.W, 4, 11, 5);

        new Triangle(Color.W, 81, 11, 0);
        new Triangle(Color.W, 72, 11, 1);
        new Triangle(Color.W, 6, 11, 6);
        new Triangle(Color.W, 9, 11, 7);
        new Triangle(Color.W, 49, 12, 2);
        new Triangle(Color.W, 42, 12, 3);
        new Triangle(Color.W, 20, 12, 4);
        new Triangle(Color.W, 25, 12, 5);

        new Square(Color.W, 153, 12, 0);
        new Square(Color.W, 289, 13, 0);
        new Square(Color.W, 169, 13, 1);
        new Square(Color.W, 45, 12, 6);
        new Square(Color.W, 81, 13, 6);
        new Square(Color.W, 15, 12, 7);
        new Square(Color.W, 25, 13, 7);
    }*/
    
    
    
    public boolean isValidPos(int x, int y) {
    	//System.out.print("isValidPos called: ");
    	return x >= 0 && x < rows && y >= 0 && y < cols;
    	
    }

    public Set<Piece> findClosestNeighbors(int xStart, int yStart){
        Set<Piece> neighbors = new HashSet<>();
        if (findClosestRight(xStart, yStart)!=null)
            neighbors.add(findClosestRight(xStart, yStart));
        if (findClosestLeft(xStart, yStart)!=null)
            neighbors.add(findClosestLeft(xStart, yStart));
        if (findClosestUp(xStart, yStart)!=null)
            neighbors.add(findClosestUp(xStart, yStart));
        if (findClosestDown(xStart, yStart)!=null)
            neighbors.add(findClosestDown(xStart, yStart));
        if (findClosestUpRight(xStart, yStart)!=null)
            neighbors.add(findClosestUpRight(xStart, yStart));
        if (findClosestUpLeft(xStart, yStart)!=null)
            neighbors.add(findClosestUpLeft(xStart, yStart));
        if (findClosestDownRight(xStart, yStart)!=null)
            neighbors.add(findClosestDownRight(xStart, yStart));
        if (findClosestDownLeft(xStart, yStart)!=null)
            neighbors.add(findClosestDownLeft(xStart, yStart));
        return neighbors;
    }

    public Piece findClosestRight(int row, int col) {
        for (int i = col+1; i<this.cols; i++){
            if (!this.isEmpty(row, i)) {
                return this.getPiece(row, i);
            }
        }
        return null;
    }

    public Piece findClosestLeft(int row, int col) {
        for (int i = col -1; i>=0; i--){
            if (!this.isEmpty(row, i)) {
                return this.getPiece(row, i);
            }
        }
        return null;
    }

    public Piece findClosestUp(int row, int col) {
        for (int i = row-1; i>=0; i--){
            if (!this.isEmpty(i, col)) {
                return this.getPiece(i, col);
            }
        }
        return null;
    }

    public Piece findClosestDown(int row, int col) {
        for (int i = row+1; i<this.rows; i++){
            if (!this.isEmpty(i, col)) {
                return this.getPiece(i, col);
            }
        }
        return null;
    }

    public Piece findClosestUpRight(int row, int col) {
        for (int i = row-1, j = col+1; i>=0 && j<this.cols; i--, j++){
            if (!this.isEmpty(i, j)) {
                return this.getPiece(i, j);
            }
        }
        return null;
    }

    public Piece findClosestDownRight(int row, int col) {
        for (int i = row+1, j = col+1; i<this.rows && j<this.cols; i++, j++){
            if (!this.isEmpty(i, j)) {
                return this.getPiece(i, j);
            }
        }
        return null;
    }

    public Piece findClosestUpLeft(int row, int col) {
        for (int i = row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if (!this.isEmpty(i, j)) {
                return this.getPiece(i, j);
            }
        }
        return null;
    }

    public Piece findClosestDownLeft(int row, int col) {
        for (int i = row+1, j = col-1; i<this.rows && j>=0; i++, j--){
            if (!this.isEmpty(i, j)) {
                return this.getPiece(i, j);
            }
        }
        return null;
    }
    
    public boolean isEmpty(int x, int y) {
    	if(!isValidPos(x,y)) {
    		return false;
    	}
    	
    	return pieces[x][y] == null;
    }
    
 // Helper method to check if the path is clear
 	 public boolean pathIsClear(int x1, int y1, int x2, int y2, Board board) {
         // Determine the direction of movement
         int dx = Integer.signum(x2 - x1); // Direction along x-axis
         int dy = Integer.signum(y2 - y1); // Direction along y-axis

         // Loop over each square between (x1, y1) and (x2, y2)
         for (int i = 1; i < Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)); i++) {
             int nextX = x1 + i * dx; // The x-coordinate of the next square along the path
             int nextY = y1 + i * dy; // The y-coordinate of the next square along the path

             // If any square along the path is not empty, the path is blocked
             if (!board.isEmpty(nextX, nextY)) {
                 return false; // Path is blocked by another piece
             }
         }

         // Check if the destination square (x2, y2) is empty
         // If it's occupied, the piece cannot move there
         if (!board.isEmpty(x2, y2)) {
             return false; // Target square is occupied
         }

         // If all squares are empty and the target square is not occupied, the path is clear
         return true;
     }
 	 
 	public boolean capturepathIsClear(int x1, int y1, int x2, int y2, Board board) {
        // Determine the direction of movement
        int dx = Integer.signum(x2 - x1); // Direction along x-axis
        int dy = Integer.signum(y2 - y1); // Direction along y-axis

        // Loop over each square between (x1, y1) and (x2, y2)
        for (int i = 1; i < Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1)); i++) {
            int nextX = x1 + i * dx; // The x-coordinate of the next square along the path
            int nextY = y1 + i * dy; // The y-coordinate of the next square along the path

            // If any square along the path is not empty, the path is blocked
            if (!board.isEmpty(nextX, nextY)) {
                return false; // Path is blocked by another piece
            }
        }


        // If all squares are empty and the target square is not occupied, the path is clear
        return true;
    }
 	 
 	public boolean contains(int x, int y, int value) {
 		//System.out.print("Contains function called");
 	    // Check if the position (x, y) contains a piece with the specific value.
 	    Piece piece = getPiece(x, y); // Retrieves the piece at position (x, y)
 	    if (piece != null && piece.getValue() == value) {
 	        return true; // Return true if the piece has the same value
 	    }
 	    return false;
 	}
 	
 	//Check if a piece is the same as another piece
 	public boolean checkColor(int x, int y, Color c) {
 		Piece piece = getPiece(x,y);
 		if (piece.getColor() == c) {
 			return false;
 		}
 		return true;
 	}

    

    public void setPiece(int x, int y, Piece piece) {
        if (piece != null) {
            piece.setX(x);
            piece.setY(y);
        }
        pieces[y][x] = piece;
    }

    public Piece getPiece(int x, int y) {
        return pieces[x][y];
    }
}

public class Board {
    static int rows; //Number of Rows
    static int cols; //Number of Columns
	
	static Piece[][] board;
	
	public static void initBoard(int numRows, int numCols) {
		rows = numRows;
		cols = numCols;
		board = new Piece[rows][cols];
	}

    static void printBoard() {
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
                if (board[i][j] == null) {
                    System.out.print("         |");  // Empty space if no piece
                } else {
                    System.out.printf("%-8s|", board[i][j]);  // Piece name
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


    static void startGame() {
        // Initializes black pieces
        new Circle(Color.B, "circle3", 3, 5, 2);
        new Circle(Color.B, "circle5", 5, 5, 3);
        new Circle(Color.B, "circle7", 7, 5, 4);
        new Circle(Color.B, "circle9", 9, 5, 5);
        new Circle(Color.B, "circle9", 9, 4, 2);
        new Circle(Color.B, "circle25", 25, 4, 3);
        new Circle(Color.B, "circle49", 49, 4, 4);
        new Circle(Color.B, "circle81", 81, 4, 5);

        new Triangle(Color.B, "triangle16", 16, 4, 0);
        new Triangle(Color.B, "triangle12", 12, 4, 1);
        new Triangle(Color.B, "triangle90", 90, 4, 6);
        new Triangle(Color.B, "triangle100", 100, 4, 7);
        new Triangle(Color.B, "triangle36", 36, 3, 2);
        new Triangle(Color.B, "triangle30", 30, 3, 3);
        new Triangle(Color.B, "triangle56", 56, 3, 4);
        new Triangle(Color.B, "triangle64", 64, 3, 5);

        new Square(Color.B, "square49", 49, 2, 0);
        new Square(Color.B, "square28", 28, 3, 0);
        new Square(Color.B, "square121", 121, 2, 1);
        new Square(Color.B, "square66", 66, 3, 1);
        new Square(Color.B, "square225", 225, 2, 6);
        new Square(Color.B, "square120", 120, 3, 6);
        new Square(Color.B, "square361", 361, 2, 7);

        // Initializes white pieces
        new Circle(Color.W, "circle8", 8, 10, 2);
        new Circle(Color.W, "circle6", 6, 10, 3);
        new Circle(Color.W, "circle4", 4, 10, 4);
        new Circle(Color.W, "circle2", 2, 10, 5);
        new Circle(Color.W, "circle64", 64, 11, 2);
        new Circle(Color.W, "circle36", 36, 11, 3);
        new Circle(Color.W, "circle16", 16, 11, 4);
        new Circle(Color.W, "circle4", 4, 11, 5);

        new Triangle(Color.W, "triangle81", 81, 11, 0);
        new Triangle(Color.W, "triangle72", 72, 11, 1);
        new Triangle(Color.W, "triangle6", 6, 11, 6);
        new Triangle(Color.W, "triangle9", 9, 11, 7);
        new Triangle(Color.W, "triangle49", 49, 12, 2);
        new Triangle(Color.W, "triangle42", 42, 12, 3);
        new Triangle(Color.W, "triangle20", 20, 12, 4);
        new Triangle(Color.W, "triangle25", 25, 12, 5);

        new Square(Color.W, "square153", 153, 12, 0);
        new Square(Color.W, "square289", 289, 13, 0);
        new Square(Color.W, "square169", 169, 13, 1);
        new Square(Color.W, "square45", 45, 12, 6);
        new Square(Color.W, "square81", 81, 13, 6);
        new Square(Color.W, "square15", 15, 12, 7);
        new Square(Color.W, "square25", 25, 13, 7);
    }
    
    public static boolean isValidPos(int x, int y) {
    	return x >= 0 && x < cols && y >= 0 && y < rows;
    }
    
    public static boolean isEmpty(int x, int y) {
    	if(!isValidPos(x,y)) {
    		return false;
    	}
    	
    	return board[y][x] == null;
    }
    
 // Helper method to check if the path is clear
 	 public static boolean pathIsClear(int x1, int y1, int x2, int y2, Board board) {
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

    

    public static void setPiece(int x, int y, Piece piece) {
        if (piece != null) {
            piece.setX(x);
            piece.setY(y);
        }
        board[y][x] = piece;
    }

    public static Piece getPiece(int x, int y) {
        return board[y][x];
    }
}

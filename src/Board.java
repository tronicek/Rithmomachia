
public class Board {
	static Piece board[][] = new Piece[8][16];
	
	static void printBoard() {
	    // Print the numbers at the top for the columns
	    System.out.println("      1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16");

	    // Adjust the horizontal separator for 16 columns
	    System.out.println("    -------------------------------------------------------------------------------");

	    // Letters on the sides for the rows
	    char letter = 'a';
	    for (int i = 0; i < 8; i++) {
	        System.out.print(" " + letter + " ");  // Print the letter for the row
	        System.out.print("| ");
	        for (int j = 0; j < 16; j++) {
	            if (board[i][j] == null) {
	                System.out.print("   | ");
	            } else {
	                System.out.print(board[i][j] + " | ");
	            }
	        }
	        System.out.print(letter);  // Print the letter again at the end of the row
	        letter++;
	        System.out.println();
	        System.out.println("    -------------------------------------------------------------------------------");
	    }

	    // Print the numbers again at the bottom for the columns
	    System.out.println("      1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16");
	    System.out.println();
	}
	
	static void startGame() {
		// Initializes blacks pieces
		new Circle(Color.BLACK, "circle3", 5, 3);
		new Circle(Color.BLACK, "circle5", 5, 3);
		new Circle(Color.BLACK, "circle7", 5, 4);
		new Circle(Color.BLACK, "circle9", 5, 5);
		new Circle(Color.BLACK, "circle9", 4, 2);
		new Circle(Color.BLACK, "circle25", 4, 3);
		new Circle(Color.BLACK, "circle49", 4, 4);
		new Circle(Color.BLACK, "circle81", 4, 5);
		
		new Triangle(Color.BLACK, "triangle16", 4, 0);
		new Triangle(Color.BLACK, "triangle12", 4, 1);
		new Triangle(Color.BLACK, "triangle90", 4, 6);
		new Triangle(Color.BLACK, "triangle100", 4, 7);
		new Triangle(Color.BLACK, "triangle36", 3, 2);
		new Triangle(Color.BLACK, "triangle30", 3, 3);
		new Triangle(Color.BLACK, "triangle56", 3, 4);
		new Triangle(Color.BLACK, "triangle64", 3, 5);
		
		new Square(Color.BLACK, "square49", 2, 0);
		new Square(Color.BLACK, "square28", 3, 0);
		new Square(Color.BLACK, "square121", 2, 1);
		new Square(Color.BLACK, "square66", 3, 1);
		new Square(Color.BLACK, "square225", 2, 6);
		new Square(Color.BLACK, "square120", 3, 6);
		new Square(Color.BLACK, "square361", 2, 7);
		
		//Initializes whites pieces
		new Circle(Color.WHITE, "circle8", 10, 2);
		new Circle(Color.WHITE, "circle6", 10, 3);
		new Circle(Color.WHITE, "circle4", 10, 4);
		new Circle(Color.WHITE, "circle2", 10, 5);
		new Circle(Color.WHITE, "circle64", 11, 2);
		new Circle(Color.WHITE, "circle36", 11, 3);
		new Circle(Color.WHITE, "circle16", 11, 4);
		new Circle(Color.WHITE, "circle4", 11, 5);
		
		new Triangle(Color.WHITE, "triangle81", 11, 0);
		new Triangle(Color.WHITE, "triangle72", 11, 1);
		new Triangle(Color.WHITE, "triangle6", 11, 6);
		new Triangle(Color.WHITE, "triangle9", 11, 7);
		new Triangle(Color.WHITE, "triangle49", 12, 2);
		new Triangle(Color.WHITE, "triangle42", 12, 3);
		new Triangle(Color.WHITE, "triangle20", 12, 4);
		new Triangle(Color.WHITE, "triangle25", 12, 5);
		
		new Square(Color.WHITE, "square153", 12, 0);
		new Square(Color.WHITE, "square289", 13, 0);
		new Square(Color.WHITE, "square169", 13, 1);
		new Square(Color.WHITE, "square45", 12, 6);
		new Square(Color.WHITE, "square81", 13, 6);
		new Square(Color.WHITE, "square15", 12, 7);
		new Square(Color.WHITE, "square25", 13, 7);
		
		
		
		
	}
	
	public static void setPiece(int x, int y, Piece piece) {
		if(piece != null) {
			piece.setX(x);
			piece.setY(y);
		}
		board[y][x] = piece;
	}
	
	public static Piece getPiece(int x, int y) {
		return board[y][x];
	}

	}
	



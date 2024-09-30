public class Board {
    static Piece board[][] = new Piece[8][16];

    static void printBoard() {
        // Print the numbers at the top for the columns
        System.out.println("         1         2         3         4         5         6         7         8         9        10        11        12        13        14        15        16");

        // Adjust the horizontal separator for 16 columns
        System.out.println("    ---------------------------------------------------------------------------------------------------------------------------------------------------------------");

        // Letters on the sides for the rows
        char letter = 'a';
        for (int i = 0; i < 8; i++) {
            System.out.print(" " + letter + " ");  // Print the letter for the row
            System.out.print("| ");
            for (int j = 0; j < 16; j++) {
                if (board[i][j] == null) {
                    System.out.print("        | ");  // Eight spaces for each cell to allow more room for piece names
                } else {
                    System.out.printf("%-8s| ", board[i][j]);  // Use printf for consistent width formatting (8 spaces)
                }
            }
            System.out.print(letter);  // Print the letter again at the end of the row
            letter++;
            System.out.println();
            System.out.println("    ----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

        // Print the numbers again at the bottom for the columns
        System.out.println("         1         2         3         4         5         6         7         8         9        10        11        12        13        14        15        16");
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
    	return x >= 0 && x < 16 && y >= 0 && y < 8;
    }
    
    public static boolean isEmpty(int x, int y) {
    	if(!isValidPos(x,y)) {
    		return false;
    	}
    	
    	return board[y][x] == null;
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

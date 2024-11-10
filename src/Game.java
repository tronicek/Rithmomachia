import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter number of rows: ");
			int numRows = scanner.nextInt();
			System.out.print("Enter number of columns: ");
			int numCols = scanner.nextInt();
			
			Board.initBoard(numRows, numCols);
		}
		
		Board.printBoard();
		
		

	}

}

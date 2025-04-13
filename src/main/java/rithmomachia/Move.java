package rithmomachia;

public class Move {
    private final int startRow, startCol;
    private final int endRow, endCol;

    public Move(int startRow, int startCol, int endRow, int endCol) {
        this.startRow = startRow;
        this.startCol = startCol;
        this.endRow = endRow;
        this.endCol = endCol;
    }

    public int getStartRow() {
        return startRow;
    }
    public int getStartCol() {
        return startCol;
    }
    public int getEndRow() {
        return endRow;
    }
    public int getEndCol() {
        return endCol;
    }

    @Override
    public String toString() {
        return String.format("Move from (%d, %d) to (%d, %d)", startRow, startCol, endRow, endCol);
    }

}
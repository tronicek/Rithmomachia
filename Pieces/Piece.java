public abstract class Piece {
    private String shape;
    private int value;
    private ArrayList<Integer> listValue;
    private int movement;
    private String color;

// Constructor For the Circle, Triangle and Square pieces
    public Piece(String shape, int value, int movement, String color) {
        this.shape = shape;
        this.value = value;
        this.movement = movement;
        this.color = color;
    }

// Constructor For the Pyramid pieces
    public Piece(String shape, ArrayList<Integer> listValue, int movement, String color) {
        this.shape = shape;
        this.listValue = new ArrayList<>();
        this.movement = movement;
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public int getValue() {
        return listValue;
    }
    
    public int getValue() {
        return value;
    }

    public int getMovement() {
        return movement;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean isValidMove(int startX, int startY, int endX, int endY, Board board);
}

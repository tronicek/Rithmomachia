public abstract class Piece {
    private String shape;
    private int value;
    private ArrayList<Integer> listValue;
    private int movement;
    private String color;
    private String type

// Constructor For the Circle, Triangle and Square pieces
    public Piece(String shape, int value, int movement, String color, String type) {
        this.shape = shape;
        this.value = value;
        this.movement = movement;
        this.color = color;
        this.type = type
    }

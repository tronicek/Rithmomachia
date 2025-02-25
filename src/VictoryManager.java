package Rithmomachia;

import java.util.HashMap;

public class VictoryManager {

    private Board board;
    private HashMap<String, Integer> whiteCaptures;
    private HashMap<String, Integer> blackCaptures;
    private Victory victory;
    private int bodiesGoal;
    private int digitsGoal;
    private int valueGoal;

    // Please construct with appropriate values or -1 if that value is not being used.
    public VictoryManager(Board board, Victory victory, int numBodies, int numDigits, int value) {
        this.board = board;
        this.whiteCaptures = new HashMap<>();
        this.whiteCaptures.put("bodies", 0);
        this.whiteCaptures.put("digits", 0);
        this.whiteCaptures.put("value", 0);
        this.blackCaptures = new HashMap<>();
        this.blackCaptures.put("bodies", 0);
        this.blackCaptures.put("digits", 0);
        this.blackCaptures.put("value", 0);
        this.victory = victory;
        this.bodiesGoal = numBodies;
        this.digitsGoal = numDigits;
        this.valueGoal = value;
    }

    public boolean capture(Piece piece) {
        switch (piece.getColor()){
            case B: // If a black piece was captured, update white's capture map
                this.whiteCaptures.put("bodies", this.whiteCaptures.get("bodies") + 1);
                this.whiteCaptures.put("digits", this.whiteCaptures.get("digits") + Integer.toString(piece.getValue()).length());
                this.whiteCaptures.put("value", this.whiteCaptures.get("value") + piece.getValue());
                break;
            case W: // If a white piece was captured, update black's capture map
                this.blackCaptures.put("bodies", this.blackCaptures.get("bodies") + 1);
                this.blackCaptures.put("digits", this.blackCaptures.get("digits") + Integer.toString(piece.getValue()).length());
                this.blackCaptures.put("value", this.blackCaptures.get("value") + piece.getValue());
        }
        Color colorToCheck = piece.getColor() == Color.W ? Color.B : Color.W; // Check if the color opposite to the captured piece has won
        return this.checkForVictory(colorToCheck); // Return true if the color that did the capture has won
    }

    public boolean checkForVictory(Color colorToCheck) { // Checks given victory condition for color that is being checked
        switch (this.victory) {
            case BODIES:
                return this.checkVictoryBodies(colorToCheck);
            case GOODS:
                return this.checkVictoryValues(colorToCheck);
            case QUARREL:
                return this.checkVictoryValues(colorToCheck) && this.checkVictoryDigits(colorToCheck);
            case HONOR:
                return this.checkVictoryValues(colorToCheck) && this.checkVictoryBodies(colorToCheck);
            case HONOR_AND_QUARREL:
                return this.checkVictoryValues(colorToCheck) && this.checkVictoryDigits(colorToCheck) && this.checkVictoryBodies(colorToCheck);
            default:
                return false;
        }
    }

    private boolean checkVictoryBodies(Color colorToCheck) {
        return colorToCheck == Color.B ? blackCaptures.get("bodies") >= bodiesGoal : whiteCaptures.get("bodies") >= bodiesGoal;
    }

    private boolean checkVictoryDigits(Color colorToCheck) {
        return colorToCheck == Color.B ? blackCaptures.get("digits") >= digitsGoal : whiteCaptures.get("digits") >= digitsGoal;
    }

    private boolean checkVictoryValues(Color colorToCheck) {
        return colorToCheck == Color.B ? blackCaptures.get("value") >= valueGoal : whiteCaptures.get("value") >= valueGoal;
    }

    private boolean checkGloriousVictories(Color colorToCheck) {
        return false;
    }

    private boolean checkVictoriaMagna(Color colorToCheck) {
        return false;
    }

    private boolean checkVictoriaMayor(Color colorToCheck) {
        return false;
    }

    private boolean checkVictoriaExcelentisma(Color colorToCheck) {
        return false;
    }
}

// Board has a victory tracker? Victory tracker has a board??
// Board has capture function?
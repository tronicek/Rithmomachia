package rithmomachia;

public class GoalHolder {
    private int bodiesRemaining;
    private int valueRemaining;
    private int digitsRemaining;
    private final boolean isMaximizingPlayer;

    public GoalHolder(int bodiesRemaining, int valueRemaining, int digitsRemaining, boolean isMaximizingPlayer) {
        this.bodiesRemaining = bodiesRemaining;
        this.valueRemaining = valueRemaining;
        this.digitsRemaining = digitsRemaining;
        this.isMaximizingPlayer = isMaximizingPlayer;
    }

    public int getBodiesRemaining() {
        return bodiesRemaining;
    }

    public void setBodiesRemaining(int bodiesRemaining) {
        this.bodiesRemaining = bodiesRemaining;
    }

    public int getValueRemaining() {
        return valueRemaining;
    }

    public void setValueRemaining(int valueRemaining) {
        this.valueRemaining = valueRemaining;
    }

    public int getDigitsRemaining() {
        return digitsRemaining;
    }

    public void setDigitsRemaining(int digitsRemaining) {
        this.digitsRemaining = digitsRemaining;
    }

    public boolean isMaximizingPlayer() {
        return isMaximizingPlayer;
    }

    public boolean hasWon(){
        return bodiesRemaining == 0 && valueRemaining == 0 && digitsRemaining == 0;
    }
}

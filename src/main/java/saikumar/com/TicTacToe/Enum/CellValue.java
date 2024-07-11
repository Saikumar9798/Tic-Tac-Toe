package saikumar.com.TicTacToe.Enum;

public enum CellValue {
    X("X"),
    O("O"),
    EMPTY(" ");

    private final String value;

    CellValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

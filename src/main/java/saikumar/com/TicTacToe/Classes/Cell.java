package saikumar.com.TicTacToe.Classes;

import saikumar.com.TicTacToe.Enum.CellValue;

import java.util.Objects;

public class Cell {
    private String value;

    public Cell() {
        this.value = CellValue.EMPTY.getValue();
    }


    public boolean isCellEmpty() {
        return Objects.equals(this.value, CellValue.EMPTY.getValue());
    }

    public boolean assignCellValue(String value) {
        if (this.isCellEmpty()) {
            this.value = value;
            return true;
        }
        return false;
    }

    public String getCellValue() {
        return this.value;
    }
}

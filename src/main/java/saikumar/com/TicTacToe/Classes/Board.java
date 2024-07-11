package saikumar.com.TicTacToe.Classes;

import saikumar.com.TicTacToe.Enum.CellValue;

import java.util.Objects;

public class Board {
    private final Cell[][] grid;

    public Board() {
        this.grid = new Cell[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                this.grid[i][j] = new Cell();
    }

    public boolean assignValueToCell(int i, int j, String value) {
        try {
            if (i < 1 || j < 1 || i >= 4 || j >= 4) throw new IllegalArgumentException();
            return grid[i - 1][j - 1].assignCellValue(value);
        } catch (Exception e) {
            return false;
        }
    }

    public String getCellValue(int i, int j) {
        if (i < 1 || j < 1 || i >= 4 || j >= 4) throw new IllegalArgumentException();
        return this.grid[i][j].getCellValue();
    }


    public void displayBoard() {
        System.out.println("----- ----- -----");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) System.out.print("| " + this.grid[i][j].getCellValue() + " | ");
            System.out.println();
            System.out.println("----- ----- -----");
        }
    }

    public boolean verify() {
        return (((Objects.equals(this.grid[0][0].getCellValue(), this.grid[1][1].getCellValue())) && (Objects.equals(this.grid[1][1].getCellValue(), this.grid[2][2].getCellValue()) && !Objects.equals(this.grid[0][0].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[1][1].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[2][2].getCellValue(), CellValue.EMPTY.getValue()))) ||
                ((Objects.equals(this.grid[0][0].getCellValue(), this.grid[1][0].getCellValue())) && (Objects.equals(this.grid[2][0].getCellValue(), this.grid[1][0].getCellValue()) && !Objects.equals(this.grid[0][0].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[1][0].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[2][0].getCellValue(), CellValue.EMPTY.getValue()))) ||
                ((Objects.equals(this.grid[0][2].getCellValue(), this.grid[1][2].getCellValue())) && (Objects.equals(this.grid[1][2].getCellValue(), this.grid[2][2].getCellValue()) && !Objects.equals(this.grid[0][2].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[1][2].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[2][2].getCellValue(), CellValue.EMPTY.getValue()))) ||
                ((Objects.equals(this.grid[0][0].getCellValue(), this.grid[0][1].getCellValue())) && (Objects.equals(this.grid[0][1].getCellValue(), this.grid[0][2].getCellValue()) && !Objects.equals(this.grid[0][0].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[0][1].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[0][2].getCellValue(), CellValue.EMPTY.getValue()))) ||
                ((Objects.equals(this.grid[1][0].getCellValue(), this.grid[1][1].getCellValue())) && (Objects.equals(this.grid[1][1].getCellValue(), this.grid[1][2].getCellValue()) && !Objects.equals(this.grid[1][0].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[1][1].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[1][2].getCellValue(), CellValue.EMPTY.getValue()))) ||
                ((Objects.equals(this.grid[2][0].getCellValue(), this.grid[2][1].getCellValue())) && (Objects.equals(this.grid[2][1].getCellValue(), this.grid[2][2].getCellValue())) && !Objects.equals(this.grid[2][0].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[2][1].getCellValue(), CellValue.EMPTY.getValue()) && !Objects.equals(this.grid[2][2].getCellValue(), CellValue.EMPTY.getValue())));
    }
}

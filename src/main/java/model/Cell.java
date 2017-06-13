package model;


import type.Seed;

public class Cell {

    Seed content;
    private int row;
    private int col;

    public Cell() {

    }

    public Cell(int row, int col) {
        setRow(row);
        setCol(col);
    }

    public Seed getContent() {
        return content;
    }

    public void setContent(Seed content) throws NullPointerException {
        if (content == null) {
            throw new NullPointerException();
        }
        this.content = content;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) throws IllegalArgumentException {
        if (row < 1 || row > 3) {
            throw new IllegalArgumentException("Incorrect row value");
        }
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) throws IllegalArgumentException {
        if (col < 1 || col > 3) {
            throw new IllegalArgumentException("Incorrect col value");
        }
        this.col = col;
    }
}

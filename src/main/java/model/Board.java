package model;


import exception.InvalidCellNumberException;
import type.WinningRowsCoordinates;
import type.Seed;


public class Board {

    Cell [] cells;

    Board() {
    }

    public Cell [] getCells() {
        return this.cells;
    }

    public void setCells(Cell[] cells) {
        this.cells = cells;
    }

    void init() {
        this.cells = new Cell[] {new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(),
                new Cell(), new Cell(), new Cell()};
    }

    public Boolean isRowFilledWithSameSigns(int[] cellNumbers) {
        Integer crossFieldCounter = 0;
        Integer noughtFieldCounter = 0;
        for (Integer cellNumber : cellNumbers) {
            switch (this.getCells()[cellNumber].getContent()) {
                case CROSS:
                    crossFieldCounter++;
                    break;
                case NOUGHT:
                    noughtFieldCounter++;
                default:
                    break;
            }
        }
        return (crossFieldCounter == 3) || (noughtFieldCounter == 3);
    }

    public void markField(Seed seed, int cellNumber) throws ArrayIndexOutOfBoundsException, InvalidCellNumberException {
        if (this.getCells()[cellNumber].getContent().equals(Seed.EMPTY)) {
            this.getCells()[cellNumber].setContent(seed);
        }
        else {
            throw new InvalidCellNumberException();
        }
    }

    Boolean allFieldsAreFilled() {
        for(Cell cell : this.getCells()) {
            if(cell.getContent() == Seed.EMPTY) {
                return false;
            }
        }
        return true;
    }

    Boolean isDraw() {
        if (this.allFieldsAreFilled()) {
            return true;
        }
        return false;
    }

    Boolean hasWon(Seed seed, int cellNumber) throws InvalidCellNumberException, ArrayIndexOutOfBoundsException {
        markField(seed, cellNumber);
        for (WinningRowsCoordinates rowCoord : WinningRowsCoordinates.values()) {
            if (isRowFilledWithSameSigns(rowCoord.getCoordinates())) {
                return true;
            }
        }
        return false;
    }

}

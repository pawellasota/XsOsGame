package model;


import exception.InvalidCellNumberException;
import type.WinningRowsCoordinates;
import type.Seed;


public class Board {

    Cell [] cells;

    Board() {
    }

    Cell [] getCells() {
        return this.cells;
    }

    void init() {
        this.cells = new Cell[8];
    }

    private Boolean isRowFilledWithSameSigns(int[] cellNumbers) {
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

    private void markField(Seed seed, int cellNumber) throws InvalidCellNumberException{
        if (this.getCells()[cellNumber].getContent().equals(Seed.EMPTY)) {
            this.getCells()[cellNumber].setContent(seed);
        }
        else {
            throw new InvalidCellNumberException();
        }
    }

    Boolean hasWon(Seed seed, int cellNumber) throws InvalidCellNumberException{
        markField(seed, cellNumber);
        for (WinningRowsCoordinates rowCoord : WinningRowsCoordinates.values()) {
            if (isRowFilledWithSameSigns(rowCoord.getCoordinates())) {
                return true;
            }
        }
        return false;
    }

}

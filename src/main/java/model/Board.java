package model;


import type.Seed;
import type.WinPattern;

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

//    Boolean isFilled(Cell cell) {
//        return (cell.getContent() == null);
//    }

    Cell [] getBoardCrossedOnly() {
        Cell [] crossed = new Cell[];
        System.arraycopy(this.getCells(), 0, crossed, 0, this.getCells().length);
        for(Cell cell : crossed) {
            if(cell.getContent() != Seed.CROSS) {
                cell.setContent(null);
            }
        }
        return crossed;
    }

    Cell [] getBoardNoughtOnly() {
        Cell [] crossed = new Cell[];
        System.arraycopy(this.getCells(), 0, crossed, 0, this.getCells().length);
        for(Cell cell : crossed) {
            if(cell.getContent() != Seed.NOUGHT) {
                cell.setContent(null);
            }
        }
        return crossed;
    }


    Boolean hasWon(Seed seed, int row, int col) {
        WinPattern winPattern = new WinPattern();
        if (winPattern. getBoardCrossedOnly())

        for(Cell cell : this.getCells()) {
            if(isFilled(cell)) {

            }
        }
    }

}

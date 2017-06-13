package type;


import model.Cell;

public enum WinPattern {
    Cell cell;

    Cell[] first_win = new Cell[]{cell, cell, cell, null,null,null, null,null,null};
    Cell[] second_win = new Cell[]{null,null,null, cell, cell, cell, null,null,null};
    Cell[] third_win = new Cell[]{null,null,null, null,null,null, cell, cell, cell};

//    Boolean isWinPattern(Cell[] board){
//        switch (this) {
//            case(board) {
//                return true;
//            }
//            return false;
//        }
//    }

    public WinPattern(){
        cell = new Cell();
        cell.setContent(Seed.CROSS);

    }

    public Cell getCell() {
        return cell;
    }

    public Cell[] getFirst_win() {
        return first_win;
    }

    public Cell[] getSecond_win() {
        return second_win;
    }

    public Cell[] getThird_win() {
        return third_win;
    }
}

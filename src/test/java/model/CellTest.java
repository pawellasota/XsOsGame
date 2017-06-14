//package model;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import type.Seed;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//class CellTest {
//    @BeforeEach
//    void setUp() {
//
//    }
//
//    @Test
//    void testIfConstructorSetValidRow() {
//        Cell cell = new Cell(1, 2);
//        int expectedRow = cell.getRow();
//        assertEquals(expectedRow, 1);
//    }
//
//    @Test
//    void testIfConstructorSetValidCol() {
//        Cell cell = new Cell(1, 2);
//        int expectedCol = cell.getCol();
//        assertEquals(expectedCol, 2);
//    }
//
//    @Test
//    void testIfCellSetValidContent() {
//        Cell cell = new Cell(1, 3);
//        cell.setContent(Seed.CROSS);
//        assertEquals(Seed.CROSS, cell.getContent());
//    }
//
//    @Test
//    void testIfContentIsNullThrowsNullPointerException() {
//        Cell cell = new Cell(1, 3);
//        assertThrows(NullPointerException.class, () -> {
//            cell.setContent(null);
//        });
//    }
//
//    @Test
//    void testIfSetColOutOfValidRangeThrowsIllegalArgumentException() throws Exception {
//        assertThrows(IllegalArgumentException.class, () -> {
//            Cell cell = new Cell(1, 5);
//        });
//    }
//
//    @Test
//    void testIfSetRowOutOfValidRangeThrowsIllegalArgumentException() throws Exception {
//        assertThrows(IllegalArgumentException.class, () -> {
//            Cell cell = new Cell(10, 2);
//        });
//    }
//}
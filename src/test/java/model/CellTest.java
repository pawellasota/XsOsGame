package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import type.Seed;
import static org.junit.jupiter.api.Assertions.*;


class CellTest {

    Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell();
    }

    @Test
    void testIfContentIsNullThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            cell.setContent(null);
        });
    }

    @Test
    void testIfContentSetSeedToEmpty() {
        cell.setContent(Seed.EMPTY);
        assertEquals(Seed.EMPTY, cell.getContent());
    }

    @Test
    void testIfContentSetSeedToCross() {
        cell.setContent(Seed.CROSS);
        assertEquals(Seed.CROSS, cell.getContent());
    }
}
package type;


public enum WinningRowsCoordinates {
    FIRST(1, 2, 3),
    SECOND(4, 5, 6),
    THIRD(7, 8, 9),
    FOURTH(1, 4, 7),
    FIFTH(2, 5, 8),
    SIXTH(3, 6, 9),
    SEVENTH(1, 5, 9),
    EIGHTH(3, 5, 7);

    private final Integer x;
    private final Integer y;
    private final Integer z;

    WinningRowsCoordinates(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int[] getCoordinates() {
        return new int[]{x, y, z};
    }
}

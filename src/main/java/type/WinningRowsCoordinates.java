package type;


public enum WinningRowsCoordinates {
    FIRST(0, 1, 2),
    SECOND(3, 4, 5),
    THIRD(6, 7, 8),
    FOURTH(0, 3, 6),
    FIFTH(1, 4, 7),
    SIXTH(2, 5, 8),
    SEVENTH(0, 4, 8),
    EIGHTH(2, 4, 6);

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

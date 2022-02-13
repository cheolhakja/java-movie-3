package movie;

public enum SeatPosition {

    A1(1, 1), A2(1, 2), A3(1, 3);

    private int row;
    private int column;

    private SeatPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static SeatPosition findSeatPositionByRowColumn(int row, int column) throws CannotFindSeatException {
        for (SeatPosition seatPosition : values()) {
            if (seatPosition.row == row && seatPosition.column == column) {
                return seatPosition;
            }

            //refactor: to lambda
        }

        throw new CannotFindSeatException();
    }
}
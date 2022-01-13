package movie;

class Seat {

    private int row;
    private int column;
    private boolean booked;

    public Seat(boolean booked) {
        this.booked = booked;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Seat(int row, int column, boolean booked) {
        this.row = row;
        this.column = column;
        this.booked = booked;
    }

    public boolean isBooked() {
        return booked;
    }

    public boolean reserve() {
        if (isBooked()) {
            throw new CannotReserveException();
        }

        this.booked = true;
        System.out.println("예매되었습니다");
        return true;
    }
}
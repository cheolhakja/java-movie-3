package movie;

class Seat {

    private int row;
    private int column;
    private boolean reserveStatus;
    private SeatPosition seatPosition;

    public Seat(boolean reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.reserveStatus = false;
    }

    public Seat(SeatPosition seatPosition) {
        this.seatPosition = seatPosition;
    }

    public void reserved() {
        checkIfSeatIsReserved();

        this.reserveStatus = true;
    }

    private void checkIfSeatIsReserved() { //단일 책임 이슈?
        if(reserveStatus == true) {
            throw new CannotReserveException();
        }
    }

    public void printSeat() {
        if(reserveStatus == true) {
            System.out.println(row + "행" + column + "열" + "o ");
            return;
        }

        System.out.println(row + "행" + column + "열" + "x ");
    }
}
package movie;

class Seat {

    private int row;
    private int column;
    private boolean reserveStatus;

    public Seat(boolean reserveStatus) {
        this.reserveStatus = reserveStatus;
    }

    public Seat(int row, int column, boolean reserveStatus) {
        this.row = row;
        this.column = column;
        this.reserveStatus = reserveStatus;
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
}
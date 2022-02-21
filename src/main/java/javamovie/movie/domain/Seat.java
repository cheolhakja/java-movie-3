package javamovie.movie.domain;

import javamovie.movie.exception.CannotReserveException;

public class Seat {

    private Long id;
    private boolean reserveStatus; //need refactor: to enum
    private RowColumnPair rowColumnPair;

    public Seat(Long id, RowColumnPair rowColumnPair) {
        this.id = id;
        this.rowColumnPair = rowColumnPair;
    }

    public boolean reserved() {
        checkIfSeatIsReserved();

        return reserveStatus = true;
    }

    private void checkIfSeatIsReserved() { //검증의 책임을 가져도 되는가?
        if(reserveStatus == true) {
            throw new CannotReserveException();
        }
    }

    public void printSeat() {
        if(reserveStatus == true) {
            System.out.print(rowColumnPair.getRow() + "행" + rowColumnPair.getColumn() + "열" + "o ");
            return;
        }

        System.out.print(rowColumnPair.getRow() + "행" + rowColumnPair.getColumn() + "열" + "x ");
    }
}
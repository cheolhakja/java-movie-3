package movie;

import java.util.ArrayList;

public class Seats {

    private ArrayList<Seat> seats = new ArrayList<>();

    public Seats() {
        this.setSeats();
    }

    public boolean isBooked(int row, int column) {
        for (Seat seat: seats) {
            if(seat.getRow() == row && seat.getColumn() == column) {
                return seat.isBooked();
            }
        }

        throw new IllegalArgumentException(); //need refactor
    }

    public boolean reserve(int row, int column) {
        int seatIndex = 0;

        for (Seat seat: seats) {
            if(seat.getRow() == row && seat.getColumn() == column && seat.isBooked() == false) {
                seats.set(seatIndex, new Seat(seat.getRow(), seat.getColumn(), true));
                return true;
            }

            seatIndex++;
        }

        throw new CannotReserveException();
    }

    private void setSeats() {
        //initialize로 이름 수정
        seats.add(new Seat(1L,1L,false));
        seats.add(new Seat(1L,2L,false));
        seats.add(new Seat(1L,3L,false));
    }
}
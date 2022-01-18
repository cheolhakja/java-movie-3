package movie;

import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

public class Seats {

    private Map<RowColumnPair, Seat> seats = new LinkedHashMap<RowColumnPair, Seat>();

    public Seats() {
        this.initializeSeats();
    }

    public boolean isBooked(int row, int column) {
        if (seats.containsKey(new RowColumnPair(row, column))) {
            return seats.get(new RowColumnPair(row, column)).isBooked();
        }

        return false;
    }

    public boolean reserve(int row, int column) {
        if (seats.containsKey(new RowColumnPair(row, column)) && !isBooked(row, column)) {
            seats.replace(new RowColumnPair(row, column), new Seat(row, column, true));
            return true;
        }

        throw new CannotReserveException();
    }

    private void initializeSeats() {
        seats.put(new RowColumnPair(1, 1), new Seat(1, 1, false));
        seats.put(new RowColumnPair(1, 2), new Seat(1, 2, false));
        seats.put(new RowColumnPair(1, 3), new Seat(1, 3, false));

        seats.put(new RowColumnPair(2, 1), new Seat(2, 1, false));
        seats.put(new RowColumnPair(4, 2), new Seat(4, 2, false));
        seats.put(new RowColumnPair(5, 3), new Seat(5, 3, false));
    }

    public void printSeats() {
        Seat seat = new Seat(100,100,false); //가짜값
        Set<Map.Entry<RowColumnPair, Seat>> entries = seats.entrySet();
        Iterator iterator = entries.iterator();
        int count = 1;

        while(iterator.hasNext()) {
            if(count == 1) {
                count++;
                seat = ((Map.Entry<RowColumnPair, Seat>)iterator.next()).getValue(); //이게 되나? 하나도 없으면?
                System.out.print(seat.getRow() + "행 : ");
                for (int i = 0; i < seat.getColumn()-1; i++) {
                    System.out.print(" ");
                }

                if(seat.isBooked()) {
                    System.out.print("x");
                    continue;
                }

                System.out.print("o");
            }

            Seat seatNext = ((Map.Entry<RowColumnPair, Seat>)iterator.next()).getValue();

            if(seat.getRow() != seatNext.getRow()) {
                //행이 바뀐경우
                //개행하고 행 정보 출력
                //n 출력
                // o x 출력
                //seat에 대입
                System.out.println();
                System.out.print(seatNext.getRow() + "행 : ");
                for (int i = 0; i < seatNext.getColumn()-1; i++) {
                    System.out.print(" ");
                }

                if(seatNext.isBooked()) {
                    System.out.print("x");
                    seat = seatNext;
                    continue;
                }

                System.out.print("o");
                seat = seatNext;
                continue;
            }

            for (int i = 0; i < seatNext.getColumn()-seat.getColumn()-1; i++) {
                System.out.print(" ");
            }

            if(seatNext.isBooked()) {
                System.out.print("x");
                seat = seatNext;
                continue;
            }

            System.out.print("o");
            seat = seatNext;
        }
    }
}
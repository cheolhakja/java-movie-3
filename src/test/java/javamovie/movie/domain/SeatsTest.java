package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SeatsTest {

    private Seats SeatCollection(Seat... seats) {
        return new Seats(seats);
    }

    @Test
    public void 존재하지_않은_좌석_조회() {
        Seats seats = this.SeatCollection(
                new Seat(1L, new RowColumnPair(1,1)),
                new Seat(2L, new RowColumnPair(1,2)),
                new Seat(3L, new RowColumnPair(1,3))
        );

        assertThatThrownBy(() -> seats.seatToReserve(1000,1000))
                .isInstanceOf(CannotFindSeatException.class)
                .hasMessageContaining("좌석을 찾을 수 없습니다");
    }

    @Test
    public void 존재하는_좌석_조회() {
        Seats seats = this.SeatCollection(
                new Seat(1L, new RowColumnPair(1,1)),
                new Seat(2L, new RowColumnPair(1,2)),
                new Seat(3L, new RowColumnPair(1,3))
        );

        assertThat(seats.seatToReserve(1,1)).isInstanceOf(Seat.class);
    }
}

package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SeatsTest {

    private Seats SeatCollection(ISeat... seats) {
        return new Seats(seats);
    }

    @Test
    public void 존재하지_않은_좌석_조회() {
        Seats seats = this.SeatCollection(
                new NotBookedSeat(1L, new RowColumnPair(1,1)),
                new NotBookedSeat(2L, new RowColumnPair(1,2)),
                new NotBookedSeat(3L, new RowColumnPair(1,3))
        );

        assertThatThrownBy(() -> seats.seatToBook(new RowColumnPair(1000, 1000)))
                .isInstanceOf(CannotFindSeatException.class)
                .hasMessageContaining("좌석을 찾을 수 없습니다");
    }

    @Test
    public void 존재하는_좌석_조회() {
        Seats seats = this.SeatCollection(
                new NotBookedSeat(1L, new RowColumnPair(1,1)),
                new NotBookedSeat(2L, new RowColumnPair(1,2)),
                new NotBookedSeat(3L, new RowColumnPair(1,3))
        );

        assertThat(seats.seatToBook(new RowColumnPair(1,1))).isInstanceOf(NotBookedSeat.class);
    }
}

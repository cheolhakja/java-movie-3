package javamovie.movie.domain;

import javamovie.movie.exception.CannotFindSeatException;
import javamovie.movie.exception.CannotBookException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ReservationTest {

    //do not make shared member variable
    private MovieSchedule createMovieSchedule() {
        RowColumnPair A1 = new RowColumnPair(1, 1);
        RowColumnPair A2 = new RowColumnPair(1, 2);
        RowColumnPair A3 = new RowColumnPair(1, 3);

        return new MovieSchedule(new Movie(1L), A1, A2, A3);
    }

    @Test()
    public void 예매_성공() {
        MovieSchedule movieSchedule = createMovieSchedule();

        assertThat(movieSchedule.book(1, 1)).isTrue();
    }

    @Test()
    public void 존재하지_않는_좌석_예매() {
        MovieSchedule movieSchedule = createMovieSchedule();

        assertThatThrownBy(() -> movieSchedule.book(1000, 1))
                .isInstanceOf(CannotFindSeatException.class);
    }

    @Test()
    public void 이미_예매된_좌석을_예매() {
        MovieSchedule movieSchedule = createMovieSchedule();
        movieSchedule.book(1, 1);

        assertThatThrownBy(() -> movieSchedule.book(1, 1))
                .isInstanceOf(CannotBookException.class);
    }
}

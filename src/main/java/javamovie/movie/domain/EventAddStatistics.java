package javamovie.movie.domain;

import org.springframework.context.ApplicationEvent;

public class EventAddStatistics extends ApplicationEvent {

    private RowColumnPair rowColumnPair;

    private MovieSchedule movieSchedule;

    public EventAddStatistics(Object source, RowColumnPair rowColumnPair, MovieSchedule movieSchedule) {
        super(source);
        this.rowColumnPair = rowColumnPair;
        this.movieSchedule = movieSchedule;
    }

    public RowColumnPair getRowColumnPair() {
        return rowColumnPair;
    }

    public MovieSchedule getMovieSchedule() {
        return movieSchedule;
    }
}

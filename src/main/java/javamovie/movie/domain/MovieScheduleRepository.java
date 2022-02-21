package javamovie.movie.domain;

public interface MovieScheduleRepository {

    public void saveSchedule(MovieSchedule movieSchedule);

    public MovieSchedule findSchedule();
}
package javamovie.repository;

import javamovie.domain.MovieSchedule;

public interface MovieScheduleRepository {

    public void saveSchedule(MovieSchedule movieSchedule);

    public MovieSchedule findSchedule();
}
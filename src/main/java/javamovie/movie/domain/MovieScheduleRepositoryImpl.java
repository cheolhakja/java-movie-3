package javamovie.movie.domain;

public class MovieScheduleRepositoryImpl implements MovieScheduleRepository {

    private static MovieSchedule movieSchedules;

    @Override
    public void saveSchedule(MovieSchedule movieSchedule) {
        movieSchedules = movieSchedule;
    }

    @Override
    public MovieSchedule findSchedule() {
        return movieSchedules;
        //need refactor: NullPointerException handling
    }
}
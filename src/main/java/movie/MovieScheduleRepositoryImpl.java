package movie;

public class MovieScheduleRepositoryImpl implements MovieScheduleRepositoryInterface {

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
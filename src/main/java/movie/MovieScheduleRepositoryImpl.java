package movie;

public class MovieScheduleRepositoryImpl implements MovieScheduleRepositoryInterface {

    private MovieSchedule movieSchedule;

    @Override
    public void saveSchedule(MovieSchedule movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    @Override
    public MovieSchedule findSchedule() {
        return this.movieSchedule;
        //need refactor: NullPointerException handling
    }
}
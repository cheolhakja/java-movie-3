package movie;

public interface MovieScheduleRepositoryInterface {

    public void saveSchedule(MovieSchedule movieSchedule);

    public MovieSchedule findSchedule();
}
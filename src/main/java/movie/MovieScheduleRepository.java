package movie;

public interface MovieScheduleRepository {

    public void saveSchedule(MovieSchedule movieSchedule);

    public MovieSchedule findSchedule();
}
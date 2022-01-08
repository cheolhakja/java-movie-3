package movie;

class MovieScheduleRepository {
    private MovieSchedule movieSchedule;

    public void addSchedule(MovieSchedule movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    public boolean reserve(int row, int column) {
        return movieSchedule.reserve(row, column);
    }
}
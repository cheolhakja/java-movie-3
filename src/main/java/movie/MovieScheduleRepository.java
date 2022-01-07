package movie;

class MovieScheduleRepository {
    private MovieSchedule movieSchedule;

    public void addSchedule(MovieSchedule movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    public void reserve(int row, int column) {
        movieSchedule.reserve(row, column);
    }
}
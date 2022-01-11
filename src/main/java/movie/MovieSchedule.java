package movie;

class MovieSchedule {
    private Movie movie;
    private int startTime;
    private Seats seats;

    public MovieSchedule(Movie movie, int startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.seats = new Seats();
    }

    public boolean reserve(int row, int column) {
        return seats.reserve(row, column);
    }
}
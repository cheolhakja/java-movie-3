package movie;

class MovieSchedule {
    private Movie movie;
    private int startTime;
    private Seat[][] seats;

    public MovieSchedule(Movie movie, int startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.seats = new Seat[5][5];
        this.setSeats();
    }

    public void reserve(int row, int column) {
        seats[row][column].reserve();
    }

    public void setSeats() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seats[i][j] = new Seat(false);
            }
        }
    }
}